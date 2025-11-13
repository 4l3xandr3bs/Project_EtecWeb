package br.com.etecweb.etecweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etecweb.etecweb.dto.AlunoTelefone;
import br.com.etecweb.etecweb.entity.Aluno;
import br.com.etecweb.etecweb.repository.AlunoRepository;
@Service
public class AlunoService {
    
//injeção de dependencia do repositorio de alunos
  @Autowired
  private AlunoRepository alunoRepository;
  //método para salvar um aluno
  public Aluno save(Aluno aluno ){
      return alunoRepository.save(aluno);

  }
  //método para listar todos os alunos
  public List<Aluno> findAll(){
    return alunoRepository.findAll();
  }
   public void deleteById(Integer id){
        alunoRepository.deleteById(id);
    }
    public Aluno findById(Integer id){
        return alunoRepository.findById(id).orElse(null);
    };
    //metodo para buscar nome e telefone dos alunos peli id
    public List<AlunoTelefone> buscarNomesETelefone(){
      return alunoRepository.buscarNomesETelefone();
    }
}
