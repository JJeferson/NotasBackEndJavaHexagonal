package com.teste_notas_hexagonal.JavaNotasTestes.framework.adapters.in.rest;


import com.teste_notas_hexagonal.JavaNotasTestes.application.in.NotasUseCase;
import com.teste_notas_hexagonal.JavaNotasTestes.domain.Notas;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/notas")

public class NotasRest {

    @Autowired
    NotasUseCase notasUseCase;

    @ApiOperation(value="Grava nova nota")
    @ApiResponses(value={
            @ApiResponse(code=200,message="ok"),
            @ApiResponse(code=500,message="Internal Server Error")
    })
    @Transactional
    @CacheEvict(value = "/nova_nota", allEntries = true)
    @PostMapping("/nova_nota")
    public ResponseEntity<Notas> novaNota(@RequestBody Notas nota)
    {
        Notas notaSalva = notasUseCase.SaveNotas(nota);
        return ResponseEntity.ok(notaSalva);
    }


    @ApiOperation(value="Localiza uma nota")
    @ApiResponses(value={
            @ApiResponse(code=200,message="ok"),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="Not Found")
    })
    @RequestMapping(value = "/findbyid", method = RequestMethod.GET)
    public ResponseEntity<Notas> findbyid
            (@RequestParam(value = "id", required=false, defaultValue = "0") String id)
    {
        if(id.equals("0")){
            Notas notaException = new Notas();
            notaException.setCnjpCliente("ERRO: um id precisa ser informado");
            return ResponseEntity.status(412).body(notaException);
        }else{
        Notas notas = notasUseCase.getNotasPorId(id);
        return ResponseEntity.ok(notas);
        }
    }


    @ApiOperation(value="Localiza notas desse cliente pelo cnpj")
    @ApiResponses(value={
            @ApiResponse(code=200,message="ok"),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="Not Found")
    })
    @RequestMapping(value = "/lista_notas_nosso_cliente", method = RequestMethod.GET)
    public ResponseEntity<List<Notas>> listaNotasNossoCliente
            (@RequestParam(value = "cnpj", required=false, defaultValue = "0") String cnpj)
    {
        if(cnpj.equals("0")){
            Notas notaException = new Notas();
            notaException.setCnjpCliente("ERRO: Para usar este endpoint precisa informar um cnpj de nosso cliente Valido");
            List<Notas> listNotas = new ArrayList<>();
            listNotas.add(notaException);
            return ResponseEntity.status(412).body(listNotas);
        }
        List<Notas> listNotas = notasUseCase.getNotasPorCnpjEmissor(cnpj);
        if(listNotas.size()==0){
            Notas notaException = new Notas();
            notaException.setCnjpCliente("ERRO: Nenhum registro encontrado, verifique se o cnpj certo");
            listNotas.add(notaException);
            return ResponseEntity.status(404).body(listNotas);
        }
        return ResponseEntity.ok(listNotas);
    }

    @ApiOperation(value="Localiza todas as notas")
    @ApiResponses(value={
            @ApiResponse(code=200,message="ok"),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="Not Found")
    })
    @RequestMapping(value = "/todas_em_lista", method = RequestMethod.GET)
    public ResponseEntity<List<Notas>> todasEmLista()
    {
        List<Notas> listNotas = notasUseCase.getNotas();
        return ResponseEntity.ok(listNotas);
    }

}
