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
	public Optional<Nota> getNotaById(Long id) {
		return notaRepository.findById(id);
	}
	
	@Override
	public Optional<List<Nota>> getNotasByCategoriaId(Long id){
		return notaRepository.findByCategoriaId(id);
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
	public Boolean deleteNotaById(Long id) {
		
		return getNotaById(id)
				.map(nota -> {
					notaRepository.deleteById(id);
					return true;
				}).orElse(false);
	}

}
