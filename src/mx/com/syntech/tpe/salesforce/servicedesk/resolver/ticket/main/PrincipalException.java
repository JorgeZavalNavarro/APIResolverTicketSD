package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.main;

import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.core.CoreException;

/**
 * 
 * @author Jorge Zavala Navarro
 */
public class PrincipalException extends CoreException{

    public PrincipalException(String idError, Throwable cause) {
        super(idError, cause);
    }
    
    

}
