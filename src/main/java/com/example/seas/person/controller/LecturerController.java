package com.example.seas.person.controller;

import com.example.seas.person.dto.LecturerDTO;
import com.example.seas.person.entity.Lecturer;
import com.example.seas.person.mapper.LecturerMapper;
import com.example.seas.person.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Validated
public class LecturerController {

    private final LecturerMapper lecturerMapper;
    private final LecturerService lecturerService;

    @GetMapping("/lecturers")
    public List<LecturerDTO> getAllLecturers() {
        List<Lecturer> lecturers = lecturerService.getAllLecturers();
        return lecturerMapper.mapToDto(lecturers);
    }
    @GetMapping("/lecturer/of/{eventName}")
    public LecturerDTO getLecturerOfEvent(@PathVariable String eventName) {
        Optional<Lecturer> optionalLecturer = lecturerService.getLecturerOfEvent(eventName);
        return lecturerMapper.mapToDto(optionalLecturer.get());
    }
}
