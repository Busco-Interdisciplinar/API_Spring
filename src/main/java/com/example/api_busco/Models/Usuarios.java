package com.example.api_busco.Models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "usuario_padrao")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String senha;
    private String cep;
    private String nome;
    private String cpf;
    private int qnt_doacao;
    private String telefone;
    private String foto;

    public Usuarios(String email, String senha, String cep, String nome, String cpf,  String telefone) {
        this.email = email;
        this.senha = senha;
        this.cep = cep;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }
}
