<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : 09/10/2010, 11:24:40 AM
    Author     : LENIN
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
            </head>
            <body id="outputBody1" style="background-color: rgb(255, 255, 255); -rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height: 100%; left: 0px; top: 0%; position: absolute; width:100%">
                        <div align="center">
                            <ice:panelLayout id="panecabeza" style="border: 1px solid rgb(204, 204, 204); height: 100px; top: 0%; position: relative; width: 960px">
                                <ice:graphicImage height="100%" id="graphicImage1" style="height: 100px; width: 960px" value="/resources/cabeza.jpg" width="83%"/>
                            </ice:panelLayout>
                        </div>
                        <div align="center">
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid rgb(204, 204, 204); height: 470px; top: 5px; position: relative; width: 960px">
                                <ice:outputLabel id="label1"
                                    style="font-size: 20px; font-weight: bold; height: 20px; left: 0%; top: 20px; position: absolute; text-align: center; width: 100%" value="Nuestra Empresa:"/>
                                <ice:panelGrid id="gridPanel1"
                                    style="border: 2px solid black; margin: 4px; padding: 4px; height: 288px; left: 30%; top: 45px; position: absolute" width="40%">
                                    <ice:outputLabel id="label4" style="font-size: 12px; top: 60px" value="La Entidad Técnica &quot;Su Casa Propia&quot; es una empresa promotora de vivienda que atravez de Ministerio  de Desarrollo Urbano y Vivienda MIDUVI tiene como bjetivo primordial  ayudar aquellas personas quieran  acceder a una vivienda digna  y segura."/>
                                    <ice:graphicImage height="144" id="image2" style="left: 10%; width: 100%" value="/resources/casamiduvi.jpg" width="288"/>
                                </ice:panelGrid>
                                <ice:panelLayout id="panelLayout2" style="border-width: 1px; border-style: solid; border-color: rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0); background-color: rgb(48, 67, 87); height: 100%; left: 0px; top: 0px; position: absolute; width: 25%">
                                    <ice:outputLabel id="label2"
                                        style="color: rgb(255, 255, 255); font-size: 18px; left: 5%; top: 72px; position: absolute; text-align: center; width: 90%" value="OPCIONES"/>
                                    <ice:commandButton action="#{Inicio.btnclientes_action}" id="btnclientes" image="/resources/btnClientes_1.png"
                                        style="height: 46px; left: 5%; top: 110px; position: absolute; width: 90%" title="Sección para clientes" value="CLIENTES"/>
                                    <ice:commandButton action="#{Inicio.btnpersonaltec_action}" id="btnpersonaltec" image="/resources/btnPersonal.png"
                                        style="height: 46px; left: 5%; top: 170px; position: absolute; width: 90%" title="Sección para el personal técnico" value="PERSONAL TÉCNICO"/>
                                </ice:panelLayout>
                                <ice:panelLayout id="panelLayout3" style="border: 1px solid rgb(204, 204, 204); background-color: rgb(48, 67, 87); height: 100%; left: 75%; top: 0px; position: absolute; text-align: center; width: 25%">
                                    <ice:commandButton action="#{Inicio.btn_mision_action}" id="btn_mision" image="/resources/btn_mision.jpg"
                                        style="height: 75px; left: 5%; top: 110px; position: absolute; width: 90%" value="Mision"/>
                                    <ice:outputLabel id="label8"
                                        style="color: rgb(255, 255, 255); height: 42px; left: 0px; top: 220px; position: absolute; text-align: center; width: 100%" value="Dirección: Rocafuerte 14- 37entre Sucre y Bolivar"/>
                                    <ice:outputLabel id="label9"
                                        style="color: rgb(255, 255, 255); height: 22px; left: 0px; top: 270px; position: absolute; width: 100%" value="LOJA - ECUADOR"/>
                                    <ice:outputLabel id="label5"
                                        style="color: rgb(255, 255, 255); font-size: 18px; left: 5%; top: 72px; position: absolute; text-align: center; width: 85%" value="NUESTRA EMPRESA"/>
                                    <ice:outputLabel id="label6"
                                        style="border-style: double; background-color: #006666; color: rgb(255, 255, 255); font-size: 18px; left: 5%; top: 190px; position: absolute; text-align: center; width: 88%" value="CONTACTANOS"/>
                                    <ice:graphicImage id="graphicImage2" style="left: 35%; top: 296px; position: absolute" value="/resources/47mloop.gif"/>
                                </ice:panelLayout>
                            </ice:panelLayout>
                            <ice:outputStyle href="resources/stylesheet.css" id="outputStyle3"/>
                        </div>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
