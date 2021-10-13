package mx.com.syntech.tpe.salesforce.servicedesk.changestatus.principal;

import com.totalplay.syntech.integracion.sdm.soainfra.wssdm.soainfra.client.ConsumoSoaInfraAPIRestClient;
import com.totalplay.syntech.integracion.sdm.soainfra.wssdm.soainfra.client.ConsumoSoaInfraChangeStatusAPIRestClient;
import com.totalplay.syntech.integracion.sdm.soainfra.wssdm.soainfra.client.InputWsInfoVO;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.conectbdd.ConnectorBDDConsultasBean;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.core.CoreBean;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.props.AppPropsBean;
import org.apache.log4j.Category;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 * Nombre del componente/API ChangeStatusSF
 *
 * Descripción Este componente se va a encargar de enviar la información de
 * cambio de estado de algun ticket en particular. Los valores que se deben de
 * recibir desde la linea de comando son:
 *
 * ID del ticket en formato cr:1321654
 *
 * El componente va a invocar el servicio de:
 * http://localhost:8084/soa-infra/resources/SalesForce/ChangeStatusTicketSF/RestChangeStatus/ChangeStatus
 * de TPE, el cual va a recibir la información correspondiente
 *
 * @author dell
 */
public class ChangeStatusSFBean extends CoreBean {

    // Constantes fijas de la clase
    private static final Category log = Category.getInstance(ChangeStatusSFBean.class);
    private static final String uNoLock = "  WITH (NOLOCK) ";

    // Variables de la clase
    private URL urlWsSD = null;

    public ChangeStatusSFBean() throws MalformedURLException {
        urlWsSD = new URL(AppPropsBean.getPropsVO().getUrlServicedeskWs());
    }

