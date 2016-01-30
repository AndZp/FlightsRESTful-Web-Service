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

@XmlRootElement(name = "innerTest")
@XmlAccessorType(XmlAccessType.NONE)
class InnerTest {

    @XmlElement(name = "innerString")
    private String innerString;
    
    @XmlElement(name = "innerInInner")
    private InnerInInner innerInInner;

    public InnerInInner getInnerInInner() {
        return innerInInner;
    }

    public void setInnerInInner(InnerInInner innerInInner) {
        this.innerInInner = innerInInner;
    }

    public InnerTest() {
        innerString = "Hello from InnerTest.class";
        innerInInner = new InnerInInner();
    }

    public void setInnerString(String innerString) {
        this.innerString = innerString;
    }

    public String getInnerString() {
        return innerString;
    }

}
