package be.technifutur.java.timairport.model.dto;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaneDTO {
    private long id;
    private String callSign;
    private LocalDate registrationDate;
    private boolean inMaintenance;
    private CompanyDTO company;
    private TypeDTO type;
    @Data
    @Builder
    public static class TypeDTO {
        private long id;
        private String name;
        private int capacity;
    }
    @Data
    @Builder
    public static class CompanyDTO {
        private long id;
        private String name;
        private String originCountry;
    }


}