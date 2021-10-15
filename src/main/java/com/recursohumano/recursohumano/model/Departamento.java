package com.recursohumano.recursohumano.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence. * ;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="departamento")
public class Departamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numId;
    private String nombreDepartamento;
    private Date fechaCreacionDate;
    
    // relacion uno a muchos
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "departamento")
    @JsonIgnoreProperties("departamento")
    private List<Empleado> empleados;

    public Date getFechaCreacionDate() {
        return fechaCreacionDate;
    }
    public void setFechaCreacionDate(Date fechaCreacionDate) {
        this.fechaCreacionDate = fechaCreacionDate;
    }
    public Integer getNumId() {
        return numId;
    }
    public void setNumId(Integer numId) {
        this.numId = numId;
    }
    public String getNombreDepartamento() {
        return nombreDepartamento;
    }
    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
    public List<Empleado> getEmpleados() {
        return empleados;
    }
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    
}
