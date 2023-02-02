package be.technifutur.java.timairport.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class InPastValidator implements ConstraintValidator<InPast, LocalDate> {

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if(value.isBefore(LocalDate.now().minusDays(7)))
            //value.plusDays(7).isBefore(LocalDate.now())
        return false;
        else{
            return true;
        }
    }

}