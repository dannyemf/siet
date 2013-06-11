<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : AdminstrarCliente
    Created on : 04/06/2010, 04:36:21 PM
    Author     : Administrator
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="html1">
            <head id="head1" title="SIET - ADMINISTRAR CLIENTE">
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
                                    <ice:outputLabel id="outputLabel1"
                                        style="color: rgb(255, 255, 255); left: 0px; top: 20px; position: absolute; text-align: center; width: 100%" value="Buscar por Apellido"/>
                                    <ice:commandButton action="#{AdminstrarCliente.btn_Buscar1_action}" id="btn_Buscar1" image="/resources/buscarwhite.png"
                                        style="height: 37px; left: 20%; top: 100px; position: absolute; width: 60%" value="BUSCAR"/>
                                    <ice:inputText id="txt_Buscar1" style="margin: 2px; height: 30px; left: 20%; top: 50px; position: absolute; width: 60%" value="#{AdminstrarCliente.apellido}"/>
                                    <ice:commandButton action="#{AdminstrarCliente.btnvolver_action}" id="btnvolver" image="/resources/volverok.png"
                                        style="height: 38px; left: 20%; top: 150px; position: absolute; text-align: center; width: 60%" value="Volver"/>
                                </ice:panelLayout>
                                <div align="center">
                                    <ice:outputLabel id="label1"
                                        style="font-size: 18px; left: 25%; top: 30px; position: absolute; text-align: center; width: 719px" value="DATOS DE CLIENTES REGISTRADOS EN EL SISTEMA"/>
                                </div>
                                <ice:panelLayout id="panelLayout55" style="border: 0px solid rgb(0, 0, 0); height: 300px; left: 28%; top: 70px; position: absolute; width: 68%">
                                    <div align="center" style="overflow:auto; width:auto; height:260px">
                                        <ice:dataTable headerClass="list-header" id="dataTable1" resizable="true" rows="16"
                                            style="position: relative; text-align: center; width: 100%" value="#{AdminstrarCliente.modelClientes}" var="c">
                                            <h:column id="column092">
                                                <h:outputText id="outputText1" value="#{c.ci}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText2" value="Cédula"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column2">
                                                <h:outputText id="outputText3" value="#{c.nombre}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText4" value="Nombre"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column3">
                                                <h:outputText id="outputText5" value="#{c.apellido}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText6" value="Apellido"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column4">
                                                <h:outputText id="outputText7" value="#{c.celular}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText8" value="Celular"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column5">
                                                <h:outputText id="outputText9" value="#{c.sexo}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText10" value="Sexo"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column6">
                                                <h:outputText id="outputText11" value="#{c.fechaNac}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText12" value="Fecha nac"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column7">
                                                <h:outputText id="outputText13" value="#{c.estadoCivil}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText14" value="Estado"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column1">
                                                <ice:panelGrid id="gridPanel1">
                                                    <h:commandLink action="#{AdminstrarCliente.linkActionEditar_action}" id="linkActionEditar"
                                                        style="color: #003333; text-decoration: underline" value="Editar"/>
                                                </ice:panelGrid>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText15" value="Editar"/>
                                                </f:facet>
                                            </h:column>
                                        </ice:dataTable>                                        
                                    </div>
                                </ice:panelLayout>

                                <ice:panelGrid columns="2" styleClass="panelAyuda panelAyudaOneButton">
                                            <ice:commandButton id="btnAyuda" image="/resources/help_button.png" immediate="true" actionListener="#{ServicioAyuda.showPopup}" value="Ayuda"
                                            title="Ayuda clientes"/>
                                </ice:panelGrid>
                                
                            </ice:panelLayout>

                           <!-- Panel Popup Ayuda -->
                            <ice:panelPopup autoCentre="true" draggable="true" id="modalPnlPop" modal="true" styleClass="corePopup" visible="#{ServicioAyuda.visiblePopup}">
                                <f:facet name="header">
                                    <ice:panelGroup styleClass="popupHeaderWrapper">
                                        <ice:outputText styleClass="popupHeaderText" value="Ayuda - Cliente"/>
                                        <ice:commandButton actionListener="#{ServicioAyuda.closePopup}" alt="Cerrar" id="modalPnlCloseBtn"
                                            image="/resources/popupclose.gif" styleClass="popupHeaderImage" title="Cerrar" type="button"/>
                                    </ice:panelGroup>
                                </f:facet>
                                <f:facet name="body">
                                    <ice:panelGroup styleClass="popupBody" style="width: 400px">
                                        <p><b>Cliente</b></p>

                                        <p>Un cliente es la persona que se ha registrado en el sistema con la finalidad de acceder a uno de nuestros los proyectos.</p>

                                        <p>El cliente se registra en la sección de clientes, por lo que aquí únicamente se puede verificar y editar sus datos personales</p>

                                        <p>Para una búsqueda más precisa ingrese el apellido del cliente y presione buscar</p>

                                        <p><b>Nota: </b>Si desea cambiar la clave del cliente puede ingresar por el icono editar</p>

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
