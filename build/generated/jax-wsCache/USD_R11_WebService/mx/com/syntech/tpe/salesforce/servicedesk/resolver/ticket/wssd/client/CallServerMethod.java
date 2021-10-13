
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
 *         &lt;element name="methodName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="factoryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="formatList" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parameters" type="{http://www.ca.com/UnicenterServicePlus/ServiceDesk}ArrayOfString"/>
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
    "methodName",
    "factoryName",
    "formatList",
    "parameters"
})
@XmlRootElement(name = "callServerMethod")
public class CallServerMethod {

    protected int sid;
    @XmlElement(required = true)
    protected String methodName;
    @XmlElement(required = true)
    protected String factoryName;
    @XmlElement(required = true)
    protected String formatList;
    @XmlElement(required = true)
    protected ArrayOfString parameters;

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
     * Obtiene el valor de la propiedad methodName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * Define el valor de la propiedad methodName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMethodName(String value) {
        this.methodName = value;
    }

    /**
     * Obtiene el valor de la propiedad factoryName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFactoryName() {
        return factoryName;
    }

    /**
     * Define el valor de la propiedad factoryName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFactoryName(String value) {
        this.factoryName = value;
    }

    /**
     * Obtiene el valor de la propiedad formatList.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatList() {
        return formatList;
    }

    /**
     * Define el valor de la propiedad formatList.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatList(String value) {
        this.formatList = value;
    }

    /**
     * Obtiene el valor de la propiedad parameters.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getParameters() {
        return parameters;
    }

    /**
     * Define el valor de la propiedad parameters.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setParameters(ArrayOfString value) {
        this.parameters = value;
    }

}
