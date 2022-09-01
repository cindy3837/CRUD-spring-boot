package com.example.service.app.repository;

import com.example.service.app.entity.crud.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select t from User t where t.username =:username")
    User findByUserName(@Param("username") String username);
}
