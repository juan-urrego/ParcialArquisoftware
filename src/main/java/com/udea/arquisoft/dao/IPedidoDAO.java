package com.udea.arquisoft.dao;

import com.udea.arquisoft.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoDAO extends CrudRepository<Pedido, Integer> {
}
