
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
 *         &lt;element name="getPendingIssueTaskListForContactReturn" type="{http://www.ca.com/UnicenterServicePlus/ServiceDesk}ListResult"/>
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
    "getPendingIssueTaskListForContactReturn"
})
@XmlRootElement(name = "getPendingIssueTaskListForContactResponse")
public class GetPendingIssueTaskListForContactResponse {

    @XmlElement(required = true)
    protected ListResult getPendingIssueTaskListForContactReturn;

    /**
     * Obtiene el valor de la propiedad getPendingIssueTaskListForContactReturn.
     * 
     * @return
     *     possible object is
     *     {@link ListResult }
     *     
     */
    public ListResult getGetPendingIssueTaskListForContactReturn() {
        return getPendingIssueTaskListForContactReturn;
    }

    /**
     * Define el valor de la propiedad getPendingIssueTaskListForContactReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link ListResult }
     *     
     */
    public void setGetPendingIssueTaskListForContactReturn(ListResult value) {
        this.getPendingIssueTaskListForContactReturn = value;
    }

}
