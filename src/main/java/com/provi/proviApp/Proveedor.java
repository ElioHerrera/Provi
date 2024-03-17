package com.provi.proviApp;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String password;
    private String empresa;
    private String rubro;
    private String direccion;
    private String numeroContacto;

    @ManyToMany
    @JoinTable(
            name = "proveedor_cliente",
            joinColumns = @JoinColumn(name = "proveedor_id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    private List<Cliente> clientes = new ArrayList<>();

    // Constructor vacío (necesario para Hibernate)
    public Proveedor() {}

    // Constructor con parámetros
    public Proveedor(String nombre, String email, String password, String empresa, String rubro, String direccion, String numeroContacto) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.empresa = empresa;
        this.rubro = rubro;
        this.direccion = direccion;
        this.numeroContacto = numeroContacto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
