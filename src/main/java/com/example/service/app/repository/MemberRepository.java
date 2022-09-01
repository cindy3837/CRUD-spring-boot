package com.example.service.app.repository;

import com.example.service.app.entity.member.Member;
import com.example.service.app.entity.member.MemberData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
