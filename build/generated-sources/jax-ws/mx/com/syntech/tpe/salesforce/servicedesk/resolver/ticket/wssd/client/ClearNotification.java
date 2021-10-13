
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
 *         &lt;element name="lrObject" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clearBy" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "lrObject",
    "clearBy"
})
@XmlRootElement(name = "clearNotification")
public class ClearNotification {

    protected int sid;
    @XmlElement(required = true)
    protected String lrObject;
    @XmlElement(required = true)
    protected String clearBy;

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
     * Obtiene el valor de la propiedad lrObject.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLrObject() {
        return lrObject;
    }

    /**
     * Define el valor de la propiedad lrObject.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLrObject(String value) {
        this.lrObject = value;
    }

    /**
     * Obtiene el valor de la propiedad clearBy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClearBy() {
        return clearBy;
    }

    /**
     * Define el valor de la propiedad clearBy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClearBy(String value) {
        this.clearBy = value;
    }

}
