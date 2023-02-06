package be.technifutur.java.timairport.exceptions;

import lombok.Getter;

@Getter
public class NoPilotFoundExceptions extends RuntimeException{

    private final long id;

    public NoPilotFoundExceptions(long id) {
        super("Pilot not found : "+id);
        this.id = id;
    }
}
