
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
 *         &lt;element name="whereClause" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sortBy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="desc" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="maxRows" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="attributes" type="{http://www.ca.com/UnicenterServicePlus/ServiceDesk}ArrayOfString"/>
 *         &lt;element name="skip" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "whereClause",
    "sortBy",
    "desc",
    "maxRows",
    "attributes",
    "skip"
})
@XmlRootElement(name = "doSelectKD")
public class DoSelectKD {

    protected int sid;
    @XmlElement(required = true)
    protected String whereClause;
    @XmlElement(required = true)
    protected String sortBy;
    protected boolean desc;
    protected int maxRows;
    @XmlElement(required = true)
    protected ArrayOfString attributes;
    protected int skip;

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
     * Obtiene el valor de la propiedad desc.
     * 
     */
    public boolean isDesc() {
        return desc;
    }

    /**
     * Define el valor de la propiedad desc.
     * 
     */
    public void setDesc(boolean value) {
        this.desc = value;
    }

    /**
     * Obtiene el valor de la propiedad maxRows.
     * 
     */
    public int getMaxRows() {
        return maxRows;
    }

    /**
     * Define el valor de la propiedad maxRows.
     * 
     */
    public void setMaxRows(int value) {
        this.maxRows = value;
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
     * Obtiene el valor de la propiedad skip.
     * 
     */
    public int getSkip() {
        return skip;
    }

    /**
     * Define el valor de la propiedad skip.
     * 
     */
    public void setSkip(int value) {
        this.skip = value;
    }

}
