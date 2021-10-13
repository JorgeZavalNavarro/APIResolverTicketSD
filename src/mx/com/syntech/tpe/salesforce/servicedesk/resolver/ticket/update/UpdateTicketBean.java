package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.update;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import com.totalplay.syntech.integracion.sdm.soainfra.wssdm.soainfra.client.ConsumoSoaInfraUpdateTicketAPIRestClient;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import java.io.StringReader;
import mx.com.syntech.tpe.salesforce.servicedesk.changestatus.principal.ChangeStatusSFBean;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.conectbdd.ConnectorBDDConsultasBean;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.core.CoreBean;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.keys.CodeKeys;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.main.AreaResolutoraInfoVO;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.main.DiagnosticoInfoVO;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.main.JustificacionResolucionInfoVO;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.main.PrincipalException;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.main.SolucionInfoVO;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.main.SolucionTicketInfoVO;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.props.AppPropsBean;
import org.apache.log4j.Category;

/**
 * Bean para realizar la actualización del ticket en donde se van a juntar los
 * tres movimientos: Resolución --> Justificacion --> Change Status Pasan
 * unicamente al movimiento UpdateTicket
 *
 * @author dell
 */
public class UpdateTicketBean extends CoreBean {

    // Constantes de la clase
    private static final String uNoLock = "  WITH (NOLOCK) ";
    private static final Category log = Category.getInstance(UpdateTicketBean.class);

    // Propiedades de la clase
    private URL urlWsSD = null;

    public UpdateTicketBean() {

    }

