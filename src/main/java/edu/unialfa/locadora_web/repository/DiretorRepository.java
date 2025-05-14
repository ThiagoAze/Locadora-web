package edu.unialfa.locadora_web.repository;

import edu.unialfa.locadora_web.model.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiretorRepository extends JpaRepository<Diretor, Long> {
    
}
