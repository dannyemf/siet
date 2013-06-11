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
            <head id="head1" title="SIET - Administrar Proyectos">
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
                                <ice:panelLayout id="panelLayout2" style="border-width: 1px; border-style: solid; border-color: rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0); background-color: rgb(48, 67, 87); height: 100%; position: absolute; width: 25%">
                                    <ice:commandButton action="#{AdministrarProyecto.btnNuevo_action}" id="btnNuevo" image="/resources/nuevProyBl.png"
                                        style="height: 37px; left: 20%; top: 100px; position: absolute; width: 60%" value="Volver"/>
                                    <ice:commandButton action="#{AdministrarProyecto.btnvolver_action}" id="btnvolver" image="/resources/volverok.png"
                                        style="height: 38px; left: 20%; top: 150px; position: absolute; text-align: center; width: 60%" value="Volver"/>
                                </ice:panelLayout>
                                <div align="center">
                                    <ice:outputLabel id="label1"
                                        style="font-size: 18px; left: 25%; top: 30px; position: absolute; text-align: center; width: 717px" value="LISTA DE PROYECTOS"/>
                                </div>                                

                                <ice:panelLayout id="panelLayout55" style="border: 0px solid rgb(0, 0, 0); height: 75%; left: 30%; top: 70px; position: absolute; width: 65%">
                                    <div align="center" style="overflow:auto; width:auto; height:260px">
                                        <ice:dataTable headerClass="list-header" id="dataTable1" rowClasses="list-row-even,list-row-odd"
                                            style="left: 0px; top: 0px; position: relative; text-align: center; width: 100%"
                                            value="#{AdministrarProyecto.modelProyecto}" var="p">
                                            <h:column id="column2">
                                                <h:outputText id="outputText3" value="#{p.nombre}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText4" value="Nombre"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column3">
                                                <h:outputText id="outputText5" value="#{p.descripcion}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText6" value="Descripción"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column4">
                                                <h:outputText id="outputText7" value="#{p.estado}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText8" value="Estado"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column5">
                                                <h:outputText id="outputText9" value="#{p.maximoClientes}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText10" value="Max Clientes"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column11">
                                                <ice:panelGrid id="gridPanel1">
                                                    <ice:commandLink action="#{AdministrarProyecto.linkActionEditar_action}" id="linkActionEditar"
                                                        style="color: #003333; text-decoration: underline" value="Editar"/>
                                                </ice:panelGrid>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText15" value=" Editar"/>
                                                </f:facet>
                                            </h:column>
                                           
                                        </ice:dataTable>
                                    </div>                                    
                                
                                </ice:panelLayout>

                                <ice:panelGrid columns="2" styleClass="panelAyuda">
                                    <ice:commandButton actionListener="#{ServicioAyuda.showPopup}" id="btnAyuda" image="/resources/help_button.png"
                                        immediate="true" title="Ayuda" value="Ayuda"/>
                                    <div title="Manual de usuario (pdf)">
                                        <ice:outputResource attachment="false" fileName="ayuda.pdf" id="orAyuda" image="/resources/helppdf_button.png"
                                        label="Ayuda" mimeType="application/pdf" resource="#{PaginaAdministradorSistema.recursoAyuda}" shared="true"/>
                                    </div>
                                </ice:panelGrid>
                                
                            </ice:panelLayout>
                        </div>

                        <!-- Panel Popup Ayuda -->
                        <ice:panelPopup autoCentre="true" draggable="true" id="modalPnlPop" modal="true" styleClass="corePopup" visible="#{ServicioAyuda.visiblePopup}">
                            <f:facet name="header">
                                <ice:panelGroup styleClass="popupHeaderWrapper">
                                    <ice:outputText styleClass="popupHeaderText" value="Ayuda - Proyecto"/>
                                    <ice:commandButton actionListener="#{ServicioAyuda.closePopup}" alt="Cerrar" id="modalPnlCloseBtn"
                                        image="/resources/popupclose.gif" styleClass="popupHeaderImage" title="Cerrar" type="button"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup styleClass="popupBody" style="width: 400px">
                                    <p><b>Proyecto.- </b>Un proyecto es un conjunto habitacional en el que existen varios tipos de viviendas</p>

                                    <p>En ésta página se listan los proyectos (conjuntos habitacionales)</p>

                                    <p>También puede crear un nuevo proyecto o bien editar uno ya existente</p>

                                    <center>
                                        <ice:commandButton actionListener="#{ServicioAyuda.closePopup}" immediate="true" partialSubmit="true" id="modalPnlCloseButton" value="Cerrar"></ice:commandButton>
                                    </center>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
