package edu.unialfa.locadora_web.service;

import edu.unialfa.locadora_web.model.Diretor;
import edu.unialfa.locadora_web.repository.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository diretorRepository;

    public void salvar(Diretor diretor){
        if (diretor.getNome().isBlank()) return;
        diretorRepository.save(diretor);
    }

    public List<Diretor> listarTodos(){
        return diretorRepository.findAll();
    }

    public Diretor buscarPorId(Long id) {
        return diretorRepository.findById(id).get();
    }

    public void remover(Long id){
        diretorRepository.deleteById(id);
    }
}