    public UpdateTicketResultadoVO actualizarTicket(String persIdTicketSD) throws UpdateTicketException, MalformedURLException {
        UpdateTicketResultadoVO retorno = null;
        String logActDescripcion = "";
        String logActSalesforce = "";
        log.info("   ::: Proceso para actualizar el ticket de SD con el persID = " + persIdTicketSD);
        if (persIdTicketSD != null && !persIdTicketSD.isEmpty()) {

            // Inicializamos el valor de retorno
            retorno = new UpdateTicketResultadoVO();

            // Inicializamos la URL del servicio web de service desk
            this.urlWsSD = new URL(AppPropsBean.getPropsVO().getUrlServicedeskWs());
            log.info("URD servicios SD = " + this.urlWsSD);

            // Variable que va a recopilar la información para el logActivity
            // String logActivityInfo = "";
            // Variable que va a recopilar la información para el webservice
            UpdateInfoVO infoVO = new UpdateInfoVO();

            // Declarar nuestro elemento de conexión a la base de datos
            Connection conn = null;

            try {

                log.info("   ::: Conectando a la base de datos...");
                conn = ConnectorBDDConsultasBean.getConectionServiceDesk();
                log.info("   ::: Conexión a la base de datos satisfactoria");

                // Consultamos la información de ticket para obtener los siguientes parámetros
                // numeroTicketSF : Número de ticket en SalesForce
                // Status         : Estatus del ticket actual
                String sqlBuscarInfoTicket
                        = "select TOP 1 "
                        + "       ticket.zfolio_dbw_sf as NUMERO_TICKET_SF,        \n"
                        + "       ticket.ref_num as NUMERO_TICKET_SD,              \n"
                        + "	  ticket.status as ESTATUS_TICKET,                 \n"
                        + "       ticket.group_id as CLAVE_AREA_RESOLUTORA,        \n"
                        + "       ticket.zDiagnostico_id as CLAVE_DIAGNOSTICO,     \n"
                        + "       ticket.zgrp_origen_sf as BANDEJA,                \n"
                        + "       ticket.zSolucion_id as CLAVE_SOLUCION            \n"
                        + "  from call_req as ticket " + uNoLock + "               \n"
                        + " where persid = ?                                       \n"
                        + " order by ticket.open_date desc                           ";
                PreparedStatement psBuscarInfoTicket = conn.prepareCall(sqlBuscarInfoTicket);
                psBuscarInfoTicket.setString(1, persIdTicketSD);
                ResultSet rsBuscarInfoTicket = psBuscarInfoTicket.executeQuery();
                if (!rsBuscarInfoTicket.next()) {
                    String error = "No existe un ticket con el persId = " + persIdTicketSD;
                    log.error(error);
                    throw new UpdateTicketException(error);
                } else {
                    // Cargar información
                    infoVO.setEstatusTicket(rsBuscarInfoTicket.getString("ESTATUS_TICKET"));
                    infoVO.setNumeroTicketSD(rsBuscarInfoTicket.getString("NUMERO_TICKET_SD"));
                    infoVO.setNumeroTicketSF(rsBuscarInfoTicket.getString("NUMERO_TICKET_SF"));
                    infoVO.setClaveAreaResolutora(rsBuscarInfoTicket.getString("CLAVE_AREA_RESOLUTORA"));
                    infoVO.setClaveTipoSolucion(rsBuscarInfoTicket.getString("CLAVE_SOLUCION"));
                    infoVO.setClaveDiagnostico(rsBuscarInfoTicket.getString("CLAVE_DIAGNOSTICO"));
                    infoVO.setBandeja(rsBuscarInfoTicket.getString("BANDEJA"));
                    log.info("Información del ticket a procesar:");
                    log.info("Número de Ticket en SD......: " + infoVO.getNumeroTicketSD());
                    log.info("Número de Ticket en SF......: " + infoVO.getNumeroTicketSF());
                    log.info("Bandeja.....................: " + infoVO.getBandeja());

                    log.info("   ::: Obteniendo la información de la Area Resolutora...");
                    AreaResolutoraInfoVO areaResolutoraInfoVO = this.obtenerAreaResolutora(persIdTicketSD, infoVO.getClaveAreaResolutora(), conn);
                    if (areaResolutoraInfoVO != null) {
                        infoVO.setClaveAreaResolutora(areaResolutoraInfoVO.getClaveAreaResolutora());
                        infoVO.setNombreAreaResolutora(areaResolutoraInfoVO.getDescripcion());
                        log.info("   ::: Area Resolutora --> ("
                                + infoVO.getClaveAreaResolutora() + "):"
                                + infoVO.getNombreAreaResolutora());
                    } else {
                        log.info("   ::: No se tiene especificada información de la area resolutoria");
                    }

                    // log.info("   ::: Obtener la información del motivo...PENDIENTE");
                    log.info("   ::: Obtener la información del tipo de solución...");
                    SolucionInfoVO tipoSolucionVO = this.obtenerTipoSolucion(infoVO.getClaveTipoSolucion(), conn);
                    if (tipoSolucionVO != null) {
                        infoVO.setClaveTipoSolucion("" + tipoSolucionVO.getClaveSolucion().intValue());
                        infoVO.setNombreTipoSolucion(tipoSolucionVO.getDescripcion());
                        log.info("   ::: Tipo de solución --> ("
                                + infoVO.getClaveTipoSolucion() + "):"
                                + infoVO.getNombreTipoSolucion());
                    } else {
                        log.info("   ::: No se tiene asignado o no se encontro información acerca del tipo de solución.");
                    }

                    log.info("   ::: Obtener la información del diagnóstico final...");
                    DiagnosticoInfoVO diagnosticoVO = this.obtenerDiagnostico(infoVO.getClaveDiagnostico(), conn);
                    if (diagnosticoVO != null) {
                        infoVO.setClaveDiagnostico("" + diagnosticoVO.getClaveDiagnostico().intValue());
                        infoVO.setNombreDiagnostico(diagnosticoVO.getDescripcion());
                        log.info("   ::: Diagnóstico --> ("
                                + infoVO.getClaveDiagnostico() + "):"
                                + infoVO.getNombreDiagnostico());
                    } else {
                        log.info("   ::: No se tiene asignado o no se encontro información acerca del diagnóstico");
                    }

                    log.info("   ::: Obtener la información de la justificación...");
                    JustificacionResolucionInfoVO justificacionVO = this.obtenerJustificacion(persIdTicketSD, conn);
                    if (justificacionVO != null) {
                        infoVO.setClaveLogJustificacion("" + justificacionVO.getClaveLog().intValue());
                        infoVO.setDescripcionJustificacion(justificacionVO.getJustificacion());
                        log.info("   ::: Justificacion --> ("
                                + infoVO.getClaveLogJustificacion() + "):"
                                + infoVO.getDescripcionJustificacion());
                    } else {
                        log.info("   ::: No se tiene asignado o no se encontro información acerca de la justificación");
                    }

                    /**
                     * EJECUTAR EL WEB SERVICE DE TPE PARA ACTUALIZAR EL TICKET
                     * **
                     */
                    
                    /** Cambiar el valor de RE por Resuelto **/
                    // infoVO.setEstatusTicket("Resuelto");
                    
                    /** Cambiar el valor del estatus por "Validación"  **/
                    infoVO.setEstatusTicket("Validación");
                    try {
                        logActDescripcion = "Se invocó el servicio de SalesForce correctamente: " + AppPropsBean.getPropsVO().getUrlTpeUpdateticketWs() + "\n"
                                + "Con la información: " + infoVO.toString();
                        
                        ConsumoSoaInfraUpdateTicketAPIRestClient client = new ConsumoSoaInfraUpdateTicketAPIRestClient();
                        String retornoWsUpdate = client.callWS(infoVO);
                        logActSalesforce = "Respuesta del consumo del servicio: " + AppPropsBean.getPropsVO().getUrlTpeUpdateticketWs() + "\n"
                                + "Con la información: " + infoVO.toString() + "\n"
                                + "El web service se ejecutó satisfactoriamente y resolvió la siguiente información: " + "\n";

                        RetornoWSSalesForceInfoVO parserVO = new RetornoWSSalesForceInfoVO(retornoWsUpdate);
                        logActSalesforce = logActSalesforce + "result.....: " + (parserVO.getResult().equals("0") ? "0: Respuesta exitosa" : "1: Respuesta fallida") + "\n";
                        logActSalesforce = logActSalesforce + "Idresult..: " + parserVO.getIdresult()+ "\n";
                        logActSalesforce = logActSalesforce + "resultDescription...: " + parserVO.getResultDescription() + "\n";
                    } catch (Exception ex) {
                        logActSalesforce = logActSalesforce + "Error al consumir el ws de salesforce: \n";
                        logActSalesforce = logActSalesforce + ex.getMessage();
                    }
// resolve y resolvedescrp
                }

            } catch (Exception ex) {
                String error = ex.getMessage();
                log.error(error, ex);
                logActDescripcion = "Se produjo un error al intentar ejecutar la actualización del ticket con el PersID: " + persIdTicketSD + "\n"
                        + "Se recopiló la siguiente información: " + infoVO.toString() + "\n"
                        + "Error: " + error;

            } catch (Throwable th) {
                String error = th.getMessage();
                log.error(error, th);
                logActDescripcion = "Se produjo un error al intentar ejecutar la actualización del ticket con el PersID: " + persIdTicketSD + "\n"
                        + "Se recopiló la siguiente información: " + infoVO.toString() + "\n"
                        + "Error: " + error;

            } finally {

                // ejecutamos el log activity para la información de ServiceDesk
                this.agregarLogActivity(persIdTicketSD, logActDescripcion);
                
                // Ejecutamos el log activity para la información de SalesForce
                this.agregarLogActivity(persIdTicketSD, logActSalesforce);

            }

        } else {
            String error = "No se está recibiendo el numero de ticket a procesar.";
            log.error(error);
            throw new UpdateTicketException(error);
        }
        return retorno;
    }

