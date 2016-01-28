package ua.com.ukrelektro.flight.interfaces.impls;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.com.ukrelektro.flight.database.FlightDB;
import ua.com.ukrelektro.flight.database.PassengerDB;
import ua.com.ukrelektro.flight.database.PlaceDB;
import ua.com.ukrelektro.flight.database.ReservationDB;
import ua.com.ukrelektro.flight.interfaces.Buy;
import ua.com.ukrelektro.flight.objects.Flight;
import ua.com.ukrelektro.flight.objects.Passenger;
import ua.com.ukrelektro.flight.objects.Reservation;
import ua.com.ukrelektro.flight.spr.objects.Place;
import ua.com.ukrelektro.flight.utils.GMTCalendar;

public class BuyImpl implements Buy {
    
    private PlaceDB placeDB = PlaceDB.getInstance();
    private FlightDB flightDB = FlightDB.getInstance();
    private ReservationDB reservDB = ReservationDB.getInstance();
    private PassengerDB passengerDB = PassengerDB.getInstance();

    @Override
    public boolean buyTicket(Long flightId, Long placeId, Passenger passenger, String addInfo) {

        try {

            Reservation reserv = new Reservation();
            reserv.setAddInfo(addInfo);
            reserv.setCode(UUID.randomUUID().toString());
            reserv.setPassenger(passenger);

            Calendar c = GMTCalendar.getInstance();
            reserv.setReserveDateTime(c);
            
            Flight flight = flightDB.executeObject(flightDB.getObjectByID(flightId));
            Place place = placeDB.executeObject(placeDB.getObjectByID(placeId));
            
            
            reserv.setPlace(place);
            reserv.setFlight(flight);

            // TODO: One transaction
            int id = passengerDB.insert(passengerDB.getInsertStmt(passenger));
            passenger.setId(id);
            
            id = reservDB.insert(reservDB.getInsertStmt(reserv));

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BuyImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
