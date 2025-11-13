package br.com.etecweb.etecweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.etecweb.etecweb.entity.Curso;
import br.com.etecweb.etecweb.service.CursoService;


@Controller
@RequestMapping("/cursos")
public class CursoController {
    
    @Autowired
    public CursoService cursoService;

    //aluno
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Curso curso) {
        cursoService.save(curso);
        return "redirect:/cursos/listar";
    }

    @GetMapping("/listar")
    public String listar(Model  model) {
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        return "curso/listaCurso";
    }
    
    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("curso", new Curso());
        return "curso/formularioCurso";
    }

    @GetMapping("/excluir/{idCurso}")
    public String exccuir(@PathVariable Integer idCurso) {
        cursoService.deleteById(idCurso);
        return "redirect:/cursos/listar";
    }
    
    @GetMapping("/editar/{idCurso}")
    public String editarForm(@PathVariable Integer idCurso, Model model) {
        Curso curso = cursoService.findById(idCurso);
        model.addAttribute("curso", curso);
        return "curso/formularioCurso";
    }
}

