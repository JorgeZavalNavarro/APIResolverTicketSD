
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
 *         &lt;element name="getBopsidReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "getBopsidReturn"
})
@XmlRootElement(name = "getBopsidResponse")
public class GetBopsidResponse {

    @XmlElement(required = true)
    protected String getBopsidReturn;

    /**
     * Obtiene el valor de la propiedad getBopsidReturn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetBopsidReturn() {
        return getBopsidReturn;
    }

    /**
     * Define el valor de la propiedad getBopsidReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetBopsidReturn(String value) {
        this.getBopsidReturn = value;
    }

}
