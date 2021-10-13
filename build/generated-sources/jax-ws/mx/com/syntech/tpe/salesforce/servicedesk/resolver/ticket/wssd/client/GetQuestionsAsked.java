
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
 *         &lt;element name="sid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="resultSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="descending" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "sid",
    "resultSize",
    "descending"
})
@XmlRootElement(name = "getQuestionsAsked")
public class GetQuestionsAsked {

    protected int sid;
    protected int resultSize;
    protected boolean descending;

    /**
     * Obtiene el valor de la propiedad sid.
     * 
     */
    public int getSid() {
        return sid;
    }

    /**
     * Define el valor de la propiedad sid.
     * 
     */
    public void setSid(int value) {
        this.sid = value;
    }

    /**
     * Obtiene el valor de la propiedad resultSize.
     * 
     */
    public int getResultSize() {
        return resultSize;
    }

    /**
     * Define el valor de la propiedad resultSize.
     * 
     */
    public void setResultSize(int value) {
        this.resultSize = value;
    }

    /**
     * Obtiene el valor de la propiedad descending.
     * 
     */
    public boolean isDescending() {
        return descending;
    }

    /**
     * Define el valor de la propiedad descending.
     * 
     */
    public void setDescending(boolean value) {
        this.descending = value;
    }

}
