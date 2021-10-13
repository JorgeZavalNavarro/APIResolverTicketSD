package mx.com.syntech.tpe.salesforce.servicedesk.changestatus.principal;

/**
 *
 * @author dell
 */
public class ChangeStatusException extends Exception{

    public ChangeStatusException(String message) {
        super(message);
    }

    public ChangeStatusException(Throwable cause) {
        super(cause);
    }
    
}
