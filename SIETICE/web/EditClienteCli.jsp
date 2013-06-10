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
            <head id="head1" title="SIET - EDITAR CLIENTE">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
                <script id="script-entrada" language="javascript" src="./js/Entrada.js"></script>
            </head>
            <body id="body1" style="-rave-layout: grid">
                <ice:form id="formEditCliente">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height: 100%; left: 0px; top: 0px; position: absolute; width: 100%">
                        <div align="center">
                            <ice:panelLayout id="panecabeza" style="height: 100px;  left: 0%; top: 0%; position: relative; width: 960px">
                                <ice:graphicImage height="100px" id="graphicImage1" style="border: 1px solid rgb(153, 153, 153); height: 100%; width: 100%"
                                    value="/resources/cabeza.jpg" visible="true" width="800px"/>
                            </ice:panelLayout>
                        </div>
                        <div align="center">
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid gray; background-color: rgb(255, 255, 255); height: 550px; margin-bottom: 10px; left: 0%; top: 5px; position: relative; width: 960px; -rave-layout: grid;">
                                <ice:outputLabel id="label8"
                                    style="font-size: 18px; font-weight: bold; left: 0px; top: 24px; position: absolute; text-align: center; width: 100%" value="DATOS PERSONALES "/>
                                <ice:outputLabel id="label2" style="left: 15%; top: 165px; position: absolute" value="Nombres  * "/>
                                <ice:outputLabel id="label3" style="left: 15%; top: 120px; position: absolute" value="Primer Apellido  * "/>
                                <ice:outputLabel id="label4" style="left: 15%; top: 72px; position: absolute" value="Cédula * "/>
                                <ice:outputLabel id="label5" style="left: 50%; top: 165px; position: absolute" value="Celular  * "/>
                                <ice:outputLabel id="label6" style="left: 144px; top: 210px; position: absolute" value="Estado Civil  * "/>
                                <ice:outputLabel id="label7" style="left: 480px; top: 204px; position: absolute" value="Sexo  * "/>
                                <ice:inputText id="txtcedula" maxlength="10" onchange="toEntero( this);" onkeyup="toEntero( this);" required="true"
                                    style="left: 30%; top: 70px; position: absolute" validator="#{ServicioCliente.txtcedula_validate}" value="#{ServicioCliente.clienteEdicion.ci}"/>
                                <ice:inputText id="txtnombre" onchange="toCadena( this);" onkeyup="toCadena( this);" required="true"
                                    style="left: 292px; top: 172px; position: absolute" value="#{ServicioCliente.clienteEdicion.nombre}"/>
                                <ice:inputText id="txtapellido" onchange="toCadena( this);" onkeyup="toCadena( this);" required="true"
                                    style="left: 30%; top: 118px; position: absolute" validator="#{EditClienteCli.lengthValidatorapellido.validate}" value="#{ServicioCliente.clienteEdicion.apellido}"/>
                                <ice:inputText id="txtdoapellido" onchange="toCadena( this);" onkeyup="toCadena( this);" required="true"
                                    style="left: 70%; top: 118px; position: absolute" validator="#{EditClienteCli.lengthValidatornombre.validate}" value="#{ServicioCliente.clienteEdicion.apellidodos}"/>
                                <ice:inputText id="txtcelular" maxlength="9" onchange="toEntero( this);" onkeyup="toEntero( this);" required="true"
                                    style="left: 70%; top: 165px; position: absolute" validator="#{ServicioCliente.txtcelular_validate}" value="#{ServicioCliente.clienteEdicion.celular}"/>
                                <ice:inputText id="txtdireccion" required="true" style="left: 292px; top: 250px; position: absolute; width: 384px" value="#{ServicioCliente.clienteEdicion.direccion}"/>
                                <ice:selectOneMenu id="dropestadocivil" style="left: 292px; top: 208px; position: absolute; width: 143px" value="#{ServicioCliente.clienteEdicion.estadoCivil}">
                                    <f:selectItems id="dropdown1SelectItems1" value="#{EditarCliente.estadoCivil}"/>
                                </ice:selectOneMenu>
                                <ice:selectOneMenu id="dropsexo" style="left: 676px; top: 202px; position: absolute; width: 143px" value="#{ServicioCliente.clienteEdicion.sexo}">
                                    <f:selectItems id="dropdown1SelectItems" value="#{EditarCliente.sexo}"/>
                                </ice:selectOneMenu>
                                <ice:commandButton action="#{EditClienteCli.btnaceptar_action}" id="btnaceptar" image="/resources/btnAceptar.png"
                                    style="height: 48px; left: 672px; top: 480px; position: absolute; width: 141px" value="Aceptar"/>
                                <ice:outputLabel id="label9" style="left: 144px; top: 306px; position: absolute" value="Clave  * "/>
                                <ice:outputLabel id="label10" style="left: 144px; top: 354px; position: absolute" value="Confirme Clave  * "/>
                                <ice:outputLabel id="label12" style="height: 21px; left: 50%; top: 120px; position: absolute" value="Segundo Apellido: *"/>
                                <ice:outputLabel id="label13" style="font-size: 10px; left: 294px; top: 330px; position: absolute" value="( Mínimo 5 caracteres )"/>
                                <ice:outputLabel id="label15" style="left: 144px; top: 258px; position: absolute" value="Dirección: * "/>
                                <ice:inputSecret id="secretclave" partialSubmit="true" redisplay="true" style="left: 292px; top: 304px; position: absolute"
                                    validator="#{ServicioCliente.clave_validate}" value="#{ServicioCliente.clave}"/>
                                <ice:inputSecret id="secretconfclave" partialSubmit="true" redisplay="true" required="#{ServicioCliente.requiredConfirmClave}"
                                    style="left: 292px; top: 352px; position: absolute" validator="#{ServicioCliente.confclave_validate}" value="#{ServicioCliente.confirmclave}"/>
                                <ice:message for="txtcedula" id="message1" showDetail="false" showSummary="true" style="color: red; left: 30%; top: 50px; position: absolute"/>
                                <ice:message for="txtapellido" id="message2" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 30%; top: 95px; position: absolute"/>
                                <ice:message for="txtdoapellido" id="message3" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 70%; top: 95px; position: absolute"/>
                                <ice:message for="txtnombre" id="message4" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 30%; top: 145px; position: absolute"/>
                                <ice:message for="txtcelular" id="message5" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 70%; top: 140px; position: absolute"/>
                                <ice:message for="txtdireccion" id="message6" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 696px; top: 246px; position: absolute"/>
                                <ice:message for="secretclave" id="message7" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 462px; top: 300px; position: absolute"/>
                                <ice:message for="secretconfclave" id="message8" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 462px; top: 348px; position: absolute"/>
                                <ice:outputLabel id="label17" style="left: 50%; top: 72px; position: absolute" value="Fecha de Nacimiento: *"/>
                                <ice:outputResource attachment="false" fileName="ayuda.pdf" id="orAyuda" label="Ayuda" mimeType="application/pdf"
                                    resource="#{LoginCliente.recursoAyuda}" shared="true" style="color: rgb(255, 0, 0); font-size: 14px; left: 700px; top: 25px; position: absolute; width: 100px"/>
                                <ice:selectInputDate id="calendar1" renderAsPopup="true" style="left: 70%; top: 72px; position: absolute" value="#{ServicioCliente.clienteEdicion.fechaNac}"/>
                                <ice:outputLabel id="label1" style="left: 144px; top: 450px; position: absolute" value="Los campos Marcados con (*) son Obligatorios"/>
                                <ice:commandButton action="#{EditClienteCli.btnvolver1_action}" id="btnvolver1" image="/resources/btnVolver.png"
                                    partialSubmit="true" style="height: 48px; left: 144px; top: 480px; position: absolute; width: 142px" value="volver"/>
                            </ice:panelLayout>
                        </div>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
