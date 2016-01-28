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
import ua.com.ukrelektro.flight.spr.objects.City;

@XmlRootElement(name = "cityList")
@XmlAccessorType(XmlAccessType.NONE)
public class CityList {

    public CityList() {
    }
    
    @XmlElement(name = "cityList")
    private List<City> list;

    
    public List<City> getList() {
        return list;
    }

    public void setList(List<City> list) {
        this.list = list;
    }


}