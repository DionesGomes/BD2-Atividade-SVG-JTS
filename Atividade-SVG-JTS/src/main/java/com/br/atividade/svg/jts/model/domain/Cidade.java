package com.br.atividade.svg.jts.model.domain;

import com.vividsolutions.jts.geom.Geometry;

public class Cidade {

    private String populacao;
    private Geometry geom;
    private String nome;
    private String area;
    private String svg;

    public Cidade() {

    }

    public Cidade(String populacao, String nome, String area, String svg) {
        this.populacao = populacao;
        this.nome = nome;
        this.area = area;
        this.svg = svg;
    }

    public String getPopulacao() {
        return populacao;
    }

    public void setPopulacao(String populacao) {
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
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
