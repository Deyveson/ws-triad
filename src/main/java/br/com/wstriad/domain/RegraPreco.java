package br.com.wstriad.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.*;

@Entity
@Table(name = "REGRAPRECO")
public class RegraPreco {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DIAS", columnDefinition = "VARCHAR(20)")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String dias;

    @Column(name = "PERIODO", columnDefinition = "VARCHAR(20)")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String periodo;

    @Column(name = "VALOR")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double valor;

    public RegraPreco(String dias, String periodo, double valor) {
        this.dias = dias;
        this.periodo = periodo;
        this.valor = valor;
    }

    public RegraPreco() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
