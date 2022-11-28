package com.example.cykelrytter.controllers;

import com.example.cykelrytter.services.ITeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
    private ITeamService teamService;

    public TeamController(ITeamService teamService){
    this.teamService = teamService;
    }

    @PostMapping("/createTeam")
    public ResponseEntity<String> createTeam(){
        return null;
    }
}
