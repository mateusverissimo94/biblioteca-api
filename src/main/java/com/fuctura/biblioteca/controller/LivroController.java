package com.fuctura.biblioteca.controller;

import com.fuctura.biblioteca.dtos.LivroDTO;
import com.fuctura.biblioteca.model.Livro;
import com.fuctura.biblioteca.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> findById(@PathVariable Integer id){
        Livro livro = livroService.findById(id);

        return ResponseEntity.ok().body(new LivroDTO(livro));
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id){
        List<Livro> livros = livroService.findAll(id);

        return ResponseEntity.ok().body(livros.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList()));
        //localhost:8080/livro?categoria=2
    }


}
