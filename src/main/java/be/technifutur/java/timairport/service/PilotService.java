package be.technifutur.java.timairport.service;

import be.technifutur.java.timairport.model.dto.PilotDTO;
import be.technifutur.java.timairport.model.entity.Pilot;
import be.technifutur.java.timairport.repository.PilotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//Il n'y a pas de PilotServiceImpl car on a été chercher tout dans DataInit

@Service
public class PilotService {

    private final PilotRepository pilotRepository;

    public PilotService(PilotRepository pilotRepository) {
        this.pilotRepository = pilotRepository;
    }

    //Récupérer tous les pilotes
    public List<PilotDTO> getAll(){
        //Faire une liste des entités
        List<Pilot> pilots = pilotRepository.findAll();
        //builder sert créer un objet de type PilotDTO
        return pilots.stream()
                .map( entity -> PilotDTO.builder()
                                .id( entity.getId() )
                                .name( entity.getFirstname() +' '+ entity.getLastname() )
                                .build()
                )
        .toList();
    }










}