    private JustificacionResolucionInfoVO obtenerJustificacion(String persIdTicket, Connection conn) throws SQLException, UpdateTicketException {
        JustificacionResolucionInfoVO retorno = null;

        // Validamos nuestros parámetros de entrada
        if (persIdTicket != null && !persIdTicket.isEmpty() && conn != null) {

            // Buscamos la información del ticket correspondiente
            String sqlBuscarJustificacion
                    = "select top 1 LOGS.id as CLAVE_LOG,                \n"
                    + "       ANALISTA.contact_uuid as UUID_ANALISTA,    \n"
                    + "       TICKET.ref_num as TICKET_FOLIO,            \n"
                    + "       TICKET.persid as TICKET_PERSID,            \n"
                    + "       LOGS.system_time as FECHA_JUSTIFICACION,   \n"
                    + "       LOGS.description as JUSTIFICACION,         \n"
                    + "       ANALISTA.last_name as ANALISTA_APELLIDOS,  \n"
                    + "	  ANALISTA.first_name as ANALISTA_NOMBRE,    \n"
                    + "       TICKET.zfolio_dbw_sf as TICKET_SALESFORCE  \n"
                    + "  from act_log as LOGS " + uNoLock + ", ca_contact as ANALISTA " + uNoLock + ",   \n"
                    + "       call_req as TICKET " + uNoLock + "                        \n"
                    + " where LOGS.analyst = ANALISTA.contact_uuid       \n"
                    + "   and TICKET.persid = LOGS.call_req_id           \n"
                    + "   and LOGS.call_req_id = ?                       \n"
                    + "   and LOGS.type = 'RE'                           \n"
                    + " order by LOGS.system_time desc                     ";
            PreparedStatement psBuscarJustificacion = conn.prepareCall(sqlBuscarJustificacion);
            psBuscarJustificacion.setString(1, persIdTicket);
            log.info("Ejecutando el query:");
            log.info(sqlBuscarJustificacion);
            log.info("Buscando " + persIdTicket);
            ResultSet rsBuscarJustificacion = psBuscarJustificacion.executeQuery();

            // Validamos si resolvió un registro
            retorno = null;
            if (rsBuscarJustificacion.next()) {

                retorno = new JustificacionResolucionInfoVO();
                retorno.setAnalistaApellidos(rsBuscarJustificacion.getString("ANALISTA_APELLIDOS"));
                retorno.setAnalistaNombre(rsBuscarJustificacion.getString("ANALISTA_NOMBRE"));
                retorno.setClaveLog(rsBuscarJustificacion.getInt("CLAVE_LOG"));
                retorno.setTimeFechaJustificacion(rsBuscarJustificacion.getLong("FECHA_JUSTIFICACION"));
                retorno.setFechaJustificacion(new java.sql.Timestamp(rsBuscarJustificacion.getInt("FECHA_JUSTIFICACION")));
                retorno.setJustificacion(rsBuscarJustificacion.getString("JUSTIFICACION"));
                retorno.setTicketFolio(rsBuscarJustificacion.getString("TICKET_FOLIO"));
                retorno.setTicketPersid(rsBuscarJustificacion.getString("TICKET_PERSID"));
                retorno.setAnalistaUuid("cnt:" + rsBuscarJustificacion.getString("UUID_ANALISTA"));
                retorno.setTicketSalesForce(rsBuscarJustificacion.getString("TICKET_SALESFORCE"));

            } else {
                // No se encontró información
                String error = "No se encontró información de justificación para el ticket persid: " + persIdTicket;
                log.error("   ::: " + error);
                throw new UpdateTicketException(error);
            }

        } else {
            String error = "No se está recibiendo el numero de ticket a procesar.";
            log.error(error);
            throw new UpdateTicketException(error);

        }
        return retorno;
    }

