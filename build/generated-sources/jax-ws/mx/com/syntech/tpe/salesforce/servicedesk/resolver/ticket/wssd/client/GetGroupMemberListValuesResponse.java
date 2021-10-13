
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
 *         &lt;element name="getGroupMemberListValuesReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "getGroupMemberListValuesReturn"
})
@XmlRootElement(name = "getGroupMemberListValuesResponse")
public class GetGroupMemberListValuesResponse {

    @XmlElement(required = true)
    protected String getGroupMemberListValuesReturn;

    /**
     * Obtiene el valor de la propiedad getGroupMemberListValuesReturn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetGroupMemberListValuesReturn() {
        return getGroupMemberListValuesReturn;
    }

    /**
     * Define el valor de la propiedad getGroupMemberListValuesReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetGroupMemberListValuesReturn(String value) {
        this.getGroupMemberListValuesReturn = value;
    }

}
