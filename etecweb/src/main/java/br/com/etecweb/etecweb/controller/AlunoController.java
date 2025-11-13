package br.com.etecweb.etecweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import br.com.etecweb.etecweb.dto.AlunoTelefone;
import br.com.etecweb.etecweb.entity.Aluno;
import br.com.etecweb.etecweb.entity.Curso;
import br.com.etecweb.etecweb.entity.Cidade;
import br.com.etecweb.etecweb.service.AlunoService;
import br.com.etecweb.etecweb.service.CidadeService;
import br.com.etecweb.etecweb.service.CursoService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
    // injeção de dependencia da service de alunos e cursos
    @Autowired
    private AlunoService alunoservice;
    @Autowired
    private CursoService cursoService;
    @Autowired
    private CidadeService cidadeService;

    // metodo para salvar um aluno
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Aluno aluno) {
        // salva aluno
        alunoservice.save(aluno);

        return "redirect:/alunos/listar";
    }
    // Método para abrir o formulário de edição de alunos

    @GetMapping("/listar")
    public String listar(Model model) {
        // lista todos os alunos
        List<Aluno> alunos = alunoservice.findAll();
        // Adiciona os alunos ao modelo
        model.addAttribute("alunos", alunos);
        return "aluno/listaaluno";
    }

    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("aluno", new Aluno());
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        List<Cidade> cidades = cidadeService.findAll();
        model.addAttribute("cidades", cidades);
        return "aluno/fomularioaluno";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        alunoservice.deleteById(id);
        return "redirect:/alunos/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        Aluno aluno = alunoservice.findById(id);
        model.addAttribute("aluno", aluno);
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        List<Cidade> cidades = cidadeService.findAll();
        model.addAttribute("cidades", cidades);
        return "aluno/formularioaluno";

    }
    
    //metodo para buscar o nome e telefone dos alunos
    @GetMapping("/listar-nome-telefone")
    public String listarNomeTelefone(Model model){
     List<AlunoTelefone> alunos = alunoservice.buscarNomesETelefone();
     model.addAttribute("alunos", alunos);
    return "aluno/listaNomeTelefone";
}
}
