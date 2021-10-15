package com.udea.arquisoft.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter

@NoArgsConstructor

@Entity
@Table(name = "pedido")
@ApiModel(description = "Todos los detalles del pedido")
public class Pedido {

    @Id
    @Column(name = "pedido_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "La BD genera un ID autoincrementable para la base de datos")
    private int id;

    @Column(name = "pedido_status", nullable = false)
    @ApiModelProperty(notes = "Estado en el que se encuentra el pedido")
    private String status;

    @Column(name = "pedido_direccionEntrega", nullable = false)
    @ApiModelProperty(notes = "Direccion final en la que se debe entregar el pedido")
    private String direccionEntrega;

    @Column(name = "pedido_horaEntrega", nullable = false)
    @ApiModelProperty(notes = "Hora de entrega del pedido")
    private String horaEntrega;

    @OneToOne(orphanRemoval = true)
    @ApiModelProperty(notes = "Objeto cliente, con toda su información")
    @JoinColumn(name = "cliente_cliente_id")
    private Cliente cliente;

    public Pedido(String status, String direccionEntrega, String horaEntrega, Cliente cliente) {
        this.status = status;
        this.direccionEntrega = direccionEntrega;
        this.horaEntrega = horaEntrega;
        this.cliente = cliente;
    }
}
