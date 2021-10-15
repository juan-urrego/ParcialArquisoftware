package com.udea.arquisoft.controller;

import com.udea.arquisoft.exception.ModelNotFoundException;
import com.udea.arquisoft.model.Cliente;
import com.udea.arquisoft.service.ClienteService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/cliente")
@CrossOrigin("*")
@Api(value = "Sistema de gestion de clientes", description = "Operaciones para gestionar el cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @ApiOperation(value = "agregar cliente")
    @PostMapping("/save")
    public ResponseEntity<?> save(@ApiParam(value = "Objeto cliente que se almacena en la base de datos", required = true)
                     @RequestBody Cliente cliente) {
        Cliente clienteGuardado = clienteService.save(cliente);
        return new ResponseEntity<>(clienteGuardado, HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of available clientes", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/listAll")
    public ResponseEntity<?> listAllClientes(){ return new ResponseEntity<>(clienteService.list(), HttpStatus.OK);}

    @ApiOperation(value = "Get a cliente by id")
    @GetMapping("/list/{id}")
    public ResponseEntity<?> listClienteById(@ApiParam(value = "identificacion requerida para recuperar cliente asociada a esta id", required = true)
                                        @PathVariable("id") int id) {
        Optional<Cliente> cliente = clienteService.listId(id);
        if (cliente.isPresent()) {
            return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
        }

        throw new ModelNotFoundException("Id de cliente es inválida");
    }
}
