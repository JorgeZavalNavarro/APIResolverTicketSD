
package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.wssd.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ListResult complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ListResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listHandle" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="listLength" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListResult", propOrder = {
    "listHandle",
    "listLength"
})
public class ListResult {

    protected int listHandle;
    protected int listLength;

    /**
     * Obtiene el valor de la propiedad listHandle.
     * 
     */
    public int getListHandle() {
        return listHandle;
    }

    /**
     * Define el valor de la propiedad listHandle.
     * 
     */
    public void setListHandle(int value) {
        this.listHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad listLength.
     * 
     */
    public int getListLength() {
        return listLength;
    }

    /**
     * Define el valor de la propiedad listLength.
     * 
     */
    public void setListLength(int value) {
        this.listLength = value;
    }

}
