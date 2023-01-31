package be.technifutur.java.timairport.controller;

import be.technifutur.java.timairport.model.entity.Flight;
import be.technifutur.java.timairport.model.form.FlightForm;
import be.technifutur.java.timairport.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private final FlightService flightService;


    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }


    @PostMapping("/add")
    public void create(@RequestBody @Valid FlightForm form){
        flightService.create(form);
    }


}
