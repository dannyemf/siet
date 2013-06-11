<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : EditarPersonalPer
    Created on : 12/12/2010, 09:04:35 PM
    Author     : LENIN 
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="html1">
            <head id="head1" title="SIET - EDITAR PERSONAL">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
                <script id="script-entrada" language="javascript" src="./js/Entrada.js"></script>
            </head>
            <body id="body1" style="-rave-layout: grid">
                <ice:form id="formEditPersonalPer">
                    <ice:panelLayout id="panetodo"
                            style="border-width: 0px; border-style: dotted; height: 100%; left: 0px; top: 0px; position: absolute; width: 100%">*
                            <div align="center">
                            <ice:panelLayout id="panecabeza" style="border-width: 0px; border-style: dotted; height: 100px; left: 0%; top: 0%; position: relative; width: 960px">
                                <ice:graphicImage height="100%" id="graphicImage1" value="/resources/cabeza.jpg" width="100%"/>
                            </ice:panelLayout>
                        </div>
                        <div align="center">
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid #999999; height: 600px; left: 0%; top: 5px; position: relative; width: 960px; -rave-layout: grid;">
                                <ice:outputLabel id="label8" style="font-size: 18px; left: 0px; top: 20px; position: absolute; text-align: center; width: 100%" value="DATOS PERSONALES DEL EMPLEADO"/>
                                <ice:outputLabel id="label2" style="left: 15%; top: 160px; position: absolute" value="Nombres: *"/>
                                <ice:outputLabel id="label3" style="left: 15%; top: 120px; position: absolute" value="Primer Apellido: *"/>
                                <ice:outputLabel id="label4" style="left: 15%; top: 72px; position: absolute" value="Cédula: *"/>
                                <ice:outputLabel id="label5" style="left: 50%; top: 160px; position: absolute; width: 119px" value="Celular: *"/>
                                <ice:outputLabel id="label6" style="left: 144px; top: 224px; position: absolute" value="Estado Civil: *"/>
                                <ice:outputLabel id="label7" style="left: 480px; top: 200px; position: absolute; width: 95px" value="Sexo: *"/>
                                <ice:inputText id="txtcedula" maxlength="10" onchange="toEntero(this);" onkeyup="toEntero(this);" required="true"
                                    style="left: 30%; top: 70px; position: absolute" validator="#{ServicioEmpleado.txtcedula_validate}" value="#{ServicioEmpleado.empleadoEdicion.cedula}"/>
                                <ice:inputText id="txtapellido" onchange="toCadena(this);" onkeyup="toCadena(this);" partialSubmit="true" required="true"
                                    style="left: 286px; top: 118px; position: absolute" validator="#{EditarPersonalPer.lengthValidatorapellido.validate}" value="#{ServicioEmpleado.empleadoEdicion.apellido}"/>
                                <ice:inputText id="txtdoapellido" onchange="toCadena(this);" onkeyup="toCadena(this);" partialSubmit="true" required="true"
                                    style="left: 70%; top: 118px; position: absolute" validator="#{EditarPersonalPer.lengthValidatordoapellido.validate}" value="#{ServicioEmpleado.empleadoEdicion.apellidodos}"/>
                                <ice:inputText id="txtnombre" onchange="toCadena(this);" onkeyup="toCadena(this);" partialSubmit="true" required="true"
                                    style="left: 286px; top: 166px; position: absolute" validator="#{EditarPersonalPer.lengthValidatornombre.validate}" value="#{ServicioEmpleado.empleadoEdicion.nombres}"/>
                                <ice:inputText id="txtcelular" maxlength="9" onchange="toEntero(this);" onkeyup="toEntero(this);" partialSubmit="true"
                                    required="true" style="left: 70%; top: 160px; position: absolute" validator="#{ServicioEmpleado.txtcelular_validate}" value="#{ServicioEmpleado.empleadoEdicion.celular}"/>
                                <ice:inputText id="txtdireccion" required="true" style="left: 286px; top: 262px; position: absolute; width: 384px" value="#{ServicioEmpleado.empleadoEdicion.direccion}"/>
                                <h:selectOneMenu id="dropsexo" style="left: 672px; top: 200px; position: absolute; width: 120px" value="#{ServicioEmpleado.empleadoEdicion.sexo}">
                                    <f:selectItems id="dropdown1SelectItems" value="#{EditarPersonalPer.sexo}"/>
                                </h:selectOneMenu>
                                <h:selectOneMenu id="dropestadocivil" style="left: 288px; top: 232px; position: absolute; width: 120px" value="#{ServicioEmpleado.empleadoEdicion.estadocivil}">
                                    <f:selectItems id="dropdown1SelectItems1" value="#{EditarPersonalPer.estadoCivil}"/>
                                </h:selectOneMenu>
                                <ice:commandButton action="#{EditarPersonalPer.btnaceptar_action}" id="btnaceptar" image="/resources/btnAceptar.png"
                                    style="height: 46px; left: 720px; top: 528px; position: absolute; width: 142px" value="Aceptar"/>
                                <ice:outputLabel id="label9" style="left: 144px; top: 390px; position: absolute; width: 135px" value="Nueva Clave: *"/>
                                <ice:outputLabel id="label12" style="left: 50%; top: 120px; position: absolute; width: 157px" value="2 do Apellido: *"/>
                                <ice:outputLabel id="label15" style="left: 144px; top: 264px; position: absolute" value="Dirección: *"/>
                                <ice:inputSecret id="secretclave" partialSubmit="true" redisplay="true" style="left: 286px; top: 388px; position: absolute"
                                    validator="#{ServicioEmpleado.clave_validate}" value="#{ServicioEmpleado.clave}"/>
                                <ice:outputLabel id="label1" style="left: 144px; top: 200px; position: absolute" value="Rol: *"/>
                                <ice:outputLabel id="label10" style="left: 480px; top: 232px; position: absolute" value="Estado: *"/>
                                <h:selectOneMenu id="drpdownrol" style="left: 288px; top: 200px; position: absolute; width: 120px" value="#{ServicioEmpleado.empleadoEdicion.rol}">
                                    <f:selectItems id="dropdown1SelectItems2" value="#{EditarPersonalPer.rol}"/>
                                </h:selectOneMenu>
                                <h:selectOneMenu id="drpdownestado" style="left: 672px; top: 232px; position: absolute; width: 120px" value="#{ServicioEmpleado.empleadoEdicion.estado}">
                                    <f:selectItems id="dropdown1SelectItems3" value="#{EditarPersonalPer.estado}"/>
                                </h:selectOneMenu>
                                <ice:inputText id="txtusuario" required="true" style="left: 286px; top: 304px; position: absolute" value="#{ServicioEmpleado.empleadoEdicion.usuario}"/>
                                <ice:outputLabel id="label13" style="left: 144px; top: 304px; position: absolute" value="Usuario: *"/>
                                <ice:message for="txtcedula" id="message1" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 30%; top: 50px; position: absolute"/>
                                <ice:message for="txtapellido" id="message2" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 288px; top: 96px; position: absolute; width: 167px"/>
                                <ice:message for="txtdoapellido" id="message3" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 70%; top: 100px; position: absolute; width: 167px"/>
                                <ice:message for="txtnombre" id="message4" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 288px; top: 144px; position: absolute; width: 167px"/>
                                <ice:message for="txtcelular" id="mscelular" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 70%; top: 140px; position: absolute; width: 167px"/>
                                <ice:message for="txtdireccion" id="message6" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 680px; top: 264px; position: absolute; width: 167px"/>
                                <ice:message for="txtusuario" id="message7" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 456px; top: 306px; position: absolute; width: 397px"/>
                                <ice:message for="secretclave" id="msxsecretclav" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 456px; top: 390px; position: absolute; width: 397px"/>
                                <ice:outputLabel id="label17" style="left: 50%; top: 72px; position: absolute" value="Fecha de Nacimiento: *"/>
                                <ice:selectInputDate id="calendar1" renderAsPopup="true" renderMonthAsDropdown="true" renderYearAsDropdown="true"
                                    style="height: 24px; left: 70%; top: 72px; position: absolute" value="#{ServicioEmpleado.empleadoEdicion.fechaNac}"/>
                                <ice:commandButton action="#{EditarPersonalPer.btncancelar_action}" id="btncancelar" image="/resources/btnVolver.png"
                                    immediate="true" partialSubmit="true" style="height: 48px; left: 144px; top: 528px; position: absolute; width: 142px" value="CANCELAR"/>
                                <ice:outputLabel id="label11" style="left: 144px; top: 488px; position: absolute" value="Los campos marcados con * son obligatorios"/>
                                <ice:outputLabel id="label14" style="left: 144px; top: 420px; position: absolute; width: 135px" value="Confirmar Clave: *"/>
                                <ice:inputSecret id="secretclaveconf" partialSubmit="true" redisplay="true" required="#{ServicioEmpleado.requiredConfirmClave}"
                                    style="left: 286px; top: 418px; position: absolute" validator="#{ServicioEmpleado.confclave_validate}" value="#{ServicioEmpleado.confirmclave}"/>
                                <ice:message for="secretclaveconf" id="msxsecretclav1" style="color: rgb(255, 0, 0); left: 456px; top: 420px; position: absolute; width: 397px"/>
                                <ice:panelGrid columns="2" styleClass="panelAyuda">
                                    <ice:commandButton actionListener="#{ServicioAyuda.showPopup}" id="btnAyuda" image="/resources/help_button.png"
                                        immediate="true" title="Ayuda datos personales" value="Ayuda"/>
                                    <div title="Manual de usuario (pdf)">
                                        <ice:outputResource attachment="false" fileName="ayuda.pdf" id="orAyuda" image="/resources/helppdf_button.png"
                                            label="Ayuda" mimeType="application/pdf" resource="#{PaginaEmpleado.recursoAyuda}" shared="true"/>
                                    </div>
                                </ice:panelGrid>
                                <ice:outputLabel id="label16"
                                    style="border-bottom: dotted orange 2px; color: orange; left: 144px; top: 354px; position: absolute; width: 713px" value="Cambiar clave..."/>
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
                                            <b>Nota:</b> Ingrese una clave de por lo menos cinco caracteres, de preferencia que combine letras y números.
                                            <br/>
                                            <br/>
                                            Solor si desea cambia la clave ingrese la nueva clave y su confirmación, de lo contrario dejar vacío.
                                            </p>
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
