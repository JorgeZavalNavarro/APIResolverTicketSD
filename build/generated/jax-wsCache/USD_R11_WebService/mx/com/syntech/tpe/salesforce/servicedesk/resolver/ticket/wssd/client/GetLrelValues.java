
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
 *         &lt;element name="contextObject" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lrelName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="startIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="endIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="attributes" type="{http://www.ca.com/UnicenterServicePlus/ServiceDesk}ArrayOfString"/>
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
    "contextObject",
    "lrelName",
    "startIndex",
    "endIndex",
    "attributes"
})
@XmlRootElement(name = "getLrelValues")
public class GetLrelValues {

    protected int sid;
    @XmlElement(required = true)
    protected String contextObject;
    @XmlElement(required = true)
    protected String lrelName;
    protected int startIndex;
    protected int endIndex;
    @XmlElement(required = true)
    protected ArrayOfString attributes;

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
     * Obtiene el valor de la propiedad lrelName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLrelName() {
        return lrelName;
    }

    /**
     * Define el valor de la propiedad lrelName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLrelName(String value) {
        this.lrelName = value;
    }

    /**
     * Obtiene el valor de la propiedad startIndex.
     * 
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * Define el valor de la propiedad startIndex.
     * 
     */
    public void setStartIndex(int value) {
        this.startIndex = value;
    }

    /**
     * Obtiene el valor de la propiedad endIndex.
     * 
     */
    public int getEndIndex() {
        return endIndex;
    }

    /**
     * Define el valor de la propiedad endIndex.
     * 
     */
    public void setEndIndex(int value) {
        this.endIndex = value;
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

}
