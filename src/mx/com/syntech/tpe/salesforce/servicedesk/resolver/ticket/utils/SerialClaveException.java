package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.utils;

/**
 *
 * @author jzavala
 */
public class SerialClaveException extends Exception{

    public SerialClaveException(Exception ex){
        super(ex);
    }

    public SerialClaveException(String mensaje){
        super(mensaje);
    }
}
