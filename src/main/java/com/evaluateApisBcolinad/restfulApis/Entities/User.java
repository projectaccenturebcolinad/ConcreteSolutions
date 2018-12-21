package com.evaluateApisBcolinad.restfulApis.Entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="users",uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class User {

    @Id
    @Column(name="ID")
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;
    @Column(name="NAME")
    @NotNull
    private String name;
    @Column(name="EMAIL")
    @NotNull
    private String email;
    @Column(name="PASSWORD")
    @NotNull
    private String password;
    @Column(name="PHONES")
    private String phones;
    @Column(name="CREATED")
    @NotNull
    private LocalDateTime created;
    @Column(name="MODIFIED")
    private LocalDateTime modified;
    @Column(name="LAST_LOGIN")
    private LocalDateTime last_login;
    @Column(name="TOKEN")
    private String token;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    public User(){}

    public User(@NotNull String name, @NotNull String email, @NotNull String password, String phones, @NotNull LocalDateTime created, LocalDateTime modified, LocalDateTime last_login, String token, List<String> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
        this.created = created;
        this.modified = modified;
        this.last_login = last_login;
        this.token = token;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public LocalDateTime getLast_login() {
        return last_login;
    }

    public void setLast_login(LocalDateTime last_login) {
        this.last_login = last_login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}