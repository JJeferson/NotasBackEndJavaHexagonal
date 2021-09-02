package com.teste_notas_hexagonal.JavaNotasTestes.Adapters.out;

import com.teste_notas_hexagonal.JavaNotasTestes.domain.Notas;
import com.teste_notas_hexagonal.JavaNotasTestes.framework.adapters.out.NotasPersistence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


@ExtendWith(MockitoExtension.class)
public class TestGetNotasPorId {
    @Mock
    NotasPersistence notasPersistence;

    @Test
    public void Caso01() throws Exception{

        Notas Objeto = preparaObjeto();
        Mockito.when(notasPersistence.getNotasPorId("1")).thenReturn(Objeto);
        Notas Teste = notasPersistence.getNotasPorId("1");
        assertTrue(Teste.getCnjpCliente() != null);
    }

    private Notas preparaObjeto(){
        Notas registro1 = new Notas();
        registro1.setCnjpCliente("11");
        return registro1;
    }
}
