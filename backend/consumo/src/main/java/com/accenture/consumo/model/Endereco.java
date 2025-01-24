package com.accenture.consumo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@Table
@Entity
public class Endereco {

    @Id
    @Column(length = 9, nullable = false)
    private String cep;

    @Column(length = 255)
    private String logradouro;

    @Column(length = 255)
    private String complemento;

    @Column(length = 100)
    private String bairro;

    @Column(length = 100)
    private String localidade;

    @Column(length = 2)
    private String uf;

    @Column(length = 50)
    private String estado;

    @Column(length = 50)
    private String regiao;

    @Column(length = 10)
    private String ibge;

    @Column(length = 10)
    private String gia;

    @Column(length = 5)
    private String ddd;

    @Column(length = 10)
    private String siafi;


    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro=" + bairro +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", estado='" + estado + '\'' +
                ", regiao='" + regiao + '\'' +
                ", ibge='" + ibge + '\'' +
                ", gia='" + gia + '\'' +
                ", ddd='" + ddd + '\'' +
                ", siafi='" + siafi + '\'' +
                '}';
    }
}
