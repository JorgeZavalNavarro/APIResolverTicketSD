package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.update;

/**
 *
 * @author dell
 */
public class UpdateTicketException extends Exception{

    public UpdateTicketException(String message) {
        super(message);
    }

    public UpdateTicketException(Throwable cause) {
        super(cause);
    }
    
}
