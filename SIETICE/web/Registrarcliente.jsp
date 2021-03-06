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
            <head id="head1" title="SIET - REGISTRO CLIENTE">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
                <!--script src="./js/nn.js" type="text/javascript"></script-->
                <script id="script-entrada" language="javascript" src="./js/Entrada.js"></script>
            </head>
            <body id="body1" style="-rave-layout: grid">
                <ice:form id="formRegistrar">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height: 100%; left: 0px; top: 0px; position: absolute; width: 100%">
                        <div align="center">
                            <ice:panelLayout id="panecabeza" style="border-width: 0px; border-style: dotted; height: 100px; top: 0%; position: relative; width: 960px">
                                <ice:graphicImage height="100px" id="graphicImage1" value="/resources/cabeza.jpg" width="960px"/>
                            </ice:panelLayout>
                        </div>
                        <div align="center">
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid #cccccc; height: 550px; top: 5px; position: relative; width: 960px; -rave-layout: grid;">
                                <ice:outputText id="label1"
                                    style="color: rgb(0, 102, 51); font-weight: bold; left: 192px; top: 10px; position: absolute; width: 645px" value="Bienvenido al Sistema de Registro para vivienda de la Entidad Técnica &quot;SU CASA PROPIA&quot;"/>
                                <ice:outputText id="label2" style="left: 15%; top: 144px; position: absolute; width: 15%" value="Nombres: *"/>
                                <ice:outputText id="label3" style="left: 144px; top: 186px; position: absolute; width: 15%" value="Primer   Apellido: *"/>
                                <ice:outputText id="label31" style="left: 480px; top: 186px; position: absolute" value="Segundo Apellido: *"/>
                                <ice:outputText id="label4" style="left: 15%; top: 96px; position: absolute; width: 15%" value="Cédula: *"/>
                                <ice:outputText id="label5" style="left: 144px; top: 234px; position: absolute; width: 15%" value="Celular: *"/>
                                <ice:outputText id="label6" style="left: 50%; top: 144px; position: absolute" value="Estado Civil: *"/>
                                <ice:outputText id="label7" style="left: 480px; top: 234px; position: absolute" value="Sexo: *"/>
                                <ice:inputText id="txtcedula" label="Cédula" maxlength="10" onchange="toEntero(this);" onkeyup="toEntero(this);" required="true"
                                    style="left: 30%; top: 94px; position: absolute" validator="#{ServicioCliente.txtcedula_validate}" value="#{ServicioCliente.clienteEdicion.ci}"/>
                                <ice:inputText id="txtnombre" maxlength="40" onchange="toCadena(this);" onkeyup="toCadena(this);" required="true"
                                    style="left: 30%; top: 142px; position: absolute" validator="#{Registrarcliente.lengthValidatorNombre.validate}" value="#{ServicioCliente.clienteEdicion.nombre}"/>
                                <ice:inputText id="txtapellido" maxlength="30" onchange="toCadena(this);" onkeyup="toCadena(this);" required="true"
                                    style="left: 292px; top: 190px; position: absolute" validator="#{Registrarcliente.lengthValidatorApellido.validate}" value="#{ServicioCliente.clienteEdicion.apellido}"/>
                                <ice:inputText id="txtapellidodos" maxlength="30" onchange="toCadena(this);" onkeyup="toCadena(this);" required="true"
                                    style="left: 676px; top: 190px; position: absolute" validator="#{Registrarcliente.lengthValidatorApellidodos.validate}" value="#{ServicioCliente.clienteEdicion.apellidodos}"/>
                                <ice:inputText id="txtcelular" maxlength="9" onchange="toEntero(this);" onkeyup="toEntero(this);" required="true"
                                    style="left: 292px; top: 238px; position: absolute" validator="#{ServicioCliente.txtcelular_validate}" value="#{ServicioCliente.clienteEdicion.celular}"/>
                                <ice:inputText id="txtdireccion" required="true" style="left: 292px; top: 280px; position: absolute; width: 384px" value="#{ServicioCliente.clienteEdicion.direccion}"/>
                                <h:selectOneMenu id="dropestadocivil" style="height: 21px; left: 678px; top: 144px; position: absolute; width: 149px" value="#{ServicioCliente.clienteEdicion.estadoCivil}">
                                    <f:selectItems id="dropdown1SelectItems1" value="#{Registrarcliente.estadoCivil}"/>
                                </h:selectOneMenu>
                                <h:selectOneMenu id="dropsexo" style="left: 678px; top: 234px; position: absolute; width: 149px" value="#{ServicioCliente.clienteEdicion.sexo}">
                                    <f:selectItems id="dropdown1SelectItems" value="#{Registrarcliente.sexo}"/>
                                </h:selectOneMenu>
                                <ice:outputText id="label8"
                                    style="background-color: rgb(255, 255, 255); font-size: 18px; font-weight: bold; left: 0px; top: 35px; position: absolute; text-align: center; width: 100%" value="         DATOS PERSONALES DEL POSTULANTE"/>
                                <ice:outputText id="label9" style="left: 144px; top: 330px; position: absolute; width: 15%" value="Clave: *"/>
                                <ice:outputText id="label10" style="left: 144px; top: 366px; position: absolute" value="Confirme Clave: *"/>
                                <ice:outputText id="label15" style="left: 144px; top: 282px; position: absolute; width: 15%" value="Dirección: *"/>
                                <ice:inputSecret id="secretclave" partialSubmit="true" redisplay="true" required="true"
                                    style="left: 292px; top: 328px; position: absolute" validator="#{ServicioCliente.clave_validate}" value="#{ServicioCliente.clave}">
                                    <f:validateLength minimum="4"/>
                                </ice:inputSecret>
                                <ice:message for="secretconfclave" id="outtxtconfirmclave" showDetail="true" style="color: rgb(255, 0, 0); left: 468px; top: 366px; position: absolute; width: 285px"/>
                                <ice:inputSecret id="secretconfclave" partialSubmit="true" redisplay="true" required="true"
                                    style="left: 292px; top: 364px; position: absolute" validator="#{ServicioCliente.confclave_validate}" value="#{ServicioCliente.confirmclave}">
                                    <f:validateLength minimum="4"/>
                                </ice:inputSecret>
                                <ice:message for="txtapellido" id="message2" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 288px; top: 168px; position: absolute; width: 167px"/>
                                <ice:message for="txtcedula" id="message1" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 30%; top: 70px; position: absolute; width: 167px"/>
                                <ice:message for="txtapellidodos" id="message3" showSummary="false" style="color: rgb(255, 0, 0); left: 678px; top: 168px; position: absolute; width: 189px"/>
                                <ice:message for="txtcelular" id="message4" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 288px; top: 216px; position: absolute; width: 166px"/>
                                <ice:message for="txtnombre" id="message5" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 30%; top: 120px; position: absolute; width: 119px"/>
                                <ice:message for="txtdireccion" id="message6" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 690px; top: 282px; position: absolute; width: 240px"/>
                                <ice:message for="secretclave" id="message7" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 468px; top: 330px; position: absolute; width: 291px"/>
                                <ice:outputText id="label17" style="left: 50%; top: 96px; position: absolute" value="Fecha de Nacimiento: *"/>
                                <ice:selectInputDate id="calendar1" renderAsPopup="true" renderMonthAsDropdown="true" renderYearAsDropdown="true"
                                    style="height: 24px; left: 70%; top: 96px; position: absolute;" value="#{ServicioCliente.clienteEdicion.fechaNac}"/>
                                <ice:commandButton action="#{Registrarcliente.btnvolver1_action}" id="btnvolver1" image="/resources/btnVolver.png"
                                    immediate="true" partialSubmit="true" style="height: 46px; left: 120px; top: 480px; position: absolute; width: 144px" value="VOLVER"/>
                                <ice:commandButton action="#{Registrarcliente.btnaceptar_action}" id="btnaceptar" image="/resources/btnAceptar.png"
                                    style="height: 48px; left: 672px; top: 480px; position: absolute; width: 142px" value="Aceptar"/>
                                <ice:outputText id="label11" style="left: 144px; top: 426px; position: absolute; width: 453px" value="Los campos marcados con  * son obligatorios"/>
                                <ice:panelGrid columns="2" styleClass="panelAyuda">
                                    <ice:commandButton actionListener="#{ServicioAyuda.showPopup}" id="btnAyuda" image="/resources/help_button.png"
                                        immediate="true" title="Ayuda datos personales" value="Ayuda"/>
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
                                            <b>Nota:</b> Ingrese una clave de por lo menos cinco caracteres, de preferencia que combine letras y números.</p>
                                        <p>
                                            <b>Importante:</b> La clave que ingresa debe ser fácil de recordar. Anótela en un lugar seguro ya que la misma le servirá para ingresar al sistema.</p>
                                        <center>
                                            <ice:commandButton actionListener="#{ServicioAyuda.closePopup}" id="modalPnlCloseButton" immediate="true"
                                                partialSubmit="true" value="Cerrar"/>
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
