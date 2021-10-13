
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
    "createObjectResult",
    "newHandle"
})
@XmlRootElement(name = "createObjectResponse")
public class CreateObjectResponse {

    @XmlElement(required = true)
    protected String createObjectResult;
    @XmlElement(required = true)
    protected String newHandle;

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
