package be.technifutur.java.timairport.model.form;

import be.technifutur.java.timairport.constraints.Not0;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginForm {
    @NotNull
    private String username;
    @NotNull
    private String password;


}
