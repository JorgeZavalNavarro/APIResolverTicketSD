
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
 *         &lt;element name="getAssetExtInfoResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="extensionHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="extensionName" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "getAssetExtInfoResult",
    "extensionHandle",
    "extensionName"
})
@XmlRootElement(name = "getAssetExtensionInformationResponse")
public class GetAssetExtensionInformationResponse {

    @XmlElement(required = true)
    protected String getAssetExtInfoResult;
    @XmlElement(required = true)
    protected String extensionHandle;
    @XmlElement(required = true)
    protected String extensionName;

    /**
     * Obtiene el valor de la propiedad getAssetExtInfoResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetAssetExtInfoResult() {
        return getAssetExtInfoResult;
    }

    /**
     * Define el valor de la propiedad getAssetExtInfoResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetAssetExtInfoResult(String value) {
        this.getAssetExtInfoResult = value;
    }

    /**
     * Obtiene el valor de la propiedad extensionHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtensionHandle() {
        return extensionHandle;
    }

    /**
     * Define el valor de la propiedad extensionHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtensionHandle(String value) {
        this.extensionHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad extensionName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtensionName() {
        return extensionName;
    }

    /**
     * Define el valor de la propiedad extensionName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtensionName(String value) {
        this.extensionName = value;
    }

}
