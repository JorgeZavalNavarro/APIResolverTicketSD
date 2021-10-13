
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
 *         &lt;element name="docIds" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="propertyList" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sortBy" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "docIds",
    "propertyList",
    "sortBy",
    "descending"
})
@XmlRootElement(name = "getDocumentsByIDs")
public class GetDocumentsByIDs {

    protected int sid;
    @XmlElement(required = true)
    protected String docIds;
    @XmlElement(required = true)
    protected String propertyList;
    @XmlElement(required = true)
    protected String sortBy;
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
     * Obtiene el valor de la propiedad docIds.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocIds() {
        return docIds;
    }

    /**
     * Define el valor de la propiedad docIds.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocIds(String value) {
        this.docIds = value;
    }

    /**
     * Obtiene el valor de la propiedad propertyList.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyList() {
        return propertyList;
    }

    /**
     * Define el valor de la propiedad propertyList.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyList(String value) {
        this.propertyList = value;
    }

    /**
     * Obtiene el valor de la propiedad sortBy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSortBy() {
        return sortBy;
    }

    /**
     * Define el valor de la propiedad sortBy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSortBy(String value) {
        this.sortBy = value;
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
