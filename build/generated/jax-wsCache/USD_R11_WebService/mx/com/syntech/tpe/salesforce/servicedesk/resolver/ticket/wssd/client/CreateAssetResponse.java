
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
 *         &lt;element name="createAssetResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newAssetHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newExtensionHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newExtensionName" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "createAssetResult",
    "newAssetHandle",
    "newExtensionHandle",
    "newExtensionName"
})
@XmlRootElement(name = "createAssetResponse")
public class CreateAssetResponse {

    @XmlElement(required = true)
    protected String createAssetResult;
    @XmlElement(required = true)
    protected String newAssetHandle;
    @XmlElement(required = true)
    protected String newExtensionHandle;
    @XmlElement(required = true)
    protected String newExtensionName;

    /**
     * Obtiene el valor de la propiedad createAssetResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateAssetResult() {
        return createAssetResult;
    }

    /**
     * Define el valor de la propiedad createAssetResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateAssetResult(String value) {
        this.createAssetResult = value;
    }

    /**
     * Obtiene el valor de la propiedad newAssetHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewAssetHandle() {
        return newAssetHandle;
    }

    /**
     * Define el valor de la propiedad newAssetHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewAssetHandle(String value) {
        this.newAssetHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad newExtensionHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewExtensionHandle() {
        return newExtensionHandle;
    }

    /**
     * Define el valor de la propiedad newExtensionHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewExtensionHandle(String value) {
        this.newExtensionHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad newExtensionName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewExtensionName() {
        return newExtensionName;
    }

    /**
     * Define el valor de la propiedad newExtensionName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewExtensionName(String value) {
        this.newExtensionName = value;
    }

}
