package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.main;

import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.core.CoreException;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.props.AppPropsBean;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.update.UpdateTicketBean;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.update.UpdateTicketException;
import org.apache.log4j.Category;

/**
 *
 * @author dell
 */
public class PrincipalMainUpdateTicketBean {
    
    private static Category log = null;
    
    public static void main(String...params){
        // debemos de recibir el ticket a procesar
        // params = new String[]{"cr:1470677"};
        System.out.println("Class BDD:" + AppPropsBean.getPropsVO().getBddConexionBasedatos());
        log = Category.getInstance(PrincipalMainUpdateTicketBean.class);
        if(params!=null && params.length==1){
            
            try {
                // Tomamos el ID persistente del ticket
                String persidTicket = params[0];
                log.info("Actualizando la información del ticket de SD con el persID: " + params[0]);
                UpdateTicketBean bean = new UpdateTicketBean();
                bean.actualizarTicket(persidTicket);
                
            } catch (UpdateTicketException ex) {
                log.error(ex.getMessage(), ex);
                ex.printStackTrace();
            } catch (MalformedURLException ex) {
                log.error(ex.getMessage(), ex);
                Logger.getLogger(PrincipalMainUpdateTicketBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                log.error(ex.getMessage(), ex);
                Logger.getLogger(PrincipalMainUpdateTicketBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Throwable ex) {
                log.error(ex.getMessage(), ex);
                Logger.getLogger(PrincipalMainUpdateTicketBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }else{
            log.error("No se puede proceder con la ejecución de este programa !!");
            log.error("No se está recibiendo el parámetro a procesar o no se están recibiendo parámetros no ejecutados");
            log.error("Solo debe de recibir un solo argumento el cual corresponde al ID persistente del ticket");
            log.error("con el cual se desea trabajar.");
        }
        
                
    }
    
}
