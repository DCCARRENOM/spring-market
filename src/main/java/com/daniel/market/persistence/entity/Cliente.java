package com.daniel.market.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    private String id;

    private String nombre;

    private String apellidos;

    private Long celular;

    private String direccion;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;

    @Column(name="correo_electronico")
    private String correoElectronico;
}
