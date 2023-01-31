package be.technifutur.java.timairport.model.form;

import be.technifutur.java.timairport.model.entity.Airport;
import be.technifutur.java.timairport.model.entity.Flight;
import be.technifutur.java.timairport.model.entity.Pilot;
import be.technifutur.java.timairport.model.entity.Plane;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class FlightForm {
    @NotNull
    private String departureTime;
    @NotNull
    private String arrivalTime;
    @NotNull
    private Long departureId;
    @NotNull
    private Long destinationId;
    @NotNull
    private Long planeId;
    @NotNull
    private Long captainId;
    @NotNull
    private Long firstOfficerId;


    public Flight toEntity(){
        Flight flight = new Flight();

        flight.setDepartureTime(LocalDateTime.parse(this.departureTime));
        flight.setArrivalTime(LocalDateTime.parse(this.arrivalTime));

        return flight;
    }


}
