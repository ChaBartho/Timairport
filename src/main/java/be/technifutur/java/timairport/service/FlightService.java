package be.technifutur.java.timairport.service;

import be.technifutur.java.timairport.model.entity.Flight;
import be.technifutur.java.timairport.model.form.FlightForm;

import java.util.Map;

public interface FlightService {

    void create(FlightForm form);
    void update(long id, Map<String, Object> updateFlight);
    void delete(long id);
    Flight read(long id);
}
