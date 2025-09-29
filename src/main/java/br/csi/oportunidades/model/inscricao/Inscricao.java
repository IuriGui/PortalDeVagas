package br.csi.oportunidades.model.inscricao;


import br.csi.oportunidades.model.oportunidade.Oportunidade;
import br.csi.oportunidades.model.usuario.types.Candidate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "inscricao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inscricao {

    @Id @GeneratedValue()
    private Long id;

    @ManyToOne
    @JoinColumn(name = "oportunidade_id")
    private Oportunidade oportunidade;

    @ManyToOne
    private Candidate candidato;


    private LocalDateTime dataInscricao;



}
