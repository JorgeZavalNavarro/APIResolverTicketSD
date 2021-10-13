
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
 *         &lt;element name="workFlowHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="objectHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "workFlowHandle",
    "objectHandle"
})
@XmlRootElement(name = "deleteWorkFlowTask")
public class DeleteWorkFlowTask {

    protected int sid;
    @XmlElement(required = true)
    protected String workFlowHandle;
    @XmlElement(required = true)
    protected String objectHandle;

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
     * Obtiene el valor de la propiedad workFlowHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkFlowHandle() {
        return workFlowHandle;
    }

    /**
     * Define el valor de la propiedad workFlowHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkFlowHandle(String value) {
        this.workFlowHandle = value;
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

}
