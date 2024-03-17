package com.provi.proviApp.Controller;

import com.provi.proviApp.Cliente;
import com.provi.proviApp.Proveedor;
import com.provi.proviApp.service.ClienteService;
import com.provi.proviApp.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/registro")
public class RegistroController {

    private final ClienteService clienteService;
    private final ProveedorService proveedorService;

    @Autowired
    public RegistroController(ClienteService clienteService, ProveedorService proveedorService) {
        this.clienteService = clienteService;
        this.proveedorService = proveedorService;
    }

    @GetMapping
    public String mostrarFormularioRegistro() {
        return "public/registro"; // Devuelve la vista del formulario de registro
    }

    @PostMapping("/registrarUsuario")
    public String registrarUsuario(@RequestParam("tipoUsuario") String tipoUsuario,
                                   @RequestParam("email") String email,
                                   @RequestParam("password") String password,
                                   @RequestParam("nombre") String nombre,
                                   @RequestParam("empresa") String empresa,
                                   @RequestParam("rubro") String rubro,
                                   @RequestParam("direccion") String direccion,
                                   @RequestParam("numeroContacto") String numeroContacto,
                                   Model model) {

        if ("cliente".equals(tipoUsuario)) {
            Cliente cliente = new Cliente();
            cliente.setEmail(email);
            cliente.setPassword(password);
            cliente.setNombre(nombre);
            cliente.setEmpresa(empresa);
            cliente.setRubro(rubro);
            cliente.setDireccion(direccion);
            cliente.setNumeroContacto(numeroContacto);
            clienteService.guardarCliente(cliente);
        } else if ("proveedor".equals(tipoUsuario)) {
            Proveedor proveedor = new Proveedor();
            proveedor.setEmail(email);
            proveedor.setPassword(password);
            proveedor.setNombre(nombre);
            proveedor.setEmpresa(empresa);
            proveedor.setRubro(rubro);
            proveedor.setDireccion(direccion);
            proveedor.setNumeroContacto(numeroContacto);
            proveedorService.guardarProveedor(proveedor);
        }

        model.addAttribute("registroExitoso", true); // Agregar atributo de registro exitoso al modelo
        return "index"; // Devolver la vista index.html
    }
}