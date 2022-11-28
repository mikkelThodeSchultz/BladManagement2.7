package com.example.cykelrytter.repositories;

import com.example.cykelrytter.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
