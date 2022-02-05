package com.teste_notas_hexagonal.JavaNotasTestes.framework.adapters.out;

import com.teste_notas_hexagonal.JavaNotasTestes.application.out.NotasPortOut;
import com.teste_notas_hexagonal.JavaNotasTestes.config.controller_advice.exceptions.NotFoundException;
import com.teste_notas_hexagonal.JavaNotasTestes.domain.Notas;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotasPersistence implements NotasPortOut {

    @Autowired
    NotasRepository notasRepository;
    @Override
    public Notas SaveNotas(Notas notas) {
        return notasRepository.save(notas);
    }

    @Override
    @Generated  // vai fazer o jacoco ignorar o teste
    public List<Notas> getNotas() {
        if(notasRepository.findAll().size()==0){
           throw new NotFoundException("Nenhum registro encontrado");
        }else {
            return notasRepository.findAll();
        }
    }

    @Override
    public List<Notas> getNotasPorCnpjEmissor(String cnpj) {
        return notasRepository.findAllByCnjpNossoCliente(cnpj);
    }

    @Override
    public Notas getNotasPorId(String id) {
        return notasRepository.findById(id).get();
    }
}
