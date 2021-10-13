
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
 *         &lt;element name="categoryIds" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="resultSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="propertyList" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sortBy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descending" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="whereClause" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="maxDocIDs" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "categoryIds",
    "resultSize",
    "propertyList",
    "sortBy",
    "descending",
    "whereClause",
    "maxDocIDs"
})
@XmlRootElement(name = "faq")
public class Faq {

    protected int sid;
    @XmlElement(required = true)
    protected String categoryIds;
    protected int resultSize;
    @XmlElement(required = true)
    protected String propertyList;
    @XmlElement(required = true)
    protected String sortBy;
    protected boolean descending;
    @XmlElement(required = true)
    protected String whereClause;
    protected int maxDocIDs;

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
     * Obtiene el valor de la propiedad categoryIds.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryIds() {
        return categoryIds;
    }

    /**
     * Define el valor de la propiedad categoryIds.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryIds(String value) {
        this.categoryIds = value;
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

    /**
     * Obtiene el valor de la propiedad whereClause.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWhereClause() {
        return whereClause;
    }

    /**
     * Define el valor de la propiedad whereClause.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWhereClause(String value) {
        this.whereClause = value;
    }

    /**
     * Obtiene el valor de la propiedad maxDocIDs.
     * 
     */
    public int getMaxDocIDs() {
        return maxDocIDs;
    }

    /**
     * Define el valor de la propiedad maxDocIDs.
     * 
     */
    public void setMaxDocIDs(int value) {
        this.maxDocIDs = value;
    }

}
