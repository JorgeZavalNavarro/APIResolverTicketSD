
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
 *         &lt;element name="parentHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="childHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "parentHandle",
    "childHandle"
})
@XmlRootElement(name = "createAssetParentChildRelationship")
public class CreateAssetParentChildRelationship {

    protected int sid;
    @XmlElement(required = true)
    protected String parentHandle;
    @XmlElement(required = true)
    protected String childHandle;

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
     * Obtiene el valor de la propiedad parentHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentHandle() {
        return parentHandle;
    }

    /**
     * Define el valor de la propiedad parentHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentHandle(String value) {
        this.parentHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad childHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildHandle() {
        return childHandle;
    }

    /**
     * Define el valor de la propiedad childHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildHandle(String value) {
        this.childHandle = value;
    }

}
