package com.udea.arquisoft.service;

import com.udea.arquisoft.dao.IClienteDAO;
import com.udea.arquisoft.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private IClienteDAO dao;

    public Cliente save(Cliente cliente){ return dao.save(cliente);}
    public Cliente update(Cliente cliente){ return dao.save(cliente);}
    public void delete(Cliente cliente) { dao.delete(cliente);}
    public Iterable<Cliente> list() { return dao.findAll();}
    public Optional<Cliente> listId(int id) { return dao.findById(id);}
}
