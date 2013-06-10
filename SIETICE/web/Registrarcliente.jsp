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
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid #cccccc; height: 470px; top: 5px; position: relative; width: 960px">
                                <ice:outputText id="label1"
                                    style="color: rgb(0, 102, 51); font-weight: bold; left: 192px; top: 10px; position: absolute; width: 645px" value="Bienvenido al Sistema de Registro para vivienda de la Entidad Técnica &quot;SU CASA PROPIA&quot;"/>
                                <ice:outputText id="label2" style="left: 15%; top: 144px; position: absolute; width: 15%" value="Nombres: *"/>
                                <ice:outputText id="label3" style="left: 15%; top: 180px; position: absolute; width: 15%" value="Primer   Apellido: *"/>
                                <ice:outputText id="label31" style="left: 50%; top: 180px; position: absolute" value="Segundo Apellido: *"/>
                                <ice:outputText id="label4" style="left: 15%; top: 96px; position: absolute; width: 15%" value="Cédula: *"/>
                                <ice:outputText id="label5" style="left: 15%; top: 220px; position: absolute; width: 15%" value="Celular: *"/>
                                <ice:outputText id="label6" style="left: 50%; top: 144px; position: absolute" value="Estado Civil: *"/>
                                <ice:outputText id="label7" style="left: 50%; top: 220px; position: absolute" value="Sexo: *"/>
                                <ice:inputText id="txtcedula" maxlength="10" onchange="toEntero(this);" onkeyup="toEntero(this);" required="true"
                                    style="left: 30%; top: 94px; position: absolute" validator="#{Registrarcliente.txtcedula_validate}" value="#{Registrarcliente.servicioCliente.clienteEdicion.ci}"/>
                                <ice:inputText id="txtnombre" maxlength="40" onchange="toCadena(this);" onkeyup="toCadena(this);" required="true"
                                    style="left: 30%; top: 142px; position: absolute" validator="#{Registrarcliente.lengthValidatorNombre.validate}" value="#{ServicioCliente.clienteEdicion.nombre}"/>
                                <ice:inputText id="txtapellido" maxlength="30" onchange="toCadena(this);" onkeyup="toCadena(this);" required="true"
                                    style="left: 30%; top: 180px; position: absolute" validator="#{Registrarcliente.lengthValidatorApellido.validate}" value="#{ServicioCliente.clienteEdicion.apellido}"/>
                                <ice:inputText id="txtapellidodos" maxlength="30" onchange="toCadena(this);" onkeyup="toCadena(this);" required="true"
                                    style="left: 70%; top: 180px; position: absolute" validator="#{Registrarcliente.lengthValidatorApellidodos.validate}" value="#{ServicioCliente.clienteEdicion.apellidodos}"/>
                                <ice:inputText action="#{Registrarcliente.txtcelular_action}" id="txtcelular" maxlength="9" onchange="toEntero(this);"
                                    onkeyup="toEntero(this);" required="true" style="left: 30%; top: 220px; position: absolute"
                                    validator="#{Registrarcliente.txtcelular_validate}" value="#{ServicioCliente.clienteEdicion.celular}"/>
                                <ice:inputText action="#{Registrarcliente.txtdireccion_action}" id="txtdireccion" required="true"
                                    style="left: 30%; top: 310px; position: absolute; width: 384px" value="#{Registrarcliente.servicioCliente.clienteEdicion.direccion}"/>
                                <h:selectOneMenu id="dropestadocivil" style="height: 21px; left: 70%; top: 144px; position: absolute; width: 120px" value="#{Registrarcliente.servicioCliente.clienteEdicion.estadoCivil}">
                                    <f:selectItems id="dropdown1SelectItems1" value="#{Registrarcliente.estadoCivil}"/>
                                </h:selectOneMenu>
                                <h:selectOneMenu id="dropsexo" style="left: 70%; top: 220px; position: absolute; width: 120px" value="#{Registrarcliente.servicioCliente.clienteEdicion.sexo}">
                                    <f:selectItems id="dropdown1SelectItems" value="#{Registrarcliente.sexo}"/>
                                </h:selectOneMenu>
                                <ice:outputText id="label8"
                                    style="background-color: rgb(255, 255, 255); font-size: 18px; font-weight: bold; left: 0px; top: 35px; position: absolute; text-align: center; width: 100%" value="         DATOS PERSONALES DEL POSTULANTE"/>
                                <ice:outputText id="label9" style="left: 15%; top: 260px; position: absolute; width: 15%" value="Clave: *"/>
                                <ice:outputText id="label10" style="left: 50%; top: 260px; position: absolute" value="Confirme Clave: *"/>
                                <ice:outputText id="label15" style="left: 15%; top: 310px; position: absolute; width: 15%" value="Dirección: *"/>
                                <ice:inputSecret id="secretclave" redisplay="true" required="true" style="left: 30%; top: 260px; position: absolute" value="#{Registrarcliente.clave}">
                                    <f:validateLength minimum="4"/>
                                </ice:inputSecret>
                                <ice:message for="secretconfclave" id="outtxtconfirmclave" showDetail="true" style="color: rgb(255, 0, 0); left: 70%; top: 280px; position: absolute; width: 189px"/>
                                <ice:inputSecret id="secretconfclave" redisplay="true" required="true" style="left: 70%; top: 260px; position: absolute" value="#{Registrarcliente.confirmclave}">
                                    <f:validateLength minimum="4"/>
                                </ice:inputSecret>
                                <ice:message for="txtapellido" id="message2" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 30%; top: 160px; position: absolute; width: 167px"/>
                                <ice:message for="txtcedula" id="message1" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 30%; top: 70px; position: absolute; width: 167px"/>
                                <ice:message for="txtapellidodos" id="message3" showSummary="true" style="color: rgb(255, 0, 0); left: 70%; top: 160px; position: absolute; width: 189px"/>
                                <ice:message for="txtcelular" id="message4" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 30%; top: 200px; position: absolute; width: 166px"/>
                                <ice:message for="txtnombre" id="message5" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 30%; top: 120px; position: absolute; width: 119px"/>
                                <ice:message for="txtdireccion" id="message6" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 30%; top: 290px; position: absolute; width: 240px"/>
                                <ice:message for="secretclave" id="message7" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 30%; top: 240px; position: absolute; width: 165px"/>
                                <ice:outputText id="label17" style="left: 50%; top: 96px; position: absolute" value="Fecha de Nacimiento: *"/>
                                <ice:selectInputDate id="calendar1" renderAsPopup="true" renderMonthAsDropdown="true" renderYearAsDropdown="true"
                                    style="height: 24px; left: 70%; top: 96px; position: absolute; width: 168px" value="#{Registrarcliente.servicioCliente.clienteEdicion.fechaNac}"/>
                                <ice:commandButton action="#{Registrarcliente.btnvolver1_action}" id="btnvolver1" image="/resources/btnVolver.png"
                                    immediate="true" partialSubmit="true" style="height: 46px; left: 120px; top: 410px; position: absolute; width: 144px" value="VOLVER"/>
                                <ice:commandButton action="#{Registrarcliente.btnaceptar_action}" id="btnaceptar" image="/resources/btnAceptar.png"
                                    style="height: 48px; left: 70%; top: 410px; position: absolute; width: 142px" value="Aceptar"/>
                                <ice:outputResource attachment="false" fileName="ayuda.pdf" id="orAyuda" label="Ayuda" mimeType="application/pdf"
                                    resource="#{LoginCliente.recursoAyuda}" shared="true" style="color: rgb(255, 0, 0); font-size: 20px; left: 70%; top: 25px; position: absolute; width: 406px"/>
                                <ice:outputText id="label11" style="left: 144px; top: 360px; position: absolute; width: 453px" value="Los campos marcados con  * son obligatorios"/>
                            </ice:panelLayout>
                        </div>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