    private DiagnosticoInfoVO obtenerDiagnostico(String claveDiagnostico, Connection conn) throws SQLException, UpdateTicketException {
        DiagnosticoInfoVO retorno = null;
        if (claveDiagnostico != null && !claveDiagnostico.isEmpty() && conn != null) {
            String sqlBuscarDiagnostico
                    = "select DIAGNOSTICO.id as CLAVE_DIAGNOSTICO, \n"
                    + "       DIAGNOSTICO.del AS ELIMINADO,        \n"
                    + "	   DIAGNOSTICO.description as DESCRIPCION, \n"
                    + "       DIAGNOSTICO.sym as SISTEMA           \n"
                    + "  from zDiagnostico as DIAGNOSTICO  " + uNoLock + "        \n"
                    + " where DIAGNOSTICO.id = ?                     ";
            log.debug("   ::: Query para validar la información del diagnóstico...");
            log.debug(sqlBuscarDiagnostico);
            PreparedStatement psBuscarDiagnostico = conn.prepareCall(sqlBuscarDiagnostico);
            psBuscarDiagnostico.setInt(1, Integer.valueOf(claveDiagnostico));
            ResultSet rsBuscarDiagnostico = psBuscarDiagnostico.executeQuery();

            if (rsBuscarDiagnostico.next()) {
                // Cargar la información del diagnóstico
                log.info("   ::: Diagnósticop encontrado: " + rsBuscarDiagnostico.getString("DESCRIPCION"));
                retorno = new DiagnosticoInfoVO();
                retorno.setClaveDiagnostico(rsBuscarDiagnostico.getInt("CLAVE_DIAGNOSTICO"));
                retorno.setEliminado(rsBuscarDiagnostico.getInt("CLAVE_DIAGNOSTICO"));
                retorno.setDescripcion(rsBuscarDiagnostico.getString("DESCRIPCION"));
                retorno.setSistema(rsBuscarDiagnostico.getString("SISTEMA"));

            } else {
                // NO existe el diagnóstico
                String error = "No se encontró la información del diagnóstico " + claveDiagnostico;
                log.error(error);
                throw new UpdateTicketException(error);
            }
        } else {
            String warn = "El ticket no tiene asignado ningun diagnóstico";
            log.warn(warn);
        }
        return retorno;
    }

