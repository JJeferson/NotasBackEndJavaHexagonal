package com.teste_notas_hexagonal.JavaNotasTestes.framework.adapters.out;

import com.teste_notas_hexagonal.JavaNotasTestes.domain.Notas;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface NotasRepository extends MongoRepository<Notas,String> {
    List<Notas> findAllByCnjpNossoCliente(String cnpj);
    Optional<Notas> findById(String id);
}
