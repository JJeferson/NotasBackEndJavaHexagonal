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
public class TestGetNotasPorCnpjEmissor {

    @Mock
    NotasPersistence notasPersistence;


    @Test
    public void Caso01() throws Exception{

        List<Notas> listNotas = preparaListaComDoisRegistros();
        Mockito.when(notasPersistence.getNotasPorCnpjEmissor("123")).thenReturn(listNotas);
        List<Notas> listTeste = notasPersistence.getNotasPorCnpjEmissor("123");
        assertTrue(listTeste.size()==2);
    }

    private List<Notas> preparaListaComDoisRegistros(){
        Notas registro1 = new Notas();
        Notas registro2 = new Notas();

        registro1.setCnjpCliente("11");
        registro2.setCnjpCliente("11");
        List<Notas> listNotas = new ArrayList<>();
        listNotas.add(registro1);
        listNotas.add(registro2);
        return listNotas;
    }
}
