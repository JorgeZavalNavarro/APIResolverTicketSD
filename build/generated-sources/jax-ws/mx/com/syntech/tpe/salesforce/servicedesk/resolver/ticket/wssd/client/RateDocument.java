
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
 *         &lt;element name="docId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="multiplier" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ticketPerId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="onTicketAccept" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="solveUserProblem" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isDefault" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "docId",
    "rating",
    "multiplier",
    "ticketPerId",
    "onTicketAccept",
    "solveUserProblem",
    "isDefault"
})
@XmlRootElement(name = "rateDocument")
public class RateDocument {

    protected int sid;
    protected int docId;
    protected int rating;
    protected int multiplier;
    @XmlElement(required = true)
    protected String ticketPerId;
    protected boolean onTicketAccept;
    protected boolean solveUserProblem;
    protected boolean isDefault;

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
     * Obtiene el valor de la propiedad docId.
     * 
     */
    public int getDocId() {
        return docId;
    }

    /**
     * Define el valor de la propiedad docId.
     * 
     */
    public void setDocId(int value) {
        this.docId = value;
    }

    /**
     * Obtiene el valor de la propiedad rating.
     * 
     */
    public int getRating() {
        return rating;
    }

    /**
     * Define el valor de la propiedad rating.
     * 
     */
    public void setRating(int value) {
        this.rating = value;
    }

    /**
     * Obtiene el valor de la propiedad multiplier.
     * 
     */
    public int getMultiplier() {
        return multiplier;
    }

    /**
     * Define el valor de la propiedad multiplier.
     * 
     */
    public void setMultiplier(int value) {
        this.multiplier = value;
    }

    /**
     * Obtiene el valor de la propiedad ticketPerId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketPerId() {
        return ticketPerId;
    }

    /**
     * Define el valor de la propiedad ticketPerId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketPerId(String value) {
        this.ticketPerId = value;
    }

    /**
     * Obtiene el valor de la propiedad onTicketAccept.
     * 
     */
    public boolean isOnTicketAccept() {
        return onTicketAccept;
    }

    /**
     * Define el valor de la propiedad onTicketAccept.
     * 
     */
    public void setOnTicketAccept(boolean value) {
        this.onTicketAccept = value;
    }

    /**
     * Obtiene el valor de la propiedad solveUserProblem.
     * 
     */
    public boolean isSolveUserProblem() {
        return solveUserProblem;
    }

    /**
     * Define el valor de la propiedad solveUserProblem.
     * 
     */
    public void setSolveUserProblem(boolean value) {
        this.solveUserProblem = value;
    }

    /**
     * Obtiene el valor de la propiedad isDefault.
     * 
     */
    public boolean isIsDefault() {
        return isDefault;
    }

    /**
     * Define el valor de la propiedad isDefault.
     * 
     */
    public void setIsDefault(boolean value) {
        this.isDefault = value;
    }

}
