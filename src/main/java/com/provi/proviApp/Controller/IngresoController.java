package com.provi.proviApp.Controller;


import com.provi.proviApp.Cliente;
import com.provi.proviApp.Proveedor;
import com.provi.proviApp.service.ClienteService;
import com.provi.proviApp.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IngresoController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/")
    public String mostrarPaginaInicio() {
        return "index";
    }

    @GetMapping("/inicio")
    public String mostrarFormularioIngreso(Model model) {
        model.addAttribute("errorInicioSesion", false);
        model.addAttribute("registroExitoso", false);
        return "index"; // Devuelve la vista de inicio de sesión
    }

    @PostMapping("/inicio")
    public String autenticarUsuario(@RequestParam String email, @RequestParam String password, Model model) {
        Cliente cliente = clienteService.obtenerClientePorEmailYPassword(email, password);
        if (cliente != null) {
            // Aquí podrías guardar información adicional del cliente en el modelo si lo deseas
            model.addAttribute("cliente", cliente);
            return "cliente/inicio"; // Si el cliente se autentica con éxito, muestra el mensaje de registro exitoso
        }

        Proveedor proveedor = proveedorService.obtenerProveedorPorEmailYPassword(email, password);
        if (proveedor != null) {
            // Aquí podrías guardar información adicional del proveedor en el modelo si lo deseas
            model.addAttribute("proveedor", proveedor);
            return "proveedor/inicio"; // Si el proveedor se autentica con éxito, muestra el mensaje de registro exitoso
        }

        model.addAttribute("errorInicioSesion", true);
        return "index"; // Si la autenticación falla, muestra el mensaje de error
    }
}