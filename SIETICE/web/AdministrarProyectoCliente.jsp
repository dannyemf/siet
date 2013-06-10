<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Proyecto
    Created on : 15/06/2010, 03:39:42 PM
    Author     : Desarrollador
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="html1">
            <head id="head1" title="SIET - Administrar Proyecto-Cliente">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
            </head>
            <body id="body1">
                <ice:form id="form1">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height: 100%; left: 0px; top: 0px; position: absolute; width: 100%">
                        <div align="center">
                               <ice:panelLayout id="panecabeza" style="border-width: 0px; border-style: dotted; height: 100px; left: 0%; top: 0%; position: relative; width:960px">
                            <ice:graphicImage height="100%" id="graphicImage1" value="/resources/cabeza.jpg" width="100%"/>
                        </ice:panelLayout>
                        </div>
                        <div align="center">
                                    <ice:panelLayout id="panecuerpo" style="border: 1px solid rgb(0, 51, 51); height: 470px; left: 0%; top: 5px; position: relative; width: 960px">
                            <ice:panelLayout id="panelLayout2" style="border-width: 1px; border-style: solid; border-color: rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0); background-color: rgb(48, 67, 87); height: 100%; position: absolute; width: 25%">
                                <ice:outputLabel id="outputLabel1"
                                    style="color: rgb(255, 255, 255); top: 50px; position: absolute; text-align: center; left:0px; width: 100%" value="Buscar por PROYECTO"/>
                                <ice:selectOneMenu id="cmbProyectos" immediate="true" partialSubmit="true"
                                    style="margin: 2px; height: 30px; left: 20%; top: 70px; position: absolute; width: 60%"
                                    value="#{AdministrarProyectoCliente.idProyecto}" valueChangeListener="#{AdministrarProyectoCliente.cmbProyectos_processValueChange}">
                                    <f:selectItems id="selectOneMenu1selectItems" value="#{AdministrarProyectoCliente.itemsProyectos}"/>
                                </ice:selectOneMenu>
                                <ice:commandButton action="#{AdministrarProyectoCliente.btnvolver_action}" id="btnvolver" image="/resources/volverok.png"
                                    style="height: 38px; left: 20%; top: 150px; position: absolute; text-align: center; width: 60%" value="Volver"/>
                            </ice:panelLayout>
                            <div align="center">
                                <ice:outputLabel id="label1" style=" font-size: 18px; top: 30px; left:25%; position: absolute;  text-align: center;  width: 75%" value="LISTA DE OBRAS POR PROYECTO"/>
                            </div>
                            <ice:panelLayout id="panelLayout55" style="border-width: 0px; border-style: solid; border-color: rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0); height: 75%; left: 30%; top: 70px; position: absolute; width: 65%">
                                <div align="center" style="overflow:auto; width:auto; height:260px">
                                    <ice:dataTable headerClass="list-header" id="dataTable1" rowClasses="list-row-even,list-row-odd" style=" font-size: 12px; position: relative"
                                        value="#{AdministrarProyectoCliente.modelProyecto}" var="p">
                                        <h:column id="column1">
                                            <h:outputText id="outputText1" value="#{p.propietario.nombre} #{p.propietario.apellido} "/>
                                            <f:facet name="header">
                                                <h:outputText id="outputText2" value="Propietario" style="font-size: 10px;"/>
                                            </f:facet>
                                        </h:column>
                                        <h:column id="column2">
                                            <h:outputText id="outputText3" value="#{p.ubicacion}"/>
                                            <f:facet name="header">
                                                <h:outputText id="outputText4" value="Ubicación"/>
                                            </f:facet>
                                        </h:column>
                                        <h:column id="column3">
                                            <h:outputText id="outputText5" value="#{p.tipoVivienda.presupuesto}"/>
                                            <f:facet name="header">
                                                <h:outputText id="outputText6" value="Presupuesto"/>
                                            </f:facet>
                                        </h:column>
                                        <h:column id="column4">
                                            <h:outputText id="outputText7" value="#{p.estado}"/>
                                            <f:facet name="header">
                                                <h:outputText id="outputText8" value="Estado"/>
                                            </f:facet>
                                        </h:column>
                                        <h:column id="column5">
                                            <h:outputText id="outputText9" value="#{p.tipoVivienda.tipo}"/>
                                            <f:facet name="header">
                                                <h:outputText id="outputText10" value="Tipo"/>
                                            </f:facet>
                                        </h:column>
                                        <h:column id="column6">
                                            <h:outputText id="outputText11" value="#{p.residente.nombres} #{p.residente.apellido}"/>
                                            <f:facet name="header">
                                                <h:outputText id="outputText12" value="Residente"/>
                                            </f:facet>
                                        </h:column>
                                        <h:column id="column7">
                                            <h:outputText id="outputText13" value="#{p.avance}"/>
                                            <f:facet name="header">
                                                <h:outputText id="outputText14" value="Avance %"/>
                                            </f:facet>
                                        </h:column>
                                        <h:column id="column9">
                                            <h:outputText id="outputText17" value="#{p.fechaEntrega}"/>
                                            <f:facet name="header">
                                                <h:outputText id="outputText18" value="Fecha Entrega"/>
                                            </f:facet>
                                        </h:column>
                                        <h:column id="column10">
                                            <ice:panelGrid id="gridPanel1">
                                                <h:commandLink action="#{AdministrarProyectoCliente.linkActionEditar_action}" id="linkActionEditar"
                                                    style="color: #003333; text-decoration: underline" value="Editar"/>
                                            </ice:panelGrid>
                                            <f:facet name="header">
                                                <h:outputText id="outputText15" value="Editar"/>
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
