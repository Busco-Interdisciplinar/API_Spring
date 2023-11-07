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
@Table(name = "locais")
public class Rota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ponto_referencia;
    private String horario;
    private String bairro;
    private String rua;
    private Date data_rota;
    private int rota;

    public Rota(String ponto_referencia, String horario, String bairro, String rua, Date data_rota, int rota) {
        this.ponto_referencia = ponto_referencia;
        this.horario = horario;
        this.bairro = bairro;
        this.rua = rua;
        this.data_rota = data_rota;
        this.rota = rota;
    }
}
