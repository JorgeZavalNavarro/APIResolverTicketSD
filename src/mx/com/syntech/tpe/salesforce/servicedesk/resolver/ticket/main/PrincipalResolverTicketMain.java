package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.main;

import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.syntech.tpe.salesforce.servicedesk.changestatus.principal.ChangeStatusSFBean;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.core.CoreException;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.props.AppPropsBean;
import org.apache.log4j.Category;

/**
 * 
 * @author Jorge Zavala Navarro
 * 
 * @Modificación
 * 
 *     Fecha:      20/JULIO/2021
 *     
 *     Autor:      JORGE ZAVALA NAVARRO
 * 
 *     Descripción:
 *             
 *           REQ001: También se requiere que al resolver el ticket por un N2 o superior en Service Desk, 
 *                   el dato guardado en el campo BandejaRetornoSF sea enviado a SF, lo que significará 
 *                   que se está devolviendo el ticket a esa bandeja en SF.
 *     
 */
public class PrincipalResolverTicketMain {
    
    // Propiedades de la clase
    private static Category log = Category.getInstance(PrincipalResolverTicketMain.class);
    
    public static void main(String...params){
        
        // debemos de recibir el ticket a procesar
        // params = new String[]{"cr:1470033"};
        System.out.println("Class BDD:" + AppPropsBean.getPropsVO().getBddConexionBasedatos());
        if(params!=null && params.length==1){
            
            try {
                // Tomamos el ID persistente del ticket
                String persidTicket = params[0];
                PrincipalBean bean = new PrincipalBean();
                bean.getResolucionTicket(persidTicket);
                
                // ChangeStatusSFBean changeStatusBean = new ChangeStatusSFBean();
                // changeStatusBean.cambiarEstatus(numeroTicket, resultadoVO.getEstatusTicket(), resultadoVO.getLogActivityDescription());
                
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            } catch (CoreException ex) {
                Logger.getLogger(PrincipalResolverTicketMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }else{
            log.error("No se puede proceder con la ejecución de este programa !!");
            log.error("No se está recibiendo el parámetro a procesar o no se están recibiendo parámetros no ejecutados");
            log.error("Solo debe de recibir un solo argumento el cual corresponde al ID persistente del ticket");
            log.error("con el cual se desea trabajar.");
        }
        
        
    }
}
