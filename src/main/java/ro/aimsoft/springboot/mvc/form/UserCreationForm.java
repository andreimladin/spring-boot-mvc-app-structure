package ro.aimsoft.springboot.mvc.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserCreationForm {

    @Email
    @Size(min=8, max=30)
    private String email;

    @NotNull
    @Size(min=8, max=20)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
