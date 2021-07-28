package com.example.demo.services;

import com.example.demo.models.Sube;
import com.example.demo.repositories.SubeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubeService {
    private final SubeRepository subeRepository;

    public SubeService(SubeRepository subeRepository) {
        this.subeRepository = subeRepository;
    }

    public List<Sube> findAll() {
        return subeRepository.findAll();
    }

    public Sube findById(Long id) {
        return subeRepository.getById(id);
    }

    public Sube create(Sube sube) {
        return subeRepository.save(sube);
    }

    public Sube update(Sube sube) {
        Sube update = subeRepository.getById((long) sube.getId());
        if (update != null) {
            subeRepository.save(sube);
            return update;
        }
        return sube;

    }

    public void deleteById(Long id) {
        subeRepository.deleteById(id);
    }
}
