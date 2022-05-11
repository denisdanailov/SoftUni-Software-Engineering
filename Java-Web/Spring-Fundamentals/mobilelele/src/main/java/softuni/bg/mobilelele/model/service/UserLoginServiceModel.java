package softuni.bg.mobilelele.model.service;

public class UserLoginServiceModel {

    private Long id;

    private String username;
    private String rawPassword;

    public Long getId() {
        return id;
    }

    public UserLoginServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserLoginServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getRawPassword() {
        return rawPassword;
    }

    public UserLoginServiceModel setRawPassword(String rawPassword) {
        this.rawPassword = rawPassword;
        return this;
    }
}
