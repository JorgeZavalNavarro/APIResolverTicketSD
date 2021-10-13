
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
 *         &lt;element name="repositoryHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="folderId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="objectHandle" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "repositoryHandle",
    "folderId",
    "objectHandle",
    "description",
    "fileName"
})
@XmlRootElement(name = "createAttmnt")
public class CreateAttmnt {

    protected int sid;
    @XmlElement(required = true)
    protected String repositoryHandle;
    protected int folderId;
    protected int objectHandle;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String fileName;

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
     * Obtiene el valor de la propiedad repositoryHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepositoryHandle() {
        return repositoryHandle;
    }

    /**
     * Define el valor de la propiedad repositoryHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepositoryHandle(String value) {
        this.repositoryHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad folderId.
     * 
     */
    public int getFolderId() {
        return folderId;
    }

    /**
     * Define el valor de la propiedad folderId.
     * 
     */
    public void setFolderId(int value) {
        this.folderId = value;
    }

    /**
     * Obtiene el valor de la propiedad objectHandle.
     * 
     */
    public int getObjectHandle() {
        return objectHandle;
    }

    /**
     * Define el valor de la propiedad objectHandle.
     * 
     */
    public void setObjectHandle(int value) {
        this.objectHandle = value;
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
     * Obtiene el valor de la propiedad fileName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Define el valor de la propiedad fileName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

}
