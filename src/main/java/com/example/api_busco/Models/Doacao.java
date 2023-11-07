package com.example.api_busco.Models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "doacao")
public class Doacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date data_doacao;
    private String descricao;
    private int produto_doado;
    private int usuario_doador;
    private Integer instituicao_doador;
    private int quantidade;

    public Doacao(Date data_doacao, String descricao, int produto_doado, int usuario_doador, Integer instituicao_doador, int quantidade) {
        this.data_doacao = data_doacao;
        this.descricao = descricao;
        this.produto_doado = produto_doado;
        this.usuario_doador = usuario_doador;
        this.instituicao_doador = instituicao_doador;
        this.quantidade = quantidade;
    }

    public Doacao(Date data_doacao, String descricao, int produto_doado, int usuario_doador, int quantidade) {
        this.data_doacao = data_doacao;
        this.descricao = descricao;
        this.produto_doado = produto_doado;
        this.usuario_doador = usuario_doador;
        this.quantidade = quantidade;
    }

    public Doacao(String descricao,Date data_doacao, int produto_doado, Integer instituicao_doador, int quantidade) {
        this.data_doacao = data_doacao;
        this.descricao = descricao;
        this.produto_doado = produto_doado;
        this.instituicao_doador = instituicao_doador;
        this.quantidade = quantidade;

    }
}
