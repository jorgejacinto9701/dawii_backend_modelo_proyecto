package com.proyecto.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entidad.Marca;
import com.proyecto.service.MarcaService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/url/marca")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class MarcaController {
	@Autowired
	private MarcaService marcaService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Marca>> listaMarca() {
		List<Marca> lista = marcaService.listaMarca();
		return ResponseEntity.ok(lista);
	}

	
	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaMarca(@RequestBody Marca obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setFechaRegistro(new Date());
			obj.setEstado(1);
			Marca objSalida = marcaService.agregarMarca(obj);
			if (objSalida == null) {
				salida.put("mensaje", "No se realizó el registro, consultar con el administrador.");
			}else {
				salida.put("mensaje", "Se registró exitosamente.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se realizó el registro, consultar con el administrador.");
		}
		return ResponseEntity.ok(salida);
	}
}
