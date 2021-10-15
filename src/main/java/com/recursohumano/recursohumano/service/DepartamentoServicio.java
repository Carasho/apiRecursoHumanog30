package com.recursohumano.recursohumano.service;

import java.util.List;
import java.util.Optional;

import com.recursohumano.recursohumano.model.Departamento;
import com.recursohumano.recursohumano.repository.DepartamentoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartamentoServicio {
    @Autowired
    private DepartamentoRepositorio departamentoRepositorio;

    public List<Departamento>getAll(){
        return departamentoRepositorio.getAll();
    }
    
    public Optional <Departamento>getDepartamento(int id){
        return departamentoRepositorio.getDepartamento(id);
    }

    public Departamento save(Departamento dpto){
    // verificamos si el departamento es nuevo y de ser asi guarda
        if (dpto.getNumId()== null){
            return departamentoRepositorio.save(dpto);
        } else{ // si el objeto viene con numId se verifica si existe o no
            Optional <Departamento> consulta = departamentoRepositorio.getDepartamento(dpto.getNumId());
            if (consulta.isEmpty()) {
                return departamentoRepositorio.save(dpto);
            } else {
                return dpto;
            } 
        }
     
    }
}
