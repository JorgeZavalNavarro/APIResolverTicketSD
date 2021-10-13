
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
 *         &lt;element name="handle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ticketFactory" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "handle",
    "ticketFactory"
})
@XmlRootElement(name = "getValidTransitions")
public class GetValidTransitions {

    protected int sid;
    @XmlElement(required = true)
    protected String handle;
    @XmlElement(required = true)
    protected String ticketFactory;

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
     * Obtiene el valor de la propiedad handle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHandle() {
        return handle;
    }

    /**
     * Define el valor de la propiedad handle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHandle(String value) {
        this.handle = value;
    }

    /**
     * Obtiene el valor de la propiedad ticketFactory.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketFactory() {
        return ticketFactory;
    }

    /**
     * Define el valor de la propiedad ticketFactory.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketFactory(String value) {
        this.ticketFactory = value;
    }

}
