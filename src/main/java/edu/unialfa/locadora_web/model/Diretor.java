package edu.unialfa.locadora_web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data //Junção do @Getter, @Setter e outros
@Entity // JPA - que essa classe é tabela(Entidade) no banco de dados
public class Diretor {

    @Id // JPA - Indica que esse atributo é a PK (primary key) no banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento o id
    private Long id;
    private String nome;
}
