package com.fuctura.biblioteca.services;

import com.fuctura.biblioteca.dtos.CategoriaDTO;
import com.fuctura.biblioteca.exceptions.IllegalArgumentException;
import com.fuctura.biblioteca.exceptions.ObejectNotFoundException;
import com.fuctura.biblioteca.model.Categoria;
import com.fuctura.biblioteca.repositories.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        if (obj.isPresent()){
            return obj.get();
        }

        throw new ObejectNotFoundException("Categoria não encontrada!");
//        return obj.orElseThrow(() -> new ObejectNotFoundException("Categoria não encontrada!"));
//        return obj.orElse(null);
    }

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria save(CategoriaDTO objDTO) {
        buscarPorNome(objDTO);
        objDTO.setid(null);
        return categoriaRepository.save(modelMapper.map(objDTO, Categoria.class));
    }

    public void buscarPorNome(CategoriaDTO categoriaDTO){
        Optional<Categoria> cat = categoriaRepository.findByNome(categoriaDTO.getNome());
        if (cat.isPresent() && cat.get().getNome().equals(categoriaDTO.getNome())){
            throw new IllegalArgumentException("Já existe uma categoria com esse nome " + categoriaDTO.getNome());
        }
    }
}
