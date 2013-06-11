<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Registrarcliente
    Created on : 01/06/2010, 10:58:39 PM
    Author     : Administrator
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="html1">
            <head id="head1" title="SIET - EDITAR PROYECTO">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
                <script id="script-entrada" language="javascript" src="./js/Entrada.js"></script>
            </head>
            <body id="body1" style="-rave-layout: grid">                
                <ice:form id="form1">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height: 100%; position: absolute; width: 100%">
                        <div align="center">
                            <ice:panelLayout id="panecabeza" style="border-width: 0px; border-style: dotted; height: 100px; left: 0%; top: 0%; position: relative; width:960px">
                            <ice:graphicImage height="100%" id="graphicImage1" value="/resources/cabeza.jpg" width="100%"/>
                        </ice:panelLayout>
                        </div>
                        <div align="center">
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid #003333; height: 470px; left: 0%; top: 5px; position: relative; width: 960px">
                            <ice:outputLabel id="label6" style="height: 24px; left: 72px; top: 216px; position: absolute" value="Estado ( * )"/>
                            <ice:outputLabel id="label7" style="left: 72px; top: 264px; position: absolute" value="Máximo Clientes( * )"/>
                            <ice:inputText id="txtubicacion" style="left: 214px; top: 94px; position: absolute; width: 383px" value="#{EditarProyecto.proyecto.nombre}" required="true"/>
                            <ice:commandButton action="#{EditarProyecto.btnaceptar_action}" id="btnaceptar" image="/resources/btnAceptar.png"
                                style="height: 45px; left: 456px; top: 384px; position: absolute; width: 168px" value="Aceptar"/>
                            <ice:outputLabel id="label8"
                                style="background-color: rgb(255, 255, 255); color: rgb(0, 51, 51); left: 0px; top: 24px; position: absolute; text-align: center; width: 100%" value=" DATOS DE LA OBRA EN EDICIÓN"/>
                            <ice:outputLabel id="label15" style="left: 72px; top: 144px; position: absolute" value="Descripción ( * )"/>
                            <ice:commandButton immediate="true" action="#{EditarProyecto.btncancelar_action}" id="btncancelar" image="/resources/btnVolver2.png"
                                partialSubmit="true" style="height: 48px; left: 72px; top: 384px; position: absolute; width: 166px" value="CANCELAR"/>
                            <ice:outputText id="outputText3" style="font-weight: bold; left: 72px; top: 96px; position: absolute" value="Nombre ( * )"/>
                            <ice:inputTextarea id="inputTextarea1" style="left: 214px; top: 142px; position: absolute; width: 383px" value="#{EditarProyecto.proyecto.descripcion}"/>
                            <ice:selectBooleanCheckbox id="selectBooleanCheckbox1" partialSubmit="true" style="left: 214px; top: 216px; position: absolute" value="#{EditarProyecto.proyecto.estado}"/>
                            <ice:inputText id="txtubicacion1" style="left: 214px; top: 262px; position: absolute; width: 143px" value="#{EditarProyecto.proyecto.maximoClientes}"/>
                            <ice:outputLabel id="label1" style="left: 72px; top: 312px; position: absolute" value="Jefe Proyecto( * )"/>
                            <ice:selectOneMenu id="selectOneMenu1" partialSubmit="true" style="left: 214px; top: 310px; position: absolute; width: 143px" value="#{EditarProyecto.idEmpleado}">
                                <f:selectItems id="selectOneMenu1selectItems" value="#{EditarProyecto.itemsEmpleados}"/>
                                <f:converter converterId="javax.faces.Long"/>
                            </ice:selectOneMenu>

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
                                    <p><b>Proyecto</b></p>

                                    <p>Por favor ingrese toda la información requerida</p>

                                    <ul>
                                        <li><b>Nombre.- </b>Es el nombre del proyecto por ejemplo: Ciudad Alegría</li>
                                        <li><b>Descripción.- </b>Por ejemplo en donde está ubicado</li>
                                        <li><b>Estado.- </b>Si el proyecto está vigente o ono vigente</li>
                                        <li><b>Máximo clientes.- </b>Número máximo de clientes que pueden acceder a este proyecto</li>
                                        <li><b>Jefe proyecto.- </b>Persona encargada del proyecto</li>
                                    </ul>

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
