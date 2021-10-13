
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
 *         &lt;element name="creator" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contextObject" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="messageTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="messageBody" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="notifyLevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="notifyees" type="{http://www.ca.com/UnicenterServicePlus/ServiceDesk}ArrayOfString"/>
 *         &lt;element name="internal" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "creator",
    "contextObject",
    "messageTitle",
    "messageBody",
    "notifyLevel",
    "notifyees",
    "internal"
})
@XmlRootElement(name = "notifyContacts")
public class NotifyContacts {

    protected int sid;
    @XmlElement(required = true)
    protected String creator;
    @XmlElement(required = true)
    protected String contextObject;
    @XmlElement(required = true)
    protected String messageTitle;
    @XmlElement(required = true)
    protected String messageBody;
    protected int notifyLevel;
    @XmlElement(required = true)
    protected ArrayOfString notifyees;
    protected boolean internal;

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
     * Obtiene el valor de la propiedad creator.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreator() {
        return creator;
    }

    /**
     * Define el valor de la propiedad creator.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreator(String value) {
        this.creator = value;
    }

    /**
     * Obtiene el valor de la propiedad contextObject.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContextObject() {
        return contextObject;
    }

    /**
     * Define el valor de la propiedad contextObject.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContextObject(String value) {
        this.contextObject = value;
    }

    /**
     * Obtiene el valor de la propiedad messageTitle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageTitle() {
        return messageTitle;
    }

    /**
     * Define el valor de la propiedad messageTitle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageTitle(String value) {
        this.messageTitle = value;
    }

    /**
     * Obtiene el valor de la propiedad messageBody.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageBody() {
        return messageBody;
    }

    /**
     * Define el valor de la propiedad messageBody.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageBody(String value) {
        this.messageBody = value;
    }

    /**
     * Obtiene el valor de la propiedad notifyLevel.
     * 
     */
    public int getNotifyLevel() {
        return notifyLevel;
    }

    /**
     * Define el valor de la propiedad notifyLevel.
     * 
     */
    public void setNotifyLevel(int value) {
        this.notifyLevel = value;
    }

    /**
     * Obtiene el valor de la propiedad notifyees.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getNotifyees() {
        return notifyees;
    }

    /**
     * Define el valor de la propiedad notifyees.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setNotifyees(ArrayOfString value) {
        this.notifyees = value;
    }

    /**
     * Obtiene el valor de la propiedad internal.
     * 
     */
    public boolean isInternal() {
        return internal;
    }

    /**
     * Define el valor de la propiedad internal.
     * 
     */
    public void setInternal(boolean value) {
        this.internal = value;
    }

}
