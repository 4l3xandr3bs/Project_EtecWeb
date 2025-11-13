package br.com.etecweb.etecweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etecweb.etecweb.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
