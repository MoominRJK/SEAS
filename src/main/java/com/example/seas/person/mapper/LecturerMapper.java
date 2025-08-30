package com.example.seas.person.mapper;

import com.example.seas.person.dto.LecturerDTO;
import com.example.seas.person.entity.Lecturer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LecturerMapper {

    LecturerDTO mapToDto(Lecturer lecturer);

    Lecturer mapToEntity(LecturerDTO lecturerDTO);

    List<LecturerDTO> mapToDto(List<Lecturer> lecturerList);

    List<Lecturer> mapToEntity(List<LecturerDTO> lecturerDTOList);


}
