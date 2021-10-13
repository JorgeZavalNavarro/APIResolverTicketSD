
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
 *         &lt;element name="doQueryReturn" type="{http://www.ca.com/UnicenterServicePlus/ServiceDesk}ListResult"/>
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
    "doQueryReturn"
})
@XmlRootElement(name = "doQueryResponse")
public class DoQueryResponse {

    @XmlElement(required = true)
    protected ListResult doQueryReturn;

    /**
     * Obtiene el valor de la propiedad doQueryReturn.
     * 
     * @return
     *     possible object is
     *     {@link ListResult }
     *     
     */
    public ListResult getDoQueryReturn() {
        return doQueryReturn;
    }

    /**
     * Define el valor de la propiedad doQueryReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link ListResult }
     *     
     */
    public void setDoQueryReturn(ListResult value) {
        this.doQueryReturn = value;
    }

}
