package edu.unialfa.locadora_web.repository;

import edu.unialfa.locadora_web.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> { //Nome da classe e tipo de id

}