    @Deprecated
    public ChangeStatusSFRetornoVO cambiarEstatus(
            String persIdTicket,
            String subEstatus,
            String comentarios) throws ChangeStatusException {

        ChangeStatusSFRetornoVO retorno = null;

        log.info("Cambiar estatus del persIdTicket: " + persIdTicket);

        // Validar los parámetros de entrada
        if (persIdTicket != null && !persIdTicket.isEmpty() // && estatus != null && !estatus.isEmpty()
                && subEstatus != null && !subEstatus.isEmpty()
                && comentarios != null && !comentarios.isEmpty() // && usuario!=null && !usuario.isEmpty()
                ) {

            Connection conn = null;

            // Inicializamos nuestro valor de retorno
            try {

                // Inicializamos nuestra conexión a la base de datos
                log.info("Conectando a la base de datos...");
                conn = ConnectorBDDConsultasBean.getConectionServiceDesk();
                log.info("Conexión a la base de datos satisfactoria !!");

                // Validar que el usuario dea de N" o superior
                // Buscar la información del ticket
                log.info("   ::: Buscar la información del persIdTicket: " + persIdTicket);
                String sqlBuscarInfoTicket
                        = "SELECT id, persid,             \n"
                        + "       ref_num,                \n"
                        + "       status,                 \n"
                        + "       active_flag,            \n"
                        + "       zfolio_dbw_sf,          \n"
                        + "       zgrp_origen_sf          \n"
                        + "   FROM call_req" + uNoLock + "\n"
                        + "  WHERE persId = ?             \n";
                log.info("Ejecutando SQL");
                log.info(sqlBuscarInfoTicket);

                PreparedStatement psBuscarInfoTicket = conn.prepareCall(sqlBuscarInfoTicket);
                psBuscarInfoTicket.setString(1, persIdTicket);
                ResultSet rsBuscarInfoTicket = psBuscarInfoTicket.executeQuery();

                if (rsBuscarInfoTicket.next()) {

                    // Preparamos el elemento con la información 
                    log.info("   ::: Se encontró la información del ticket");
                    log.info("   ::: Ticket ID.............: " + rsBuscarInfoTicket.getString("id"));
                    log.info("   ::: Número/Folio (web)....: " + rsBuscarInfoTicket.getString("ref_num"));
                    log.info("   ::: Estatus...............: " + rsBuscarInfoTicket.getString("status"));
                    log.info("   ::: Activo................: " + rsBuscarInfoTicket.getString("active_flag"));
                    log.info("   ::: Folio de Salesforce...: " + rsBuscarInfoTicket.getString("zfolio_dbw_sf"));
                    log.info("   ::: Bandeja...............: " + rsBuscarInfoTicket.getString("zgrp_origen_sf"));
                    log.info("   ::: Validar el usuario que se está recibiendo como parámetro");

                    log.info("   ::: Revisar el origen del ticket, que provenga de SalesForce ppor medio del capo zFolio_dbw_sf");
                    String ticketSF = rsBuscarInfoTicket.getString("zfolio_dbw_sf");
                    if (ticketSF == null || ticketSF.isEmpty()) {
                        String error = "El Número de Ticket de ServiceDesk: "
                                + rsBuscarInfoTicket.getString("ref_num")
                                + " no esta relacionado con algún ticket de Salesforce."
                                + " Verifique la información y vuelva a intentarlo.";
                        log.error("   ::: OPERACIÓN INVÁLIDA !!!");
                        log.error(error);
                        throw new ChangeStatusException(error);
                    }

                    log.info("   ::: Revisar el tipo de usuario que sea de Service Desk N2 o superior");

                    InputWsInfoVO infoWsVO = new InputWsInfoVO();
                    infoWsVO.setBandeja(rsBuscarInfoTicket.getString("zgrp_origen_sf"));
                    infoWsVO.setComment(comentarios);
                    infoWsVO.setIp(InetAddress.getLocalHost().toString());
                    infoWsVO.setNoTicket(rsBuscarInfoTicket.getString("ref_num"));
                    infoWsVO.setPassword(AppPropsBean.getPropsVO().getWsTpeChangestatusPassword());
                    // infoWsVO.setStatus(this.covertirStatusSDtoSF(rsBuscarInfoTicket.getString("status")));
                    
                    /**
                     * Cambio de Resuelto a validación
                     * 13/octubre/20121
                     * Sol. Dante Clvo
                     */
                    // infoWsVO.setStatus("Resuelto");
                    infoWsVO.setStatus("Validación");
                    infoWsVO.setSubStatus("NA");
                    infoWsVO.setTicketSF(this.covertirStatusSDtoSF(rsBuscarInfoTicket.getString("zfolio_dbw_sf")));
                    infoWsVO.setUserId(AppPropsBean.getPropsVO().getWsTpeChangestatusUsuario());
                    String retornoWS = null;
                    String descLogActivity = null;
                    descLogActivity = "Resultado del servicio de ChangeStatusSF con los parámetros: " + "\n"
                            + infoWsVO.toString() + "\n";

                    // Enviamos la información al servicio web se sf
                    try {
                        log.info("   ::: Invocando ws de SD: ");
                        // log.info("   ::: URL: " + AppPropsBean.getPropsVO().getUrltpechangestatusWs());
                        log.info("   ::: Parámetros: " + infoWsVO.toString());
                        log.info("   ::: ejecutando...");
                        ConsumoSoaInfraChangeStatusAPIRestClient clientWS = new ConsumoSoaInfraChangeStatusAPIRestClient();
                        retornoWS = clientWS.callWS(infoWsVO);

                        /**
                         * Para el caso del retorno del WS recibimos algo con el
                         * siguiente formato
                         * <processResponse xmlns="http://xmlns.oracle.com/PortalControlRemoto/ChangeStatus/ChangeStatus">
                         * <Result>0</Result>
                         * <IdResult>3842712</IdResult>
                         * <ResultDescription>Cambio de estatus y bandeja
                         * realizado con exito</ResultDescription>
                         * </processResponse>
                         */
                        // Desglosamos el XML
                        // Validar la respuesta
                        try {
                            descLogActivity = descLogActivity + "Respuesta del servicio web" + "\n";
                            RetornoWSSalesForceInfoVO parserVO = new RetornoWSSalesForceInfoVO(retornoWS);
                            descLogActivity = descLogActivity + "Resultado " + (parserVO.getResult().equals("0") ? "0: Respuesta exitosa" : "1: Respuesta fallida") + "\n";
                            descLogActivity = descLogActivity + "ID Resultado " + parserVO.getIdResult() + "\n";
                            descLogActivity = descLogActivity + "Descripción " + parserVO.getResultDescription() + "\n";

                        } catch (Exception ex) {
                            descLogActivity = descLogActivity + "Respuesta del servicio web (no fué popsible parsear)" + "\n";
                            descLogActivity = descLogActivity + retornoWS;

                        }
                        descLogActivity = descLogActivity + retornoWS;

                    } catch (Exception ex) {
                        // Agregamos este resultado al logActivity
                        String error = "Error al intentar ejecutar el WS: "; // + AppPropsBean.getPropsVO().getUrltpechangestatusWs();
                        log.error("   ::: " + error);
                        log.error("   ::: Exception --> " + ex.getCause().getLocalizedMessage());
                        descLogActivity = descLogActivity + error + "\n";
                        descLogActivity = descLogActivity + ex.getCause().getLocalizedMessage() + "\n";

                    } catch (Throwable ex) {
                        String error = "Error al intentar ejecutar el WS: "; // + AppPropsBean.getPropsVO().getUrltpechangestatusWs();
                        log.error("   ::: " + error);
                        log.error("   ::: Throwable --> " + ex.getCause().getLocalizedMessage());
                        descLogActivity = descLogActivity + error + "\n";
                        descLogActivity = descLogActivity + ex.getCause().getLocalizedMessage() + "\n";

                    } finally {
                        // Enviamos log activity
                        log.info("Agregar el log activity");
                        log.info("PerdIdTicket: " + persIdTicket);
                        log.info("Descripción: " + descLogActivity);
                        
                        this.agregarLogActivity(persIdTicket, descLogActivity);

                    }

                } else {
                    // No se encontró el ticket
                    String error = "No se encontró información con el ticket (persId): " + persIdTicket;
                    log.error(error);
                    throw new ChangeStatusException(error);
                }
            } catch (Exception ex) {
                log.error(ex.getMessage(), ex);
                throw new ChangeStatusException(ex);

            } catch (Throwable th) {
                log.error(th.getMessage(), th);
                throw new ChangeStatusException(th);

            } finally {
                // Intentamos cerrar la conexión a la base de datos

                if (conn != null) {
                    log.info("Desconectar de la base de datos...");
                    try {
                        conn.close();
                        log.info("Desconexión satisfactoria.");

                    } catch (Exception ex) {
                        log.error(ex.getMessage(), ex);
                        throw new ChangeStatusException(ex);

                    } catch (Throwable th) {
                        log.error(th.getMessage(), th);
                        throw new ChangeStatusException(th);

                    }
                }
            }
        } else {
            throw new ChangeStatusException("No se esta recibiendo la información a procesar");
        }
        return retorno;

    }

    private String covertirStatusSDtoSF(String estatusSDM) {
        String retorno = estatusSDM;
        return retorno;
    }

    private void agregarLogActivity(String persIdTicket, String descripcion) throws MalformedURLException {

        log.info("   ::: Agregando LogActivity");

        log.info("   ::: Obteniendo el id de sesión...");
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
        private String idResult = null;
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

                String result = docXml.getElementsByTagName("Result").item(0).getTextContent();
                String idResult = docXml.getElementsByTagName("IdResult").item(0).getTextContent();
                String resultDescription = docXml.getElementsByTagName("ResultDescription").item(0).getTextContent();

                log.info("   ::: +- result: " + result);
                log.info("   ::: +- idResult: " + idResult);
                log.info("   ::: +- resultDescription: " + resultDescription);

                // Setear las propiedades correspondientes
                this.setIdResult(idResult);
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

        public String getIdResult() {
            return idResult;
        }

        public void setIdResult(String idResult) {
            this.idResult = idResult;
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
