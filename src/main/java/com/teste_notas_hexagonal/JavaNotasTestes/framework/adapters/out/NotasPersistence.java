package com.teste_notas_hexagonal.JavaNotasTestes.framework.adapters.out;

import com.teste_notas_hexagonal.JavaNotasTestes.application.out.NotasPortOut;
import com.teste_notas_hexagonal.JavaNotasTestes.domain.Notas;
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
    public List<Notas> getNotas() {
        return notasRepository.findAll();
    }
}
