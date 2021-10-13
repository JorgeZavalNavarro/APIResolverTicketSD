
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
 *         &lt;element name="creatorHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="attrVals" type="{http://www.ca.com/UnicenterServicePlus/ServiceDesk}ArrayOfString"/>
 *         &lt;element name="propertyValues" type="{http://www.ca.com/UnicenterServicePlus/ServiceDesk}ArrayOfString"/>
 *         &lt;element name="template" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="attributes" type="{http://www.ca.com/UnicenterServicePlus/ServiceDesk}ArrayOfString"/>
 *         &lt;element name="newIssueHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newIssueNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "creatorHandle",
    "attrVals",
    "propertyValues",
    "template",
    "attributes",
    "newIssueHandle",
    "newIssueNumber"
})
@XmlRootElement(name = "createIssue")
public class CreateIssue {

    protected int sid;
    @XmlElement(required = true)
    protected String creatorHandle;
    @XmlElement(required = true)
    protected ArrayOfString attrVals;
    @XmlElement(required = true)
    protected ArrayOfString propertyValues;
    @XmlElement(required = true)
    protected String template;
    @XmlElement(required = true)
    protected ArrayOfString attributes;
    @XmlElement(required = true)
    protected String newIssueHandle;
    @XmlElement(required = true)
    protected String newIssueNumber;

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
     * Obtiene el valor de la propiedad creatorHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatorHandle() {
        return creatorHandle;
    }

    /**
     * Define el valor de la propiedad creatorHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatorHandle(String value) {
        this.creatorHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad attrVals.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getAttrVals() {
        return attrVals;
    }

    /**
     * Define el valor de la propiedad attrVals.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setAttrVals(ArrayOfString value) {
        this.attrVals = value;
    }

    /**
     * Obtiene el valor de la propiedad propertyValues.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getPropertyValues() {
        return propertyValues;
    }

    /**
     * Define el valor de la propiedad propertyValues.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setPropertyValues(ArrayOfString value) {
        this.propertyValues = value;
    }

    /**
     * Obtiene el valor de la propiedad template.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplate() {
        return template;
    }

    /**
     * Define el valor de la propiedad template.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplate(String value) {
        this.template = value;
    }

    /**
     * Obtiene el valor de la propiedad attributes.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getAttributes() {
        return attributes;
    }

    /**
     * Define el valor de la propiedad attributes.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setAttributes(ArrayOfString value) {
        this.attributes = value;
    }

    /**
     * Obtiene el valor de la propiedad newIssueHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewIssueHandle() {
        return newIssueHandle;
    }

    /**
     * Define el valor de la propiedad newIssueHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewIssueHandle(String value) {
        this.newIssueHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad newIssueNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewIssueNumber() {
        return newIssueNumber;
    }

    /**
     * Define el valor de la propiedad newIssueNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewIssueNumber(String value) {
        this.newIssueNumber = value;
    }

}
