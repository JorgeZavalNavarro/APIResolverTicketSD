
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
 *         &lt;element name="isAttmntLinkedKDReturn" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "isAttmntLinkedKDReturn"
})
@XmlRootElement(name = "isAttmntLinkedKDResponse")
public class IsAttmntLinkedKDResponse {

    protected int isAttmntLinkedKDReturn;

    /**
     * Obtiene el valor de la propiedad isAttmntLinkedKDReturn.
     * 
     */
    public int getIsAttmntLinkedKDReturn() {
        return isAttmntLinkedKDReturn;
    }

    /**
     * Define el valor de la propiedad isAttmntLinkedKDReturn.
     * 
     */
    public void setIsAttmntLinkedKDReturn(int value) {
        this.isAttmntLinkedKDReturn = value;
    }

}
