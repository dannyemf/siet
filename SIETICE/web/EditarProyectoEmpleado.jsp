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
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height: 100%; left: 0px; top: 0px; position: absolute; width: 100%">
                        <ice:panelLayout id="panecabeza" style="border-width: 0px; border-style: dotted; height: 100px; position: relative; width: 960px">
                            <ice:graphicImage height="100%" id="graphicImage1" value="/resources/cabeza.jpg" width="100%"/>
                        </ice:panelLayout>
                        <ice:panelLayout id="panecuerpo" style=" border: 1px solid rgb(153, 153, 153); height: 470px; left: 1px; top: 5px; position: relative; width: 960px">
                            <ice:outputLabel id="label2" style="left: 15%; top: 72px; position: absolute" value="Titular : "/>
                            <ice:outputLabel id="label5" style="left: 50%; top: 120px; position: absolute; width: 119px" value="Presupuesto:"/>
                            <ice:outputLabel id="label6" style="height: 24px; left: 15%; top: 216px; position: absolute" value="Estado:"/>
                            <ice:outputLabel id="label7" style="left: 15%; top: 264px; position: absolute" value="Tipo  de Vivienda:"/>
                            <ice:inputText id="txtpresupuesto" onchange="toEntero(this)" onkeyup="toEntero(this)" readonly="true"
                                style="left: 70%; top: 118px; position: absolute; width: 70px" value="#{EditarProyectoCliente.servicioProyecto.proyectoClienteEdicion.tipoVivienda.presupuesto}"/>
                            <ice:inputText id="txtavance" onchange="toEntero(this)" onkeyup="toEntero(this)"
                                style="left: 70%; top: 214px; position: absolute; width: 71px" value="#{ServicioProyecto.proyectoClienteEdicion.avance}"/>
                            <ice:inputText id="txtubicacion" style="left: 30%; top: 166px; position: absolute; width: 431px" value="#{ServicioProyecto.proyectoClienteEdicion.ubicacion}"/>
                            <h:selectOneMenu id="droptipovivienda" style="left: 30%; top: 264px; position: absolute; width: 120px"
                                value="#{EditarProyectoEmpleado.idTipo}" valueChangeListener="#{EditarProyectoEmpleado.droptipovivienda_processValueChange}">
                                <f:selectItems id="dropdown1SelectItems" value="#{EditarProyectoEmpleado.tipovivienda}"/>
                            </h:selectOneMenu>
                            <h:selectOneMenu id="dropestado" style="left: 30%; top: 216px; position: absolute; width: 120px" value="#{ServicioProyecto.proyectoClienteEdicion.estado}">
                                <f:selectItems id="dropdown1SelectItems1" value="#{EditarProyectoEmpleado.estado}"/>
                            </h:selectOneMenu>
                            <ice:commandButton action="#{EditarProyectoEmpleado.btnaceptar_action}" id="btnaceptar" image="/resources/btnAceptar.png"
                                style="height: 45px; left: 70%; top: 370px; position: absolute; width: 168px" value="Aceptar"/>
                            <ice:outputLabel id="label8"
                                style="background-color: rgb(255, 255, 255); color: rgb(0, 51, 51); font-size: 18px; left: 0%; top: 40px; position: absolute; text-align: center; width: 100%" value="         DATOS DE LA OBRA"/>
                            <ice:outputLabel id="label15" style="left: 15%; top: 168px; position: absolute" value="Ubicación:"/>
                            <ice:outputLabel id="label1" style="left: 50%; top: 216px; position: absolute" value="Avance: "/>
                            <ice:commandButton action="#{EditarProyectoEmpleado.btnvolver_action}" id="btncancelar" image="/resources/btnVolver.png"
                                partialSubmit="true" style="height: 48px; left: 15%; top: 370px; position: absolute; width: 166px" value="CANCELAR"/>
                            <ice:outputText id="outputTitular" style="font-style: oblique; left: 30%; top: 72px; position: absolute; width: 190px" value="#{EditarProyectoCliente.servicioProyecto.proyectoClienteEdicion.propietario.nombre} #{EditarProyecto.servicioProyecto.proyectoClienteEdicion.propietario.apellido}"/>
                            <ice:outputText id="outputText3" style="left: 15%; top: 120px; position: absolute" value="Residente:"/>
                            <ice:inputText id="dropResidente" immediate="true" label="nbv" style="left: 30%; top: 118px; position: absolute; width: 168px" value="#{EditarProyectoCliente.servicioProyecto.proyectoClienteEdicion.residente}"/>
                            <ice:outputLabel id="label3" style="left: 50%; top: 264px; position: absolute; width: 141px" value="Fecha de Entrega:"/>
                            <ice:selectInputDate id="selectInputDate1" renderAsPopup="true" renderMonthAsDropdown="true" renderYearAsDropdown="true"
                                style="height: 93px; left: 70%; top: 264px; position: absolute; width: 190px"
                                value="#{EditarProyectoEmpleado.servicioProyecto.proyectoClienteEdicion.fechaEntrega}" valueChangeListener="#{EditarProyectoEmpleado.selectInputDate1_processValueChange}"/>
                        </ice:panelLayout>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
