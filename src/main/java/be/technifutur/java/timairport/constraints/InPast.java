package be.technifutur.java.timairport.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)  //mettre l'annotation sur un champs
@Retention(RetentionPolicy.RUNTIME) //retention = la maniere avec laquelle l'annotation est retenue / runtime = durant tout le run de l'appli
@Constraint(validatedBy = InPastValidator.class)
public @interface InPast {
    String message() default "La date d'enregistrement n'est pas de min 7jours dans le passé";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}
