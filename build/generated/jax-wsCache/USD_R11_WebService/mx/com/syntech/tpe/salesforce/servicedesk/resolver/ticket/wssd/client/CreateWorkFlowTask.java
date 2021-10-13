
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
 *         &lt;element name="attrVals" type="{http://www.ca.com/UnicenterServicePlus/ServiceDesk}ArrayOfString"/>
 *         &lt;element name="objectHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="creatorHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="selectedWorkFlow" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="taskType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="attributes" type="{http://www.ca.com/UnicenterServicePlus/ServiceDesk}ArrayOfString"/>
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
    "sid",
    "attrVals",
    "objectHandle",
    "creatorHandle",
    "selectedWorkFlow",
    "taskType",
    "attributes",
    "createWorkFlowTaskResult",
    "newHandle"
})
@XmlRootElement(name = "createWorkFlowTask")
public class CreateWorkFlowTask {

    protected int sid;
    @XmlElement(required = true)
    protected ArrayOfString attrVals;
    @XmlElement(required = true)
    protected String objectHandle;
    @XmlElement(required = true)
    protected String creatorHandle;
    @XmlElement(required = true)
    protected String selectedWorkFlow;
    @XmlElement(required = true)
    protected String taskType;
    @XmlElement(required = true)
    protected ArrayOfString attributes;
    @XmlElement(required = true)
    protected String createWorkFlowTaskResult;
    @XmlElement(required = true)
    protected String newHandle;

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
     * Obtiene el valor de la propiedad attrVals.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getAttrVals() {
        return attrVals;
    }

    /**
     * Define el valor de la propiedad attrVals.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setAttrVals(ArrayOfString value) {
        this.attrVals = value;
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

    /**
     * Obtiene el valor de la propiedad creatorHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatorHandle() {
        return creatorHandle;
    }

    /**
     * Define el valor de la propiedad creatorHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatorHandle(String value) {
        this.creatorHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad selectedWorkFlow.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelectedWorkFlow() {
        return selectedWorkFlow;
    }

    /**
     * Define el valor de la propiedad selectedWorkFlow.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelectedWorkFlow(String value) {
        this.selectedWorkFlow = value;
    }

    /**
     * Obtiene el valor de la propiedad taskType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskType() {
        return taskType;
    }

    /**
     * Define el valor de la propiedad taskType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskType(String value) {
        this.taskType = value;
    }

    /**
     * Obtiene el valor de la propiedad attributes.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getAttributes() {
        return attributes;
    }

    /**
     * Define el valor de la propiedad attributes.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setAttributes(ArrayOfString value) {
        this.attributes = value;
    }

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
