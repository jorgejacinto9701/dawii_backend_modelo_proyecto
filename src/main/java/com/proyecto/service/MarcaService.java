package com.proyecto.service;

import java.util.List;

import com.proyecto.entidad.Marca;

public interface MarcaService {

	public abstract List<Marca> listaMarca();
	public abstract Marca agregarMarca(Marca obj);
	
}
