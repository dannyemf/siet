<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Proyectos
    Created on : 16/10/2010, 09:21:17 PM
    Author     : LENIN
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>
                    Ministerio de Desarrollo Urbano y Vivienda "MIDUVI" - Servicio ClienteWeb [Proyectos]
                </title>
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height: 100%; left: 0px; top: 0px; position: absolute; width: 100%">
                        <ice:panelLayout id="pane1" style="border-width: 0px; border-style: dotted; background-color: #999999; height: 100%; left: 0px; top: 0%; position: absolute; width: 10%"/>
                        <ice:panelLayout id="panecabeza" style="border-width: 0px; border-style: dotted; height: 25%; left: 10%; top: 0%; position: absolute; width:80%">
                            <ice:graphicImage height="100%" id="graphicImage1" url="/resources/cabeza_1.jpg" value="/resources/cabeza_1.jpg" width="100%"/>
                        </ice:panelLayout>
                        <ice:panelLayout id="panecuerpo" style="border: 1px solid rgb(0, 51, 51); height: 75%; left: 10%; top: 25%; position: absolute; width: 80%">
                            <ice:panelLayout id="panelLayout2" style="border-width: 1px; border-style: solid; border-color: rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0); background-color: rgb(48, 67, 87); height: 100%; position: absolute; width: 25%">
                                <ice:commandButton action="#{Proyectos.btnCerrar_action}" id="btnCerrar" image="/resources/salir1ok.png"
                                    style="height: 38px; left: 20%; top: 150px; position: absolute; text-align: center; width: 60%" value="Cerrar Sesion"/>
                            </ice:panelLayout>
                            <div align="center">
                                <ice:outputText id="outputText1"
                                    style="font-weight: bold; left: 25%; top: 20px; position: absolute; text-align: center; width: 75%" value="PROYECTOS DE VIVIENDA"/>
                            </div>
                            <ice:panelLayout id="panelLayout55" style="border: 0px solid rgb(0, 0, 0); height: 80%; left: 30%; top: 45px; position: absolute; width: 65%">
                                <div align="center" style="overflow:auto; width:auto; height:260px">
                                    <!--
                                    <ice:commandButton actionListener="#{Proyectos.btn_refreshAction}" styleClass="btnR" id="buttonRefresh" style="position: relative; top: 10px;" value=""/>
                                    -->
                                    <ice:dataTable headerClass="list-header" id="dataTableProyectos" rowClasses="list-row-even,list-row-odd"
                                        style=" top: 30px; position: relative" value="#{Proyectos.proyectos}" var="p">
                                        <ice:column id="colComandos">
                                            <ice:commandLink action="#{Proyectos.lnkVer_action}" id="lnkVer" value="Ver"/>
                                            <f:facet name="header">
                                                <ice:outputText value=""/>
                                            </f:facet>
                                        </ice:column>
                                        <ice:column>
                                            <ice:outputText value="#{p.id}"/>
                                            <f:facet name="header">
                                                <ice:outputText value="id"/>
                                            </f:facet>
                                        </ice:column>
                                        <ice:column>
                                            <ice:outputText value="#{p.ubicacion}"/>
                                            <f:facet name="header">
                                                <ice:outputText value="Ubicacion"/>
                                            </f:facet>
                                        </ice:column>
                                        <ice:column>
                                            <ice:outputText value="#{p.tipoVivienda.presupuesto}"/>
                                            <f:facet name="header">
                                                <ice:outputText value="Presupuesto"/>
                                            </f:facet>
                                        </ice:column>
                                        <ice:column>
                                            <ice:outputText value="#{p.estado}"/>
                                            <f:facet name="header">
                                                <ice:outputText value="Estado"/>
                                            </f:facet>
                                        </ice:column>
                                        <ice:column>
                                            <ice:outputText value="#{p.avance}"/>
                                            <f:facet name="header">
                                                <ice:outputText value="Avance %"/>
                                            </f:facet>
                                        </ice:column>
                                        <ice:column>
                                            <ice:outputText value="#{p.propietario.nombre} #{p.propietario.apellido}"/>
                                            <f:facet name="header">
                                                <ice:outputText value="Propietario"/>
                                            </f:facet>
                                        </ice:column>
                                        <ice:column>
                                            <ice:outputText value="#{p.propietario.ci}"/>
                                            <f:facet name="header">
                                                <ice:outputText value="Ci"/>
                                            </f:facet>
                                        </ice:column>
                                        <ice:column>
                                            <ice:outputText value="#{p.propietario.sexo}"/>
                                            <f:facet name="header">
                                                <ice:outputText value="Sexo"/>
                                            </f:facet>
                                        </ice:column>
                                        <ice:column>
                                            <ice:outputText value="#{p.propietario.estadoCivil}"/>
                                            <f:facet name="header">
                                                <ice:outputText value="Estado Civil"/>
                                            </f:facet>
                                        </ice:column>
                                        <ice:column>
                                            <ice:outputText value="#{p.propietario.direccion}"/>
                                            <f:facet name="header">
                                                <ice:outputText value="Direccion"/>
                                            </f:facet>
                                        </ice:column>
                                    </ice:dataTable>
                                </div>
                            </ice:panelLayout>
                        </ice:panelLayout>
                    </ice:panelLayout>
                    <ice:panelLayout id="pane1b" style="border-width: 0px; border-style: dotted; background-color: #999999; height: 100%; left: 90%; top: 0%; position: absolute; width: 10%"/>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
