
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
 *         &lt;element name="faqReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "faqReturn"
})
@XmlRootElement(name = "faqResponse")
public class FaqResponse {

    @XmlElement(required = true)
    protected String faqReturn;

    /**
     * Obtiene el valor de la propiedad faqReturn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaqReturn() {
        return faqReturn;
    }

    /**
     * Define el valor de la propiedad faqReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaqReturn(String value) {
        this.faqReturn = value;
    }

}
