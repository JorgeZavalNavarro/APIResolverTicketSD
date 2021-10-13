
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
 *         &lt;element name="sid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="parentFolderId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="repId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="folderType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="folderName" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "repId",
    "folderType",
    "description",
    "folderName"
})
@XmlRootElement(name = "createFolder")
public class CreateFolder {

    protected int sid;
    protected int parentFolderId;
    protected int repId;
    protected int folderType;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String folderName;

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

    /**
     * Obtiene el valor de la propiedad folderType.
     * 
     */
    public int getFolderType() {
        return folderType;
    }

    /**
     * Define el valor de la propiedad folderType.
     * 
     */
    public void setFolderType(int value) {
        this.folderType = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad folderName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFolderName() {
        return folderName;
    }

    /**
     * Define el valor de la propiedad folderName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFolderName(String value) {
        this.folderName = value;
    }

}
