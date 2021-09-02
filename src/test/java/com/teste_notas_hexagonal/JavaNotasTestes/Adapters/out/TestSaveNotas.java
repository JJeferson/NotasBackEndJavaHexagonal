package com.teste_notas_hexagonal.JavaNotasTestes.Adapters.out;

import com.teste_notas_hexagonal.JavaNotasTestes.domain.Notas;
import com.teste_notas_hexagonal.JavaNotasTestes.framework.adapters.out.NotasPersistence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertTrue;

@ExtendWith(MockitoExtension.class)
public class TestSaveNotas {

    @Mock
    NotasPersistence notasPersistence;

    @Test
    public void Caso01() throws Exception{

        Notas Objeto = preparaObjeto();
        Mockito.when(notasPersistence.SaveNotas(Objeto)).thenReturn(Objeto);
        Notas Teste = notasPersistence.SaveNotas(Objeto);
        assertTrue(Teste.equals(Objeto));
    }

    private Notas preparaObjeto(){
        Notas registro1 = new Notas();
        registro1.setCnjpCliente("11");
        return registro1;
    }

}
