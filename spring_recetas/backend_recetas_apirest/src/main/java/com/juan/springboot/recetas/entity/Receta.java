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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "recetas")
public class Receta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty()
	@Size(min = 3, max = 30, message = "El nombre debe tener entre 3 y 30 caracteres")
	private String nombre;
	@NotNull(message = "La descripción no puede estar vacía")
	private String descripcion;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_at")
	private Date createAt;
	private Double totalPeso;
	private Double totalCalorias;
	
	@JsonIgnoreProperties({"recetas", "hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	private Cocinero cocinero;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "receta_id")
	private List<ItemReceta> itemRecetas;
	
	@PrePersist
	public void addDate() {
		this.createAt = new Date();
	}
	
	public Receta() {
		itemRecetas = new ArrayList<>();
	}

	public Receta(String nombre, Cocinero cocinero) {
		this();
		this.nombre = nombre;
		this.cocinero = cocinero;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public Double getTotalPeso() {
		return totalPeso;
	}

	public Double getTotalCalorias() {
		return totalCalorias;
	}

	public Cocinero getCocinero() {
		return cocinero;
	}

	public void setCocinero(Cocinero cocinero) {
		this.cocinero = cocinero;
	}
	
	public List<ItemReceta> getItemRecetas() {
		return itemRecetas;
	}

	public void setItemRecetas(List<ItemReceta> itemRecetas) {
		this.itemRecetas = itemRecetas;
	}
	
	public void addItemReceta(ItemReceta newItemReceta) {
		this.itemRecetas.add(newItemReceta);
	}

	public Double calcularTotalPeso() {
		this.totalPeso = this.itemRecetas.stream().mapToDouble(item -> item.getCantidad()).sum();
		return this.getTotalPeso();
	}
	
	public Double calcularTotalCalorias() {
		this.totalCalorias = this.itemRecetas.stream().mapToDouble(item -> item.calcularCalorias()).sum();
		return this.getTotalCalorias();
	}

}
