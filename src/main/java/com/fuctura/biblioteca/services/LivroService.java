package com.fuctura.biblioteca.services;

import com.fuctura.biblioteca.exceptions.ObejectNotFoundException;
import com.fuctura.biblioteca.model.Livro;
import com.fuctura.biblioteca.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id){
        Optional<Livro> obj = livroRepository.findById(id);
        if (obj.isPresent()){
            return obj.get();
        }

        throw new ObejectNotFoundException("Livro não encontrada!");
    }

    public List<Livro> findAll(Integer id_cat){
        categoriaService.findById(id_cat);
        return livroRepository.findAllByCategoria(id_cat);
    }
}
