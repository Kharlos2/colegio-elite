package com.example.colegioelite.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="nombre",nullable = false, length = 50)
    private String nombre;
    @Column(name="escalafon",nullable = false)
    private Integer escalafon;

    @OneToMany(mappedBy = "profesor")
    private List<Materia> materia;

    public Profesor() {
    }

    public Profesor(Integer id, String nombre, Integer escalafon, List<Materia> materia) {
        this.id = id;
        this.nombre = nombre;
        this.escalafon = escalafon;
        this.materia = materia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEscalafon() {
        return escalafon;
    }

    public void setEscalafon(Integer escalafon) {
        this.escalafon = escalafon;
    }

    public List<Materia> getMateria() {
        return materia;
    }

    public void setMateria(List<Materia> materia) {
        this.materia = materia;
    }
}
