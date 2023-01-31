package be.technifutur.java.timairport.service;

import be.technifutur.java.timairport.exceptions.RessourceNotFoundException;
import be.technifutur.java.timairport.model.entity.Airport;
import be.technifutur.java.timairport.model.entity.Flight;
import be.technifutur.java.timairport.model.entity.Pilot;
import be.technifutur.java.timairport.model.entity.Plane;
import be.technifutur.java.timairport.model.form.FlightForm;
import be.technifutur.java.timairport.repository.*;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService{
    private final FlightRepository flightRepository;
    private final PilotRepository pilotRepository;
    private final AirportRepository airportRepository;
    private final PlaneRepository planeRepository;

    public FlightServiceImpl(FlightRepository flightRepository,
                             PilotRepository pilotRepository,
                             AirportRepository airportRepository,
                             PlaneRepository planeRepository) {
        this.flightRepository = flightRepository;
        this.pilotRepository = pilotRepository;
        this.airportRepository = airportRepository;
        this.planeRepository = planeRepository;
    }

    @Override
    public void create(FlightForm form) {

        Flight flight = form.toEntity();

        Plane plane = planeRepository.findById(form.getPlaneId())
                .orElseThrow(RessourceNotFoundException::new);
        flight.setPlane(plane);
        Pilot captain = pilotRepository.findById(form.getCaptainId())
                .orElseThrow(RessourceNotFoundException::new);
        flight.setCaptain(captain);
        Pilot firstOfficer = pilotRepository.findById(form.getFirstOfficerId())
                .orElseThrow(RessourceNotFoundException::new);
        flight.setFirstOfficer(firstOfficer);
        Airport departure = airportRepository.findById(form.getDepartureId())
                .orElseThrow(RessourceNotFoundException::new);
        flight.setDeparture(departure);
        Airport destination = airportRepository.findById(form.getDestinationId())
                .orElseThrow(RessourceNotFoundException::new);
        flight.setDestination(destination);

        flightRepository.save(flight);



    }
}
