package edu.unialfa.locadora_web.controller;

import edu.unialfa.locadora_web.model.Filme;
import edu.unialfa.locadora_web.service.DiretorService;
import edu.unialfa.locadora_web.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //Difinir que é um controlador do Spring MVC (Receber e retornar respostas)
public class FilmeController {

    @Autowired //Faz a injeção de dependências automática no FilmeRepository
    private FilmeService service;

    @Autowired
    private DiretorService diretorService;

    @GetMapping("filme") //Mapeia requisições do tipo GET
    public String abrirFormulario(Filme filme, Model model) {
        model.addAttribute("diretores", diretorService.listarTodos());
        return "filme/formulario";
    }

    @GetMapping("/filmes")
    public String iniciar(Model model) {
        var filmes = service.listarTodos();
        model.addAttribute("listaDeFilmes", filmes);
        return "filme/lista"; //redirecionando para pasta filme, página lista
    }

    @PostMapping("salvar") //Mapeia requisições do tipo POST
    public String salvar(Filme filme, Model model) {
        service.salvar(filme);
        return "redirect:/filmes";
    }

    @GetMapping("alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("diretores", diretorService.listarTodos());
        model.addAttribute("filme", service.buscarPorId(id));
        return "filme/formulario";
    }

    @GetMapping("remover/{id}")
    public String remover(@PathVariable Long id, Model model) {
        service.remover(id);
        return "redirect:/filmes";
    }


    /* Exemplo retornando o primeiro da lista
        @GetMapping("/filmes")
        public String listarFilmes(Model model){
            var filmes = service.listarTodos();
            model.addAttribute("primeiroDaLista",filmes.getFirst()); // retorna o primeiro da lista de filmes

            return "filmes";
        }
    */
}
