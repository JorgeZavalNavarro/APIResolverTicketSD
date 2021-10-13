package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.logactivity;

import java.net.MalformedURLException;
import java.net.URL;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.props.AppPropsBean;
import org.apache.log4j.Category;

/**
 *
 * @author dell
 */
public class EjecutarLogActivityBean {
    
    // Constantes de la clase
    private static Category log = Category.getInstance(EjecutarLogActivityBean.class);
    private URL urlWsSD = null;
    
    public EjecutarLogActivityBean() throws MalformedURLException{
        this.urlWsSD = new URL(AppPropsBean.getPropsVO().getUrlServicedeskWs());
    }

    public void agregarLogActivity(String persIdTicket, String descripcion) throws MalformedURLException {

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

}
