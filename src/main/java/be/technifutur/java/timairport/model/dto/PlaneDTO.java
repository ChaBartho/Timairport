package be.technifutur.java.timairport.model.dto;

import lombok.Builder;
import lombok.Data;
//DTO = Data Transactionnal Object = objet contenant les données qui vont être transitées = Protection
import java.time.LocalDate;
@Data
@Builder    //pas necessaire
public class PlaneDTO {

    private long id;
    private String callSign;
    private LocalDate registrationDate;
    private boolean inMaintenance;
    private TypeDTO type;
    private CompanyDTO company;

    @Data
    @Builder    //pas necessaire
    public static class TypeDTO {
        private long id;
        private String name;
        private int capacity;
    }

    @Data
    @Builder    //pas necessaire
    public static class CompanyDTO{
        private long id;
        private String name;
        private String originCountry;
    }
}
