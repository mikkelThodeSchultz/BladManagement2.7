package com.example.cykelrytter.services;

import com.example.cykelrytter.model.Team;
import com.example.cykelrytter.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TeamService implements ITeamService{

    private TeamRepository teamRepository;

    public TeamService (TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    @Override
    public Set<Team> findAll() {
        return new HashSet<>(teamRepository.findAll());
    }

    @Override
    public Team save(Team object) {
        return teamRepository.save(object);
    }

    @Override
    public void delete(Team object) {
        teamRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        teamRepository.deleteById(aLong);
    }

    @Override
    public Optional<Team> findById(Long aLong) {
        return teamRepository.findById(aLong);
    }
}
