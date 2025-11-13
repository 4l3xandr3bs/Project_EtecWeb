package br.com.etecweb.etecweb.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etecweb.etecweb.entity.Cidade;
import br.com.etecweb.etecweb.repository.CidadeRepository;
@Service
public class CidadeService {
    
//injeção de dependencia do repositorio de alunos
  @Autowired
  private CidadeRepository cidadeRepository;
  //método para salvar um aluno
  public Cidade save(Cidade cidade ){
      return cidadeRepository.save(cidade);

  }
  //método para listar todos os alunos
  public List<Cidade> findAll(){
    return cidadeRepository.findAll();
  }
   public void deleteById(Integer id){
        cidadeRepository.deleteById(id);
    }
    public Cidade findById(Integer id){
        return cidadeRepository.findById(id).orElse(null);
    };
}
