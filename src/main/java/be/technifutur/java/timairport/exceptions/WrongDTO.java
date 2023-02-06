package be.technifutur.java.timairport.exceptions;

import be.technifutur.java.timairport.model.dto.FlightDTO;
import lombok.Getter;

@Getter
public class WrongDTO extends RuntimeException{

    private final FlightDTO flight;

    public WrongDTO(FlightDTO flight) {
        super("Wrong DTO : "+ flight);
        this.flight = flight;
    }

}
