
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
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="attrVals" type="{http://www.ca.com/UnicenterServicePlus/ServiceDesk}ArrayOfString"/>
 *         &lt;element name="attributes" type="{http://www.ca.com/UnicenterServicePlus/ServiceDesk}ArrayOfString"/>
 *         &lt;element name="createObjectResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "objectType",
    "attrVals",
    "attributes",
    "createObjectResult",
    "newHandle"
})
@XmlRootElement(name = "createObject")
public class CreateObject {

    protected int sid;
    @XmlElement(required = true)
    protected String objectType;
    @XmlElement(required = true)
    protected ArrayOfString attrVals;
    @XmlElement(required = true)
    protected ArrayOfString attributes;
    @XmlElement(required = true)
    protected String createObjectResult;
    @XmlElement(required = true)
    protected String newHandle;

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
     * Obtiene el valor de la propiedad objectType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectType() {
        return objectType;
    }

    /**
     * Define el valor de la propiedad objectType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectType(String value) {
        this.objectType = value;
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
     * Obtiene el valor de la propiedad createObjectResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateObjectResult() {
        return createObjectResult;
    }

    /**
     * Define el valor de la propiedad createObjectResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateObjectResult(String value) {
        this.createObjectResult = value;
    }

    /**
     * Obtiene el valor de la propiedad newHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewHandle() {
        return newHandle;
    }

    /**
     * Define el valor de la propiedad newHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewHandle(String value) {
        this.newHandle = value;
    }

}
