package softuni.bg.mobilelele.model.entity;

import softuni.bg.mobilelele.model.entity.enums.RoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private RoleEnum role;

    public Long getId() {
        return id;
    }

    public UserRoleEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public RoleEnum getRole() {
        return role;
    }

    public UserRoleEntity setRole(RoleEnum role) {
        this.role = role;
        return this;
    }
}
