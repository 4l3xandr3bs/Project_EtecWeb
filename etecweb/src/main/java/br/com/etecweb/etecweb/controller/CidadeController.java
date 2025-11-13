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

import br.com.etecweb.etecweb.entity.Aluno;
import br.com.etecweb.etecweb.entity.Cidade;

import br.com.etecweb.etecweb.service.CidadeService;

@Controller
@RequestMapping("/cidades")
public class CidadeController {
    @Autowired
    public CidadeService cidadeService;

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Cidade> cidades = cidadeService.findAll();
        model.addAttribute("cidades", cidades);
        return "cidade/listaCidade";
    }

    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("cidade", new Cidade());
        return "cidade/formularioCidade";
    }

    @GetMapping("/excluir/{idCidade}")
    public String excluir(@PathVariable Integer idCidade) {
        cidadeService.deleteById(idCidade);
        return "redirect:/cidades/listar";
    }

    @GetMapping("/editar/{idCidade}")
    public String editarForm(@PathVariable Integer idCidade, Model model) {
        Cidade cidade = cidadeService.findById(idCidade);
        model.addAttribute("cidade", cidade);
        return "cidade/formularioCidade";
    }

    @PostMapping("/salvar")

    public String salvar(@ModelAttribute Cidade cidade) {
        // salva aluno
        cidadeService.save(cidade);

        return "redirect:/cidades/listar";
    }
}
