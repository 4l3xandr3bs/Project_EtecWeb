package br.com.etecweb.etecweb.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.etecweb.etecweb.entity.Aluno;
import br.com.etecweb.etecweb.dto.AlunoTelefone;
//
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

//listar nome e telefone  de alunos
@Query("SELECT new br.com.etecweb.etecweb.dto.AlunoTelefone(a.nomeAluno, a.telefoneAluno) FROM Aluno a")
   List<AlunoTelefone> buscarNomesETelefone();
}