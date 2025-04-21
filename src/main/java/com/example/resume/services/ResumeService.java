package com.example.resume.services;

import com.example.resume.models.Resume;
import com.example.resume.repository.ResumeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;

    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    // Method to get all resumes
    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    // Method to get a resume by ID
    public Resume getResumeById(Long id) {
        return resumeRepository.findById(id).orElseThrow(() -> new RuntimeException("Resume not found"));
    }

    // Method to create a new resume
    public Resume createResume(Resume resume) {
        return resumeRepository.save(resume);
    }

    // Method to create multiple resumes
    public List<Resume> createResumes(List<Resume> resumes) {
        return resumeRepository.saveAll(resumes);
    }


}
