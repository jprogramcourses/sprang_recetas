package com.juan.springboot.recetas.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredienteDto {
	
	@JsonProperty("ingredienteId")
	@Null
	private UUID id;
	
	
	@NotBlank
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

}
