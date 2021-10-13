
package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clearNotificationReturn" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "clearNotificationReturn"
})
@XmlRootElement(name = "clearNotificationResponse")
public class ClearNotificationResponse {

    protected int clearNotificationReturn;

    /**
     * Obtiene el valor de la propiedad clearNotificationReturn.
     * 
     */
    public int getClearNotificationReturn() {
        return clearNotificationReturn;
    }

    /**
     * Define el valor de la propiedad clearNotificationReturn.
     * 
     */
    public void setClearNotificationReturn(int value) {
        this.clearNotificationReturn = value;
    }

}
