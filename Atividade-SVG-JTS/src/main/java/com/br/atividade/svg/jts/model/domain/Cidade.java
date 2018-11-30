package com.br.atividade.svg.jts.model.domain;

import com.vividsolutions.jts.geom.Geometry;

public class Cidade {

    private Integer populacao;
    private Geometry geom;
    private String nome;
    private Float area;
    private String svg;

    public Cidade() {

    }

    public Cidade(Integer populacao, Geometry geom, String nome, Float area, String svg) {
        this.populacao = populacao;
        this.geom = geom;
        this.nome = nome;
        this.area = area;
        this.svg = svg;
    }

    public Integer getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Integer populacao) {
        this.populacao = populacao;
    }

    public Geometry getGeom() {
        return geom;
    }

    public void setGeom(Geometry geom) {
        this.geom = geom;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public String getSvg() {
        return svg;
    }

    public void setSvg(String svg) {
        this.svg = svg;
    }

    @Override
    public String toString() {
        return "Cidade{" + "populacao=" + populacao + ", geom=" + geom + ", nome=" + nome + ", area=" + area + ", svg=" + svg + '}';
    }

}
