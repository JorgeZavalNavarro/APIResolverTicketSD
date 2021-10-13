
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
 *         &lt;element name="createIssueReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newIssueHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newIssueNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "createIssueReturn",
    "newIssueHandle",
    "newIssueNumber"
})
@XmlRootElement(name = "createIssueResponse")
public class CreateIssueResponse {

    @XmlElement(required = true)
    protected String createIssueReturn;
    @XmlElement(required = true)
    protected String newIssueHandle;
    @XmlElement(required = true)
    protected String newIssueNumber;

    /**
     * Obtiene el valor de la propiedad createIssueReturn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateIssueReturn() {
        return createIssueReturn;
    }

    /**
     * Define el valor de la propiedad createIssueReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateIssueReturn(String value) {
        this.createIssueReturn = value;
    }

    /**
     * Obtiene el valor de la propiedad newIssueHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewIssueHandle() {
        return newIssueHandle;
    }

    /**
     * Define el valor de la propiedad newIssueHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewIssueHandle(String value) {
        this.newIssueHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad newIssueNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewIssueNumber() {
        return newIssueNumber;
    }

    /**
     * Define el valor de la propiedad newIssueNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewIssueNumber(String value) {
        this.newIssueNumber = value;
    }

}
