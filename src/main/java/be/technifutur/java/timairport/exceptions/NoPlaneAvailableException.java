package be.technifutur.java.timairport.exceptions;

public class NoPlaneAvailableException extends RuntimeException {

    public NoPlaneAvailableException(){
        super("no plane available");
    }
}
