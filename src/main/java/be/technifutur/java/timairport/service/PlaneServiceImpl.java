package be.technifutur.java.timairport.service;

import be.technifutur.java.timairport.exceptions.RessourceNotFoundException;
import be.technifutur.java.timairport.mapper.PlaneMapper;
import be.technifutur.java.timairport.model.dto.PlaneDTO;
import be.technifutur.java.timairport.model.entity.Company;
import be.technifutur.java.timairport.model.entity.Plane;
import be.technifutur.java.timairport.model.entity.TypePlane;
import be.technifutur.java.timairport.model.form.PlaneInsertForm;
import be.technifutur.java.timairport.repository.CompanyRepository;
import be.technifutur.java.timairport.repository.PlaneRepository;
import be.technifutur.java.timairport.repository.TypePlaneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneServiceImpl implements PlaneService{

    private final PlaneRepository planeRepository;
    private final CompanyRepository companyRepository;
    private final TypePlaneRepository typePlaneRepository;
    private final PlaneMapper mapper;

    public PlaneServiceImpl(PlaneRepository planeRepository,
                            CompanyRepository companyRepository,
                            TypePlaneRepository typePlaneRepository,
                            PlaneMapper mapper) {
        this.planeRepository = planeRepository;
        this.companyRepository = companyRepository;
        this.typePlaneRepository = typePlaneRepository;
        this.mapper = mapper;
    }


    @Override
    public void create(PlaneInsertForm form) {

        Plane plane = form.toEntity();


/*        Plane plane = new Plane();

        plane.setCallSign(form.getCallSign());
        plane.setRegistrationDate(form.getRegistrationDate());
*/

        Company company = companyRepository.findById(form.getCompanyId())
                .orElseThrow(RessourceNotFoundException::new);

        TypePlane typePlane = typePlaneRepository.findById(form.getTypeId())
                .orElseThrow(RessourceNotFoundException::new);

        plane.setCompany(company);
        plane.setType(typePlane);

        planeRepository.save(plane);

    }
    @Override
    public PlaneDTO getOne(long id) {
        return planeRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(RessourceNotFoundException::new);
    }

    @Override
    public List<PlaneDTO> getAll() {
        return planeRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }


}
