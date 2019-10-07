package com.javagda25.spring_library.service;

import com.javagda25.spring_library.model.Client;
import com.javagda25.spring_library.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public void remove(Long id) {
        clientRepository.deleteById(id);
    }

    public Optional<Client> getById(Long id) {
        return clientRepository.findById(id);
    }
}