    private AreaResolutoraInfoVO obtenerAreaResolutora(String persIdTicket, String claveAreaResolutora, Connection conn) throws SQLException, UpdateTicketException {

        AreaResolutoraInfoVO retorno = null;

        /**
         * BUSCAR EL AREA RESOLUTORIA DESDE EL ULTIMO LOG ACTIVITY DE
         * TRANSFERENCIA *
         */
        log.info("   ::: Buscar area resolutoria anterior e inmediata en el log de comentarios");
        log.info("   ::: En descripción buscar que diga: 'Transferir grupo de'.");
        log.info("   ::: del ticket " + persIdTicket);
        String sqlBuscarDescripcion
                = "SELECT top 1 description \n"
                + "  FROM act_log \n"
                + " WHERE description like '%Transferir grupo de%'\n"
                + "   AND type = 'TR'\n"
                + "   AND call_req_id = ?     \n"
                + " ORDER BY SYSTEM_TIME DESC   ";
        log.debug("   ::: SQL EJECUTAR");
        log.debug(sqlBuscarDescripcion);

        // Ejecutar consulta
        PreparedStatement psBuscarDescripcion = conn.prepareCall(sqlBuscarDescripcion);
        psBuscarDescripcion.setString(1, persIdTicket);
        ResultSet rsBuscarDescripcion = psBuscarDescripcion.executeQuery();

        // Validamos el resultado de la consulta
        if (!rsBuscarDescripcion.next()) {
            String warn = "No se encontró log activity que nos pudiera proporcionar area resolutora. Buscar por clave.";
            log.warn("   ::: " + warn);
        } else {

            // Parseamos la descripción del log activity que se encontro
            // y extraemos el fragmento que corresponde al nombre de la area resolutora
            String descripcion = rsBuscarDescripcion.getString("description");
            log.info("   ::: Se encontro el reciente log: " + descripcion);
            log.info("   ::: Extraer el grupo origen: ");
            int posInicio = descripcion.indexOf("' a '");
            if (posInicio >= 0) {
                int posFinal = descripcion.indexOf("'", posInicio + 5);
                if (posFinal >= 0) {
                    posInicio = posInicio + 5;

                    // Obtenemos el nombre de la area resolutora
                    log.info("   ::: de la posicion " + posInicio + " hasta la posición " + posFinal);
                    String nombreAreaResolutoria = descripcion.substring(posInicio, posFinal);
                    log.info("   ::: Area Resolutoria: " + nombreAreaResolutoria);

                    // Buscar el area resolutora en el last_name de la tabla de contactos
                    log.info("   ::: Buscar area: " + nombreAreaResolutoria + " en el catálogo de los contactos 'ca_contact'");
                    String sqlBuscarAreaResolutora
                            = "select top 1 "
                            + "       AREA_RESOLUTORA.contact_uuid as CLAVE_AREA_RESOLUTORA,\n"
                            + "       AREA_RESOLUTORA.inactive as ELIMINADO,\n"
                            + "	      AREA_RESOLUTORA.last_name as DESCRIPCION,\n"
                            + "	      AREA_RESOLUTORA.alias as SISTEMA\n"
                            + "  from ca_contact as AREA_RESOLUTORA  " + uNoLock + "  \n"
                            + " where last_name = ?" + "\n"
                            + " order by creation_date desc ";
                    PreparedStatement psBuscarAreaResolutoria = conn.prepareCall(sqlBuscarAreaResolutora);
                    psBuscarAreaResolutoria.setString(1, nombreAreaResolutoria);
                    ResultSet rsBuscarAreaResolutoria = psBuscarAreaResolutoria.executeQuery();

                    if (!rsBuscarAreaResolutoria.next()) {
                        log.info("No se encontró el area Resolutora de nombre: " + nombreAreaResolutoria + " en el catálogo correspondiente.");
                    } else {
                        // Exraer el area reesolutoria
                        retorno = new AreaResolutoraInfoVO();
                        retorno.setClaveAreaResolutora(rsBuscarAreaResolutoria.getString("CLAVE_AREA_RESOLUTORA"));
                        retorno.setDescripcion(rsBuscarAreaResolutoria.getString("DESCRIPCION"));
                        retorno.setEliminado(rsBuscarAreaResolutoria.getInt("ELIMINADO"));
                        retorno.setSistema(rsBuscarAreaResolutoria.getString("SISTEMA"));
                        log.info("Area resolutora obtenida: " + retorno.toString());
                    }

                } else {
                    log.info("No se encontró area resolutoria por logAct.");
                }
            } else {
                log.info("No se encontró area resolutoria por logAct.");
            }
        }

        // Si no se pudo extraer el area resolucota desde la descripción del log de transferencia
        // tomamos el area resolutora del group_id del ticket, y buscamos su información en caso
        // de existir valor en este campo groupId
        if (claveAreaResolutora != null && !claveAreaResolutora.isEmpty() && retorno == null) {

            log.info("   ::: Buscar Area Resolutora con la clave: " + claveAreaResolutora);
            String sqlBuscarAreaResolutora
                    = "select TOP 1"
                    + "       AREA_RESOLUTORA.contact_uuid as CLAVE_AREA_RESOLUTORA,\n"
                    + "       AREA_RESOLUTORA.inactive as ELIMINADO,\n"
                    + "	  AREA_RESOLUTORA.last_name as DESCRIPCION,\n"
                    + "	  AREA_RESOLUTORA.alias as SISTEMA\n"
                    + "  from ca_contact as AREA_RESOLUTORA  " + uNoLock + "  \n"
                    + " where contact_uuid = 0x" + claveAreaResolutora;
            PreparedStatement psBuscarAreaResolutora = conn.prepareCall(sqlBuscarAreaResolutora);
            log.info("Query a ejecutar:");
            log.info(sqlBuscarAreaResolutora);
            // psBuscarAreaResolutora.setString(1, vo.getClaveAreaResolutora());
            ResultSet rsBuscarAreaResultora = psBuscarAreaResolutora.executeQuery();
            if (rsBuscarAreaResultora.next()) {

                // Cargamos la información de la area resolutora
                retorno = new AreaResolutoraInfoVO();
                retorno.setClaveAreaResolutora(rsBuscarAreaResultora.getString("CLAVE_AREA_RESOLUTORA"));
                retorno.setDescripcion(rsBuscarAreaResultora.getString("DESCRIPCION"));
                retorno.setEliminado(rsBuscarAreaResultora.getInt("ELIMINADO"));
                retorno.setSistema(rsBuscarAreaResultora.getString("SISTEMA"));

            } else {
                // NO existe la solucion
                String mensaje = "No se encontró la información de la Area Resolutora ID: " + claveAreaResolutora;
                log.error(mensaje);
                throw new UpdateTicketException(mensaje);
            }
        } else {
            if (retorno == null) {
                String mensaje = "El registro de la solución del ticket no tiene asignada ninguna area resolutora !!";
                log.warn(mensaje);
            }
        }

        return retorno;
    }

