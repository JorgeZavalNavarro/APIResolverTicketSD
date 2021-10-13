package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.main;

import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.core.CoreResultadoVO;

/**
 * 
 * @author Jorge Zavala Navarro
 */
public class PrincipalResultadoVO extends CoreResultadoVO{
    
    // Debemos tener el estatus del ticket y el comentario 
    // ticket.status y alg.description
    private String estatusTicket = null;
    private String logActivityDescription = null;

    public String getEstatusTicket() {
        return estatusTicket;
    }

    public void setEstatusTicket(String estatusTicket) {
        this.estatusTicket = estatusTicket;
    }

    public String getLogActivityDescription() {
        return logActivityDescription;
    }

    public void setLogActivityDescription(String logActivityDescription) {
        this.logActivityDescription = logActivityDescription;
    }
    
    

}
