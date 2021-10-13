
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
 *         &lt;element name="requestHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="changeHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="changeAttrVals" type="{http://www.ca.com/UnicenterServicePlus/ServiceDesk}ArrayOfString"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "requestHandle",
    "changeHandle",
    "changeAttrVals",
    "description"
})
@XmlRootElement(name = "attachChangeToRequest")
public class AttachChangeToRequest {

    protected int sid;
    @XmlElement(required = true)
    protected String creator;
    @XmlElement(required = true)
    protected String requestHandle;
    @XmlElement(required = true)
    protected String changeHandle;
    @XmlElement(required = true)
    protected ArrayOfString changeAttrVals;
    @XmlElement(required = true)
    protected String description;

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
     * Obtiene el valor de la propiedad requestHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestHandle() {
        return requestHandle;
    }

    /**
     * Define el valor de la propiedad requestHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestHandle(String value) {
        this.requestHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad changeHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangeHandle() {
        return changeHandle;
    }

    /**
     * Define el valor de la propiedad changeHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangeHandle(String value) {
        this.changeHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad changeAttrVals.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getChangeAttrVals() {
        return changeAttrVals;
    }

    /**
     * Define el valor de la propiedad changeAttrVals.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setChangeAttrVals(ArrayOfString value) {
        this.changeAttrVals = value;
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

}
