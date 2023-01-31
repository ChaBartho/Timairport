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

    private long id;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Long departureId;
    private Long destinationId;
    private Long planeId;
    private Long captainId;
    private Long firstOfficerId;

}
