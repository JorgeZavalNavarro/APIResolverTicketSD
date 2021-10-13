
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
 *         &lt;element name="parentFolderId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="repId" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "parentFolderId",
    "repId"
})
@XmlRootElement(name = "getFolderList")
public class GetFolderList {

    protected int sid;
    protected int parentFolderId;
    protected int repId;

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
     * Obtiene el valor de la propiedad parentFolderId.
     * 
     */
    public int getParentFolderId() {
        return parentFolderId;
    }

    /**
     * Define el valor de la propiedad parentFolderId.
     * 
     */
    public void setParentFolderId(int value) {
        this.parentFolderId = value;
    }

    /**
     * Obtiene el valor de la propiedad repId.
     * 
     */
    public int getRepId() {
        return repId;
    }

    /**
     * Define el valor de la propiedad repId.
     * 
     */
    public void setRepId(int value) {
        this.repId = value;
    }

}
