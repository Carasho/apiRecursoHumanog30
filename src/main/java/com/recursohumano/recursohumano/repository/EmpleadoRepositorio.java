package com.recursohumano.recursohumano.repository;

import java.util.List;
import java.util.Optional;

import com.recursohumano.recursohumano.model.Empleado;
import com.recursohumano.recursohumano.repository.crud.EmpleadoCrudRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpleadoRepositorio {
    @Autowired
    private EmpleadoCrudRepositorio empleadoCrudRepositorio;

    public List<Empleado>getAll(){
        return (List<Empleado>)empleadoCrudRepositorio.findAll();
    }

    public Optional<Empleado>getEmpleado(int id){
        return empleadoCrudRepositorio.findById(id);
    }
    
    public Empleado save (Empleado empleado){
        return empleadoCrudRepositorio.save(empleado);    
    }

    
}
