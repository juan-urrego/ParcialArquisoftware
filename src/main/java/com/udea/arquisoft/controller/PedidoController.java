package com.udea.arquisoft.controller;


import com.udea.arquisoft.exception.ModelNotFoundException;
import com.udea.arquisoft.model.Pedido;
import com.udea.arquisoft.service.PedidoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/pedido")
@CrossOrigin("*")
@Api(value = "Sistema de gestion de pedido", description = "Operaciones para gestionar los pedidos")
public class PedidoController {
    
    @Autowired
    PedidoService pedidoService;

    @ApiOperation(value = "agregar pedido")
    @PostMapping("/save")
    public ResponseEntity<?> save(@ApiParam(value = "Objeto pedido que se almacena en la base de datos", required = true)
                     @RequestBody Pedido pedido) {
        Pedido pedidoGuardado = pedidoService.save(pedido);
        return new ResponseEntity<>(pedidoGuardado, HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of available pedidos", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/listAll")
    public ResponseEntity<?> listAllPedidos(){ return new ResponseEntity<>(pedidoService.list(), HttpStatus.OK);}

    @ApiOperation(value = "Get a pedido by id")
    @GetMapping("/list/{id}")
    public ResponseEntity<?> listPedidoById(@ApiParam(value = "identificacion requerida para recuperar pedido asociada a esta id", required = true)
                                                @PathVariable("id") int id) {
        Optional<Pedido> pedido = pedidoService.listId(id);
        if (pedido.isPresent()) {
            return new ResponseEntity<>(pedido.get(), HttpStatus.OK);
        }

        throw new ModelNotFoundException("Id de pedido es inválida");
    }
}
