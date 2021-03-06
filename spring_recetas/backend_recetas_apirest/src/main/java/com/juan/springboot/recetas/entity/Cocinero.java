package com.juan.springboot.recetas.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "COCINEROS")
public class Cocinero implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "El campo nombre no debe estar vacío")
	@Size(min = 3, max = 25, message = "El nombre debe tener entre 3 y 25 caracteres")
	private String nombre;
	private String apellido;
	@NotEmpty(message = "El campo email no debe estar vacío")
	@Email
	@Column(unique = true)
	private String email;
	@NotNull(message = "La fecha no puede estar vacía")
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	@JsonIgnoreProperties({"cocinero", "hibernateLazyInitializer", "handler"})
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cocinero", cascade = CascadeType.REFRESH)
	private List<Receta> recetas;
	
//	@PrePersist
//	public void addDate() {
//		this.createAt = new Date();
//	}
	
	public Cocinero() {
		recetas = new ArrayList<>();
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public List<Receta> getRecetas() {
		return recetas;
	}

	public void addReceta(Receta newReceta) {
		this.recetas.add(newReceta);
	}

}
