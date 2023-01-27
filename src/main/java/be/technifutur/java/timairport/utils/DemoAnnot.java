package be.technifutur.java.timairport.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD}) //sur quoi je peux mettre mon annotation = cible
@Retention(RetentionPolicy.RUNTIME) //jusqu'à quel moment l'annotation va rester dnas le code
public @interface DemoAnnot {


}
