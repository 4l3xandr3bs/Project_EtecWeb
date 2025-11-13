package br.com.etecweb.etecweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etecweb.etecweb.entity.Curso;
import br.com.etecweb.etecweb.repository.CursoRepository;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository cursoRepository;

    public Curso save(Curso curso){
        return cursoRepository.save(curso);
    }
    
    public List<Curso> findAll(){
        return cursoRepository.findAll();
    }

    public void deleteById(Integer idCurso){
        cursoRepository.deleteById(idCurso);
    }

    public Curso findById(Integer idCurso) {
        return cursoRepository.findById(idCurso).orElse(null);
    }
}