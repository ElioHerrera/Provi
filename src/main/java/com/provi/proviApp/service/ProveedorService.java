package com.provi.proviApp.service;

import com.provi.proviApp.Cliente;
import com.provi.proviApp.Proveedor;
import com.provi.proviApp.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProveedorService {
    private final ProveedorRepository proveedorRepository;

    @Autowired
    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public List<Proveedor> obtenerTodosLosProveedores() {
        return proveedorRepository.findAll();
    }

    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Proveedor obtenerProveedorPorId(Long id) {
        return proveedorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Proveedor no encontrado con ID: " + id));
    }

    public Proveedor obtenerProveedorPorEmailYPassword(String email, String password) {
        return proveedorRepository.findByEmailAndPassword(email, password);
    }

    public void eliminarProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }
}