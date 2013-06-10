<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : PaginaResultadoProyectoCli
    Created on : 19/10/2010, 10:31:46 PM
    Author     : LENIN 
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/xp/xp.css" id="outputStyle2"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height: 100%; left: 0px; top: 0%; position: absolute; width:100%">
                        <div align="center">
                            <ice:panelLayout id="panecabeza" style="border-width: 0px; border-style: dotted; height: 25%; top: 0%; position: relative; width:960px">
                                <ice:graphicImage height="100px" id="graphicImage1" value="/resources/cabeza.jpg" width="960px"/>
                            </ice:panelLayout>
                        </div>
                        <div align="center">
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid #003333; height: 470px; top: 5px; position: relative; width: 960px">
                                <ice:outputText id="outputText1" style="height: 18px; left: 50%; top: 120px; position: absolute; width: 288px" value="#{PaginaResultadoProyectoCli.proyecto.estado}"/>
                                <ice:outputText id="outputText2"
                                    style="font-weight: bold; height: 18px; left: 15%; top: 120px; position: absolute; width: 166px" value="Estado del proyecto :"/>
                                <ice:outputText id="outputText3" style="left: 30%; top: 48px; position: absolute; width: 550px" value="#{PaginaResultadoProyectoCli.servicioCliente.clienteLogeado.nombre} #{PaginaResultadoProyectoCli.servicioCliente.clienteLogeado.apellido}"/>
                                <ice:commandButton action="#{PaginaResultadoProyectoCli.btnvolver_action}" id="btnvolver" image="/resources/btnVolver.png"
                                    style="border-width: 1px; height: 48px; left: 15%; top: 336px; position: absolute; width: 166px" value="VOLVER"/>
                                <ice:outputText id="outputText4"
                                    style="font-size: 18px; font-style: oblique; font-weight: bold; left: 15%; top: 48px; position: absolute" value="Bienvenido:"/>
                            </ice:panelLayout>
                        </div>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
