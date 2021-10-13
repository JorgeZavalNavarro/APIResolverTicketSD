
package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="loginWithArtifactReturn" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "loginWithArtifactReturn"
})
@XmlRootElement(name = "loginWithArtifactResponse")
public class LoginWithArtifactResponse {

    protected int loginWithArtifactReturn;

    /**
     * Obtiene el valor de la propiedad loginWithArtifactReturn.
     * 
     */
    public int getLoginWithArtifactReturn() {
        return loginWithArtifactReturn;
    }

    /**
     * Define el valor de la propiedad loginWithArtifactReturn.
     * 
     */
    public void setLoginWithArtifactReturn(int value) {
        this.loginWithArtifactReturn = value;
    }

}
