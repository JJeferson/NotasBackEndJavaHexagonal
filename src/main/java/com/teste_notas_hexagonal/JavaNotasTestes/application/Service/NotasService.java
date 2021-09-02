package com.teste_notas_hexagonal.JavaNotasTestes.application.Service;


import com.teste_notas_hexagonal.JavaNotasTestes.application.in.NotasUseCase;
import com.teste_notas_hexagonal.JavaNotasTestes.application.out.NotasPortOut;
import com.teste_notas_hexagonal.JavaNotasTestes.domain.Notas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotasService implements NotasUseCase {

    @Autowired
    NotasPortOut notasPortOut;

    @Override
    public Notas SaveNotas(Notas notas) {
        return notasPortOut.SaveNotas(notas);
    }

    @Override
    public List<Notas> getNotas() {
        return notasPortOut.getNotas();
    }

    @Override
    public List<Notas> getNotasPorCnpjEmissor(String cnpj) {
        return notasPortOut.getNotasPorCnpjEmissor(cnpj);
    }

    @Override
    public Notas getNotasPorId(String id) {
        return notasPortOut.getNotasPorId(id);
    }

}
