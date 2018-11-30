package com.br.atividade.svg.jts.model.dao;

import com.br.atividade.svg.jts.model.domain.Cidade;
import com.br.atividade.svg.jts.model.jdbc.ConnectionFactory;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDaoImpl implements CidadeDao {

    public ConnectionFactory factory;
    public WKTReader reader;

    public CidadeDaoImpl() {
        factory = new ConnectionFactory();
        reader = new WKTReader();
    }

    @Override
    public Cidade buscarCidadeUF(String nomeCidade, String nomeEstado) throws ClassNotFoundException, SQLException, ParseException {
        try (Connection connection = factory.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement(""
                            + "SELECT c.nome, c.populacao_2010, c.area, ST_AsText(ST_AsEWKT(c.geom)),ST_AsSVG(geom)"
                            + " FROM cidade c, estados e "
                            + "WHERE c.nome ilike ? and e.nome ilike ?");

            statement.setString(1, nomeCidade);
            statement.setString(2, nomeEstado);

            ResultSet resultado = statement.executeQuery();
            Cidade cidade = new Cidade();
            if (resultado.next()) {
                cidade.setNome(resultado.getString(1));
                cidade.setPopulacao(resultado.getInt(2));
                cidade.setArea(resultado.getFloat(3));
//	        TRANSFORMA O TEXTO EM UMA GEOMETRIA COM A CLASSE WKTReader
                cidade.setGeom(reader.read(resultado.getString(4)));
                cidade.setSvg(resultado.getString(5));
                return cidade;
            }
        }
        return null;
    }

    @Override
    public List<String> buscarNomeCidadeUF(String estado) throws ClassNotFoundException, SQLException {
        List<String> cidades = new ArrayList<>();
        try (Connection connection = factory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(""
                    + "SELECT c.nome "
                    + "FROM cidade c, estados e "
                    + "WHERE c.estado_id = e.id and e.nome ilike ? "
                    + "ORDER BY c.nome");
            statement.setString(1, estado);
            ResultSet resultado = statement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    cidades.add(resultado.getString(1));
                }
                return cidades;
            }
        }
        return null;
    }

    @Override
    public List<String> buscarNomeUF() throws ClassNotFoundException, SQLException {
        List<String> NomeUF = new ArrayList<>();
        try (Connection connection = factory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "select nome from estados order by nome");
            ResultSet resultado = statement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    NomeUF.add(resultado.getString(1));
                }
                return NomeUF;
            }
        }

        return null;
    }

    @Override
    public String getViewBox(String cidade_1, String cidade_2) throws ClassNotFoundException, SQLException {
        try (Connection connection = factory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(""
                    + "SELECT getviewbox(?,?)"
            );
            statement.setString(1, cidade_1);
            statement.setString(2, cidade_2);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                return resultado.getString(1);
            }
        }
        return null;
    }
}
