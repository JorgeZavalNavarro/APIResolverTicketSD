
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
 *         &lt;element name="loginServiceManagedReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "loginServiceManagedReturn"
})
@XmlRootElement(name = "loginServiceManagedResponse")
public class LoginServiceManagedResponse {

    @XmlElement(required = true)
    protected String loginServiceManagedReturn;

    /**
     * Obtiene el valor de la propiedad loginServiceManagedReturn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginServiceManagedReturn() {
        return loginServiceManagedReturn;
    }

    /**
     * Define el valor de la propiedad loginServiceManagedReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginServiceManagedReturn(String value) {
        this.loginServiceManagedReturn = value;
    }

}
