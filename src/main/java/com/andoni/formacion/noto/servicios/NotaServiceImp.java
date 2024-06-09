package com.andoni.formacion.noto.servicios;

import java.time.LocalDateTime;
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
	public List<Nota> getAllNotas(Boolean eliminada) {
		return notaRepository.findByIsEliminada(eliminada);
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
		System.out.println(nota.toString());
		if(nota.getId() == null) {
			return null;
		}

		return notaRepository.save(nota);
	}
	
	@Override
	public Nota restoreNota(Nota nota) {
		
		if(nota.getIsEliminada() == true) {
			nota.setIsEliminada(false);
			nota.setFechaEliminacion(null);
		}
		
		return notaRepository.save(nota);
	}

	@Override
	public Boolean deleteNotaById(Long id) {
		
		boolean eliminada = false;
		
		Optional<Nota> notaOpt = getNotaById(id);
		
		if(notaOpt.isPresent()) {
			
			if(notaOpt.get().getIsEliminada() == true) {
				notaRepository.deleteById(id);
				eliminada = true;
			}else {
				Nota nota = notaOpt.get();
				nota.setIsEliminada(true);
				nota.setFechaEliminacion(LocalDateTime.now());
				updateNota(nota);
				eliminada = true;
			}
		}
		
		System.out.println(eliminada);
		
		return eliminada;
			
	}

}
