<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : AdminPersonal
    Created on : 01/06/2010, 10:58:39 PM
    Author     : Administrator
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
                <ice:form id="formRegistrarPersonal">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height: 100%; left: 0px; top: 0%; position: absolute; width:100%">
                        <div align="center">
                            <ice:panelLayout id="panecabeza" style="border-width: 0px; border-style: dotted; height: 100px; top: 0%; position: relative; width:960px">
                                <ice:graphicImage height="100px" id="graphicImage1" value="/resources/cabeza.jpg" width="960px"/>
                            </ice:panelLayout>
                        </div>
                        <div align="center">
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid rgb(153, 153, 153); height: 600px; top: 5px; position: relative; width: 960px; -rave-layout: grid;">
                                <ice:outputLabel id="label8"
                                    style="background-color: rgb(255, 255, 255); font-size: 18px; left: 0px; top: 20px; position: absolute; text-align: center; width: 100%" value="DATOS PERSONALES DEL NUEVO EMPLEADO"/>
                                <ice:outputLabel id="label2" style="height: 17px; left: 144px; top: 168px; position: absolute; text-align: left; width: 15%" value="Nombres: *"/>
                                <ice:outputLabel id="label3" style="left: 15%; top: 120px; position: absolute; text-align: left; width: 15%" value="Primer Apellido: *"/>
                                <ice:outputLabel id="label4" style="height: 17px; left: 15%; top: 72px; position: absolute; text-align: left; width: 15%" value="Cédula:  *"/>
                                <ice:outputLabel id="label5" style="height: 17px; left: 480px; top: 168px; position: absolute; text-align: left; width: 20%" value="Celular: *"/>
                                <ice:outputLabel id="label6" style="left: 144px; top: 216px; position: absolute; text-align: left; width: 15%" value="Estado Civil: *"/>
                                <ice:outputLabel id="label7" style="height: 15px; left: 480px; top: 216px; position: absolute; text-align: left; width: 20%" value="Sexo: *"/>
                                <ice:inputText id="txtcedula" maxlength="10" onchange="toEntero(this);" onkeyup="toEntero(this);" required="true"
                                    style="left: 30%; top: 70px; position: absolute; text-align: left" validator="#{ServicioEmpleado.txtcedula_validate}" value="#{ServicioEmpleado.empleadoEdicion.cedula}"/>
                                <ice:inputText id="txtapellido" onchange="toCadena( this);" onkeyup="toCadena( this);" required="true"
                                    style="left: 30%; top: 118px; position: absolute" validator="#{RegistrarPersonal.lengthValidatorapellido.validate}" value="#{ServicioEmpleado.empleadoEdicion.apellido}"/>
                                <ice:inputText id="txtdoapellido" onchange="toCadena( this);" onkeyup="toCadena( this);" required="true"
                                    style="left: 70%; top: 118px; position: absolute" validator="#{RegistrarPersonal.lengthValidatordoapellido.validate}" value="#{ServicioEmpleado.empleadoEdicion.apellidodos}"/>
                                <ice:inputText id="txtnombre" onchange="toCadena( this);" onkeyup="toCadena( this);" required="true"
                                    style="left: 30%; top: 165px; position: absolute" validator="#{RegistrarPersonal.lengthValidatornombre.validate}" value="#{ServicioEmpleado.empleadoEdicion.nombres}"/>
                                <ice:inputText id="txtcelular" maxlength="9" onchange="toEntero( this);" onkeyup="toEntero( this);" required="true"
                                    style="left: 70%; top: 165px; position: absolute" validator="#{RegistrarPersonal.lengthValidatorcelular.validate}" value="#{ServicioEmpleado.empleadoEdicion.celular}"/>
                                <ice:inputText action="#{RegistrarPersonal.txtdireccion_action}" id="txtdireccion" maxlength="150" required="true"
                                    style="left: 292px; top: 322px; position: absolute; width: 384px" value="#{ServicioEmpleado.empleadoEdicion.direccion}"/>
                                <h:selectOneMenu id="dropsexo" required="true" style="left: 672px; top: 216px; position: absolute; width: 120px" value="#{ServicioEmpleado.empleadoEdicion.sexo}">
                                    <f:selectItems id="dropdown1SelectItems" value="#{RegistrarPersonal.sexo}"/>
                                </h:selectOneMenu>
                                <h:selectOneMenu id="dropestadocivil" required="true" style="left: 288px; top: 216px; position: absolute; width: 117px" value="#{ServicioEmpleado.empleadoEdicion.estadocivil}">
                                    <f:selectItems id="dropdown1SelectItems1" value="#{RegistrarPersonal.estadoCivil}"/>
                                </h:selectOneMenu>
                                <ice:commandButton action="#{RegistrarPersonal.btnaceptar_action}" id="btnaceptar" image="/resources/btnAceptar.png"
                                    style="height: 46px; left: 672px; top: 534px; position: absolute; width: 142px" value="Aceptar"/>
                                <ice:outputLabel id="label9" style="left: 144px; top: 414px; position: absolute; text-align: left; width: 141px" value="Clave: *"/>
                                <ice:outputLabel id="label12" style="left: 50%; top: 120px; position: absolute; text-align: left; width: 20%" value="Segundo Apellido: *"/>
                                <ice:outputLabel id="label15" style="left: 144px; top: 324px; position: absolute; text-align: left; width: 15%" value="Dirección: *"/>
                                <ice:inputSecret id="secretclave" partialSubmit="true" redisplay="true" required="true"
                                    style="left: 286px; top: 412px; position: absolute" validator="#{ServicioEmpleado.clave_validate}" value="#{ServicioEmpleado.clave}"/>
                                <ice:outputLabel id="label1" style="left: 144px; top: 270px; position: absolute; text-align: left; width: 15%" value="Rol: *"/>
                                <ice:outputLabel id="label10" style="left: 480px; top: 270px; position: absolute; text-align: left; width: 20%" value="Estado: *"/>
                                <h:selectOneMenu id="drpdownrol" style="left: 288px; top: 270px; position: absolute; width: 120px" value="#{ServicioEmpleado.empleadoEdicion.rol}">
                                    <f:selectItems id="dropdown1SelectItems2" value="#{RegistrarPersonal.rol}"/>
                                </h:selectOneMenu>
                                <h:selectOneMenu id="drpdownestado" style="left: 672px; top: 270px; position: absolute; width: 120px" value="#{ServicioEmpleado.empleadoEdicion.estado}">
                                    <f:selectItems id="dropdown1SelectItems3" value="#{RegistrarPersonal.estado}"/>
                                </h:selectOneMenu>
                                <ice:inputText id="txtusuario" required="true" style="left: 286px; top: 382px; position: absolute"
                                    validator="#{RegistrarPersonal.lengthValidatorusuario.validate}" value="#{ServicioEmpleado.empleadoEdicion.usuario}"/>
                                <ice:outputLabel id="label13" style="left: 144px; top: 384px; position: absolute; text-align: left; width: 15%" value="Usuario: *"/>
                                <ice:message for="txtcedula" id="message1" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 30%; top: 50px; position: absolute"/>
                                <ice:message for="txtapellido" id="message2" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 288px; top: 96px; position: absolute"/>
                                <ice:message for="txtdoapellido" id="message3" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 672px; top: 96px; position: absolute; width: 243px"/>
                                <ice:message for="txtnombre" id="message4" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 30%; top: 140px; position: absolute"/>
                                <ice:message for="txtcelular" id="message5" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 672px; top: 144px; position: absolute; width: 243px"/>
                                <ice:message for="txtdireccion" id="message6" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 690px; top: 324px; position: absolute; width: 221px"/>
                                <ice:message for="secretclave" id="message7" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 456px; top: 414px; position: absolute; width: 453px"/>
                                <ice:message for="txtusuario" id="message8" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 456px; top: 378px; position: absolute; width: 455px"/>
                                <ice:outputLabel id="label17" style="left: 50%; top: 72px; position: absolute; text-align: left; width: 20%" value="Fecha de Nacimiento: *"/>
                                <ice:selectInputDate id="calendar1" renderAsPopup="true" renderMonthAsDropdown="true" renderYearAsDropdown="true"
                                    style="height: 24px; left: 70%; top: 72px; position: absolute; text-align: left; width: 25%" value="#{ServicioEmpleado.empleadoEdicion.fechaNac}"/>
                                <ice:commandButton action="#{RegistrarPersonal.btncancelar_action}" id="btncancelar" image="/resources/btnVolver.png"
                                    immediate="true" partialSubmit="true"
                                    style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 48px; left: 144px; top: 534px; position: absolute; width: 144px" value="CANCELAR"/>
                                <ice:outputLabel id="label11" style="left: 144px; top: 492px; position: absolute; text-align: left" value="Los campos Marcados con (*) son Obligatorios"/>
                                <ice:outputLabel id="label14" style="left: 144px; top: 444px; position: absolute; text-align: left; width: 141px" value="Confirmar Clave: *"/>
                                <ice:inputSecret id="secretclaveconf" partialSubmit="true" redisplay="true" required="true"
                                    requiredMessage="#{ServicioEmpleado.requiredConfirmClave}" style="left: 286px; top: 442px; position: absolute"
                                    validator="#{ServicioEmpleado.confclave_validate}" value="#{ServicioEmpleado.confirmclave}"/>
                                <ice:message for="secretclaveconf" id="message9" style="color: rgb(255, 0, 0); left: 456px; top: 444px; position: absolute; width: 453px"/>
                            </ice:panelLayout>
                        </div>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
