package be.technifutur.java.timairport.mapper;

import be.technifutur.java.timairport.model.dto.PlaneDTO;
import be.technifutur.java.timairport.model.entity.Plane;
import be.technifutur.java.timairport.model.form.PlaneInsertForm;
import org.springframework.stereotype.Service;
// mapper = transformer diff objet en autre diff objet
@Service
public class PlaneMapper {
//1ere méthode (de entity à DTO)
    public PlaneDTO toDto(Plane entity){

        if(entity == null)
            return null;

        return PlaneDTO.builder()
                .id(entity.getId())
                .inMaintenance(entity.isInMaintenance())
                .callSign(entity.getCallSign())
                .registrationDate(entity.getRegistrationDate())
                .company(
                        PlaneDTO.CompanyDTO.builder()
                                .id(entity.getCompany().getId())
                                .name(entity.getCompany().getName())
                                .originCountry(entity.getCompany().getOriginCountry())
                                .build()
                )
                .type(
                        PlaneDTO.TypeDTO.builder()
                                .id(entity.getType().getId())
                                .name(entity.getType().getName())
                                .capacity(entity.getType().getCapacity())
                                .build()
                )
                .build();
    }


//2eme méthode (de form vers l'entité)
    public Plane toEntity(PlaneInsertForm form){
        Plane entity = new Plane();

        entity.setCallSign( form.getCallSign() );
        entity.setRegistrationDate( form.getRegistrationDate() );

        return entity;
    }
}
