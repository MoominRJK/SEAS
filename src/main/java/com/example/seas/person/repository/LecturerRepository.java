package com.example.seas.person.repository;

import com.example.seas.person.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LecturerRepository  extends JpaRepository<Lecturer, Integer> {
    Optional<Lecturer> findByUsername(String username);

    Optional<Lecturer> findByPhone(String phone);

    Optional<Lecturer> findByEmail(String email);
}
