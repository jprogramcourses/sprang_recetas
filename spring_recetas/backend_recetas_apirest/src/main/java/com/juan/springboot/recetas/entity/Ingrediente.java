package com.juan.springboot.recetas.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "INGREDIENTES")
public class Ingrediente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String nombre;
	private String descripcion;
	private Double calorias;
	private Double grasa;
	private Double proteina;
	private Double agua;
	private Double fibra;
	private Double carbohidratos;
	private Double acidosGrasosMonoinsaturados;
	private Double acidosGrasosPoliinsaturados;
	private Double acidosGrasosSaturados;
	private Double colesterol;
	private Double vitaminaA;
	private Double vitaminaB6;
	private Double vitaminaB12;
	private Double vitaminaC;
	private Double vitaminaD;
	private Double vitaminaE;
	private Double riboflavina;
	private Double tiamina;
	private Double niacina;
	private Double folato;
	private Double calcio;
	private Double hierro;
	private Double potasio;
	private Double sodio;
	private Double fosforo;
	private Double ioduro;
	private Double selenio;
	private Double zinc;
	
	public Ingrediente() {
	}

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getCalorias() {
		return calorias;
	}

	public void setCalorias(Double calorias) {
		this.calorias = calorias;
	}

	public Double getGrasa() {
		return grasa;
	}

	public void setGrasa(Double grasa) {
		this.grasa = grasa;
	}

	public Double getProteina() {
		return proteina;
	}

	public void setProteina(Double proteina) {
		this.proteina = proteina;
	}

	public Double getAgua() {
		return agua;
	}

	public void setAgua(Double agua) {
		this.agua = agua;
	}

	public Double getFibra() {
		return fibra;
	}

	public void setFibra(Double fibra) {
		this.fibra = fibra;
	}

	public Double getCarbohidratos() {
		return carbohidratos;
	}

	public void setCarbohidratos(Double carbohidratos) {
		this.carbohidratos = carbohidratos;
	}

	public Double getAcidosGrasosMonoinsaturados() {
		return acidosGrasosMonoinsaturados;
	}

	public void setAcidosGrasosMonoinsaturados(Double acidosGrasosMonoinsaturados) {
		this.acidosGrasosMonoinsaturados = acidosGrasosMonoinsaturados;
	}

	public Double getAcidosGrasosPoliinsaturados() {
		return acidosGrasosPoliinsaturados;
	}

	public void setAcidosGrasosPoliinsaturados(Double acidosGrasosPoliinsaturados) {
		this.acidosGrasosPoliinsaturados = acidosGrasosPoliinsaturados;
	}

	public Double getAcidosGrasosSaturados() {
		return acidosGrasosSaturados;
	}

	public void setAcidosGrasosSaturados(Double acidosGrasosSaturados) {
		this.acidosGrasosSaturados = acidosGrasosSaturados;
	}

	public Double getColesterol() {
		return colesterol;
	}

	public void setColesterol(Double colesterol) {
		this.colesterol = colesterol;
	}

	public Double getVitaminaA() {
		return vitaminaA;
	}

	public void setVitaminaA(Double vitaminaA) {
		this.vitaminaA = vitaminaA;
	}

	public Double getVitaminaB6() {
		return vitaminaB6;
	}

	public void setVitaminaB6(Double vitaminaB6) {
		this.vitaminaB6 = vitaminaB6;
	}

	public Double getVitaminaB12() {
		return vitaminaB12;
	}

	public void setVitaminaB12(Double vitaminaB12) {
		this.vitaminaB12 = vitaminaB12;
	}

	public Double getVitaminaC() {
		return vitaminaC;
	}

	public void setVitaminaC(Double vitaminaC) {
		this.vitaminaC = vitaminaC;
	}

	public Double getVitaminaD() {
		return vitaminaD;
	}

	public void setVitaminaD(Double vitaminaD) {
		this.vitaminaD = vitaminaD;
	}

	public Double getVitaminaE() {
		return vitaminaE;
	}

	public void setVitaminaE(Double vitaminaE) {
		this.vitaminaE = vitaminaE;
	}

	public Double getRiboflavina() {
		return riboflavina;
	}

	public void setRiboflavina(Double riboflavina) {
		this.riboflavina = riboflavina;
	}

	public Double getTiamina() {
		return tiamina;
	}

	public void setTiamina(Double tiamina) {
		this.tiamina = tiamina;
	}

	public Double getNiacina() {
		return niacina;
	}

	public void setNiacina(Double niacina) {
		this.niacina = niacina;
	}

	public Double getFolato() {
		return folato;
	}

	public void setFolato(Double folato) {
		this.folato = folato;
	}

	public Double getCalcio() {
		return calcio;
	}

	public void setCalcio(Double calcio) {
		this.calcio = calcio;
	}

	public Double getHierro() {
		return hierro;
	}

	public void setHierro(Double hierro) {
		this.hierro = hierro;
	}

	public Double getPotasio() {
		return potasio;
	}

	public void setPotasio(Double potasio) {
		this.potasio = potasio;
	}

	public Double getSodio() {
		return sodio;
	}

	public void setSodio(Double sodio) {
		this.sodio = sodio;
	}

	public Double getFosforo() {
		return fosforo;
	}

	public void setFosforo(Double fosforo) {
		this.fosforo = fosforo;
	}

	public Double getIoduro() {
		return ioduro;
	}

	public void setIoduro(Double ioduro) {
		this.ioduro = ioduro;
	}

	public Double getSelenio() {
		return selenio;
	}

	public void setSelenio(Double selenio) {
		this.selenio = selenio;
	}

	public Double getZinc() {
		return zinc;
	}

	public void setZinc(Double zinc) {
		this.zinc = zinc;
	}

}
