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
            <head id="head1" title="SIET - EDITAR CLIENTE [ Empleado ]">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
                <script id="script-entrada" language="javascript" src="./js/Entrada.js"></script>
            </head>
            <body id="body1" style="-rave-layout: grid">
                <ice:form id="formEditCli">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height: 100%; left: 0px; top: 0%; position: absolute; width: 100%">
                        <div align="center">
                            <ice:panelLayout id="panecabeza" style="border-width: 0px; border-style: dotted; height: 100px; left: 0%; top: 0%; position: relative; width: 960px">
                                <ice:graphicImage height="100%" id="graphicImage1" value="/resources/cabeza.jpg" width="100%"/>
                            </ice:panelLayout>
                        </div>
                        <div align="center">
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid #999999; height: 550px; left: 0%; top: 5px; position: relative; width: 960px; -rave-layout: grid;">
                                <ice:outputLabel id="label2" style="left: 15%; top: 170px; position: absolute" value="Nombres: *"/>
                                <ice:outputLabel id="label3" style="left: 15%; top: 120px; position: absolute" value="Primer Apellido: *"/>
                                <ice:outputLabel id="label4" style="left: 15%; top: 72px; position: absolute; width: 15%" value="Cédula: *"/>
                                <ice:outputLabel id="label5" style="left: 480px; top: 168px; position: absolute" value="Celular : *"/>
                                <ice:outputLabel id="label6" style="left: 144px; top: 216px; position: absolute" value="Estado Civil: *"/>
                                <ice:outputLabel id="label7" style="left: 480px; top: 210px; position: absolute" value="Sexo: *"/>
                                <ice:inputText id="txtcedula" maxlength="10" onchange="toEntero( this);" onkeyup="toEntero( this);" required="true"
                                    style="left: 30%; top: 70px; position: absolute" validator="#{ServicioCliente.txtcedula_validate}" value="#{ServicioCliente.clienteEdicion.ci}"/>
                                <ice:inputText id="txtapellido" onchange="toCadena(this);" onkeyup="toCadena(this);" required="true"
                                    style="left: 286px; top: 118px; position: absolute" validator="#{EditarClienteEmpleado.lengthValidatorapellido.validate}" value="#{ServicioCliente.clienteEdicion.apellido}"/>
                                <ice:inputText id="txtdoapellido" onchange="toCadena(this);" onkeyup="toCadena(this);" required="true"
                                    style="left: 70%; top: 118px; position: absolute" validator="#{EditarClienteEmpleado.lengthValidatordoapellido.validate}" value="#{ServicioCliente.clienteEdicion.apellidodos}"/>
                                <ice:inputText id="txtnombre" onchange="toCadena(this);" onkeyup="toCadena(this);" required="true"
                                    style="left: 30%; top: 170px; position: absolute" validator="#{EditarClienteEmpleado.lengthValidatornombre.validate}" value="#{ServicioCliente.clienteEdicion.nombre}"/>
                                <ice:inputText id="txtcelular" maxlength="9" onchange="toEntero(this);" onkeyup="toEntero(this);" required="true"
                                    style="left: 70%; top: 170px; position: absolute" validator="#{ServicioCliente.txtcelular_validate}" value="#{ServicioCliente.clienteEdicion.celular}"/>
                                <ice:inputText id="txtdireccion" required="true" style="left: 292px; top: 262px; position: absolute; width: 384px" value="#{ServicioCliente.clienteEdicion.direccion}"/>
                                <h:selectOneMenu id="dropestadocivil" style="left: 294px; top: 216px; position: absolute; width: 143px" value="#{ServicioCliente.clienteEdicion.estadoCivil}">
                                    <f:selectItems id="dropdown1SelectItems1" value="#{EditarClienteEmpleado.estadoCivil}"/>
                                </h:selectOneMenu>
                                <h:selectOneMenu id="dropsexo" style="left: 672px; top: 216px; position: absolute; width: 149px" value="#{ServicioCliente.clienteEdicion.sexo}">
                                    <f:selectItems id="dropdown1SelectItems" value="#{EditarClienteEmpleado.sexo}"/>
                                </h:selectOneMenu>
                                <ice:outputLabel id="label8"
                                    style="background-color: rgb(255, 255, 255); color: rgb(0, 51, 51); font-size: 14px; left: 0px; top: 20px; position: absolute; text-align: center; width: 100%" value="         DATOS PERSONALES DEL POSTULANTE"/>
                                <ice:outputLabel id="label9" style="left: 144px; top: 336px; position: absolute" value="Nueva Clave: *"/>
                                <ice:outputLabel id="label10" style="left: 144px; top: 378px; position: absolute" value="Confirme Clave: *"/>
                                <ice:outputLabel id="label12" style="left: 50%; top: 120px; position: absolute" value="Segundo Apellido: *"/>
                                <ice:outputLabel id="label15" style="left: 144px; top: 264px; position: absolute" value="Dirección: *"/>
                                <ice:inputSecret id="secretclave" maxlength="15" redisplay="true" style="left: 292px; top: 340px; position: absolute"
                                    validator="#{ServicioCliente.clave_validate}" value="#{ServicioCliente.clave}"/>
                                <ice:inputSecret id="secretconfclave" maxlength="15" redisplay="true" required="#{ServicioCliente.requiredConfirmClave}"
                                    style="left: 292px; top: 376px; position: absolute" validator="#{ServicioCliente.confclave_validate}" value="#{ServicioCliente.confirmclave}"/>
                                <ice:message for="txtcedula" id="mscedula" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 30%; top: 50px; position: absolute"/>
                                <ice:message for="txtapellido" id="msapellid" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 288px; top: 96px; position: absolute"/>
                                <ice:message for="txtdoapellido" id="msdoapellid" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 70%; top: 95px; position: absolute"/>
                                <ice:message for="txtnombre" id="msnombre" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 30%; top: 150px; position: absolute"/>
                                <ice:message for="txtcelular" id="mscelular" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 70%; top: 150px; position: absolute"/>
                                <ice:message for="txtdireccion" id="msdirecion" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 696px; top: 264px; position: absolute"/>
                                <ice:message for="secretclave" id="mssecretclav" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 468px; top: 342px; position: absolute"/>
                                <ice:message for="secretconfclave" id="msconfclav" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 468px; top: 378px; position: absolute"/>
                                <ice:outputLabel id="label17" style="left: 50%; top: 72px; position: absolute" value="Fecha de Nacimiento:  *"/>
                                <ice:selectInputDate id="calendar1" renderAsPopup="true" style="height: 24px; left: 70%; top: 72px; position: absolute" value="#{ServicioCliente.clienteEdicion.fechaNac}"/>
                                <ice:commandButton action="#{EditarClienteEmpleado.btnaceptar_action}" id="btnaceptar" image="/resources/btnAceptar.png"
                                    style="height: 48px; left: 672px; top: 480px; position: absolute; width: 141px" value="Aceptar"/>
                                <ice:commandButton action="#{EditarClienteEmpleado.btn_volver1_action}" id="btn_volver1" image="/resources/btnVolver.png"
                                    style="height: 48px; left: 120px; top: 480px; position: absolute; width: 144px" value="VOLVER"/>
                                <ice:outputLabel id="label1" style="left: 144px; top: 438px; position: absolute" value="Los campos marcados con * son obligatorios"/>
                                <ice:outputLabel id="label11"
                                    style="border-bottom: dotted orange 2px; color: orange; left: 144px; top: 306px; position: absolute; width: 713px" value="Cambiar clave..."/>

                                    <ice:panelGrid columns="2" styleClass="panelAyuda">
                                    <ice:commandButton id="btnAyuda" image="/resources/help_button.png" immediate="true" actionListener="#{ServicioAyuda.showPopup}" value="Ayuda"
                                    title="Ayuda datos personales"/>

                                    <div title="Manual de usuario (pdf)">
                                        <ice:outputResource id="orAyuda" attachment="false" fileName="ayuda.pdf" label="Ayuda" mimeType="application/pdf" image="/resources/helppdf_button.png"
                                        resource="#{LoginCliente.recursoAyuda}" shared="true"/>
                                    </div>
                                </ice:panelGrid>
                                
                            </ice:panelLayout>

                        </div>

                        <!-- Panel Popup Ayuda -->
                            <ice:panelPopup autoCentre="true" draggable="true" id="modalPnlPop" modal="true" styleClass="corePopup" visible="#{ServicioAyuda.visiblePopup}">
                                <f:facet name="header">
                                    <ice:panelGroup styleClass="popupHeaderWrapper">
                                        <ice:outputText styleClass="popupHeaderText" value="Ayuda - Datos personales"/>
                                        <ice:commandButton actionListener="#{ServicioAyuda.closePopup}" alt="Cerrar" id="modalPnlCloseBtn"
                                            image="/resources/popupclose.gif" styleClass="popupHeaderImage" title="Cerrar" type="button"/>
                                    </ice:panelGroup>
                                </f:facet>
                                <f:facet name="body">
                                    <ice:panelGroup style="width: 400px" styleClass="popupBody">
                                        <p>
                                            <b>Datos personales</b>
                                        </p>
                                        <p>Por favor ingrese todos los datos requeridos, los mismos que están marcados con un asterisco.</p>
                                        <br/>
                                        <p>
                                            <b>Nota:</b> Ingrese una clave de por lo menos cinco caracteres, de preferencia que combine letras y números.
                                            <br/>
                                            <br/>
                                            Solor si desea cambia la clave ingrese la nueva clave y su confirmación, de lo contrario dejar vacío.
                                        </p>
                                            
                                        <center>
                                            <ice:commandButton actionListener="#{ServicioAyuda.closePopup}" id="modalPnlCloseButton" immediate="true"
                                                partialSubmit="true" value="Cerrar"/>
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
