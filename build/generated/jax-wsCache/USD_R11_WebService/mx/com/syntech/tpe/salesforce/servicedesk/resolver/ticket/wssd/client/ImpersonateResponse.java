
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
 *         &lt;element name="impersonateReturn" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "impersonateReturn"
})
@XmlRootElement(name = "impersonateResponse")
public class ImpersonateResponse {

    protected int impersonateReturn;

    /**
     * Obtiene el valor de la propiedad impersonateReturn.
     * 
     */
    public int getImpersonateReturn() {
        return impersonateReturn;
    }

    /**
     * Define el valor de la propiedad impersonateReturn.
     * 
     */
    public void setImpersonateReturn(int value) {
        this.impersonateReturn = value;
    }

}
