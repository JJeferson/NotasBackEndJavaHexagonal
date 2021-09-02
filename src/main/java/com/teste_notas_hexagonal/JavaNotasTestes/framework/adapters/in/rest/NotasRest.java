package com.teste_notas_hexagonal.JavaNotasTestes.framework.adapters.in.rest;


import com.teste_notas_hexagonal.JavaNotasTestes.application.in.NotasUseCase;
import com.teste_notas_hexagonal.JavaNotasTestes.domain.Notas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/notas")

public class NotasRest {

    @Autowired
    NotasUseCase notasUseCase;

    @Transactional
    @CacheEvict(value = "/nova_nota", allEntries = true)
    @PostMapping("/nova_nota")
    public ResponseEntity<Notas> novaNota(@RequestBody Notas nota)
    {
        Notas notaSalva = notasUseCase.SaveNotas(nota);
        return ResponseEntity.ok(notaSalva);
    }

    @RequestMapping(value = "/todas_em_lista", method = RequestMethod.GET)
    public ResponseEntity<List<Notas>> todasEmLista()
    {
        List<Notas> listNotas = notasUseCase.getNotas();
        return ResponseEntity.ok(listNotas);
    }

}
