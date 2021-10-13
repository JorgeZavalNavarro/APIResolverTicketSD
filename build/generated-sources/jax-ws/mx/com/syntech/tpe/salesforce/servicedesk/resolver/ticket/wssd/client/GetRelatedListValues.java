
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
 *         &lt;element name="objectHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="listName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numToFetch" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="attributes" type="{http://www.ca.com/UnicenterServicePlus/ServiceDesk}ArrayOfString"/>
 *         &lt;element name="getRelatedListValuesResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numRowsFound" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "objectHandle",
    "listName",
    "numToFetch",
    "attributes",
    "getRelatedListValuesResult",
    "numRowsFound"
})
@XmlRootElement(name = "getRelatedListValues")
public class GetRelatedListValues {

    protected int sid;
    @XmlElement(required = true)
    protected String objectHandle;
    @XmlElement(required = true)
    protected String listName;
    protected int numToFetch;
    @XmlElement(required = true)
    protected ArrayOfString attributes;
    @XmlElement(required = true)
    protected String getRelatedListValuesResult;
    protected int numRowsFound;

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
     * Obtiene el valor de la propiedad objectHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectHandle() {
        return objectHandle;
    }

    /**
     * Define el valor de la propiedad objectHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectHandle(String value) {
        this.objectHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad listName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListName() {
        return listName;
    }

    /**
     * Define el valor de la propiedad listName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListName(String value) {
        this.listName = value;
    }

    /**
     * Obtiene el valor de la propiedad numToFetch.
     * 
     */
    public int getNumToFetch() {
        return numToFetch;
    }

    /**
     * Define el valor de la propiedad numToFetch.
     * 
     */
    public void setNumToFetch(int value) {
        this.numToFetch = value;
    }

    /**
     * Obtiene el valor de la propiedad attributes.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getAttributes() {
        return attributes;
    }

    /**
     * Define el valor de la propiedad attributes.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setAttributes(ArrayOfString value) {
        this.attributes = value;
    }

    /**
     * Obtiene el valor de la propiedad getRelatedListValuesResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetRelatedListValuesResult() {
        return getRelatedListValuesResult;
    }

    /**
     * Define el valor de la propiedad getRelatedListValuesResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetRelatedListValuesResult(String value) {
        this.getRelatedListValuesResult = value;
    }

    /**
     * Obtiene el valor de la propiedad numRowsFound.
     * 
     */
    public int getNumRowsFound() {
        return numRowsFound;
    }

    /**
     * Define el valor de la propiedad numRowsFound.
     * 
     */
    public void setNumRowsFound(int value) {
        this.numRowsFound = value;
    }

}
