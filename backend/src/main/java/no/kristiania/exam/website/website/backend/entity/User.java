package no.kristiania.exam.website.website.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

/**
 * Adapted from:
 * https://github.com/arcuri82/testing_security_development_enterprise_systems/tree/master/intro/exercise-solutions/quiz-game/part-11/backend
 */

@Entity
@Table(name="USERS")
public class User {
    @Id
    @NotBlank
    private String username;

    @Size(max = 255)
    @NotNull
    private String first_name;

    @Size(max = 255)
    @NotNull
    private String surname;

    @Email
    @NotNull
    private String email;

    @NotBlank
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;

    @NotNull
    private Boolean enabled;

    @ManyToMany
    private List<Item> rankedItems;


    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Item> getRankedItems() {
        return rankedItems;
    }

    public void setRankedItems(List<Item> rankedItems) {
        this.rankedItems = rankedItems;
    }
}

