<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : TipoVivienda
    Created on : 12/06/2010, 01:06:16 PM
    Author     : Administrator
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="html1">
            <head id="head1" title="SIET - SELECCION DE TIPO DE VIVIENDA">
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>                
                <script id="script-entrada" language="javascript" src="./js/Entrada.js"></script>
            </head>
            <body id="body1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height: 800px; left: 0%; top: 0%; position: absolute; width: 100%">
                        <div align="center">
                            <ice:panelLayout id="panecabeza" style="border-width: 0px; border-style: dotted; height: 100px; left: 0px; top: 0%; position: relative; width: 960px">
                                <ice:graphicImage height="100%" id="graphicImage1" value="/resources/cabeza.jpg" width="100%"/>
                            </ice:panelLayout>
                        </div>
                        <div align="center">
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid rgb(0, 51, 51); height: 750px; left: 0%; top: 5px; position: relative; width: 960px; -rave-layout: grid;">
                                <ice:outputLabel id="label1" style="font-size: 18px; left: 0px; top: 0px; position: absolute; text-align: center; width: 100%" value="SELECCIÓN DE TIPO DE VIVIENDA"/>
                                <ice:outputLabel id="label2" style="left: 15%; top: 144px; position: absolute" value="ESPECIFICACIONES TÉCNICAS"/>
                                <ice:outputLabel id="label3" style="left: 15%; top: 96px; position: absolute" value="VIVIENDA TIPO"/>
                                <ice:outputLabel id="label43" style="left: 15%; top: 528px; position: absolute" value="Ingrese la Ubicación de su terreno"/>
                                <ice:selectOneMenu id="somTipoVivienda" immediate="true" partialSubmit="true" required="true"
                                    style="height: 24px; left: 15%; top: 118px; position: absolute; width: 143px" value="#{TipoVivienda.tipo}" valueChangeListener="#{TipoVivienda.somTipoVivienda_processValueChange}">
                                    <f:selectItems id="selectOneMenu1selectItems" value="#{TipoVivienda.tiposVivienda}"/>
                                </ice:selectOneMenu>
                                <ice:outputLabel id="staticText1" style="height: 24px; left: 15%; top: 312px; position: absolute; width: 96px" value="Estructura :"/>
                                <ice:outputLabel id="staticText2" style="height: 24px; left: 15%; top: 336px; position: absolute; width: 96px" value="Cubierta :"/>
                                <ice:outputStyle href="resources/stylesheet.css" id="outputStyle3"/>
                                <ice:outputText id="outputestructura" style="left: 30%; top: 312px; position: absolute; width: 15%" value="#{TipoVivienda.currenTipoVivienda.estructura}"/>
                                <ice:outputText id="outputcubierta" style="left: 30%; top: 336px; position: absolute; width: 15%" value="#{TipoVivienda.currenTipoVivienda.cubierta}"/>
                                <ice:outputLabel id="staticText3" style="height: 24px; left: 15%; top: 360px; position: absolute; width: 96px" value="Piso :"/>
                                <ice:outputLabel id="staticText4" style="height: 24px; left: 15%; top: 384px; position: absolute; width: 96px" value="Cielo Razo :"/>
                                <ice:outputLabel id="staticText5" style="height: 24px; left: 15%; top: 408px; position: absolute; width: 96px" value="Puertas :"/>
                                <ice:inputTextarea id="textArea1" required="true"
                                    style="font-size: 14px; height: 47px; left: 15%; top: 574px; position: absolute; width: 287px" value="#{TipoVivienda.servicioProyecto.proyectoClienteEdicion.ubicacion}"/>
                                <ice:outputLabel id="staticText6" style="height: 24px; left: 15%; top: 432px; position: absolute; width: 96px" value="Ventanas :"/>
                                <ice:outputLabel id="staticText7" style="height: 24px; left: 15%; top: 456px; position: absolute; width: 96px" value="Paredes :"/>
                                <ice:outputLabel id="staticText8" style="height: 24px; left: 15%; top: 480px; position: absolute; width: 118px" value="Revestido : "/>
                                <ice:inputTextarea id="inputTextAmbientes" readonly="true"
                                    style="height: 47px; left: 15%; top: 262px; position: absolute; width: 286px" value="#{TipoVivienda.currenTipoVivienda.ambientes}"/>
                                <ice:outputText id="outputpiso" style="left: 30%; top: 360px; position: absolute; width: 15%" value="#{TipoVivienda.currenTipoVivienda.piso}"/>
                                <ice:outputText id="outputcielorazo" style="left: 30%; top: 384px; position: absolute; width: 15%" value="#{TipoVivienda.currenTipoVivienda.cielorazo}"/>
                                <ice:outputText id="outputpuertas" style="left: 30%; top: 408px; position: absolute; width: 15%" value="#{TipoVivienda.currenTipoVivienda.puertas}"/>
                                <ice:outputText id="outputventanas" style="left: 30%; top: 432px; position: absolute; width: 262px" value="#{TipoVivienda.currenTipoVivienda.ventanas}"/>
                                <ice:outputText id="outpuparedes" style="left: 30%; top: 456px; position: absolute; width: 262px" value="#{TipoVivienda.currenTipoVivienda.paredes}"/>
                                <ice:outputText id="outputarea" style="left: 30%; top: 192px; position: absolute; width: 70px" value="#{TipoVivienda.currenTipoVivienda.area}"/>
                                <!--ice:inputTextarea id="textAmbientes" style="font-size: 14px; left: 22px; top: 430px; position: absolute; width: 312px" value="{TipoVivienda.currenTipoVivienda.ambientes}"/-->
                                <ice:outputLabel id="staticText9" style="height: 24px; left: 15%; top: 192px; position: absolute; width: 96px" value="Área :"/>
                                <ice:outputLabel id="staticText10" style="height: 24px; left: 15%; top: 240px; position: absolute; width: 96px" value="Ambientes :"/>
                                <ice:outputLabel id="staticText12" style="height: 24px; left: 15%; top: 216px; position: absolute; width: 118px" value="Presupuesto : "/>
                                <ice:outputText id="outputrevestido" style="left: 30%; top: 480px; position: absolute; width: 15%" value="#{TipoVivienda.currenTipoVivienda.revestido}"/>
                                <ice:inputText id="inputText2" readonly="true" style="height: 24px; left: 30%; top: 214px; position: absolute; width: 120px" value="#{TipoVivienda.currenTipoVivienda.presupuesto}"/>
                                <ice:graphicImage alt="Plano no encontrado..." height="669" id="graphicImage11"
                                    style="color: rgb(255, 0, 0); font-weight: bold; height: 650px; left: 504px; top: 66px; position: absolute"
                                    value="#{TipoVivienda.plano}" width="381"/>
                                <ice:message for="textArea1" id="message1" showSummary="true" style="color: rgb(255, 0, 0); left: 15%; top: 624px; position: absolute; width: 213px"/>
                                <ice:commandButton action="#{TipoVivienda.btnvolver_action}" id="btnvolver" image="/resources/btnVolver.png" immediate="true"
                                    style="height: 48px; left: 15%; top: 650px; position: absolute; width: 15%" value="VOLVER"/>
                                <ice:commandButton action="#{TipoVivienda.btnaceptarvivienda_action}" id="btnaceptarvivienda" image="/resources/btnAceptar.png"
                                    style="height: 48px; left: 288px; top: 650px; position: absolute; width: 15%" value="ACEPTAR"/>
                                <ice:outputLabel id="label4" style="left: 15%; top: 48px; position: absolute" value="SELECCIONAR PROYECTO"/>
                                <ice:selectOneMenu id="somProyecto" immediate="true" partialSubmit="true" required="true"
                                    style="height: 24px; left: 15%; top: 70px; position: absolute; width: 143px" value="#{TipoVivienda.proyecto}" valueChangeListener="#{TipoVivienda.somProyecto_processValueChange}">
                                    <f:selectItems id="selectOneMenu2selectItems" value="#{TipoVivienda.proyectos}"/>
                                </ice:selectOneMenu>
                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="somProyecto" id="message2" infoClass="infoMessage"
                                    style="height: 20px; left: 304px; top: 72px; position: absolute; width: 181px" warnClass="warnMessage"/>
                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="somTipoVivienda" id="message3" infoClass="infoMessage"
                                    style="position: absolute; left: 304px; top: 120px; width: 184px; height: 24px;" warnClass="warnMessage"/>
                                <ice:panelGrid columns="2" styleClass="panelAyuda">
                                    <ice:commandButton actionListener="#{ServicioAyuda.showPopup}" id="btnAyuda" image="/resources/help_button.png"
                                        immediate="true" title="Ayuda tipo vivienda" value="Ayuda"/>
                                    <div title="Manual de usuario (pdf)">
                                        <ice:outputResource attachment="false" fileName="ayuda.pdf" id="orAyuda" image="/resources/helppdf_button.png"
                                            label="Ayuda" mimeType="application/pdf" resource="#{LoginCliente.recursoAyuda}" shared="true"/>
                                    </div>
                                </ice:panelGrid>
                            </ice:panelLayout>

                            <!-- Panel Popup Ayuda -->
                            <ice:panelPopup autoCentre="true" draggable="true" id="modalPnlPop" modal="true" styleClass="corePopup" visible="#{ServicioAyuda.visiblePopup}">
                                <f:facet name="header">
                                    <ice:panelGroup styleClass="popupHeaderWrapper">
                                        <ice:outputText styleClass="popupHeaderText" value="Ayuda - Tipo vivienda"/>
                                        <ice:commandButton immediate="true" actionListener="#{ServicioAyuda.closePopup}" alt="Cerrar" id="modalPnlCloseBtn"
                                            image="/resources/popupclose.gif" styleClass="popupHeaderImage" title="Cerrar" type="button"/>
                                    </ice:panelGroup>
                                </f:facet>
                                <f:facet name="body">
                                    <ice:panelGroup style="width: 400px" styleClass="popupBody">
                                        <p>
                                            <b>Tipo de vivienda</b>
                                        </p>
                                        <p>En ésta página usted puede seleccionar el tipo de vivienda que mejor se adapte a sus necesidades, para lo cual siga los pasos:</p>
                                        <br/>
                                        <ul>
                                            <li>Seleccione el proyecto habitacional</li>
                                            <li>Seleccione el tipo de vivienda</li>
                                            <li>Ingrese la ubicación de su terreo (Dirección)</li>
                                            <li>Verifique las especificaciones técnicas y el plano</li>
                                            <li>Presione aceptar para guardar los cambios</li>
                                        </ul>
                                        <center>
                                            <ice:commandButton actionListener="#{ServicioAyuda.closePopup}" id="modalPnlCloseButton" immediate="true" type="submit" value="Cerrar"/>
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
