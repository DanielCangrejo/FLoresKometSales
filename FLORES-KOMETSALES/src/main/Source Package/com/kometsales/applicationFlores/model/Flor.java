package com.kometsales.applicationFlores.model;

import jakarta.persistence.*;

@Entity
@Table(name = "flores")
public class Flor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String nombre;

    @Column(name = "price")
    private Double precio;

    public Flor() {
    }

    public Flor(String nombre, Double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	// Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

	@Override
	public String toString() {
		return "Flor [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
  
}