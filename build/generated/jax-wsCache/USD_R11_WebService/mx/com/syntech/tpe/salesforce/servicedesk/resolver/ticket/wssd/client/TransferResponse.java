
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
 *         &lt;element name="transferReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "transferReturn"
})
@XmlRootElement(name = "transferResponse")
public class TransferResponse {

    @XmlElement(required = true)
    protected String transferReturn;

    /**
     * Obtiene el valor de la propiedad transferReturn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransferReturn() {
        return transferReturn;
    }

    /**
     * Define el valor de la propiedad transferReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransferReturn(String value) {
        this.transferReturn = value;
    }

}
