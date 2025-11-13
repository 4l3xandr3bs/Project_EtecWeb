package br.com.etecweb.etecweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Curso {
    @Id // chave primaria = id = identifica come ateibuto chave.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCurso;

    @Column(nullable = false, length = 40)
    private String nomeCurso;

    @Column(nullable = false, length = 50)
    private String periodoCurso; 

    @Column(nullable =  false, length = 30)
    private String chCurso;// CH ==> carga horaria 

    
}