package com.recursohumano.recursohumano.repository;

import java.util.List;
import java.util.Optional;

import com.recursohumano.recursohumano.model.Departamento;
import com.recursohumano.recursohumano.repository.crud.DepartamentoCrudRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartamentoRepositorio {

    @Autowired
    private DepartamentoCrudRepositorio departamentoCrudRepositorio;

    public List <Departamento> getAll(){
        return (List<Departamento>)departamentoCrudRepositorio.findAll();
    }
    
    public Optional <Departamento> getDepartamento(int id) {
        return departamentoCrudRepositorio.findById(id);
    }
    
    public Departamento save(Departamento dpto){
        return departamentoCrudRepositorio.save(dpto);
    }

}
