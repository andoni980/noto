package com.andoni.formacion.noto.servicios;

import java.util.List;
import java.util.Optional;

import com.andoni.formacion.noto.entidades.Nota;

public interface NotaService {

	List<Nota> getAllNotas();
	Optional<Nota> getNotaById(Long id);
	Optional<List<Nota>> getNotasByCategoriaId(Long id);
	Nota saveNota(Nota nota);
	Nota updateNota(Nota nota);
	Boolean deleteNotaById(Long id);
}
