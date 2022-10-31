package com.asociation.nurses.application.repositories;

import com.asociation.nurses.application.enums.Status;
import com.asociation.nurses.application.models.Association;
import com.asociation.nurses.application.models.Chapter;
import com.asociation.nurses.application.models.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChapterRepositoryTest {

    @Autowired
    private AssociationRepository associationRepository;
    @Autowired
    private ChapterRepository chapterRepository;
    @Autowired
    private MemberRepository memberRepository;

    private Association association;
    private Chapter chapter;
    private Member member;

    @BeforeEach
    void setUp() {
        association = new Association("Long Island");
        association = associationRepository.save(association);

        chapter = new Chapter("East Side","First District", association, null);
        chapter = chapterRepository.save(chapter);

        member = new Member("John", Status.ACTIVE,LocalDate.of(2023,2,3),chapter);
        member = memberRepository.save(member);

        chapter.setPresident(member);
        chapterRepository.save(chapter);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void findById(){
        Optional<Chapter> chapterOptional = chapterRepository.findById(chapter.getId());

        assertEquals("John",chapterOptional.get().getPresident().getName());
    }
}