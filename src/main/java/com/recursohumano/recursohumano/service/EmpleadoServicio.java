package com.recursohumano.recursohumano.service;

import java.util.List;
import java.util.Optional;

import com.recursohumano.recursohumano.model.Empleado;
import com.recursohumano.recursohumano.repository.EmpleadoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServicio {
    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    public List<Empleado>getAll(){
        return empleadoRepositorio.getAll();
    }
    
    public Optional <Empleado>getEmpleado(int id){
        return empleadoRepositorio.getEmpleado(id);
    }

    public Empleado save(Empleado empleado){
        if (empleado.getNumId()== null){
            return empleadoRepositorio.save(empleado);
        } else{ // si el objeto viene con numId se verifica si existe o no
            Optional <Empleado> consulta = empleadoRepositorio.getEmpleado (empleado.getNumId());
            if (consulta.isEmpty()) {
                return empleadoRepositorio.save(empleado);
            } else {
                return empleado; 
            } 
        }
        
    }

}
