
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
 *         &lt;element name="policy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="encrypted_policy" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "policy",
    "encryptedPolicy"
})
@XmlRootElement(name = "loginServiceManaged")
public class LoginServiceManaged {

    @XmlElement(required = true)
    protected String policy;
    @XmlElement(name = "encrypted_policy", required = true)
    protected String encryptedPolicy;

    /**
     * Obtiene el valor de la propiedad policy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicy() {
        return policy;
    }

    /**
     * Define el valor de la propiedad policy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicy(String value) {
        this.policy = value;
    }

    /**
     * Obtiene el valor de la propiedad encryptedPolicy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncryptedPolicy() {
        return encryptedPolicy;
    }

    /**
     * Define el valor de la propiedad encryptedPolicy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncryptedPolicy(String value) {
        this.encryptedPolicy = value;
    }

}
