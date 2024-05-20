package com.andoni.formacion.noto.servicios;

import java.util.List;
import java.util.Optional;

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
		
		Optional<Nota> notaOpt = notaRepository.findById(id);
		if(notaOpt.isEmpty()) {
			return null;
		}
		
		return notaRepository.findById(id).get();
	}

	@Override
	public Nota saveNota(Nota nota) {
		
		if(nota.getId() != null) {
			return null;
		}
		
		return notaRepository.save(nota);
	}

	@Override
	public Nota updateNota(Nota nota) {
		
		if(nota.getId() == null) {
			return null;
		}
		
		return notaRepository.save(nota);
	}

	@Override
	public void deleteNotaById(Long id) {
		
		notaRepository.deleteById(id);
	}

}
