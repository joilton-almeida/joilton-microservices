package br.unb.joilton.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unb.joilton.model.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long> {

	Cambio findByFromAndTo(String from, String to);
	
}