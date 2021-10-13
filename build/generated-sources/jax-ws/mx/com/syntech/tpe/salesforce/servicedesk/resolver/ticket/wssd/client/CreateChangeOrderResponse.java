
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
 *         &lt;element name="createChangeOrderReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newChangeHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newChangeNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "createChangeOrderReturn",
    "newChangeHandle",
    "newChangeNumber"
})
@XmlRootElement(name = "createChangeOrderResponse")
public class CreateChangeOrderResponse {

    @XmlElement(required = true)
    protected String createChangeOrderReturn;
    @XmlElement(required = true)
    protected String newChangeHandle;
    @XmlElement(required = true)
    protected String newChangeNumber;

    /**
     * Obtiene el valor de la propiedad createChangeOrderReturn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateChangeOrderReturn() {
        return createChangeOrderReturn;
    }

    /**
     * Define el valor de la propiedad createChangeOrderReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateChangeOrderReturn(String value) {
        this.createChangeOrderReturn = value;
    }

    /**
     * Obtiene el valor de la propiedad newChangeHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewChangeHandle() {
        return newChangeHandle;
    }

    /**
     * Define el valor de la propiedad newChangeHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewChangeHandle(String value) {
        this.newChangeHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad newChangeNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewChangeNumber() {
        return newChangeNumber;
    }

    /**
     * Define el valor de la propiedad newChangeNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewChangeNumber(String value) {
        this.newChangeNumber = value;
    }

}
