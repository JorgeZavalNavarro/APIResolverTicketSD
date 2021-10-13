
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
 *         &lt;element name="removeAttachmentReturn" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "removeAttachmentReturn"
})
@XmlRootElement(name = "removeAttachmentResponse")
public class RemoveAttachmentResponse {

    protected int removeAttachmentReturn;

    /**
     * Obtiene el valor de la propiedad removeAttachmentReturn.
     * 
     */
    public int getRemoveAttachmentReturn() {
        return removeAttachmentReturn;
    }

    /**
     * Define el valor de la propiedad removeAttachmentReturn.
     * 
     */
    public void setRemoveAttachmentReturn(int value) {
        this.removeAttachmentReturn = value;
    }

}
