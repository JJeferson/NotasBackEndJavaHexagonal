package com.teste_notas_hexagonal.JavaNotasTestes.application.in;

import com.teste_notas_hexagonal.JavaNotasTestes.domain.Notas;

import java.util.List;

public interface NotasUseCase {
    Notas SaveNotas (Notas notas);
    List<Notas> getNotas();
    List<Notas> getNotasPorCnpjEmissor(String cnpj);
    Notas getNotasPorId(String id);

}
