package com.udea.arquisoft.service;

import com.udea.arquisoft.dao.IPedidoDAO;
import com.udea.arquisoft.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private IPedidoDAO dao;

    public Pedido save(Pedido pedido){ return dao.save(pedido);}
    public Pedido update(Pedido pedido){ return dao.save(pedido);}
    public void delete(Pedido pedido) { dao.delete(pedido);}
    public Iterable<Pedido> list() { return dao.findAll();}
    public Optional<Pedido> listId(int id) { return dao.findById(id);}
}