    private SolucionInfoVO obtenerTipoSolucion(String claveTipoSolucion, Connection conn) throws UpdateTicketException, SQLException {
        SolucionInfoVO retorno = null;
        if (claveTipoSolucion != null && !claveTipoSolucion.isEmpty() && conn != null) {

            // Consultar la información del tipo de solicón
            String sqlBuscarSolucion
                    = "select SOLUCION.id AS CLAVE_SOLUCION,        \n"
                    + "       SOLUCION.del AS ELIMINADO,            \n"
                    + "	   SOLUCION.description as DESCRIPCION, \n"
                    + "        SOLUCION.sym as SISTEMA,              \n"
                    + "	   SOLUCION.solucion as SOLUCION        \n"
                    + "  from zSolucion as SOLUCION    " + uNoLock + "             \n"
                    + " where SOLUCION.id = ?                         ";
            log.debug("Ejecutar el siguiente query...");
            log.debug(sqlBuscarSolucion);
            PreparedStatement psBuscarSolucion = conn.prepareCall(sqlBuscarSolucion);
            psBuscarSolucion.setInt(1, Integer.valueOf(claveTipoSolucion).intValue());
            ResultSet rsBuscarSolucion = psBuscarSolucion.executeQuery();
            if (rsBuscarSolucion.next()) {

                // Asignar solución encontrada al ticket
                log.info("   ::: Solución encontrada: " + rsBuscarSolucion.getString("DESCRIPCION"));
                retorno = new SolucionInfoVO();
                retorno.setClaveSolucion(rsBuscarSolucion.getInt("CLAVE_SOLUCION"));
                retorno.setDescripcion(rsBuscarSolucion.getString("DESCRIPCION"));
                retorno.setEliminado(rsBuscarSolucion.getInt("ELIMINADO"));
                retorno.setSistema(rsBuscarSolucion.getString("SISTEMA"));
                retorno.setSolucion(rsBuscarSolucion.getString("SOLUCION"));

            } else {
                // NO existe la solucion
                String mensaje = "No se encontró la información del tipo de solución clave: " + claveTipoSolucion;
                log.error(mensaje);

            }
        } else {
            String error = "No se esta recibiendo el ID del tipo de la solución y/o la conexión a la base de datos no se ha establecido correctamente.";
            log.warn(error);
        }
        return retorno;
    }

    public class UpdateInfoVO {

