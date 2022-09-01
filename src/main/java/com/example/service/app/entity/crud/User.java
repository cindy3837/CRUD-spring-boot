package com.example.service.app.entity.crud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @Column(name = "id", length = 4)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "custom_id")
    @GenericGenerator(name = "custom_id", strategy = "com.example.service.app.entity.ManualInsertGenerator")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "phone")
    private String phone;

}
