package com.provi.proviApp.repository;

import com.provi.proviApp.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    Proveedor findByEmailAndPassword(String email, String password);
}