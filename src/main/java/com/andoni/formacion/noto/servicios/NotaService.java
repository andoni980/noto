package com.andoni.formacion.noto.servicios;

import java.util.List;

import com.andoni.formacion.noto.entidades.Nota;

public interface NotaService {

	List<Nota> getAllNotas();
	Nota getNotaById(Long id);
	Nota saveNota(Nota nota);
	Nota updateNota(Nota nota);
	void deleteNotaById(Long id);
}
