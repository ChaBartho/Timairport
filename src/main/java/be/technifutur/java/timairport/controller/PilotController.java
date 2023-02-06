package be.technifutur.java.timairport.controller;

import be.technifutur.java.timairport.exceptions.NoPilotFoundExceptions;
import be.technifutur.java.timairport.model.dto.PilotDTO;
import be.technifutur.java.timairport.service.PilotService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //= @Controller + @Responsbody
@RequestMapping("/pilot") //= pour ne pas écrire "pilot" à chaque mapping
public class PilotController {

    private final PilotService pilotService;

    public PilotController(PilotService pilotService) {
        this.pilotService = pilotService;
    }

    //Recuperer les pilots
    @GetMapping("/all")
    public List<PilotDTO> getAll(){
        return pilotService.getAll();
    }



}
