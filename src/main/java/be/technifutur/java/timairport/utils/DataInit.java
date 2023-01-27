package be.technifutur.java.timairport.utils;

import be.technifutur.java.timairport.model.entity.*;
import be.technifutur.java.timairport.repository.AirportRepository;
import be.technifutur.java.timairport.repository.CompanyRepository;
import be.technifutur.java.timairport.repository.PilotRepository;
import be.technifutur.java.timairport.repository.TypePlaneRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInit implements InitializingBean {

    private final CompanyRepository companyRepository;
    private final TypePlaneRepository typePlaneRepository;
    private final AirportRepository airportRepository;
    private final PilotRepository pilotRepository;

    public DataInit(CompanyRepository companyRepository, TypePlaneRepository typePlaneRepository,
                    AirportRepository airportRepository,
                    PilotRepository pilotRepository) {
        this.companyRepository = companyRepository;
        this.typePlaneRepository = typePlaneRepository;
        this.airportRepository = airportRepository;
        this.pilotRepository = pilotRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

//New plane:
        TypePlane type = new TypePlane();
        type.setName("big_plane");
        type.setCapacity(300);

        typePlaneRepository.save(type);

        TypePlane type2 = new TypePlane();
        type2.setName("average_plane");
        type2.setCapacity(200);

        typePlaneRepository.save(type2);

        TypePlane type3 = new TypePlane();
        type3.setName("small_plane");
        type3.setCapacity(100);

        typePlaneRepository.save(type3);

//New company:
        Company company = new Company();
        company.setName("Big Money Company");
        company.setOriginCountry("USA");

        companyRepository.save(company);

        Company company2 = new Company();
        company2.setName("Deedlamerd");
        company2.setOriginCountry("Belgium");

        companyRepository.save(company);

//Création liste de type

        List<TypePlane> maliste = new ArrayList<>();
        maliste.add(type);
        maliste.add(type2);

        List<TypePlane> maliste2 = new ArrayList<>();
        maliste2.add(type);
        maliste2.add(type2);
        maliste2.add(type3);

//New Aiport:
        Airport airport = new Airport();
        airport.setName("Technifutur International");
        airport.setCity("Dubai");
        airport.setPlaneTypesAllowed(maliste2);

        airportRepository.save(airport);

        Airport airport2 = new Airport();
        airport2.setName("YasQueen-Charles-De-Gaulle");
        airport2.setCity("New-York");
        airport2.setPlaneTypesAllowed(maliste);

        airportRepository.save(airport);

//New Pilot:
        Pilot pilot = new Pilot();
        pilot.setFirstname("Julie-Vander");
        pilot.setLastname("Byse");
        pilot.setCompany(company);

        pilotRepository.save(pilot);

        Pilot pilot2 = new Pilot();
        pilot2.setFirstname("Tim");
        pilot2.setLastname("Prégardine");
        pilot2.setCompany(company2);

        pilotRepository.save(pilot2);

    }
}
