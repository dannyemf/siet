<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : GenerarReporte
    Created on : 20/10/2010, 11:00:45 PM
    Author     : LENIN 
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>                
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height: 100%; left: 0px; top: 0px; position: relative; width: 100%">
                        <div align="center">
                            <ice:panelLayout id="panecabeza" style="border-width: 0px; border-style: dotted; height: 100px; position: relative; width: 960px">
                                <ice:graphicImage height="100%" id="graphicImage1" value="/resources/cabeza.jpg" width="100%"/>
                            </ice:panelLayout>
                        </div>
                        <div align="center">
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid rgb(0, 51, 51); height: 470px; top: 5px; position: relative; width: 960px">
                                <ice:panelLayout id="panelLayout2" style="border-width: 1px; border-style: solid; border-color: rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0); background-color: rgb(48, 67, 87); height: 100%; position: absolute; width: 25%">
                                    <ice:commandButton action="#{GenerarReporte.btnsalir_action}" id="btnsalir" image="/resources/volverok.png"
                                        style="height: 38px; left: 20%; top: 150px; position: absolute; text-align: center; width: 60%" value="Salir"/>
                                </ice:panelLayout>
                                <div align="center">
                                    <ice:outputLabel id="label12"
                                        style="color: black; font-size: 18px; font-weight: bold; left: 25%; top: 30px; position: absolute; text-align: center; width: 719px" value="OPCIONES DE REPORTES"/>
                                </div>
                                <ice:panelLayout id="panelLayout55" style="border: 0px solid rgb(0, 0, 0); height: 35%; left: 30%; top: 70px; position: absolute; width: 65%">
                                    <div align="center">
                                        <ice:outputResource attachment="false" fileName="ReporteProyectosAprobados.pdf" label="Proyectos Aprobados"
                                            mimeType="application/pdf" resource="#{GenerarReporte.recProysAprobados}"
                                            style="top: 200px; height:30px; width:200px" type="button"/>
                                        <ice:outputResource attachment="false" fileName="ReporteProyectosRechazados.pdf" label="Proyectos Rechazados"
                                            mimeType="application/pdf" resource="#{GenerarReporte.recProysRechazados}"
                                            style="top: 250px; height:30px; width:200px" type="button"/>
                                    </div>
                                </ice:panelLayout>

                                 <ice:panelGrid columns="2" styleClass="panelAyuda panelAyudaOneButton">
                                            <ice:commandButton id="btnAyuda" image="/resources/help_button.png" immediate="true" actionListener="#{ServicioAyuda.showPopup}" value="Ayuda"
                                            title="Ayuda reportes"/>
                                </ice:panelGrid>

                            </ice:panelLayout>

                            <!-- Panel Popup Ayuda -->
                            <ice:panelPopup autoCentre="true" draggable="true" id="modalPnlPop" modal="true" styleClass="corePopup" visible="#{ServicioAyuda.visiblePopup}">
                                <f:facet name="header">
                                    <ice:panelGroup styleClass="popupHeaderWrapper">
                                        <ice:outputText styleClass="popupHeaderText" value="Ayuda - Reportes"/>
                                        <ice:commandButton actionListener="#{ServicioAyuda.closePopup}" alt="Cerrar" id="modalPnlCloseBtn"
                                            image="/resources/popupclose.gif" styleClass="popupHeaderImage" title="Cerrar" type="button"/>
                                    </ice:panelGroup>
                                </f:facet>
                                <f:facet name="body">
                                    <ice:panelGroup styleClass="popupBody" style="width: 500px">
                                        <p><b>Reportes</b></p>

                                        <p>En esta sección se lista los reportes disponibles:</p>

                                        <ol>
                                            <li><b>Proyectos aprobados.- </b> Son todos los trámites de los clientes con un visto bueno</li>
                                            <li><b> Proyectos rechazados.- </b>Son todos los trámites que no han cumplido los requerimientos</li>
                                        </ol>

                                        <center>
                                            <ice:commandButton actionListener="#{ServicioAyuda.closePopup}" immediate="true" partialSubmit="true" id="modalPnlCloseButton" value="Cerrar"></ice:commandButton>
                                        </center>
                                    </ice:panelGroup>
                                </f:facet>
                            </ice:panelPopup>
                        </div>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
