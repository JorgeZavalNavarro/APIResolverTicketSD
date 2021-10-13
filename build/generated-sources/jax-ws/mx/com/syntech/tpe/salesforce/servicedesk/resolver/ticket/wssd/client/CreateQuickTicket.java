
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
 *         &lt;element name="sid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="customerHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newTicketHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newTicketNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "sid",
    "customerHandle",
    "description",
    "newTicketHandle",
    "newTicketNumber"
})
@XmlRootElement(name = "createQuickTicket")
public class CreateQuickTicket {

    protected int sid;
    @XmlElement(required = true)
    protected String customerHandle;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String newTicketHandle;
    @XmlElement(required = true)
    protected String newTicketNumber;

    /**
     * Obtiene el valor de la propiedad sid.
     * 
     */
    public int getSid() {
        return sid;
    }

    /**
     * Define el valor de la propiedad sid.
     * 
     */
    public void setSid(int value) {
        this.sid = value;
    }

    /**
     * Obtiene el valor de la propiedad customerHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerHandle() {
        return customerHandle;
    }

    /**
     * Define el valor de la propiedad customerHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerHandle(String value) {
        this.customerHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
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

}
