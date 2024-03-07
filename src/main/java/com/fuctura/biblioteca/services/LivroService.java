package com.fuctura.biblioteca.services;

import com.fuctura.biblioteca.dtos.LivroDTO;
import com.fuctura.biblioteca.exceptions.ObejectNotFoundException;
import com.fuctura.biblioteca.model.Categoria;
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

    public List<Livro> findAllLivroByCategoriaName(String nome){
        categoriaService.BuscarPorNome(nome);
        return livroRepository.findByCategoriaNomeContainingIgnoreCase(nome);
    }

    public Livro save(Integer id_cat, LivroDTO livroDTO) {
        livroDTO.setId(null);
        Categoria cat = categoriaService.findById(id_cat);
        livroDTO.setCategoria(cat);

        return livroRepository.save(new Livro(livroDTO));
    }

    public Livro upDate(Integer id, LivroDTO livroDTO){
        Livro livro = findById(id);
        livroDTO.setId(id);
        upDateDados(livro, livroDTO);
        return livroRepository.save(livro);
    }

    public void delete(Integer id){
        findById(id);
        livroRepository.deleteById(id);
    }

    private void upDateDados(Livro livro, LivroDTO livroDTO){
        livro.setid(livroDTO.getId());
        livro.setTitulo(livroDTO.getTitulo());
        livro.setNomeAutor(livroDTO.getNomeAutor());
        livro.setTexto(livroDTO.getTexto());
        livro.setTamanho(livroDTO.getTamanho());
        livro.setCategoria(livroDTO.getCategoria());
    }

}
