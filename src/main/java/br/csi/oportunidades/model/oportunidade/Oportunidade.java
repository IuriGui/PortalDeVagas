package br.csi.oportunidades.model.oportunidade;

import br.csi.oportunidades.model.inscricao.Inscricao;
import br.csi.oportunidades.model.usuario.Usuario;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "oportunidade")
public class Oportunidade {



    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Usuario instituicao;

    @OneToMany
    private List<Inscricao> inscricoes;


    private String titulo;
    private String descricao;
    private boolean remoto;
    private BigDecimal remuneracao;
    private String tipo;

    private Timestamp dataInicio;
    private Timestamp dataFim;
    private String turno;

    private int cargaHoraria;
    private String area;



}
