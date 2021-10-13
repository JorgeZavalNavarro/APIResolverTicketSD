
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
 *         &lt;element name="createRequestReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newRequestHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newRequestNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "createRequestReturn",
    "newRequestHandle",
    "newRequestNumber"
})
@XmlRootElement(name = "createRequestResponse")
public class CreateRequestResponse {

    @XmlElement(required = true)
    protected String createRequestReturn;
    @XmlElement(required = true)
    protected String newRequestHandle;
    @XmlElement(required = true)
    protected String newRequestNumber;

    /**
     * Obtiene el valor de la propiedad createRequestReturn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateRequestReturn() {
        return createRequestReturn;
    }

    /**
     * Define el valor de la propiedad createRequestReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateRequestReturn(String value) {
        this.createRequestReturn = value;
    }

    /**
     * Obtiene el valor de la propiedad newRequestHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewRequestHandle() {
        return newRequestHandle;
    }

    /**
     * Define el valor de la propiedad newRequestHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewRequestHandle(String value) {
        this.newRequestHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad newRequestNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewRequestNumber() {
        return newRequestNumber;
    }

    /**
     * Define el valor de la propiedad newRequestNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewRequestNumber(String value) {
        this.newRequestNumber = value;
    }

}
