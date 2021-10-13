
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
 *         &lt;element name="problem" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="resultSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="properties" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sortBy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descending" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="relatedCategories" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="searchType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="matchType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="searchField" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="categoryPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "problem",
    "resultSize",
    "properties",
    "sortBy",
    "descending",
    "relatedCategories",
    "searchType",
    "matchType",
    "searchField",
    "categoryPath",
    "whereClause",
    "maxDocIDs"
})
@XmlRootElement(name = "search")
public class Search {

    protected int sid;
    @XmlElement(required = true)
    protected String problem;
    protected int resultSize;
    @XmlElement(required = true)
    protected String properties;
    @XmlElement(required = true)
    protected String sortBy;
    protected boolean descending;
    protected boolean relatedCategories;
    protected int searchType;
    protected int matchType;
    protected int searchField;
    @XmlElement(required = true)
    protected String categoryPath;
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
     * Obtiene el valor de la propiedad problem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProblem() {
        return problem;
    }

    /**
     * Define el valor de la propiedad problem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProblem(String value) {
        this.problem = value;
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
     * Obtiene el valor de la propiedad properties.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties() {
        return properties;
    }

    /**
     * Define el valor de la propiedad properties.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties(String value) {
        this.properties = value;
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
     * Obtiene el valor de la propiedad relatedCategories.
     * 
     */
    public boolean isRelatedCategories() {
        return relatedCategories;
    }

    /**
     * Define el valor de la propiedad relatedCategories.
     * 
     */
    public void setRelatedCategories(boolean value) {
        this.relatedCategories = value;
    }

    /**
     * Obtiene el valor de la propiedad searchType.
     * 
     */
    public int getSearchType() {
        return searchType;
    }

    /**
     * Define el valor de la propiedad searchType.
     * 
     */
    public void setSearchType(int value) {
        this.searchType = value;
    }

    /**
     * Obtiene el valor de la propiedad matchType.
     * 
     */
    public int getMatchType() {
        return matchType;
    }

    /**
     * Define el valor de la propiedad matchType.
     * 
     */
    public void setMatchType(int value) {
        this.matchType = value;
    }

    /**
     * Obtiene el valor de la propiedad searchField.
     * 
     */
    public int getSearchField() {
        return searchField;
    }

    /**
     * Define el valor de la propiedad searchField.
     * 
     */
    public void setSearchField(int value) {
        this.searchField = value;
    }

    /**
     * Obtiene el valor de la propiedad categoryPath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryPath() {
        return categoryPath;
    }

    /**
     * Define el valor de la propiedad categoryPath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryPath(String value) {
        this.categoryPath = value;
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
