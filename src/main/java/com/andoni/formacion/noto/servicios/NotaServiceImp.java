package com.andoni.formacion.noto.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.andoni.formacion.noto.datos.NotaRepository;
import com.andoni.formacion.noto.entidades.Nota;

@Service
public class NotaServiceImp implements NotaService {

	private NotaRepository notaRepository;
	
	public NotaServiceImp(NotaRepository notaRepository) {
		this.notaRepository = notaRepository;
	}
	
	@Override
	public List<Nota> getAllNotas() {
		return notaRepository.findAll();
	}

	@Override
	public Nota getNotaById(Long id) {
		return notaRepository.findById(id).get();
	}

	@Override
	public Nota saveNota(Nota nota) {
		return notaRepository.save(nota);
	}

	@Override
	public Nota updateNota(Nota nota) {
		return notaRepository.save(nota);
	}

	@Override
	public void deleteNotaById(Long id) {
		notaRepository.deleteById(id);
	}

}
