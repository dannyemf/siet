<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : 16/10/2010, 09:11:16 PM
    Author     : LENIN
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>
                    Ministerio de Desarrollo Urbano y Vivienda "MIDUVI" - Servicio ClienteWeb
                </title>
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/xp/xp.css" id="outputStyle2"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height: 100%; left: 0px; top: 0%; position: absolute; width:100%">
                        <ice:panelLayout id="pane1" style="border-width: 0px; border-style: dotted; background-color: #999999; height: 100%; left: 0px; top: 0%; position: absolute; width: 10%"/>
                        <ice:panelLayout id="panecabeza" style="border-width: 0px; border-style: dotted; height: 25%; left: 10%; top: 0%; position: absolute; width:97%">
                            <ice:graphicImage height="100%" id="graphicImage1" url="/resources/cabeza_1.jpg" value="/resources/cabeza_1.jpg" width="83%"/>
                        </ice:panelLayout>
                        <ice:panelLayout id="panecuerpo" style="border-width: 1px; border-style: double; border-color: rgb(0, 51, 51) rgb(0, 51, 51) rgb(0, 51, 51) rgb(0, 51, 51); height: 75%; left: 10%; top: 25%; position: absolute; width: 80%">
                            <ice:panelLayout id="panelLayout2" style="border: 1px solid rgb(0, 0, 0); background-color: #304357; height: 100%; left: 0px; top: 0px; position: absolute; width: 25%"/>
                            <ice:panelLayout id="panelLayout1" style="border-width: 1px; border-style: solid; border-color: rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0); background-color: rgb(255, 255, 255); height: 189px; left: 40%; top: 72px; position: absolute; width: 309px">
                                <ice:outputText id="outputText3"
                                    style="color: rgb(255, 0, 0); left: 0px; top: 96px; position: absolute; text-align: center; width: 100%" value="#{Inicio.mensaje}"/>
                                <ice:outputText id="outputText1" style="font-weight: bold; left: 48px; top: 24px; position: absolute; width: 72px" value="Usuario :"/>
                                <ice:inputText id="inputText1" style="height: 24px; left: 142px; top: 22px; position: absolute; width: 144px" value="#{Inicio.usuario}"/>
                                <ice:outputText id="outputText2" style="font-weight: bold; height: 18px; left: 48px; top: 72px; position: absolute; width: 72px" value="Clave :"/>
                                <ice:inputSecret id="inputSecret1" redisplay="true" action="#{Inicio.btnIngresar_action}"
                                    style="height: 24px; left: 142px; top: 70px; position: absolute; width: 142px" value="#{Inicio.clave}"/>
                                <ice:outputText id="outputText4"
                                    style="font-weight: bold; height: 18px; left: 0px; position: absolute; text-align: center; width: 100%" value="PERSONAL MIDUVI"/>
                                <ice:commandButton action="#{Inicio.btnIngresar_action}" id="btnIngresar" image="/resources/btnIngreso123.png"
                                    style="height: 48px; left: 96px; top: 120px; position: absolute; width: 144px" value="Ingresar"/>
                            </ice:panelLayout>
                        </ice:panelLayout>
                        <ice:panelLayout id="pane1b" style="border: 1px solid rgb(0, 51, 51); background-color: #999999; height: 100%; left: 90%; top: 0%; position: absolute; width: 10%"/>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
