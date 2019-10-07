package com.javagda25.spring_library.repository;

import com.javagda25.spring_library.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
