package be.technifutur.java.timairport.model.dto;
import be.technifutur.java.timairport.model.entity.Airport;
import be.technifutur.java.timairport.model.entity.Pilot;
import be.technifutur.java.timairport.model.entity.Plane;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class FlightDTO {

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Airport departure;
    private Airport destination;
    private Plane plane;
    private Pilot captain;
    private Pilot firstOfficer;

}
