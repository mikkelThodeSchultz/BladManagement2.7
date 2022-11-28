package com.example.cykelrytter.controllers;

import com.example.cykelrytter.model.Rider;
import com.example.cykelrytter.model.Team;
import com.example.cykelrytter.services.IRiderService;
import com.example.cykelrytter.services.ITeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
public class RiderController {

    private IRiderService riderService;
    private ITeamService teamService;

    public RiderController(IRiderService riderService, ITeamService teamService) {
        this.riderService = riderService;
        this.teamService = teamService;
    }

    @PostMapping("/createRider")
    public ResponseEntity<String> createRider(@RequestBody Rider rider) {
        if (riderService.save(rider) != null) {
            return new ResponseEntity<>("Super, du har gemt " + rider.getRiderName(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Noget gik galt, du har ikke gemt " + rider.getRiderName(), HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/editRider")
    public ResponseEntity<String> editRider(@RequestParam Long id, @RequestBody Rider rider) {
        Rider riderToSave = null;
        if (riderService.findById(id).isPresent()) {
            riderToSave = riderService.findById(id).get();
            System.out.println(riderToSave);
            if (rider.getRiderName() != null) {
                riderToSave.setRiderName(rider.getRiderName());
            }
            if (rider.getAge() != 0) {
                riderToSave.setAge(rider.getAge());
            }
            riderService.save(riderToSave);
            return new ResponseEntity<>("helt sikkert", HttpStatus.OK);
        }
        return new ResponseEntity<>("noget gik galt", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/deleteRider")
    public ResponseEntity<String> deleteRider(@RequestParam Long riderId) {
        riderService.deleteById(riderId);
        return new ResponseEntity<>("Smukt, nr: " + riderId + "  er blevet slettet", HttpStatus.OK);
    }

    @GetMapping("/getRiders")
    public ResponseEntity<Set<Rider>> getRiders(){
        return new ResponseEntity<>(riderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getRidersFromTeam")
    public ResponseEntity<Set<Rider>> getRidersFromTeam(@RequestParam Team team){
        Team teamWithRiders = null;
    if (teamService.findById(team.getId()).isPresent()){
        teamWithRiders = teamService.findById(team.getId()).get();
        return new ResponseEntity<>(teamWithRiders.getRiders(), HttpStatus.OK);
    }   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
