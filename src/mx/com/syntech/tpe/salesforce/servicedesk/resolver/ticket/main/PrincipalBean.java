    package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.main;

import com.totalplay.syntech.integracion.sdm.soainfra.wssdm.soainfra.client.ConsumoSoaInfraAPIRestClient;
import com.totalplay.syntech.integracion.sdm.soainfra.wssdm.soainfra.client.ConsumoSoaInfraAPIRestException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.conectbdd.ConnectorBDDConsultasBean;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.conectbdd.ConnectorBDDConsultasException;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.core.CoreBean;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.core.CoreException;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.keys.CodeKeys;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.props.AppPropsBean;
import org.apache.log4j.Category;

/**
 * Clase para mandar la información del ticket que se resolvió
 *
 * @author dell
 */
public class PrincipalBean extends CoreBean {

    // Constantes de la clase
    private static Category log = Category.getInstance(PrincipalBean.class);
    private static final String uNoLock = "  WITH (NOLOCK) ";
    private URL url = null;

    public PrincipalBean() throws MalformedURLException {
        this.url = new URL(AppPropsBean.getPropsVO().getUrlServicedeskWs());
    }

    public void getResolucionTicket(String persid) throws CoreException {

        verCharSet();
        SolucionTicketInfoVO vo = null;
        String ticket = null;
        String ticketSalesforce = null;
        String areaResolutoria = null;
        String diagnostico = null;
        String solucion = null;

        // Validamos la información recibida
        if (persid != null && !persid.isEmpty()) {

            // Cargamos la información del ticket de salesforce y los estatus
            // Validar los siguientes campos
            // zact_realizadas  --> Resolución del ticket
            // zdiag_inicial    --> Diagnóstico inicial del ticket
            // zDiagnostico_id  --> ID del diagnóstico :: Tabla zDiagnostico.id
            // zSolucion_iD     --> ID de la solucion :: Tabla zSolucion
            // zfecha_sol       --> fecha de la soluición
            Connection conn = null;

            try {

                // Realizamos la conexióna a la base de datos de ServiceDesk
                log.info("   ::: Obtener la conexión a la base de datos...");
                conn = ConnectorBDDConsultasBean.getConectionServiceDesk();

                // Cargamos la información correspondiente al diagnóstico y solución del ticket
                String sqlBuscarInfoTicket
                        = "select ticket.id as ID_TICKET,  " + "\n"
                        + "       ticket.persid as PERSID_TICKET,  " + "\n"
                        + "       ticket.ref_num as FOLIO_TICKET,  " + "\n"
                        // + "       ticket.external_system_ticket as FOLIO_SALESFORCE,  " + "\n"
                        // Se cambia el nombre del campo del tickeyt externo 22/06/2021
                        // por el campo de zfolio_dbw_sf el cual se va a registrar el numero
                        // de ticket correspondiente a salesforce
                        + "       ticket.zfolio_dbw_sf as FOLIO_SALESFORCE,  " + "\n"
                        + "       ticket.zact_realizadas as ACTIVIDADES_REALIZADAS,  " + "\n"
                        + "       ticket.zdiag_inicial as DIAGNOSTICO_INICIAL,       " + "\n"
                        + "       ticket.zDiagnostico_id as CLAVE_DIAGNOSTICO,       " + "\n"
                        + "       ticket.zSolucion_id as CLAVE_SOLUCION,             " + "\n"
                        + "       ticket.group_id as CLAVE_AREA_RESOLUTORA, " + "\n"
                        + "       ticket.zfecha_sol AS TIME_FECHA_SOLUCION,          " + "\n"
                        + "       DATEADD(SECOND,ticket.zfecha_sol,'1970-1-1') as    " + "\n"
                        + "           FECHA_RESOLUCION                               " + "\n"
                        + "  from call_req as ticket" + uNoLock + "                  " + "\n"
                        + " where ticket.persid = ?                                  ";
                log.info("Query a ejecutar...");
                log.info(sqlBuscarInfoTicket);
                PreparedStatement psBuscarInfoTicket = conn.prepareCall(sqlBuscarInfoTicket);
                psBuscarInfoTicket.setString(1, persid);
                ResultSet rsBuscarInfoTicket = psBuscarInfoTicket.executeQuery();

                if (rsBuscarInfoTicket.next()) {
                    log.info("   ::: Ticket encontrado");

                    // Cargamos la información correspondiente
                    vo = new SolucionTicketInfoVO();
                    vo.setActividadesRealizadas(rsBuscarInfoTicket.getString("ACTIVIDADES_REALIZADAS"));
                    vo.setClaveDiagnostico(rsBuscarInfoTicket.getInt("CLAVE_DIAGNOSTICO"));
                    vo.setClaveSolucion(rsBuscarInfoTicket.getInt("CLAVE_SOLUCION"));
                    vo.setDiagnosticoInicial(rsBuscarInfoTicket.getString("DIAGNOSTICO_INICIAL"));
                    vo.setFechaSolucion(rsBuscarInfoTicket.getTimestamp("FECHA_RESOLUCION"));
                    vo.setTimeFechaSolucion(rsBuscarInfoTicket.getString("TIME_FECHA_SOLUCION"));
                    vo.setClaveAreaResolutora(rsBuscarInfoTicket.getString("CLAVE_AREA_RESOLUTORA"));
                    vo.setIdTicket(rsBuscarInfoTicket.getInt("ID_TICKET"));
                    vo.setPersIdTicket(rsBuscarInfoTicket.getString("PERSID_TICKET"));
                    vo.setFolioTicket(rsBuscarInfoTicket.getString("FOLIO_TICKET"));
                    vo.setTicketSalesforce(rsBuscarInfoTicket.getString("FOLIO_SALESFORCE"));

                    // Buscar la información del diagnóstico correspondiente
                    log.info("   ::: Validar la información del diagnóstico...");
                    if (vo.getClaveDiagnostico() != null && vo.getClaveDiagnostico() > 0) {

                        log.info("   ::: Diagnóstico de la solución del ticket: " + vo.getClaveDiagnostico());
                        log.info("   ::: Validar la información del diagnóstico... ");
                        /**
                         * CARGAR LA INFORMACIÓN ESPECIFICA DEL DIAGNÓSTICO *
                         */
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
                        psBuscarDiagnostico.setInt(1, vo.getClaveDiagnostico());
                        ResultSet rsBuscarDiagnostico = psBuscarDiagnostico.executeQuery();

                        if (rsBuscarDiagnostico.next()) {
                            // Cargar la información del diagnóstico
                            log.info("   ::: Diagnósticop encontrado: " + rsBuscarDiagnostico.getString("DESCRIPCION"));
                            vo.setDiagnosticoVO(new DiagnosticoInfoVO());
                            vo.getDiagnosticoVO().setClaveDiagnostico(rsBuscarDiagnostico.getInt("CLAVE_DIAGNOSTICO"));
                            vo.getDiagnosticoVO().setEliminado(rsBuscarDiagnostico.getInt("CLAVE_DIAGNOSTICO"));
                            vo.getDiagnosticoVO().setDescripcion(rsBuscarDiagnostico.getString("DESCRIPCION"));
                            vo.getDiagnosticoVO().setSistema(rsBuscarDiagnostico.getString("SISTEMA"));

                        } else {
                            // NO existe el diagnóstico
                            String mensaje = "No se encontró la información del diagnóstico " + vo.getClaveDiagnostico();
                            log.error(mensaje);
                            String codigo = CodeKeys.CODE_135_CLAVE_DIAGNOSTICO_NO_EXISTE;
                            throw new PrincipalException(codigo, new Exception(mensaje));
                        }
                    } else {
                        String mensaje = "El registro de la solución del ticket no tiene asignado ningun diangóstico !!";
                        log.warn(mensaje);
                        // String codigo = CodeKeys.CODE_130_SIN_DIAGNOSTICO_CATALOGO;
                        // throw new PrincipalException(codigo, new Exception(mensaje));
                    }

                    /**
                     * CARGAR LA INFORMACIÓN ESPECIFICA DE LA SOLUCIÓN *
                     */
                    if (vo.getClaveSolucion() != null && vo.getClaveSolucion() > 0) {
                        log.info("   ::: Buscar la información de la solución: " + vo.getClaveSolucion());
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
                        psBuscarSolucion.setInt(1, vo.getClaveSolucion());
                        ResultSet rsBuscarSolucion = psBuscarSolucion.executeQuery();
                        if (rsBuscarSolucion.next()) {

                            // Asignar solución encontrada al ticket
                            log.info("   ::: Solución encontrada: " + rsBuscarSolucion.getString("DESCRIPCION"));
                            vo.setSolucionVO(new SolucionInfoVO());
                            vo.getSolucionVO().setClaveSolucion(rsBuscarSolucion.getInt("CLAVE_SOLUCION"));
                            vo.getSolucionVO().setDescripcion(rsBuscarSolucion.getString("DESCRIPCION"));
                            vo.getSolucionVO().setEliminado(rsBuscarSolucion.getInt("ELIMINADO"));
                            vo.getSolucionVO().setSistema(rsBuscarSolucion.getString("SISTEMA"));
                            vo.getSolucionVO().setSolucion(rsBuscarSolucion.getString("SOLUCION"));

                        } else {
                            // NO existe la solucion
                            String mensaje = "No se encontró la información de la solución " + vo.getClaveSolucion();
                            log.warn(mensaje);
                            String codigo = CodeKeys.CODE_145_CLAVE_SOLUCION_NO_EXISTE;
                            throw new PrincipalException(codigo, new Exception(mensaje));
                        }

                    } else {
                        String mensaje = "El registro de la solución del ticket no tiene asignado ninguna solución !!";
                        log.warn(mensaje);
                        // String codigo = CodeKeys.CODE_140_SIN_SOLUCION_CATALOGO;
                        // throw new PrincipalException(codigo, new Exception(mensaje));
                    }

                    /**
                     * Cambio del 29 de Junio del 2021 VALIDAMOS Y CARGAMOS LA
                     * INFORMACIÓN ESPECIFICA DE LA AREA RESOLUTORIA PARA ESTE
                     * CASO PRIMERO VAMOS A BUSCAR LA PRIMER TRANSFERENCIA DE
                     * GRUPO INMEDIATA ANTERIOR QUE SE HAYA EJECUTADO Y
                     */
                    log.info("   ::: Buscar area resolutoria anterior e inmediata en el log de comentarios");
                    log.info("   ::: En descripción buscar que diga: 'Transferir grupo de'.");
                    log.info("   ::: del ticket " + vo.getPersIdTicket());
                    String sqlBuscarDescripcion
                            = "SELECT top 1 description \n"
                            + "  FROM act_log \n"
                            + " WHERE description like '%Transferir grupo de%'\n"
                            + "   AND type = 'TR'\n"
                            + "   AND call_req_id = ?     \n"
                            + " ORDER BY SYSTEM_TIME DESC   ";
                    log.debug("SQL EJECUTAR");
                    log.debug(sqlBuscarDescripcion);
                    PreparedStatement psBuscarDescripcion = conn.prepareCall(sqlBuscarDescripcion);
                    psBuscarDescripcion.setString(1, vo.getPersIdTicket());
                    ResultSet rsBuscarDescripcion = psBuscarDescripcion.executeQuery();
                    if (rsBuscarDescripcion.next()) {
                        String descripcion = rsBuscarDescripcion.getString("description");
                        log.info("Se encontro el reciente log: " + descripcion);
                        log.info("Extraer el grupo origen: ");
                        int posInicio = descripcion.indexOf("' a '");
                        if (posInicio >= 0) {
                            int posFinal = descripcion.indexOf("'", posInicio + 5);
                            if (posFinal >= 0) {
                                posInicio = posInicio + 5;
                                log.info("de la posicion " + posInicio + " hasta la posición " + posFinal);
                                String nombreAreaResolutoria = descripcion.substring(posInicio, posFinal);
                                log.info("Area Resolutoria: " + nombreAreaResolutoria);

                                log.info("Buscar area: " + nombreAreaResolutoria + " en el catálogo de los contactos 'ca_contact'");
                                String sqlBuscarAreaResolutora
                                        = "select top 1 AREA_RESOLUTORA.contact_uuid as CLAVE_AREA_RESOLUTORA,\n"
                                        + "       AREA_RESOLUTORA.inactive as ELIMINADO,\n"
                                        + "	   AREA_RESOLUTORA.last_name as DESCRIPCION,\n"
                                        + "	   AREA_RESOLUTORA.alias as SISTEMA\n"
                                        + "  from ca_contact as AREA_RESOLUTORA  " + uNoLock + "  \n"
                                        + " where last_name = ?" + "\n"
                                        + " order by creation_date desc ";
                                PreparedStatement psBuscarAreaResolutoria = conn.prepareCall(sqlBuscarAreaResolutora);
                                psBuscarAreaResolutoria.setString(1, nombreAreaResolutoria);
                                ResultSet rsBuscarAreaResolutoria = psBuscarAreaResolutoria.executeQuery();

                                if (rsBuscarAreaResolutoria.next()) {
                                    // Exraer el area reesolutoria
                                    vo.setAreaResolutoraVO(new AreaResolutoraInfoVO());
                                    vo.getAreaResolutoraVO().setClaveAreaResolutora(rsBuscarAreaResolutoria.getString("CLAVE_AREA_RESOLUTORA"));
                                    vo.getAreaResolutoraVO().setDescripcion(rsBuscarAreaResolutoria.getString("DESCRIPCION"));
                                    vo.getAreaResolutoraVO().setEliminado(rsBuscarAreaResolutoria.getInt("ELIMINADO"));
                                    vo.getAreaResolutoraVO().setSistema(rsBuscarAreaResolutoria.getString("SISTEMA"));
                                    log.info("Area resolutora obtenida: " + vo.getAreaResolutoraVO().toString());
                                } else {
                                    log.error("No se encontró el area resolutara de nombre: " + nombreAreaResolutoria);
                                }

                            } else {
                                log.info("No se encontró area resolutoria por logAct.");
                            }
                        } else {
                            log.info("No se encontró area resolutoria por logAct.");
                        }
                    } else {
                        log.warn("No se encontró log activity que nos pudiera proporcionar area resolutora. Buscar por clave.");
                    }

                    // Validamos si no se encontró area resolutora por medio de los activity y se está
                    // recibiedo la clave en el VO buscamos la clave en el catalogo de contactos ca_contacts
                    if (vo.getClaveAreaResolutora() != null && !vo.getClaveAreaResolutora().isEmpty()
                            && vo.getAreaResolutoraVO() == null) {
                        log.info("   ::: Buscar Area Resolutora con la clave: " + vo.getClaveAreaResolutora());
                        String sqlBuscarAreaResolutora
                                = "select AREA_RESOLUTORA.contact_uuid as CLAVE_AREA_RESOLUTORA,\n"
                                + "       AREA_RESOLUTORA.inactive as ELIMINADO,\n"
                                + "	   AREA_RESOLUTORA.last_name as DESCRIPCION,\n"
                                + "	   AREA_RESOLUTORA.alias as SISTEMA\n"
                                + "  from ca_contact as AREA_RESOLUTORA  " + uNoLock + "  \n"
                                + " where contact_uuid = 0x" + vo.getClaveAreaResolutora();
                        PreparedStatement psBuscarAreaResolutora = conn.prepareCall(sqlBuscarAreaResolutora);
                        log.info("Query a ejecutar:");
                        log.info(sqlBuscarAreaResolutora);
                        // psBuscarAreaResolutora.setString(1, vo.getClaveAreaResolutora());
                        ResultSet rsBuscarAreaResultora = psBuscarAreaResolutora.executeQuery();
                        if (rsBuscarAreaResultora.next()) {

                            // Cargamos la información de la area resolutora
                            vo.setAreaResolutoraVO(new AreaResolutoraInfoVO());
                            vo.getAreaResolutoraVO().setClaveAreaResolutora(rsBuscarAreaResultora.getString("CLAVE_AREA_RESOLUTORA"));
                            vo.getAreaResolutoraVO().setDescripcion(rsBuscarAreaResultora.getString("DESCRIPCION"));
                            vo.getAreaResolutoraVO().setEliminado(rsBuscarAreaResultora.getInt("ELIMINADO"));
                            vo.getAreaResolutoraVO().setSistema(rsBuscarAreaResultora.getString("SISTEMA"));

                        } else {
                            // NO existe la solucion
                            String mensaje = "No se encontró la información de la Area Resolutora: " + vo.getClaveAreaResolutora();
                            log.error(mensaje);
                            String codigo = CodeKeys.CODE_150_SIN_AREA_RESOLUTORA_CATALOGO;
                            throw new PrincipalException(codigo, new Exception(mensaje));
                        }

                    } else {
                        if (vo.getAreaResolutoraVO() == null) {
                            String mensaje = "El registro de la solución del ticket no tiene asignada ninguna area resolutora !!";
                            log.warn(mensaje);
                            // String codigo = CodeKeys.CODE_150_SIN_AREA_RESOLUTORA_CATALOGO;
                            // throw new PrincipalException(codigo, new Exception(mensaje));
                        }
                    }

                    // Con la información recabada armamos la petición al ws de salesforce
                    log.info("   ::: Enviar la siguiente información a salesforce:");
                    log.info("   ::: Número de ticket (SD)....: " + vo.getFolioTicket());
                    log.info("   ::: Número de ticket (SF)....: " + vo.getTicketSalesforce());
                    log.info("   ::: Area resolutoria.........: " + (vo.getAreaResolutoraVO() == null ? "NO_ASIGNADO" : vo.getAreaResolutoraVO().getDescripcion()));
                    log.info("   ::: Diagnóstico final........: " + (vo.getDiagnosticoVO() == null ? "" : vo.getDiagnosticoVO().getDescripcion() + "."));

                    log.info("   ::: Solución.................: " + (vo.getSolucionVO() == null ? "" : vo.getSolucionVO().getDescripcion() + "."));
                    ticket = (vo.getFolioTicket() != null ? vo.getFolioTicket().replaceAll("\"", "'") : "");
                    ticketSalesforce = vo.getTicketSalesforce() != null ? vo.getTicketSalesforce().replaceAll("\"", "'") : "";
                    areaResolutoria = (vo.getAreaResolutoraVO() == null ? "NO_ASIGNADO" : vo.getAreaResolutoraVO().getDescripcion()).replaceAll("\"", "'");
                    diagnostico = (vo.getDiagnosticoVO() == null ? "" : vo.getDiagnosticoVO().getDescripcion() + ".").replaceAll("\"", "'");
                    solucion = ((vo.getSolucionVO() == null ? "" : vo.getSolucionVO().getDescripcion() + ".")).replaceAll("\"", "'");
                    ConsumoSoaInfraAPIRestClient clientSoa = new ConsumoSoaInfraAPIRestClient();

                    String retWS = clientSoa.callWSTicketUpdate(ticket, areaResolutoria, diagnostico, solucion, ticketSalesforce);
                    log.info("   ::: Resultado del WS: " + retWS);
                    // Parseamos el resultado del ws
                    String wsResultado = ParsearXML.parsearResultado(retWS);
                    String wsDescripcion = ParsearXML.parsearDescripcion(retWS);

                    log.info("   ::: Resultado Parseado: " + wsResultado);
                    log.info("   ::: Descripción Parseada: " + wsDescripcion);

                    log.info("   ::: Agregar la información al log activity del ticket");
                    log.info("   ::: Obtener el ID de sesión para el WS de SD");
                    int sid = this.login(AppPropsBean.getPropsVO().getWssdUsuario(),
                            AppPropsBean.getPropsVO().getWssdPassword());
                    log.info("   ::: ID de sesión................: " + sid);

                    String creator = this.getHandleForUserid(sid, AppPropsBean.getPropsVO().getWssdUsuario());
                    log.info("   ::: creator.....................: " + sid);
                    log.info("   ::: Object Handle (persid)......: " + vo.getPersIdTicket());

                    String descripcion
                            = "Ticket: " + vo.getFolioTicket() + "\n"
                            + ". Area Resolutoria: " + (vo.getAreaResolutoraVO() == null ? "NO ESPECIFICADO" : vo.getAreaResolutoraVO().getDescripcion()) + "\n"
                            + ". Diagnóstico final: " + (vo.getDiagnosticoVO() == null ? "NO ESPECIFICADO" : vo.getDiagnosticoVO().getDescripcion() + ".") + "\n"
                            + ". Solución: " + (vo.getSolucionVO() == null ? "NO ESPECIFICADO" : vo.getSolucionVO().getDescripcion()) + "\n"
                            + ". El consumo del web service: " + AppPropsBean.getPropsVO().getUrlTpeUpdateticketWs() + " reporta:";
                    if (wsResultado.equals("1")) {
                        // Ejecutó satisfactoriamente
                        descripcion = descripcion
                                + "Se produjo un error con la información enviada: " + wsDescripcion;
                    } else {
                        descripcion = descripcion
                                + "La información se procesó satisfactoriamente.";
                    }

                    // enviar activity log
                    log.info("   ::: Agregando el LogActivity a SDM...");
                    String logActivity = this.createActivityLog(sid, creator, vo.getPersIdTicket(), descripcion, "LOG", 0, Boolean.FALSE);
                    log.info("   ::: Log activity de SD devolvio:" + logActivity);

                    // cerramos la sesión
                    this.logout(sid);

                } else {
                    log.error("   ::: No se encontró el ticket persid: " + persid);
                }
            } catch (ConsumoSoaInfraAPIRestException ex) {
                String error
                        = "   ::: Error en el consumo del servicio web para la resolución del ticke SDM: "
                        + persid + " desde el servicio de salesforce. Error al consumir el WS: "
                        + AppPropsBean.getPropsVO().getUrlTpeUpdateticketWs()+ "\n"
                        + "Con la siguiente información:"
                        + "ticket:" + ticket + ", "
                        + "areaResolutoria:" + areaResolutoria + ", "
                        + "diagnostico:" + diagnostico + ", "
                        + "solucion:" + solucion + "\n"
                        + "Error recibido: " + (ex.getLocalizedMessage() == null ? ex.getMessage() : ex.getLocalizedMessage());
                log.error(error);

                // Agregamos en el log de actividades del ticket
                log.error("   ::: Agregamos este error en el log de actividades del ticket correspondiente");
                int sid = this.login(AppPropsBean.getPropsVO().getWssdUsuario(),
                        AppPropsBean.getPropsVO().getWssdPassword());
                log.error("   ::: ID de sesión................: " + sid);

                String creator = this.getHandleForUserid(sid, AppPropsBean.getPropsVO().getWssdUsuario());
                log.error("   ::: creator.....................: " + sid);
                log.error("   ::: Object Handle (persid)......: " + vo.getPersIdTicket());

                String logActivity = this.createActivityLog(sid, creator, vo.getPersIdTicket(), error, "LOG", 0, Boolean.FALSE);
                log.error("   ::: Log activity de SD devolvió:" + logActivity);

                // Cerrar sesión con el logout
                this.logout(sid);

                // Disparar exceptión
                throw new PrincipalException(CodeKeys.CODE_360_SALESFORCE_SOA_WSERROR, new Exception(ex.getMessage()));

            } catch (ConnectorBDDConsultasException ex) {
                throw new PrincipalException(ex.getIdError(), new Exception(ex.getMensaje()));
            } catch (SQLException ex) {
                throw new PrincipalException(CodeKeys.CODE_320_DATABASE_SQLERROR, ex);

                /**
                 * } catch (Exception ex) {
                 *
                 * } catch (Throwable th) {*
                 */
            } finally {
                // Cerramos la conexióna a la base de datos
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Exception ex) {
                        log.error("   ::: No se puede cerrar la conexióna a la base de datos: " + ex.getLocalizedMessage());
                    } catch (Throwable th) {
                        log.error("   ::: No se puede cerrar la conexióna a la base de datos: " + th.getLocalizedMessage());
                    }
                }
            }

        } else {
            String error = "   ::: No se está recibiendo información del ticket";
            throw new CoreException(CodeKeys.CODE_010_SIN_INFORMACION, new Exception(error));
        }

    }

    /**
     * Método para enviar la información de la resolución del ticket al servicio
     * web de DBW-SF Y como segundo paso se debe de agregar al logactivity del
     * ticket el resultado del servicio web de DBW-SF. La cadena que va a
     * recibir el servicio web de DBW-SF va a recibir el usuario que relizó la
     * solución del ticket concatenado con la justificación del ticket La
     * justificación del ticket se obtiene del logactivity del ticket en donde
     * el estatus es RESUELTO. Puede existir un ticket que despues de resuelto
     * vuela a otra estado y posteriormente vuelva a estar resuelto, Para este
     * caso tomamos la información del ultimo resuelto por fecha de registro
     *
     * @param persidTicket
     * @return
     * @throws PrincipalException
     */
    @Deprecated
    public PrincipalResultadoVO sendJustificacionDeResolucionDeTicket(String persidTicket) throws PrincipalException {
        verCharSet();
        PrincipalResultadoVO retorno = null;
        log.info("Procesando la Justificació para el Objeto: " + persidTicket);
        // Validamos el   de entrada
        if (persidTicket != null && !persidTicket.isEmpty()) {

            // Inicializamos nuestro elemento de retorno
            retorno = new PrincipalResultadoVO();

            // Definir el conector a la basew de datos
            Connection conn = null;

            try {

                // Iniciar el conector a la base de datos
                log.info("Conectando a la base de datos... ");
                conn = ConnectorBDDConsultasBean.getConectionServiceDesk();

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
                psBuscarJustificacion.setString(1, persidTicket);
                log.info("Ejecutando el query:");
                log.info(sqlBuscarJustificacion);
                log.info("Buscando " + persidTicket);
                ResultSet rsBuscarJustificacion = psBuscarJustificacion.executeQuery();

                // Validamos si resolvió un registro
                JustificacionResolucionInfoVO justificacionVO = null;
                if (rsBuscarJustificacion.next()) {

                    justificacionVO = new JustificacionResolucionInfoVO();
                    justificacionVO.setAnalistaApellidos(rsBuscarJustificacion.getString("ANALISTA_APELLIDOS"));
                    justificacionVO.setAnalistaNombre(rsBuscarJustificacion.getString("ANALISTA_NOMBRE"));
                    justificacionVO.setClaveLog(rsBuscarJustificacion.getInt("CLAVE_LOG"));
                    justificacionVO.setTimeFechaJustificacion(rsBuscarJustificacion.getLong("FECHA_JUSTIFICACION"));
                    justificacionVO.setFechaJustificacion(new java.sql.Timestamp(rsBuscarJustificacion.getInt("FECHA_JUSTIFICACION")));
                    justificacionVO.setJustificacion(rsBuscarJustificacion.getString("JUSTIFICACION"));
                    retorno.setLogActivityDescription(rsBuscarJustificacion.getString("JUSTIFICACION"));
                    retorno.setEstatusTicket("Resuelto");
                    justificacionVO.setTicketFolio(rsBuscarJustificacion.getString("TICKET_FOLIO"));
                    justificacionVO.setTicketPersid(rsBuscarJustificacion.getString("TICKET_PERSID"));
                    justificacionVO.setAnalistaUuid("cnt:" + rsBuscarJustificacion.getString("UUID_ANALISTA"));
                    justificacionVO.setTicketSalesForce(rsBuscarJustificacion.getString("TICKET_SALESFORCE"));

                    // Consumir el ws para enviar la información al servicio wev
                    String retornoWS = this.enviarInfoSoa(justificacionVO);
                    String justificacionEnviada
                            = "El analista: \"" + justificacionVO.getAnalistaApellidos()
                            + ", " + justificacionVO.getAnalistaNombre()
                            + "\" Registra la justificación: \""
                            + justificacionVO.getJustificacion() + "\"";
                    // Agregamos el logActivity el resultado del retorno
                    this.agregarLogActivity(
                            justificacionVO.getTicketFolio(),
                            justificacionVO.getTicketPersid(),
                            justificacionEnviada,
                            justificacionVO.getAnalistaUuid(),
                            retornoWS,
                            justificacionVO.getTicketSalesForce());
                } else {
                    // No se encontró información
                    String error = "No se encontró información de justificación para el ticket persid: " + persidTicket;
                    log.error("   ::: " + error);
                    throw new PrincipalException(CodeKeys.CODE_160_INFORMACION_NO_ENCONTRADA, new Exception(error));
                }
            } catch (SQLException ex) {
                String error = "Error al intentan recuperar la información de la justificación";
                log.error("   ::: " + error + " --> " + ex.getMessage());
                throw new PrincipalException(CodeKeys.CODE_320_DATABASE_SQLERROR, ex);

            } catch (ConnectorBDDConsultasException ex) {
                String error = "No se pudo establecer la conexión a la base de datos";
                log.error("   ::: " + error + " --> " + ex.getMensaje());
                throw new PrincipalException(ex.getIdError(), ex);

            } catch (Exception ex) {
                String error = "Error " + ex.getMessage();
                log.error("   ::: " + error + " --> " + ex.getLocalizedMessage());
                throw new PrincipalException(CodeKeys.CODE_980_ERROR, ex);

            } catch (Throwable ex) {
                String error = "Error " + ex.getMessage();
                log.error("   ::: " + error + " --> " + ex.getLocalizedMessage());
                throw new PrincipalException(CodeKeys.CODE_980_ERROR, ex);

            } finally {

                // Cerrar y liberar los elementos abiertos
                // Intentamos cerrar nuestra conexión a la base de datos en caso de que aplique
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Exception ex) {
                        log.error("Error al intenar cerrar la base de datos: " + ex.getMessage());
                    } catch (Throwable th) {
                        log.error("Error al intenar cerrar la base de datos: " + th.getMessage());
                    }
                }
            }

        } else {
            String error = "No se está recibiendo el persid de ticket a procesar";
            log.error("   ::: " + error);
            throw new PrincipalException(CodeKeys.CODE_010_SIN_INFORMACION, new Exception(error));
        }

        return retorno;
    }

    private String enviarInfoSoa(JustificacionResolucionInfoVO infoVO) throws PrincipalException {

        String retorno = null;

        // Validar nuestro parámetro de entrada
        if (infoVO != null) {
            try {
                log.info("   ::: Enviando la información SF pra sincronizar la resolución del ticket");
                String ticketSD = infoVO.getTicketFolio();
                String ticketSF = infoVO.getTicketSalesForce();
                String justificacion
                        = "El analista: \"" + infoVO.getAnalistaApellidos()
                        + ", " + infoVO.getAnalistaNombre()
                        + "\" Registra la justificación: \""
                        + infoVO.getJustificacion() + "\"";
                log.info("   ::: Ticket a enviar: SD:" + ticketSD + ", SF:" + ticketSF);
                log.info("   ::: Justificación a enviar: " + justificacion);
                ConsumoSoaInfraAPIRestClient client = new ConsumoSoaInfraAPIRestClient();
                log.info("   ::: Enviando información...");
                retorno = client.callWS(justificacion, ticketSF);

                log.info("   ::: La información se envio y el ws respondió: " + retorno);

                // Agregamos est
            } catch (ConsumoSoaInfraAPIRestException ex) {
                String error = "Error al enviar la información a: "
                        // + AppPropsBean.getPropsVO().getUrlTpeJustificacionWs() + ". "
                        + "Error: " + ex.getLocalizedMessage();
                log.error(error);

                log.error("Enviar error al log de actividades...");
                log.error("Obteniendo id de sesión...");
                int sid = login(AppPropsBean.getPropsVO().getWssdUsuario(), AppPropsBean.getPropsVO().getWssdPassword());
                log.error("SID: " + sid);

                // Armamos la información para enviar al los activity
                String creator = this.getHandleForUserid(sid, AppPropsBean.getPropsVO().getWssdUsuario());
                String retLogActivity = this.createActivityLog(
                        sid, creator, infoVO.getTicketPersid(), error, "LOG", 0, Boolean.FALSE);

                log.error("Log activity devolvió: " + sid);
                log.error("Cerrar sesión: " + retLogActivity);
                logout(sid);

                throw new PrincipalException(CodeKeys.CODE_360_SALESFORCE_SOA_WSERROR, new Exception(error));

            }
        } else {
            throw new PrincipalException(CodeKeys.CODE_100_SIN_INFORMACION_TRABAJAR, new Exception("No se está recibiendo la información de la justificación como se esperaba"));
        }

        return retorno;

    }

    private String agregarLogActivity(String ticketFolioSD, String ticketPersidSD, String justificacionEnviada, String uuidCreator, String retornoWsSOA, String ticketSalesforce) {
        String retorno = null;

        log.info("   ::: Agregar el log activity para el SDM (resolución)");

        // Obtenemos el sid
        int sid = this.login(AppPropsBean.getPropsVO().getWssdUsuario(), AppPropsBean.getPropsVO().getWssdPassword());

        // Preparamos los parámetros para el log activity
        log.info("   ::: ID de sesión         : " + sid);
        log.info("   ::: Justificación        : " + justificacionEnviada);
        log.info("   ::: Creator              : " + uuidCreator);
        log.info("   ::: Retorno del SOA      : " + retornoWsSOA);
        log.info("   ::: Ticket en SD         : " + ticketFolioSD + " (persid:" + ticketPersidSD + ")");
        log.info("   ::: Ticket en Salesforce : " + ticketSalesforce);

        String descripcion
                = // "WS invocado: " + AppPropsBean.getPropsVO().getUrlTpeJustificacionWs() + "\n"
                "Información enviada: " + justificacionEnviada + "\n"
                + "Retorno del SOA:" + retornoWsSOA;
        log.info("   ::: Descripción       : " + descripcion);
        String tipoLog = "LOG";
        log.info("   ::: Tipo de Activity  : " + tipoLog);
        int timeSpent = 0;
        Boolean internal = Boolean.FALSE;

        log.info("   ::: Creando el log activity...");

        String retornoLogActivity = this.createActivityLog(sid, uuidCreator, ticketPersidSD, descripcion, tipoLog, timeSpent, internal);
        log.info("   ::: Log Activity ejecutado");
        log.info("   ::: Retorno del log activity: " + retornoLogActivity);

        log.info("   ::: Cerrando la SID: " + sid + " ...");
        this.logout(sid);

        log.info("   ::: Proceso terminado !!");
        return retorno;
    }

    private int login(java.lang.String username, java.lang.String password) {
        mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebService service = new mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebService(this.url);
        mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebServiceSoap port = service.getUSDWebServiceSoap();
        return port.login(username, password);
    }

    private String createActivityLog(int sid, java.lang.String creator, java.lang.String objectHandle, java.lang.String description, java.lang.String logType, int timeSpent, boolean internal) {
        mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebService service = new mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebService(this.url);
        mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebServiceSoap port = service.getUSDWebServiceSoap();
        return port.createActivityLog(sid, creator, objectHandle, description, logType, timeSpent, internal);
    }

    private void logout(int sid) {
        mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebService service = new mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebService(this.url);
        mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebServiceSoap port = service.getUSDWebServiceSoap();
        port.logout(sid);
    }

    private String getHandleForUserid(int sid, java.lang.String userID) {
        mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebService service = new mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebService(this.url);
        mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client.USDWebServiceSoap port = service.getUSDWebServiceSoap();
        return port.getHandleForUserid(sid, userID);
    }

}
