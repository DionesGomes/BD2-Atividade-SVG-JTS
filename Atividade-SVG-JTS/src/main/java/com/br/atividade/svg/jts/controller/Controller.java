package com.br.atividade.svg.jts.controller;

import com.br.atividade.svg.jts.model.dao.CidadeDAOImpl;
import com.br.atividade.svg.jts.model.domain.Cidade;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vividsolutions.jts.io.ParseException;

@WebServlet("/inicio")
public class Controller extends HttpServlet {

    public static String estadoAnterior1 = "";
    public static String estadoAnterior2 = "";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CidadeDAOImpl dao = new CidadeDAOImpl();
        try {
            List<String> estados = dao.buscarNomeEstados();
            request.setAttribute("estados", estados);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CidadeDAOImpl dao = new CidadeDAOImpl();
        String estadoNome1 = request.getParameter("estado1");
        String estadoNome2 = request.getParameter("estado2");
        String cidadeNome1 = request.getParameter("cidade1");
        String cidadeNome2 = request.getParameter("cidade2");
        request.setAttribute("estado1", estadoNome1);
        request.setAttribute("estado2", estadoNome2);
        Cidade cidade1 = null, cidade2 = null;
		
        if (!estadoNome1.equals("SELECIONE")) {
            try {
                List<String> cidades1 = dao.buscarNomeCidadesEstado(estadoNome1);
                request.setAttribute("nomeCidades1", cidades1);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            if (!cidadeNome1.equals("SELECIONE") && estadoAnterior1.equals(estadoNome1)) {
                try {
                    cidade1 = dao.buscarCidadeEstado(cidadeNome1, estadoNome1);
                    request.setAttribute("cidade1", cidade1);
                } catch (ClassNotFoundException | SQLException | ParseException e) {
                    e.printStackTrace();
                }
                /*pode haver cidades com mesmo nome em estados diferentes*/
                request.setAttribute("cidadeNome1", cidadeNome1);
            }
            estadoAnterior1 = estadoNome1;
        }

        if (!estadoNome2.equals("SELECIONE")) {
            try {
                List<String> cidades2 = dao.buscarNomeCidadesEstado(estadoNome2);
                request.setAttribute("nomeCidades2", cidades2);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            if (!cidadeNome2.equals("SELECIONE") && estadoAnterior2.equals(estadoNome2)) {
                try {
                    cidade2 = dao.buscarCidadeEstado(cidadeNome2, estadoNome2);
                    request.setAttribute("cidade2", cidade2);
                } catch (ClassNotFoundException | SQLException | ParseException e) {
                    e.printStackTrace();
                }
                request.setAttribute("cidadeNome2", cidadeNome2);//pode haver cidades com mesmo nome em estados diferentes
            }
            estadoAnterior2 = estadoNome2;
        }

        if (cidade1 != null && cidade2 != null) {
            Float dist = (float) (cidade1.getGeom().getCentroid().distance(cidade2.getGeom().getCentroid()) * (40075 / 360));
            try {
                request.setAttribute("viewBox", dao.getViewBox(cidade1, cidade2));
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("distancia", dist);
        }
		
        try {
            List<String> estados = dao.buscarNomeEstados();
            request.setAttribute("estados", estados);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
		
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}
