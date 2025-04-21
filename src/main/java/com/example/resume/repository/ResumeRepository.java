package com.example.resume.repository;

import com.example.resume.models.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {

    List<Resume> findByEducation(String education);

    Resume findByEmail(String name);

    List<Resume> findByAge(Integer age);

}