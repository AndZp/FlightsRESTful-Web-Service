/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.ukrelektro.flight.rs.resources.objects;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import ua.com.ukrelektro.flight.objects.Flight;

@XmlRootElement(name = "flightList")
@XmlAccessorType(XmlAccessType.NONE)
public class FlightList {

    public FlightList() {
    }
    
    @XmlElement(name = "flightList")
    private List<Flight> list;

    
    public List<Flight> getList() {
        return list;
    }

    public void setList(List<Flight> list) {
        this.list = list;
    }


}