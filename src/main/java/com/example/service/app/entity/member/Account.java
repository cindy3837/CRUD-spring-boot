package com.example.service.app.entity.member;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "account")
@NoArgsConstructor
public class Account {

    public Account(String accountName, String password){
        this.accountName = accountName;
        this.password = password;
    }

    @Id
    @Column(name = "id", length = 4)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "custom_id")
    @GenericGenerator(name = "custom_id", strategy = "com.example.service.app.entity.ManualInsertGenerator")
    private Long id;
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "password")
    private String password;


}
