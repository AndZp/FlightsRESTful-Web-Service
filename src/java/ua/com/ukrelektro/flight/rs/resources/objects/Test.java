/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.ukrelektro.flight.rs.resources.objects;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@XmlRootElement(name = "test")
@XmlAccessorType(XmlAccessType.NONE)
public class Test {
    
    @XmlElement(name = "i")
    private int i;
    
    @XmlElement(name = "s")
    private String s; 
    
    @XmlElement(name = "b")
    private boolean b;
    
    @XmlElement(name = "innerTestList")
    private List<InnerTest> innerTestList;
    
    public Test(){ 
        i = 10; 
        s = "Hello, I`m from RESTful"; 
        b = true;
        innerTestList = new ArrayList<>();
        innerTestList.add(new InnerTest());
        innerTestList.add(new InnerTest());
        innerTestList.add(new InnerTest());              
        
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
    
    

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public List<InnerTest> getInnerTest() {
        return innerTestList;
    }

    public void setInnerTest(List<InnerTest> innerTest) {
        this.innerTestList = innerTest;
    }         
    
}
