package ro.aimsoft.springboot.mvc.form;

import javax.validation.constraints.*;
import java.util.UUID;

public class UserEditForm {

    @NotNull
    private UUID id;

    @Email
    private String email;

    @Size(min=8, max=20)
    private String firstName;

    @Size(min=8, max=20)
    private String lastName;

    @Min(0)
    @Max(4)
    private long active;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = UUID.fromString(id);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getActive() {
        return active;
    }

    public void setActive(long active) {
        this.active = active;
    }
}
