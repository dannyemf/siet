<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : AdministrarTiposVivienda
    Created on : 11/09/2010, 12:13:02 PM
    Author     : Principal
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="html1">
            <head id="head1" title="Siet - Administrar Tipos de Vivienda">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
            </head>
            <body id="body1">
                <ice:form id="form1">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height: 100%; left: 0px; top: 0px; position: absolute; width: 100%">
                        <div align="center">
                            <ice:panelLayout id="panecabeza" style="border-width: 0px; border-style: dotted; height: 100px; left: 0%; top: 0%; position: relative; width: 960px">
                                <ice:graphicImage height="100%" id="graphicImage1" value="/resources/cabeza.jpg" width="100%"/>
                            </ice:panelLayout>
                        </div>
                        <div align="center">
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid rgb(0, 51, 51); height: 470px; left: 0%; top: 5px; position: relative; width: 960px">
                                <ice:panelLayout id="panelLayout2" style="border: 1px solid rgb(0, 0, 0); background-color: rgb(48, 67, 87); height: 100%; position: absolute; width: 20%">
                                    <ice:commandButton action="#{AdministrarTiposVivienda.btntipovivienda_action}" id="btntipovivienda"
                                        image="/resources/nuevotipoV.png" style="height: 37px; left: 15%; top: 100px; position: absolute; width: 70%" value="Nuevo Tipo de Vivienda"/>
                                    <ice:commandButton action="#{AdministrarTiposVivienda.btnvolver_action}" id="btnvolver" image="/resources/volverok.png"
                                        style="height: 38px; left: 15%; top: 150px; position: absolute; text-align: center; width: 70%" value="volver"/>
                                </ice:panelLayout>
                                <div align="center">
                                    <ice:outputLabel id="label1"
                                        style="font-size: 18px; left: 20%; top: 30px; position: absolute; text-align: center; width: 765px" value="TIPOS DE VIVIENDA"/>
                                </div>
                                <ice:panelLayout id="panelLayout55" style="border: 0px solid rgb(0, 0, 0); height: 80%; left: 21%; top: 70px; position: absolute; width: 78%">
                                    <div align="center" style="overflow:auto; width:auto; height:300px">
                                        <ice:dataTable headerClass="list-header" id="dataTable1" rowClasses="list-row-even,list-row-odd"
                                            style="position: relative; text-align: center; width: 100%" value="#{AdministrarTiposVivienda.listaTiposVivienda}" var="tp">
                                            <h:column id="column2">
                                                <h:outputText id="outputText3" value="#{tp.tipo}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText4" value="Tipo"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column12">
                                                <h:outputText id="outputText25" value="#{tp.area}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText26" value="Area m²"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column11">
                                                <h:outputText id="outputText23" value="#{tp.presupuesto}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText24" style="font-size: 10px" value="Presupuesto"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column3">
                                                <h:outputText id="outputText5" value="#{tp.estructura}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText6" style="font-size: 10px" value="Estructura"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column4">
                                                <h:outputText id="outputText7" value="#{tp.cubierta}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText8" style="font-size: 10px" value="Cubierta"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column5">
                                                <h:outputText id="outputText9" value="#{tp.piso}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText10" value="Piso"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column7">
                                                <h:outputText id="outputText13" value="#{tp.puertas}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText14" style="font-size: 10px" value="Puertas"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column8">
                                                <h:outputText id="outputText15" value="#{tp.ventanas}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText16" style="font-size: 10px" value="Ventanas"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column9">
                                                <h:outputText id="outputText19" value="#{tp.revestido}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText20" style="font-size: 10px" value="Revestido"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column1">
                                                <ice:commandLink action="#{AdministrarTiposVivienda.cmdLnkEditar_action}" id="cmdLnkEditar"
                                                    style="color: #003333; text-decoration: underline" value="Editar"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText2" style="font-size: 10px" value="ACCIÓN"/>
                                                </f:facet>
                                            </h:column>
                                        </ice:dataTable>
                                    </div>
                                </ice:panelLayout>
                            </ice:panelLayout>
                        </div>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
