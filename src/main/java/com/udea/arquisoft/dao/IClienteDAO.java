package com.udea.arquisoft.dao;

import com.udea.arquisoft.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteDAO extends CrudRepository<Cliente, Integer> {
}
