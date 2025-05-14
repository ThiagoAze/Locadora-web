package edu.unialfa.locadora_web.controller;

import edu.unialfa.locadora_web.model.Diretor;
import edu.unialfa.locadora_web.service.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DiretorController {

    @Autowired
    private DiretorService service;

    @GetMapping("diretor") //Mapeia requisições do tipo GET
    public String abrirFormularioDiretor(Diretor diretor, Model model) {
        model.addAttribute("diretores", service.listarTodos());
        return "diretor/formulario";
    }

    @GetMapping("/diretores")
    public String iniciar(Model model){
        var diretores = service.listarTodos();
        model.addAttribute("listaDeDiretores", diretores);
        return "diretor/lista";
    }

    @PostMapping("salvarDiretor")
    private String salvarDiretor(Diretor diretor, Model model){
        service.salvar(diretor);
        return "redirect:/diretores";
    }

    @GetMapping("alterarDiretor/{id}")
    public String alterarDiretor(@PathVariable Long id, Model model) {
        model.addAttribute("diretor", service.buscarPorId(id));
        return "diretor/formulario";
    }

    @GetMapping("removerDiretor/{id}")
    public String removerDiretor(@PathVariable Long id, Model model) {
        service.remover(id);
        return "redirect:/diretores";
    }
}
