package com.juan.springboot.recetas.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.juan.springboot.recetas.entity.Cocinero;
import com.juan.springboot.recetas.service.ICocineroService;

/**
 * Topics used in the class:
 * <ul>
 * <li>@CrossOrigin</li>
 * <li>org.springframework.data.domain.Page</li>
 * <li>org.springframework.data.domain.PageRequest</li>
 * <li>org.springframework.data.domain.Pageable</li>
 * <li>ServletUriComponentsBuilder</li>
 * </ul>
 * 
 * @author juand
 *
 */
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class CocineroControllerImpl implements CocineroController {

	@Autowired
	private ICocineroService cocineroService;

	@GetMapping(value = "/cocineros", produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public List<Cocinero> getCocineros() {
		return cocineroService.findAll();
	}
	
	@GetMapping(value = "/cocinerosresponseentity", produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public ResponseEntity<List<Cocinero>> getCocinerosResponseEntity(){
		List<Cocinero> cocineros = cocineroService.findAll();
		if(cocineros == null || cocineros.isEmpty()) {
			return ResponseEntity.noContent().build(); 
		}
		return ResponseEntity.ok(cocineros);
	}
	
	@GetMapping(value = "/cocineros/page/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public Page<Cocinero> getCocineros(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 3);
		return cocineroService.findAll(pageable);
	}

	@GetMapping(value = "/cocineros/{idCocinero}")
	@Override
	public ResponseEntity<?> show(@PathVariable Integer idCocinero) {
		Cocinero cocinero = null;
		Map<String, Object> response = new HashMap<>();
		try {
			cocinero = cocineroService.findById(idCocinero);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta del cocinero");
			response.put("error", e.getMessage() + ": " + e.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (cocinero == null) {
			response.put("mensaje", "El cocinero con id " + idCocinero + " no existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("prueba", "prueba");
		return new ResponseEntity<Cocinero>(cocinero, headers, HttpStatus.OK);
	}
	
	@PostMapping(value = "/cocineros", consumes = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public ResponseEntity<?> create(@Valid @RequestBody Cocinero cocinero, BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			List<String> errors = new ArrayList<>();
			
			errors = result.getFieldErrors().stream().map(err -> "El campo " + err.getField() + ": " + err.getDefaultMessage()).collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			cocineroService.create(cocinero);
		} catch (Exception e) {
			response.put("mensaje", "El cocinero " + cocinero.getNombre() + " no se ha podido guardar");
			response.put("error", e.getMessage().concat(": ").concat(e.getLocalizedMessage().toString()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente ha sido creado con éxito");
		response.put("cocinero", cocinero);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cocinero.getId()).toUri();
		ResponseEntity<?> reponseUri = ResponseEntity.created(location ).build();
		
//		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		return reponseUri;
	}

	@PutMapping(value = "/cocineros/{idCocinero}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public ResponseEntity<?> update(@Valid @RequestBody Cocinero cocinero, BindingResult result, @PathVariable Integer idCocinero) {
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			List<String> errors = new ArrayList<>();
			
			errors = result.getFieldErrors().stream().map(err -> "El campo " + err.getField() + ": " + err.getDefaultMessage()).collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (idCocinero != null) {
			Cocinero cocineroActual = cocineroService.findById(idCocinero);
			if (cocineroActual != null) {
				cocineroActual.setNombre(cocinero.getNombre());
				cocineroActual.setApellido(cocinero.getApellido());
				cocineroActual.setEmail(cocinero.getEmail());
				try {
					cocineroService.create(cocineroActual);
					response.put("mensaje", "El cliente ha sido modificado con éxito");
					response.put("cocinero", cocinero);
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
				} catch (Exception e) {
					response.put("mensaje", "Error al actualizar el cocinero en la base de datos");
					response.put("error", e.getMessage().concat(": ").concat(e.getLocalizedMessage().toString()));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NO_CONTENT);
				}
			} else {
				response.put("mensaje", "No existen cocineros con identificador " + idCocinero);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}

		} else {
			response.put("mensaje", "El identificador " + idCocinero + " no es correcto");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NO_CONTENT);
		}

	}

	@DeleteMapping(value = "/cocineros/{idCocinero}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Override
	public ResponseEntity<?> delete(@PathVariable Integer idCocinero) {
		Map<String, Object> response = new HashMap<>();
		try {
			cocineroService.delete(idCocinero);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el cocinero de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().toString()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente se ha eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
