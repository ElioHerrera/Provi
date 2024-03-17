package com.provi.proviApp.service;
import com.provi.proviApp.Cliente;
import com.provi.proviApp.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }


    public Cliente obtenerClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + id));
    }

    public Cliente obtenerClientePorEmailYPassword(String email, String password) {
        return clienteRepository.findByEmailAndPassword(email, password);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}