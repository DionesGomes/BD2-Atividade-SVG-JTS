package com.br.atividade.svg.jts.model.dao;

import com.br.atividade.svg.jts.model.domain.Cidade;
import java.sql.SQLException;
import java.util.List;

import com.vividsolutions.jts.io.ParseException;

public interface CidadeDAO {

    Cidade buscarCidadeEstado(String cidade, String estado) throws ClassNotFoundException, SQLException, ParseException;

    List<String> buscarNomeCidadesEstado(String estado) throws ClassNotFoundException, SQLException;

    List<String> buscarNomeEstados() throws ClassNotFoundException, SQLException;

    String getViewBox(Cidade cidade1, Cidade cidade2) throws ClassNotFoundException, SQLException;
}
