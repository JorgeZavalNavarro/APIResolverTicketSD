
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
 *         &lt;element name="listHandle" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="startIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="endIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="attributeNames" type="{http://www.ca.com/UnicenterServicePlus/ServiceDesk}ArrayOfString"/>
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
    "listHandle",
    "startIndex",
    "endIndex",
    "attributeNames"
})
@XmlRootElement(name = "getListValues")
public class GetListValues {

    protected int sid;
    protected int listHandle;
    protected int startIndex;
    protected int endIndex;
    @XmlElement(required = true)
    protected ArrayOfString attributeNames;

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
     * Obtiene el valor de la propiedad startIndex.
     * 
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * Define el valor de la propiedad startIndex.
     * 
     */
    public void setStartIndex(int value) {
        this.startIndex = value;
    }

    /**
     * Obtiene el valor de la propiedad endIndex.
     * 
     */
    public int getEndIndex() {
        return endIndex;
    }

    /**
     * Define el valor de la propiedad endIndex.
     * 
     */
    public void setEndIndex(int value) {
        this.endIndex = value;
    }

    /**
     * Obtiene el valor de la propiedad attributeNames.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getAttributeNames() {
        return attributeNames;
    }

    /**
     * Define el valor de la propiedad attributeNames.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setAttributeNames(ArrayOfString value) {
        this.attributeNames = value;
    }

}
