package be.technifutur.java.timairport.controller;

import be.technifutur.java.timairport.model.entity.Flight;
import be.technifutur.java.timairport.model.form.FlightForm;
import be.technifutur.java.timairport.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/{id:[0-9]+}")
    public Flight read(@PathVariable long id){
        return flightService.read(id);
    }

    @DeleteMapping("/delete/{id:[0-9]+}")
    public void delete(@PathVariable long id){
        flightService.delete(id);
    }

    @PatchMapping(path = "/{id:[0-9]+}/update")
    public void update(@PathVariable long id, @RequestParam Map<String, Object> params){
        Map<String, Object> mapValues = new HashMap<>();

        if (params.containsKey("departureTime"))
            mapValues.put("departureTime", params.get("departureTime"));

        if (params.containsKey("arrivalTime"))
            mapValues.put("arrivalTime", params.get("arrivalTime"));

        flightService.update(id, mapValues);
    }


}
