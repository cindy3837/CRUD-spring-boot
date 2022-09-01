package com.example.service.app.repository;

import com.example.service.app.entity.member.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("select t from Account t where t.accountName =:account")
    Account findByAccount(@Param("account") String account);
}
