//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.12 at 10:11:56 PM WAT 
//


package br.com.s2it.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for binaryTreeRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="binaryTreeRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BinaryTreeType" type="{http://s2it.com.br/ws}BinaryTreeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "binaryTreeRequest", propOrder = {
    "binaryTreeType"
})
public class BinaryTreeRequest {

    @XmlElement(name = "BinaryTreeType", required = true)
    protected BinaryTreeType binaryTreeType;

    /**
     * Gets the value of the binaryTreeType property.
     * 
     * @return
     *     possible object is
     *     {@link BinaryTreeType }
     *     
     */
    public BinaryTreeType getBinaryTreeType() {
        return binaryTreeType;
    }

    /**
     * Sets the value of the binaryTreeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BinaryTreeType }
     *     
     */
    public void setBinaryTreeType(BinaryTreeType value) {
        this.binaryTreeType = value;
    }

}
