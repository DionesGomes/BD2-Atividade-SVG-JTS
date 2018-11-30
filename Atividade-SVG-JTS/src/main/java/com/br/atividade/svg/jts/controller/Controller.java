package com.br.atividade.svg.jts.controller;

import com.br.atividade.svg.jts.model.dao.CidadeDaoImpl;
import com.br.atividade.svg.jts.model.domain.Cidade;
import com.vividsolutions.jts.io.ParseException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inicio")
public class Controller extends HttpServlet {

    public static String estadoAnterior1 = null;
    public static String estadoAnterior2 = null;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Command CidadeCommand = new SvgCommand();
            CidadeCommand.ToCall(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CidadeDaoImpl dao = new CidadeDaoImpl();
        String estadoAtual1 = request.getParameter("estado_1");
        String estadoAtual2 = request.getParameter("estado_2");
        String cidadeNome1 = request.getParameter("cidade_1");
        String cidadeNome2 = request.getParameter("cidade_2");
        request.setAttribute("estado_1", estadoAtual1);
        request.setAttribute("estado_2", estadoAtual2);
        request.setAttribute("cidadeNome_1", cidadeNome1);
        request.setAttribute("cidadeNome_2", cidadeNome2);
        Cidade cidade1 = null, cidade2 = null;

        if (!estadoAtual1.equals("___NENHUM___") && estadoAnterior1 != estadoAtual1) {
            estadoAnterior1 = estadoAtual1;
            try {
                List<String> cidades1 = dao.buscarNomeCidadeUF(estadoAtual1);
                request.setAttribute("nomeCidades1", cidades1);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

        if (!estadoAtual2.equals("___NENHUM___") && estadoAnterior2 != estadoAtual2) {
            estadoAnterior2 = estadoAtual2;
            try {
                List<String> cidades2 = dao.buscarNomeCidadeUF(estadoAtual2);
                request.setAttribute("nomeCidades2", cidades2);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

        if (!cidadeNome1.equals("___NENHUM___")) {
            try {
                cidade1 = dao.buscarCidadeUF(cidadeNome1, estadoAtual1);
                request.setAttribute("cidade1", cidade1);
            } catch (ClassNotFoundException | SQLException | ParseException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("cidade1", null);
        }

        if (!cidadeNome2.equals("___NENHUM___")) {
            try {
                cidade2 = dao.buscarCidadeUF(cidadeNome2, estadoAtual2);
                request.setAttribute("cidade2", cidade2);
            } catch (ClassNotFoundException | SQLException | ParseException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("cidade2", null);
        }

        if (!estadoAtual2.equals("___NENHUM___") && !estadoAtual1.equals("___NENHUM___") && !cidadeNome1.equals("___NENHUM___") && !cidadeNome2.equals("___NENHUM___")) {
            Float dist = (float) (cidade1.getGeom().getCentroid().distance(cidade2.getGeom().getCentroid()) * (40075 / 360));
            try {
                request.setAttribute("viewBox", dao.getViewBox(cidade1.getNome(), cidade2.getNome()));
            } catch (ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            request.setAttribute("distancia", dist);
        } else {
            request.setAttribute("distancia", null);
            request.setAttribute("viewBox", null);

        }

        try {
            List<String> estados = dao.buscarNomeUF();
            request.setAttribute("estados", estados);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("View.jsp").forward(request, response);
    }

}
