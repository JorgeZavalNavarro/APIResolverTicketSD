
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
 *         &lt;element name="docId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="propertyList" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="relatedDoc" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="getAttmnt" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="getHistory" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="getComment" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="getNotiList" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "docId",
    "propertyList",
    "relatedDoc",
    "getAttmnt",
    "getHistory",
    "getComment",
    "getNotiList"
})
@XmlRootElement(name = "getDocument")
public class GetDocument {

    protected int sid;
    protected int docId;
    @XmlElement(required = true)
    protected String propertyList;
    protected boolean relatedDoc;
    protected boolean getAttmnt;
    protected boolean getHistory;
    protected boolean getComment;
    protected boolean getNotiList;

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
     * Obtiene el valor de la propiedad docId.
     * 
     */
    public int getDocId() {
        return docId;
    }

    /**
     * Define el valor de la propiedad docId.
     * 
     */
    public void setDocId(int value) {
        this.docId = value;
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
     * Obtiene el valor de la propiedad relatedDoc.
     * 
     */
    public boolean isRelatedDoc() {
        return relatedDoc;
    }

    /**
     * Define el valor de la propiedad relatedDoc.
     * 
     */
    public void setRelatedDoc(boolean value) {
        this.relatedDoc = value;
    }

    /**
     * Obtiene el valor de la propiedad getAttmnt.
     * 
     */
    public boolean isGetAttmnt() {
        return getAttmnt;
    }

    /**
     * Define el valor de la propiedad getAttmnt.
     * 
     */
    public void setGetAttmnt(boolean value) {
        this.getAttmnt = value;
    }

    /**
     * Obtiene el valor de la propiedad getHistory.
     * 
     */
    public boolean isGetHistory() {
        return getHistory;
    }

    /**
     * Define el valor de la propiedad getHistory.
     * 
     */
    public void setGetHistory(boolean value) {
        this.getHistory = value;
    }

    /**
     * Obtiene el valor de la propiedad getComment.
     * 
     */
    public boolean isGetComment() {
        return getComment;
    }

    /**
     * Define el valor de la propiedad getComment.
     * 
     */
    public void setGetComment(boolean value) {
        this.getComment = value;
    }

    /**
     * Obtiene el valor de la propiedad getNotiList.
     * 
     */
    public boolean isGetNotiList() {
        return getNotiList;
    }

    /**
     * Define el valor de la propiedad getNotiList.
     * 
     */
    public void setGetNotiList(boolean value) {
        this.getNotiList = value;
    }

}
