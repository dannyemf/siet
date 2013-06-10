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
                <ice:form id="form1">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height: 100%; left: 0px; top: 0%; position: absolute; width:100%">
                        <div align="center">
                            <ice:panelLayout id="panecabeza" style="border-width: 0px; border-style: dotted; height: 100px; top: 0%; position: relative; width:960px">
                                <ice:graphicImage height="100px" id="graphicImage1" value="/resources/cabeza.jpg" width="960px"/>
                            </ice:panelLayout>
                        </div>
                        <div align="center">
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid #999999; height: 470px; top: 5px; position: relative; width: 960px">
                                <ice:outputLabel id="label8"
                                    style="background-color: rgb(255, 255, 255); font-size: 18px; left: 0px; top: 20px; position: absolute; text-align: center; width: 100%" value="DATOS PERSONALES DEL NUEVO EMPLEADO"/>
                                <ice:outputLabel id="label2" style="left: 15%; top: 160px; position: absolute; text-align: left; width: 15%" value="Nombres: *"/>
                                <ice:outputLabel id="label3" style="left: 15%; top: 120px; position: absolute; text-align: left; width: 15%" value="Primer Apellido: *"/>
                                <ice:outputLabel id="label4" style="left: 15%; top: 72px; position: absolute; text-align: left; width: 15%" value="Cédula:  *"/>
                                <ice:outputLabel id="label5" style="left: 50%; top: 160px; position: absolute; text-align: left; width: 20%" value="Celular: *"/>
                                <ice:outputLabel id="label6" style="left: 15%; top: 300px; position: absolute; text-align: left; width: 15%" value="Estado Civil: *"/>
                                <ice:outputLabel id="label7" style="height: 22px; left: 50%; top: 295px; position: absolute; text-align: left; width: 20%" value="Sexo: *"/>
                                <ice:inputText id="txtcedula" maxlength="10" onchange="toEntero(this);" onkeyup="toEntero(this);" required="true"
                                    style="left: 30%; top: 70px; position: absolute; text-align: left" validator="#{RegistrarPersonal.txtcedula_validate}" value="#{RegistrarPersonal.servicioEmpleado.empleadoEdicion.cedula}"/>
                                <ice:inputText id="txtapellido" onchange="toCadena( this);" onkeyup="toCadena( this);" required="true"
                                    style="left: 30%; top: 118px; position: absolute" validator="#{RegistrarPersonal.lengthValidatorapellido.validate}" value="#{ServicioEmpleado.empleadoEdicion.apellido}"/>
                                <ice:inputText id="txtdoapellido" onchange="toCadena( this);" onkeyup="toCadena( this);" required="true"
                                    style="left: 70%; top: 118px; position: absolute" validator="#{RegistrarPersonal.lengthValidatordoapellido.validate}" value="#{ServicioEmpleado.empleadoEdicion.apellidodos}"/>
                                <ice:inputText id="txtnombre" onchange="toCadena( this);" onkeyup="toCadena( this);" required="true"
                                    style="left: 30%; top: 165px; position: absolute" validator="#{RegistrarPersonal.lengthValidatornombre.validate}" value="#{ServicioEmpleado.empleadoEdicion.nombres}"/>
                                <ice:inputText id="txtcelular" maxlength="9" onchange="toEntero( this);" onkeyup="toEntero( this);" required="true"
                                    style="left: 70%; top: 165px; position: absolute" validator="#{RegistrarPersonal.lengthValidatorcelular.validate}" value="#{ServicioEmpleado.empleadoEdicion.celular}"/>
                                <ice:inputText action="#{RegistrarPersonal.txtdireccion_action}" id="txtdireccion" maxlength="150" required="true"
                                    style="left: 30%; top: 340px; position: absolute; width: 384px" value="#{ServicioEmpleado.empleadoEdicion.direccion}"/>
                                <h:selectOneMenu id="dropsexo" required="true" style="left: 70%; top: 300px; position: absolute; width: 120px" value="#{RegistrarPersonal.servicioEmpleado.empleadoEdicion.sexo}">
                                    <f:selectItems id="dropdown1SelectItems" value="#{RegistrarPersonal.sexo}"/>
                                </h:selectOneMenu>
                                <h:selectOneMenu id="dropestadocivil" required="true" style="left: 30%; top: 300px; position: absolute; width: 117px" value="#{RegistrarPersonal.servicioEmpleado.empleadoEdicion.estadocivil}">
                                    <f:selectItems id="dropdown1SelectItems1" value="#{RegistrarPersonal.estadoCivil}"/>
                                </h:selectOneMenu>
                                <ice:commandButton action="#{RegistrarPersonal.btnaceptar_action}" id="btnaceptar" image="/resources/btnAceptar.png"
                                    style="height: 46px; left: 70%; top: 410px; position: absolute; width: 142px" value="Aceptar"/>
                                <ice:outputLabel id="label9" style="left: 50%; top: 216px; position: absolute; text-align: left; width: 20%" value="Clave: *"/>
                                <ice:outputLabel id="label12" style="left: 50%; top: 120px; position: absolute; text-align: left; width: 20%" value="Segundo Apellido: *"/>
                                <ice:outputLabel id="label15" style="left: 15%; top: 340px; position: absolute; text-align: left; width: 15%" value="Dirección: *"/>
                                <ice:inputSecret id="secretclave" redisplay="true" required="true" style="left: 70%; top: 214px; position: absolute"
                                    validator="#{RegistrarPersonal.lengthValidatorclave.validate}" value="#{ServicioEmpleado.empleadoEdicion.clave}"/>
                                <ice:outputLabel id="label1" style="left: 15%; top: 260px; position: absolute; text-align: left; width: 15%" value="Rol: *"/>
                                <ice:outputLabel id="label10" style="left: 50%; top: 255px; position: absolute; text-align: left; width: 20%" value="Estado: *"/>
                                <h:selectOneMenu id="drpdownrol" style="left: 30%; top: 260px; position: absolute; width: 120px" value="#{RegistrarPersonal.servicioEmpleado.empleadoEdicion.rol}">
                                    <f:selectItems id="dropdown1SelectItems2" value="#{RegistrarPersonal.rol}"/>
                                </h:selectOneMenu>
                                <h:selectOneMenu id="drpdownestado" style="left: 70%; top: 260px; position: absolute; width: 120px" value="#{RegistrarPersonal.servicioEmpleado.empleadoEdicion.estado}">
                                    <f:selectItems id="dropdown1SelectItems3" value="#{RegistrarPersonal.estado}"/>
                                </h:selectOneMenu>
                                <ice:inputText id="txtusuario" required="true" style="left: 30%; top: 214px; position: absolute"
                                    validator="#{RegistrarPersonal.lengthValidatorusuario.validate}" value="#{ServicioEmpleado.empleadoEdicion.usuario}"/>
                                <ice:outputLabel id="label13" style="left: 15%; top: 216px; position: absolute; text-align: left; width: 15%" value="Usuario: *"/>
                                <ice:message for="txtcedula" id="message1" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 30%; top: 50px; position: absolute"/>
                                <ice:message for="txtapellido" id="message2" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 30%; top: 90px; position: absolute"/>
                                <ice:message for="txtdoapellido" id="message3" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 70%; top: 90px; position: absolute; width: 119px"/>
                                <ice:message for="txtnombre" id="message4" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 30%; top: 140px; position: absolute"/>
                                <ice:message for="txtcelular" id="message5" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 70%; top: 140px; position: absolute; width: 119px"/>
                                <ice:message for="txtdireccion" id="message6" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 30%; top: 320px; position: absolute"/>
                                <ice:message for="secretclave" id="message7" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 70%; top: 190px; position: absolute; width: 143px"/>
                                <ice:message for="txtusuario" id="message8" showDetail="false" showSummary="true" style="color: rgb(255, 0, 0); left: 30%; top: 190px; position: absolute"/>
                                <ice:outputLabel id="label17" style="left: 50%; top: 72px; position: absolute; text-align: left; width: 20%" value="Fecha de Nacimiento: *"/>
                                <ice:selectInputDate id="calendar1" renderAsPopup="true" renderMonthAsDropdown="true" renderYearAsDropdown="true"
                                    style="height: 24px; left: 70%; top: 72px; position: absolute; text-align: left; width: 25%" value="#{ServicioEmpleado.empleadoEdicion.fechaNac}"/>
                                <ice:commandButton action="#{RegistrarPersonal.btncancelar_action}" id="btncancelar" image="/resources/btnVolver.png"
                                    immediate="true" partialSubmit="true"
                                    style="border: 1px solid rgb(204, 204, 204); height: 48px; left: 15%; top: 410px; position: absolute; width: 144px" value="CANCELAR"/>
                                <ice:outputLabel id="label11" style="left: 15%; top: 370px; position: absolute; text-align: left" value="Los campos Marcados con (*) son Obligatorios"/>
                            </ice:panelLayout>
                        </div>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
