
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
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="problem_type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="asset" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="duplication_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "sid",
    "description",
    "problemType",
    "userid",
    "asset",
    "duplicationId",
    "newTicketHandle",
    "newTicketNumber",
    "returnUserData",
    "returnApplicationData"
})
@XmlRootElement(name = "createTicket")
public class CreateTicket {

    protected int sid;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(name = "problem_type", required = true)
    protected String problemType;
    @XmlElement(required = true)
    protected String userid;
    @XmlElement(required = true)
    protected String asset;
    @XmlElement(name = "duplication_id", required = true)
    protected String duplicationId;
    @XmlElement(required = true)
    protected String newTicketHandle;
    @XmlElement(required = true)
    protected String newTicketNumber;
    @XmlElement(required = true)
    protected String returnUserData;
    @XmlElement(required = true)
    protected String returnApplicationData;

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
     * Obtiene el valor de la propiedad problemType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProblemType() {
        return problemType;
    }

    /**
     * Define el valor de la propiedad problemType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProblemType(String value) {
        this.problemType = value;
    }

    /**
     * Obtiene el valor de la propiedad userid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Define el valor de la propiedad userid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserid(String value) {
        this.userid = value;
    }

    /**
     * Obtiene el valor de la propiedad asset.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsset() {
        return asset;
    }

    /**
     * Define el valor de la propiedad asset.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsset(String value) {
        this.asset = value;
    }

    /**
     * Obtiene el valor de la propiedad duplicationId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDuplicationId() {
        return duplicationId;
    }

    /**
     * Define el valor de la propiedad duplicationId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDuplicationId(String value) {
        this.duplicationId = value;
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
