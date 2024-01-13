package com.fuctura.biblioteca.controller;

import com.fuctura.biblioteca.dtos.CategoriaDTO;
import com.fuctura.biblioteca.model.Categoria;
import com.fuctura.biblioteca.services.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Integer id){
        Categoria cat = categoriaService.findById(id);

        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<Categoria> list = categoriaService.findAll();
        return ResponseEntity.ok().body(list.stream().map(obj -> modelMapper.map(obj, CategoriaDTO.class)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> save(@Valid @RequestBody CategoriaDTO categoriaDTO) {
        Categoria cat = categoriaService.save(categoriaDTO);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id,@Valid @RequestBody CategoriaDTO categoriaDTO){
        categoriaDTO.setid(id);
        Categoria cat = categoriaService.update(categoriaDTO);

        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDTO.class));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
//@GetMapping - buscar todos
//@PostMapping(obj) - inserir no banco
//@PutMapping(obj) - atualizar no banco
//@DeleteMapping(id) - deletar obj
//@GetMapping("/{id}") //buscar por id