
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
 *         &lt;element name="catId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="getCategoryPaths" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "catId",
    "getCategoryPaths"
})
@XmlRootElement(name = "getCategory")
public class GetCategory {

    protected int sid;
    protected int catId;
    protected boolean getCategoryPaths;

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
     * Obtiene el valor de la propiedad catId.
     * 
     */
    public int getCatId() {
        return catId;
    }

    /**
     * Define el valor de la propiedad catId.
     * 
     */
    public void setCatId(int value) {
        this.catId = value;
    }

    /**
     * Obtiene el valor de la propiedad getCategoryPaths.
     * 
     */
    public boolean isGetCategoryPaths() {
        return getCategoryPaths;
    }

    /**
     * Define el valor de la propiedad getCategoryPaths.
     * 
     */
    public void setGetCategoryPaths(boolean value) {
        this.getCategoryPaths = value;
    }

}
