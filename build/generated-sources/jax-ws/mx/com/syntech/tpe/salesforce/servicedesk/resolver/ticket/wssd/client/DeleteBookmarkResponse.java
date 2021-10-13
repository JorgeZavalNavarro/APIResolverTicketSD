
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
 *         &lt;element name="deleteBookmarkReturn" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "deleteBookmarkReturn"
})
@XmlRootElement(name = "deleteBookmarkResponse")
public class DeleteBookmarkResponse {

    protected int deleteBookmarkReturn;

    /**
     * Obtiene el valor de la propiedad deleteBookmarkReturn.
     * 
     */
    public int getDeleteBookmarkReturn() {
        return deleteBookmarkReturn;
    }

    /**
     * Define el valor de la propiedad deleteBookmarkReturn.
     * 
     */
    public void setDeleteBookmarkReturn(int value) {
        this.deleteBookmarkReturn = value;
    }

}
