package com.example.service.app.repository;

import com.example.service.app.entity.crud.User;
import com.example.service.app.entity.member.MemberData;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface MemberDataRepository extends JpaRepository<MemberData, Long> {

    @Query("select t from MemberData t where t.memberName =:memberName")
    User findByMemberName(@Param("memberName") String memberName);

}


