package com.provi.proviApp.repository;

import com.provi.proviApp.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByEmailAndPassword(String email, String password);
}