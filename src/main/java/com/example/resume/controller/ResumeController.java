package com.example.resume.controller;

import com.example.resume.models.Resume;
import com.example.resume.services.ResumeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {
    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    // Endpoint to get all resumes
    @GetMapping
    public List<Resume> getAllResumes() {
        return resumeService.getAllResumes();
    }

    // Endpoint to get a resume by ID
    @GetMapping("/{id}")
    public Resume getResumeById(@PathVariable Long id) {
        return resumeService.getResumeById(id);
    }

    @PostMapping
    public Resume createResume(@RequestBody Resume resume) {
        System.out.println("Creating resume: " + resume);
        return resumeService.createResume(resume);
    }

    @PostMapping("/bulk")
    public List<Resume> createResumes(@RequestBody List<Resume> resumes) {
        return resumeService.createResumes(resumes);
    }


}
