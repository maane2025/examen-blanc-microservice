package com.example.keynoteservice.repository;

import com.example.keynoteservice.entity.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeynoteRepository extends JpaRepository<Keynote, Long> {
}