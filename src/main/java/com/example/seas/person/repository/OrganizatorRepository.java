package com.example.seas.person.repository;

import com.example.seas.person.entity.Organizator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizatorRepository extends JpaRepository<Organizator, Integer> {

    Optional<Organizator> findByUsername(String organizatorUsername);
}
