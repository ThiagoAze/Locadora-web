package edu.unialfa.locadora_web.service;

import edu.unialfa.locadora_web.model.Filme;
import edu.unialfa.locadora_web.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Definir que está é a camada de serviço (Usada entre Controller e Repository)
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    public void salvar(Filme filme){
        if (filme.getNome().isBlank()) return;
        repository.save(filme);
    }

    public void criarNovo(){
        var filme = new Filme();
        filme.setNome("Harry Potter e o Cálice de Fogo");
        repository.save(filme);
    }

    public List<Filme> listarTodos(){
        return repository.findAll();
    }

    public Filme buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    public void remover(Long id){
        repository.deleteById(id);
    }
}
