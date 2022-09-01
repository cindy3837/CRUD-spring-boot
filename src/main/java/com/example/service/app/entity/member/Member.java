package com.example.service.app.entity.member;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "member")
@NoArgsConstructor
public class Member {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String memberAccount;
    private String memberName;
    private String password;
    private String confirmPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
