
package com.motek.soa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for report complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="report">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bigCharacters" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="characters" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="smallCharacters" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="spaces" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "report", propOrder = {
    "bigCharacters",
    "characters",
    "smallCharacters",
    "spaces"
})
public class Report {

    protected int bigCharacters;
    protected int characters;
    protected int smallCharacters;
    protected int spaces;

    /**
     * Gets the value of the bigCharacters property.
     * 
     */
    public int getBigCharacters() {
        return bigCharacters;
    }

    /**
     * Sets the value of the bigCharacters property.
     * 
     */
    public void setBigCharacters(int value) {
        this.bigCharacters = value;
    }

    /**
     * Gets the value of the characters property.
     * 
     */
    public int getCharacters() {
        return characters;
    }

    /**
     * Sets the value of the characters property.
     * 
     */
    public void setCharacters(int value) {
        this.characters = value;
    }

    /**
     * Gets the value of the smallCharacters property.
     * 
     */
    public int getSmallCharacters() {
        return smallCharacters;
    }

    /**
     * Sets the value of the smallCharacters property.
     * 
     */
    public void setSmallCharacters(int value) {
        this.smallCharacters = value;
    }

    /**
     * Gets the value of the spaces property.
     * 
     */
    public int getSpaces() {
        return spaces;
    }

    /**
     * Sets the value of the spaces property.
     * 
     */
    public void setSpaces(int value) {
        this.spaces = value;
    }

}