        private String numeroTicketSF = null;
        private String numeroTicketSD = null;
        private String estatusTicket = null;
        private String claveAreaResolutora = null;
        private String nombreAreaResolutora = null;
        private String claveTipoSolucion = null;
        private String nombreTipoSolucion = null;
        private String claveDiagnostico = null;
        private String nombreDiagnostico = null;
        private String claveLogJustificacion = null;
        private String descripcionJustificacion = null;
        private String bandeja = null;

        public String getNumeroTicketSF() {
            return numeroTicketSF;
        }

        public void setNumeroTicketSF(String numeroTicketSF) {
            this.numeroTicketSF = numeroTicketSF;
        }

        public String getNumeroTicketSD() {
            return numeroTicketSD;
        }

        public void setNumeroTicketSD(String numeroTicketSD) {
            this.numeroTicketSD = numeroTicketSD;
        }

        public String getEstatusTicket() {
            return estatusTicket;
        }

        public void setEstatusTicket(String estatusTicket) {
            this.estatusTicket = estatusTicket;
        }

        public String getClaveAreaResolutora() {
            return claveAreaResolutora;
        }

        public void setClaveAreaResolutora(String claveAreaResolutora) {
            this.claveAreaResolutora = claveAreaResolutora;
        }

        public String getNombreAreaResolutora() {
            return nombreAreaResolutora;
        }

        public void setNombreAreaResolutora(String nombreAreaResolutora) {
            this.nombreAreaResolutora = nombreAreaResolutora;
        }

        public String getClaveTipoSolucion() {
            return claveTipoSolucion;
        }

        public void setClaveTipoSolucion(String claveTipoSolucion) {
            this.claveTipoSolucion = claveTipoSolucion;
        }

        public String getNombreTipoSolucion() {
            return nombreTipoSolucion;
        }

        public void setNombreTipoSolucion(String nombreTipoSolucion) {
            this.nombreTipoSolucion = nombreTipoSolucion;
        }

        public String getClaveDiagnostico() {
            return claveDiagnostico;
        }

        public void setClaveDiagnostico(String claveDiagnostico) {
            this.claveDiagnostico = claveDiagnostico;
        }

        public String getNombreDiagnostico() {
            return nombreDiagnostico;
        }

        public void setNombreDiagnostico(String nombreDiagnostico) {
            this.nombreDiagnostico = nombreDiagnostico;
        }

        public String getClaveLogJustificacion() {
            return claveLogJustificacion;
        }

        public void setClaveLogJustificacion(String claveLogJustificacion) {
            this.claveLogJustificacion = claveLogJustificacion;
        }

        public String getDescripcionJustificacion() {
            return descripcionJustificacion;
        }

        public void setDescripcionJustificacion(String descripcionJustificacion) {
            this.descripcionJustificacion = descripcionJustificacion;
        }

        public String getBandeja() {
            return bandeja;
        }

        public void setBandeja(String bandeja) {
            this.bandeja = bandeja;
        }

        @Override
        public String toString() {
            return "UpdateInfoVO{" + "numeroTicketSF=" + numeroTicketSF + ", numeroTicketSD=" + numeroTicketSD + ", estatusTicket=" + estatusTicket + ", claveAreaResolutora=" + claveAreaResolutora + ", nombreAreaResolutora=" + nombreAreaResolutora + ", claveTipoSolucion=" + claveTipoSolucion + ", nombreTipoSolucion=" + nombreTipoSolucion + ", claveDiagnostico=" + claveDiagnostico + ", nombreDiagnostico=" + nombreDiagnostico + ", claveLogJustificacion=" + claveLogJustificacion + ", descripcionJustificacion=" + descripcionJustificacion + ", bandeja=" + bandeja + '}';
        }

    }

    private void agregarLogActivity(String persIdTicket, String descripcion) throws MalformedURLException {

        log.info("   ::: Agregando LogActivity");

        log.info("   ::: Obteniendo el id de sesión...");
        log.info("   ::: Usuario......:" + AppPropsBean.getPropsVO().getWssdUsuario());
        log.info("   ::: Password.....:" + AppPropsBean.getPropsVO().getWssdPassword());
        int sid = this.login(
                AppPropsBean.getPropsVO().getWssdUsuario(),
                AppPropsBean.getPropsVO().getWssdPassword());
        log.info("   ::: OK, se obtuvo el id de sesion: " + sid);

        log.info("   ::: Obteniendo el Handle del usuario: " + AppPropsBean.getPropsVO().getWssdUsuario() + "...");
        String handleUser = this.getHandleForUserid(sid, AppPropsBean.getPropsVO().getWssdUsuario());
        log.info("   ::: OK, se obtuvio el handle de usuario: " + handleUser);

        log.info("   ::: Generar el log activity... ");
        String retWSLogActivity = this.createActivityLog(sid, handleUser, persIdTicket, descripcion, "LOG", 0, false);
        log.info("   ::: Retorno del Log Activity: " + retWSLogActivity);

        log.info("   ::: Cerrar la sesión del WSSD...");
        this.logout(sid);
        log.info("   ::: La sesión se cerro satisfactoriamente.");

    }

