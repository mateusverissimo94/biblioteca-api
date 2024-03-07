package com.fuctura.biblioteca.controller;

import com.fuctura.biblioteca.dtos.LivroDTO;
import com.fuctura.biblioteca.model.Livro;
import com.fuctura.biblioteca.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin("*")
@RestController
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> findById(@PathVariable Integer id){
        Livro livro = livroService.findById(id);

        return ResponseEntity.ok().body(new LivroDTO(livro));
        //localhost:8080/livro/{id}
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id){
        List<Livro> livros = livroService.findAll(id);

        return ResponseEntity.ok().body(livros.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList()));
        //localhost:8080/livro?categoria=2
    }

    @GetMapping("categoria/{nome}")
    public ResponseEntity<List<LivroDTO>> findAllByName(@PathVariable String nome){
        List<Livro> livros = livroService.findAllLivroByCategoriaName(nome);

        return ResponseEntity.ok().body(livros.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList()));
        //localhost:8080/livro/categoria/{nome}
    }

    @PostMapping
    public ResponseEntity<LivroDTO> save(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat, @Valid @RequestBody LivroDTO livroDTO){
        Livro livro = livroService.save(id_cat, livroDTO);
        return ResponseEntity.ok().body(new LivroDTO(livro));
        //localhost:8080/livro?categoria={id}
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDTO> upDate(@PathVariable Integer id, @RequestBody LivroDTO livroDTO){
        Livro livro = livroService.upDate(id, livroDTO);
        return ResponseEntity.ok().body(new LivroDTO(livro));
        //localhost:8080/livro/{id}
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        livroService.delete(id);
        return ResponseEntity.noContent().build();
        //localhost:8080/livro/{id}
    }
}
