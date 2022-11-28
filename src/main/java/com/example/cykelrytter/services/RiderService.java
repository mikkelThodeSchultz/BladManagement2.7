package com.example.cykelrytter.services;

import com.example.cykelrytter.model.Rider;
import com.example.cykelrytter.repositories.RiderRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RiderService implements IRiderService{

    private RiderRepository riderRepository;

    public RiderService (RiderRepository riderRepository){
        this.riderRepository = riderRepository;
    }

    @Override
    public Set<Rider> findAll() {
        Set<Rider> set = new HashSet<>(riderRepository.findAll());
        return set;
    }

    @Override
    public Rider save(Rider object) {
        return riderRepository.save(object);
    }

    @Override
    public void delete(Rider object) {
        riderRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        riderRepository.deleteById(aLong);
    }

    @Override
    public Optional<Rider> findById(Long aLong) {
        return riderRepository.findById(aLong);
    }
}
