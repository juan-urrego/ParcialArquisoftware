package com.udea.arquisoft.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "cliente")
@ApiModel(description = "Todos los detalles del cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "La BD genera un ID autoincrementable para la base de datos")
    @Column(name = "cliente_id")
    private int id;

    @ApiModelProperty(notes = "Identificacion unico del cliente")
    @Column(name = "cliente_identificacion", nullable = false, unique = true)
    private String identificacion;

    @ApiModelProperty(notes = "Nombres y apellidos del cliente")
    @Column(name = "cliente_nombre", nullable = false)
    private String nombre;

    @ApiModelProperty(notes = "Telefono celular del cliente")
    @Column(name = "cliente_telefono", nullable = false)
    private String telefono;

    @ApiModelProperty(notes = "Email del cliente")
    @Column(name = "cliente_email", nullable = false, unique = true)
    private String email;

    public Cliente(String identificacion, String nombre, String telefono, String email) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }
}
