package com.asociation.nurses.application.repositories;

import com.asociation.nurses.application.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
