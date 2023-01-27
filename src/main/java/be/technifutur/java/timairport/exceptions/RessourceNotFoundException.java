package be.technifutur.java.timairport.exceptions;

public class RessourceNotFoundException extends RuntimeException {

    public RessourceNotFoundException(){
        super("the requested ressource was not found");
    }

    public RessourceNotFoundException(Throwable cause){
        super("the requested ressource was not found", cause);
    }

}
