
package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="getNotificationsForContactReturn" type="{http://www.ca.com/UnicenterServicePlus/ServiceDesk}ListResult"/>
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
    "getNotificationsForContactReturn"
})
@XmlRootElement(name = "getNotificationsForContactResponse")
public class GetNotificationsForContactResponse {

    @XmlElement(required = true)
    protected ListResult getNotificationsForContactReturn;

    /**
     * Obtiene el valor de la propiedad getNotificationsForContactReturn.
     * 
     * @return
     *     possible object is
     *     {@link ListResult }
     *     
     */
    public ListResult getGetNotificationsForContactReturn() {
        return getNotificationsForContactReturn;
    }

    /**
     * Define el valor de la propiedad getNotificationsForContactReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link ListResult }
     *     
     */
    public void setGetNotificationsForContactReturn(ListResult value) {
        this.getNotificationsForContactReturn = value;
    }

}
