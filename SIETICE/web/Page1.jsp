<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Meta
    Created on : 14/12/2010, 05:13:51 PM
    Author     : LENIN
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/xp/xp.css" id="outputStyle2"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1" style="">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; background-position: 100%,50%; height: 100%; left: 0px; top: 0px; position: absolute; width: 100%">
                        <div align="center">
                            <ice:panelLayout id="panecabeza" style="border-width: 0px; border-style: dotted; background-position: center; height: 100px; top: 0%; position: relative; width: 960px">
                                <ice:graphicImage height="100%" id="graphicImage1" value="/resources/cabeza.jpg" width="100%"/>
                            </ice:panelLayout>&gt;

                        </div>
                        <div align="center">
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid rgb(0, 102, 102); height: 470px; top: 5px; position: relative; width: 960px">
                                <ice:commandButton action="#{Meta.btn_volver_action}" id="btn_volver" image="/resources/btnVolver.png"
                                    style="height: 48px; left: 24px; top: 168px; position: absolute; width: 144px" value="VOLVER"/>
                                <ice:outputLabel id="label1" style="height: 90px; left: 216px; top: 144px; position: absolute; width: 454px" value="La construcción y  ampliación de soluciones habitacionales  dignos y seguros dirigido a los estratos sociales de recursos econónicos medios y bajos con la utilización del bono de la vivienda que ofrece el Ministerio de Desarrollo Urbano y Vivienda (MIDUVI)"/>
                                <ice:outputLabel id="label2" style="font-style: italic; font-weight: bold; left: 216px; top: 96px; position: absolute" value="Misión"/>
                                <ice:outputLabel id="label3" style="font-style: italic; font-weight: bold; left: 216px; top: 264px; position: absolute" value="Visión"/>
                                <ice:outputLabel id="label4" style="height: 66px; left: 216px; top: 312px; position: absolute; width: 454px" value="La Entidad Técnica &quot;Su Casa Propia&quot; es una Institución Particular d  edicada a la construcción de "/>
                                <ice:outputLabel id="label5"
                                    style="background-color: rgb(0, 0, 0); color: rgb(255, 255, 255); font-size: 18px; font-style: italic; font-weight: bold; left: 216px; top: 48px; position: absolute; text-align: center; width: 453px" value="Misión y Visión"/>
                            </ice:panelLayout>
                        </div>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
