
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
 *         &lt;element name="objectHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="setAssignee" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="newAssigneeHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="setGroup" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="newGroupHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="setOrganization" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="newOrganizationHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "objectHandle",
    "description",
    "setAssignee",
    "newAssigneeHandle",
    "setGroup",
    "newGroupHandle",
    "setOrganization",
    "newOrganizationHandle"
})
@XmlRootElement(name = "transfer")
public class Transfer {

    protected int sid;
    @XmlElement(required = true)
    protected String creator;
    @XmlElement(required = true)
    protected String objectHandle;
    @XmlElement(required = true)
    protected String description;
    protected boolean setAssignee;
    @XmlElement(required = true)
    protected String newAssigneeHandle;
    protected boolean setGroup;
    @XmlElement(required = true)
    protected String newGroupHandle;
    protected boolean setOrganization;
    @XmlElement(required = true)
    protected String newOrganizationHandle;

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
     * Obtiene el valor de la propiedad objectHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectHandle() {
        return objectHandle;
    }

    /**
     * Define el valor de la propiedad objectHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectHandle(String value) {
        this.objectHandle = value;
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
     * Obtiene el valor de la propiedad setAssignee.
     * 
     */
    public boolean isSetAssignee() {
        return setAssignee;
    }

    /**
     * Define el valor de la propiedad setAssignee.
     * 
     */
    public void setSetAssignee(boolean value) {
        this.setAssignee = value;
    }

    /**
     * Obtiene el valor de la propiedad newAssigneeHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewAssigneeHandle() {
        return newAssigneeHandle;
    }

    /**
     * Define el valor de la propiedad newAssigneeHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewAssigneeHandle(String value) {
        this.newAssigneeHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad setGroup.
     * 
     */
    public boolean isSetGroup() {
        return setGroup;
    }

    /**
     * Define el valor de la propiedad setGroup.
     * 
     */
    public void setSetGroup(boolean value) {
        this.setGroup = value;
    }

    /**
     * Obtiene el valor de la propiedad newGroupHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewGroupHandle() {
        return newGroupHandle;
    }

    /**
     * Define el valor de la propiedad newGroupHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewGroupHandle(String value) {
        this.newGroupHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad setOrganization.
     * 
     */
    public boolean isSetOrganization() {
        return setOrganization;
    }

    /**
     * Define el valor de la propiedad setOrganization.
     * 
     */
    public void setSetOrganization(boolean value) {
        this.setOrganization = value;
    }

    /**
     * Obtiene el valor de la propiedad newOrganizationHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewOrganizationHandle() {
        return newOrganizationHandle;
    }

    /**
     * Define el valor de la propiedad newOrganizationHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewOrganizationHandle(String value) {
        this.newOrganizationHandle = value;
    }

}
