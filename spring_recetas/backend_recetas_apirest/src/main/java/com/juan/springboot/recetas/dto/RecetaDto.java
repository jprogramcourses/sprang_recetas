package com.juan.springboot.recetas.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.juan.springboot.recetas.entity.Cocinero;
import com.juan.springboot.recetas.entity.ItemReceta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecetaDto {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	
	@JsonSerialize(using = LocalDateSerializer.class)
	private Date createAt;
	private Double totalPeso;
	private Double totalCalorias;
	private Cocinero cocinero;
	private List<ItemReceta> itemRecetas;

}
