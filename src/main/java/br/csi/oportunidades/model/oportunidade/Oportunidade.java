package br.csi.oportunidades.model.oportunidade;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

public class Oportunidade {

    private UUID id;
    private UUID uuid;
    private UUID idInstituicao;

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
