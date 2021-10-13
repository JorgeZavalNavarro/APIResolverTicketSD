
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
 *         &lt;element name="createTicketReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newTicketHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newTicketNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="returnUserData" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="returnApplicationData" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "createTicketReturn",
    "newTicketHandle",
    "newTicketNumber",
    "returnUserData",
    "returnApplicationData"
})
@XmlRootElement(name = "createTicketResponse")
public class CreateTicketResponse {

    @XmlElement(required = true)
    protected String createTicketReturn;
    @XmlElement(required = true)
    protected String newTicketHandle;
    @XmlElement(required = true)
    protected String newTicketNumber;
    @XmlElement(required = true)
    protected String returnUserData;
    @XmlElement(required = true)
    protected String returnApplicationData;

    /**
     * Obtiene el valor de la propiedad createTicketReturn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateTicketReturn() {
        return createTicketReturn;
    }

    /**
     * Define el valor de la propiedad createTicketReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateTicketReturn(String value) {
        this.createTicketReturn = value;
    }

    /**
     * Obtiene el valor de la propiedad newTicketHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewTicketHandle() {
        return newTicketHandle;
    }

    /**
     * Define el valor de la propiedad newTicketHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewTicketHandle(String value) {
        this.newTicketHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad newTicketNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewTicketNumber() {
        return newTicketNumber;
    }

    /**
     * Define el valor de la propiedad newTicketNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewTicketNumber(String value) {
        this.newTicketNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad returnUserData.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnUserData() {
        return returnUserData;
    }

    /**
     * Define el valor de la propiedad returnUserData.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnUserData(String value) {
        this.returnUserData = value;
    }

    /**
     * Obtiene el valor de la propiedad returnApplicationData.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnApplicationData() {
        return returnApplicationData;
    }

    /**
     * Define el valor de la propiedad returnApplicationData.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnApplicationData(String value) {
        this.returnApplicationData = value;
    }

}
