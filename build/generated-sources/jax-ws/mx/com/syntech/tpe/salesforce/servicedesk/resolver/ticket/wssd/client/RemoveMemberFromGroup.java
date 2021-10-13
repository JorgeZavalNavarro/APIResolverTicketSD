
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
 *         &lt;element name="contactHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="groupHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "contactHandle",
    "groupHandle"
})
@XmlRootElement(name = "removeMemberFromGroup")
public class RemoveMemberFromGroup {

    protected int sid;
    @XmlElement(required = true)
    protected String contactHandle;
    @XmlElement(required = true)
    protected String groupHandle;

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
     * Obtiene el valor de la propiedad contactHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactHandle() {
        return contactHandle;
    }

    /**
     * Define el valor de la propiedad contactHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactHandle(String value) {
        this.contactHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad groupHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupHandle() {
        return groupHandle;
    }

    /**
     * Define el valor de la propiedad groupHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupHandle(String value) {
        this.groupHandle = value;
    }

}
