
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
 *         &lt;element name="createWorkFlowTaskResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "createWorkFlowTaskResult",
    "newHandle"
})
@XmlRootElement(name = "createWorkFlowTaskResponse")
public class CreateWorkFlowTaskResponse {

    @XmlElement(required = true)
    protected String createWorkFlowTaskResult;
    @XmlElement(required = true)
    protected String newHandle;

    /**
     * Obtiene el valor de la propiedad createWorkFlowTaskResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateWorkFlowTaskResult() {
        return createWorkFlowTaskResult;
    }

    /**
     * Define el valor de la propiedad createWorkFlowTaskResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateWorkFlowTaskResult(String value) {
        this.createWorkFlowTaskResult = value;
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
