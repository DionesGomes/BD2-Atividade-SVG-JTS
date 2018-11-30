package com.br.atividade.svg.jts.model.dao;

import com.br.atividade.svg.jts.model.domain.Cidade;
import com.vividsolutions.jts.io.ParseException;
import java.sql.SQLException;
import java.util.List;

public interface CidadeDao {

    Cidade buscarCidadeUF(String cidade, String estado) throws ClassNotFoundException, SQLException, ParseException;

    List<String> buscarNomeCidadeUF(String stado) throws ClassNotFoundException, SQLException;

    List<String> buscarNomeUF() throws ClassNotFoundException, SQLException;

    String getViewBox(String cidade_1, String cidade_2) throws ClassNotFoundException, SQLException;

}
