package com.teste_notas_hexagonal.JavaNotasTestes.application.out;

import com.teste_notas_hexagonal.JavaNotasTestes.domain.Notas;

import java.util.List;

public interface NotasPortOut {
    Notas SaveNotas (Notas notas);
    List<Notas> getNotas();
    List<Notas> getNotasPorCnpjEmissor(String cnpj);
    List<Notas> getNotasPorId(String id);
}
