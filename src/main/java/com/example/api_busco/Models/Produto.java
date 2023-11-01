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
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private int estoque;
    private Date data_colheita;
    private double preco;
    private String tipo;
    private int fornecedor;
    private String foto;

    public Produto(String nome, int estoque, Date data_colheita, double preco, String tipo, int fornecedor) {
        this.nome = nome;
        this.estoque = estoque;
        this.data_colheita = data_colheita;
        this.preco = preco;
        this.tipo = tipo;
        this.fornecedor = fornecedor;
    }
}
