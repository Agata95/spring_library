package com.javagda25.spring_library.service;

import com.javagda25.spring_library.model.PublishingHouse;
import com.javagda25.spring_library.repository.PublishingHouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PublishingHouseService {
    private final PublishingHouseRepository publishingHouseRepository;


    public List<PublishingHouse> getAll() {
        return publishingHouseRepository.findAll();
    }

    public void save(PublishingHouse publishingHouse) {
        publishingHouseRepository.save(publishingHouse);
    }

    public Optional<PublishingHouse> getById(Long id) {
        return publishingHouseRepository.findById(id);
    }

    public void remove(Long id) {
        publishingHouseRepository.deleteById(id);
    }
}
