<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

    <head>

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">       
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="arquivo.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('select').formSelect();
            });
        </script>
    </head>

    <body>
        <div class="container">
            <form action="inicio" method="POST">
                <div class="row" id="esquerdo">
                    <h1> Cidade 1</h1>
                    <hr></br></br>

                    <div class="input-field col s5">
                        <select name="estado1" onchange="this.form.submit()" >
                            <option>SELECIONE</option>
                            <c:forEach var="estado" items="${estados}">
                                <option ${estado1==estado?'selected':''}>${estado}</option>
                            </c:forEach>
                        </select>
                        <label>Estado</label>
                    </div>

                    <div class="input-field col s5">
                        <select name="cidade1" onchange="this.form.submit()" >
                            <option>SELECIONE</option>
                            <c:forEach var="cidade" items="${nomeCidades1}">
                                <option ${cidadeNome1==cidade?'selected':''}>${cidade}</option>
                            </c:forEach>
                        </select>
                        <label>Cidade</label>
                    </div>
                </div>

                <div class="row" id="direito">
                    <h1>Cidade 2</h1>
                    <hr></br></br>

                    <div class="input-field col s5">
                        <select name="estado2" onchange="this.form.submit()">
                            <option>SELECIONE</option>
                            <c:forEach var="estado" items="${estados}">
                                <option ${estado2==estado?'selected':''}>${estado}</option>
                            </c:forEach>
                        </select>
                        <label>Estado</label>
                    </div>
                    <div class="input-field col s5">
                        <select name="cidade2" onchange="this.form.submit()" >
                            <option>SELECIONE</option>
                            <c:forEach var="cidade" items="${nomeCidades2}">
                                <option ${cidadeNome2==cidade?'selected':''}>${cidade}</option>
                            </c:forEach>
                        </select>
                        <label>Cidade</label>
                    </div>

                </div>

                <!-- Mostrar os dados -->
                <div class="row" id="esquerdo">
                    <div class="row">
                        <div class="input-field col s9">
                            <input disabled value="" id="populacao" type="text" class="validate">
                            <label for="disabled">População: ${cidade1.getPopulacao()}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s9">
                            <input disabled value="" id="densidade" type="text" class="validate">
                            <label for="disabled">Densidade demográfica: ${cidade1.getDensidade_demo()} hab/Km²</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s9">
                            <input disabled value="" id="area" type="text" class="validate">
                            <label for="disabled">Área: ${cidade1.getArea()} km²</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s9">
                            <input disabled value="" id="perimetro" type="text" class="validate">
                            <label for="disabled">Perímetro: ${cidade1.getPerimetro()} km</label>
                        </div>
                    </div>
                </div>

                <div class="row" id="direito">
                    <div class="row">
                        <div class="input-field col s9">
                            <input disabled value="" id="populacao" type="text" class="validate">
                            <label for="disabled">População: ${cidade2.getPopulacao()}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s9">
                            <input disabled value="" id="densidade" type="text" class="validate">
                            <label for="disabled">Densidade demográfica: ${cidade2.getDensidade_demo()} hab/Km²</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s9">
                            <input disabled value="" id="area" type="text" class="validate">
                            <label for="disabled">Área: ${cidade2.getArea()} km²</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s9">
                            <input disabled value="" id="perimetro" type="text" class="validate">
                            <label for="disabled">Perímetro: ${cidade2.getPerimetro()} km</label>
                        </div>
                    </div>
                </div>
                <br/>

                <div class="divDown">
                    <label>Distância Aproximada: ${distancia} km </label><br>
                    <center>
                        <div id=svg>
                            <svg viewBox="${viewBox}" width="581" height="200">
                            <path d="${cidade1.getSvg()}" stroke="black" stroke-width="0.005" fill="orange" fill-opacity=""/>
                            <path d="${cidade2.getSvg()}" stroke="black" stroke-width="0.005" fill="violet" fill-opacity=""/>
                            </svg>
                        </div>

                    </form>
                </div>        
                </body>

                </html>