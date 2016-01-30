/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.ukrelektro.flight.rs.resources.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@XmlRootElement(name = "innerTest")
@XmlAccessorType(XmlAccessType.NONE)
class InnerInInner {
    
    @XmlElement(name = "innerInInnerString")
    private String innerInInnerString;
    
    public InnerInInner() { 
        innerInInnerString = "Inner in Inner Test string";
    }

    public String getInnerInInnerString() {
        return innerInInnerString;
    }

    public void setInnerInInnerString(String innerInInnerString) {
        this.innerInInnerString = innerInInnerString;
    }
    
    
}
