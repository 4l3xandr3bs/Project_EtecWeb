package br.com.etecweb.etecweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
  // atributos
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)

  private Integer idAluno;
  @Column(nullable = false, length = 40)
  private String nomeAluno;
  @Column(nullable = false, length = 11)
  private String cpfAluno;
  @Column(nullable = false, length = 30)
  private String enderecoAluno;
  @Column(nullable = false, length = 11)
  private String telefoneAluno;

  private Integer raAluno;
  // Método 1 pra muitos
  @ManyToOne
  @JoinColumn(name = "idCurso-fk")
  private Curso curso;
  @ManyToOne
  @JoinColumn(name = "idCidade-fk")
  private Cidade cidade;
}
