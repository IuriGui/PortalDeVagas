package br.csi.oportunidades.model.oportunidade;

import br.csi.oportunidades.model.usuario.Usuario;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;



@Entity
public class Oportunidade {



    @Id
    @GeneratedValue
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "id_instituicao", nullable = false)
    private Usuario instituicao;

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
