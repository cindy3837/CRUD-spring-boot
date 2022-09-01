package com.example.service.app.entity.member;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "member_data")
@NoArgsConstructor
public class MemberData {
    public MemberData(String memberName, String memberAccount, String memberPassword){
        this.memberName = memberName;
        this.memberAccount = memberAccount;
        this.memberPassword = memberPassword;
    }

    @Id
    @Column(name = "id", length = 4)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "custom_id")
    @GenericGenerator(name = "custom_id", strategy = "com.example.service.app.entity.ManualInsertGenerator")
    private Long id;

    @Column(name = "member_name")
    private String memberName;
    @Column(name = "member_account")
    private String memberAccount;
    @Column(name = "member_password")
    private String memberPassword;

}
