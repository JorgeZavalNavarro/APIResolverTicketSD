
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
 *         &lt;element name="ticketHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="internalFlag" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "ticketHandle",
    "comment",
    "internalFlag"
})
@XmlRootElement(name = "logComment")
public class LogComment {

    protected int sid;
    @XmlElement(required = true)
    protected String ticketHandle;
    @XmlElement(required = true)
    protected String comment;
    protected int internalFlag;

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
     * Obtiene el valor de la propiedad ticketHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketHandle() {
        return ticketHandle;
    }

    /**
     * Define el valor de la propiedad ticketHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketHandle(String value) {
        this.ticketHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad comment.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Define el valor de la propiedad comment.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Obtiene el valor de la propiedad internalFlag.
     * 
     */
    public int getInternalFlag() {
        return internalFlag;
    }

    /**
     * Define el valor de la propiedad internalFlag.
     * 
     */
    public void setInternalFlag(int value) {
        this.internalFlag = value;
    }

}
