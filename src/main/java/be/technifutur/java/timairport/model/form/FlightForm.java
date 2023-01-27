package be.technifutur.java.timairport.model.form;

import be.technifutur.java.timairport.model.entity.Airport;
import be.technifutur.java.timairport.model.entity.Flight;
import be.technifutur.java.timairport.model.entity.Pilot;
import be.technifutur.java.timairport.model.entity.Plane;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class FlightForm {
    @NotNull
    private LocalDateTime departureTime;
    @NotNull
    private LocalDateTime arrivalTime;
    @NotNull
    private Airport departure;
    @NotNull
    @Future
    private Airport destination;
    @NotNull
    private Plane plane;
    @NotNull
    private Pilot captain;
    @NotNull
    private Pilot firstOfficer;


    public Flight toEntity(){
        Flight flight = new Flight();

        flight.setDepartureTime(this.departureTime);
        flight.setArrivalTime(this.arrivalTime);
        flight.setDeparture(this.departure);
        flight.setDestination(this.destination);
        flight.setPlane(this.plane);
        flight.setCaptain(this.captain);
        flight.setFirstOfficer(this.firstOfficer);

        return flight;
    }


}