    private int login(java.lang.String username, java.lang.String password) throws MalformedURLException {
        mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebService service = new mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebService(this.urlWsSD);
        mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebServiceSoap port = service.getUSDWebServiceSoap();
        return port.login(username, password);
    }

    private void logout(int sid) {
        mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebService service = new mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebService(this.urlWsSD);
        mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebServiceSoap port = service.getUSDWebServiceSoap();
        port.logout(sid);
    }

    private String createActivityLog(int sid, java.lang.String creator, java.lang.String objectHandle, java.lang.String description, java.lang.String logType, int timeSpent, boolean internal) {
        mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebService service = new mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebService(this.urlWsSD);
        mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebServiceSoap port = service.getUSDWebServiceSoap();
        return port.createActivityLog(sid, creator, objectHandle, description, logType, timeSpent, internal);
    }

    private String getHandleForUserid(int sid, java.lang.String userID) {
        mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebService service = new mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebService(this.urlWsSD);
        mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebServiceSoap port = service.getUSDWebServiceSoap();
        return port.getHandleForUserid(sid, userID);
    }

    public class RetornoWSSalesForceInfoVO {

        // Propiedades de la clase
        private String result = null;
        private String idresult = null;
        private String resultDescription = null;

        RetornoWSSalesForceInfoVO(String retXml) throws RetornoWSSalesForceException, Exception {

            Category log = Category.getInstance(RetornoWSSalesForceInfoVO.class);

            // Procesamod la cadena que recibimos como parametro
            if (retXml != null && !retXml.isEmpty()) {

                // Obtenemos el Documento
                Document docXml = this.loadXMLFromString(retXml);

                // Aplicar la normalización del documento
                docXml.getDocumentElement().normalize();

                // Obtenemos el Nodo Raiz
                log.info("   ::: Root Element :" + docXml.getDocumentElement().getNodeName());
                log.info("   ::: Documento Raiz: " + docXml.getDocumentElement().getNodeName());

                String result = docXml.getElementsByTagName("result").item(0).getTextContent();
                String Idresult = docXml.getElementsByTagName("Idresult").item(0).getTextContent();
                String resultDescription = docXml.getElementsByTagName("resultDescription").item(0).getTextContent();

                log.info("   ::: +- result: " + result);
                log.info("   ::: +- Idresult: " + Idresult);
                log.info("   ::: +- resultDescription: " + resultDescription);

                // Setear las propiedades correspondientes
                this.setIdresult(Idresult);
                this.setResult(result);
                this.setResultDescription(resultDescription);

            } else {
                log.error("No se está recibiendo la información ML a procesar !!");
                throw new RetornoWSSalesForceException("No se recibe XML para procesar !!");
            }
        }

        public Document loadXMLFromString(String xml) throws Exception {
            Document retorno = null;
            log.info("   ::: Parseando la cadena XML:");
            log.info(xml);

            if (xml != null && !xml.isEmpty()) {
                try {
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    InputSource is = new InputSource(new StringReader(xml));
                    retorno = builder.parse(is);

                } catch (Exception ex) {
                    log.error("   ::: No se puede parsear el código xml");
                    log.error(ex.getMessage(), ex);
                    throw new RetornoWSSalesForceException(ex);
                }
            } else {
                log.error("No se está recibiendo la información ML a procesar !!");
                throw new RetornoWSSalesForceException("No se recibe XML para procesar !!");
            }
            return retorno;
        }

        // Métodos getters y setters
        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getIdresult() {
            return idresult;
        }

        public void setIdresult(String idresult) {
            this.idresult = idresult;
        }

        
        public String getResultDescription() {
            return resultDescription;
        }

        public void setResultDescription(String resultDescription) {
            this.resultDescription = resultDescription;
        }

    }

    class RetornoWSSalesForceException extends Exception {

        public RetornoWSSalesForceException(String message) {
            super(message);
        }

        public RetornoWSSalesForceException(Throwable cause) {
            super(cause);
        }

    }

}
