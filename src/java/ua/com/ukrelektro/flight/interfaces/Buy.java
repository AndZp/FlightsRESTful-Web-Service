package ua.com.ukrelektro.flight.interfaces;

import ua.com.ukrelektro.flight.objects.Passenger;

public interface Buy {
    
    boolean buyTicket(Long flightId, Long placeId, Passenger passenger, String addInfo);

}
