
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
 *         &lt;element name="getAttmntInfoReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "getAttmntInfoReturn"
})
@XmlRootElement(name = "getAttmntInfoResponse")
public class GetAttmntInfoResponse {

    @XmlElement(required = true)
    protected String getAttmntInfoReturn;

    /**
     * Obtiene el valor de la propiedad getAttmntInfoReturn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetAttmntInfoReturn() {
        return getAttmntInfoReturn;
    }

    /**
     * Define el valor de la propiedad getAttmntInfoReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetAttmntInfoReturn(String value) {
        this.getAttmntInfoReturn = value;
    }

}
