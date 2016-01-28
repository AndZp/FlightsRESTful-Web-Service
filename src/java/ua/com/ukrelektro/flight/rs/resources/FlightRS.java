/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.ukrelektro.flight.rs.resources;


import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ua.com.ukrelektro.flight.interfaces.impls.BuyImpl;
import ua.com.ukrelektro.flight.interfaces.impls.CheckImpl;
import ua.com.ukrelektro.flight.interfaces.impls.SearchImpl;
import ua.com.ukrelektro.flight.objects.Flight;
import ua.com.ukrelektro.flight.rs.params.TicketParam;
import ua.com.ukrelektro.flight.rs.resources.objects.CityList;
import ua.com.ukrelektro.flight.rs.resources.objects.FlightList;
import ua.com.ukrelektro.flight.rs.resources.objects.ReservationResult;
import ua.com.ukrelektro.flight.rs.resources.objects.Test;
import ua.com.ukrelektro.flight.spr.objects.City;
import ua.com.ukrelektro.flight.utils.GMTCalendar;
import ua.com.ukrelektro.flight.ws.proxy.CustomProxySelector;

@Path("flight")
@Produces(MediaType.APPLICATION_JSON)
public class FlightRS {

    private SearchImpl searchImpl = new SearchImpl();
    private BuyImpl buyImpl = new BuyImpl();
    private CheckImpl checkImpl = new CheckImpl();

    public FlightRS() {
        ProxySelector.setDefault(new CustomProxySelector());
    }
    
    @GET     
    @Path("/test")
    public Test getTest() {
        Test test = new Test();
        test.setI((int) Math.random()*10);
        test.setS("this class: " + this);
        test.setB(true);
                      
        return test;
    }

    @GET
    @Path("/allcities")
    public CityList getAllCities() {
        List<City> list = searchImpl.getAllCities();
        CityList cityList = new CityList();
        cityList.setList(list);
        return cityList;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/searchFlight/{date}/{cityFromId}/{cityToId}")
    public FlightList searchFlight(@PathParam("date") Long date, @PathParam("cityFromId") Long cityFromId, @PathParam("cityToId") Long cityToId) {

        FlightList flightList = new FlightList();
        ArrayList<Flight> list = new ArrayList<>();
        Calendar c = GMTCalendar.getInstance();
        c.setTimeInMillis(date);

        list.addAll(searchImpl.searchFlight(date, cityFromId, cityToId));

        flightList.setList(list);

        return flightList;
    }

    @POST
    @Path("/buyTicket")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean buyTicket(TicketParam ticketParam) {

        boolean result = buyImpl.buyTicket(ticketParam.getFlightId(), ticketParam.getPlaceId(), ticketParam.getPassenger(), ticketParam.getAddInfo());

        return result;
    }

    @GET
    @Path("/checkReservation/{code}")
    public ReservationResult checkReservationByCode(@PathParam("code") String code) {
        ReservationResult reservationResult = new ReservationResult();
        reservationResult.setReservation(checkImpl.checkReservationByCode(code));
        return reservationResult;
    }
}