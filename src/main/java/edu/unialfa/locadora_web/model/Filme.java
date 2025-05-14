package edu.unialfa.locadora_web.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity //Entidade de banco de dados
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto imcremento do banco
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "codigo_diretor") // Essa coluna de código será colocada no banco
    private Diretor diretor;
}
