<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : AdministrarEmpleado
    Created on : 03/06/2010, 11:12:35 PM
    Author     : Administrator
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="html1">
            <head id="head1" title="SIET - ADMINISTRAR EMPLEADO">
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
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid #999999; height: 470px; left: 0%; top: 5px; position: relative; width: 960px">
                                <ice:panelLayout id="panelLayout2" style="border-width: 1px; border-style: solid; border-color: rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0); background-color: rgb(48, 67, 87); height: 50%; position: absolute; width: 25%">
                                    <ice:outputLabel id="outputLabel1"
                                        style="color: rgb(255, 255, 255); left: 0px; top: 20px; position: absolute; text-align: center; width: 100%" value="                    Buscar por Apellido"/>
                                    <ice:inputText id="txt_Buscar1" style="margin: 2px; height: 30px; left: 20%; top: 50px; position: absolute; width: 60%" value="#{AdministrarPersonal.apellido}"/>
                                    <ice:commandButton action="#{AdministrarPersonal.btn_Buscar1_action}" id="btn_Buscar1" image="/resources/buscarwhite.png"
                                        style="height: 37px; left: 20%; top: 100px; position: absolute; width: 60%" value="BUSCAR"/>
                                    <ice:commandButton action="#{AdministrarPersonal.btnvolver_action}" id="btnvolver" image="/resources/volverok.png"
                                        style="height: 38px; left: 20%; top: 150px; position: absolute; width: 60%" value="PANEL DE CONTROL"/>
                                </ice:panelLayout>
                                <ice:panelLayout id="panelLayout22" style="border-width: 1px; border-style: solid; border-color: rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0);background-color: rgb(48, 67, 87); top: 52%; height: 50%; position: absolute; width: 25%">
                                    <ice:outputLabel id="outputLabel15"
                                        style="color: rgb(255, 255, 255); left: 0px; top: 20px; position: absolute; text-align: center; width: 100%" value="                    Crear Nuevo Empleado"/>
                                    <ice:commandButton action="#{AdministrarPersonal.bntnuevoempleado_action}" id="bntnuevoempleado"
                                        image="/resources/nuevoEwhit.png"
                                        style="height: 38px; left: 20%; top: 60px; position: absolute; text-align: center; width: 60%" value="NUEVO EMPLEADO"/>
                                </ice:panelLayout>
                                <div align="center">
                                    <ice:outputLabel id="label1"
                                        style="font-size: 18px; left: 25%; top: 30px; position: absolute; text-align: center; width: 717px" value="DATOS DEL PERSONAL REGISTRADO EN EL SISTEMA"/>
                                </div>
                                <ice:panelLayout id="panelLayout55" style="border: 0px solid rgb(0, 0, 0); height: 75%; left: 30%; top: 70px; position: absolute; width: 65%">
                                    <div align="center" style="overflow:auto; width:auto; height:260px">
                                        <ice:dataTable headerClass="list-header" id="dataTable1" rowClasses="list-row-even,list-row-odd"
                                            style="  position: relative " value="#{AdministrarPersonal.modelEmpleados}" var="e">
                                            <h:column id="column11">
                                                <h:outputText id="outputText1" value="#{e.cedula}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText2" value=" Cédula "/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column2">
                                                <h:outputText id="outputText3" value="#{e.nombres}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText4" value=" Nombre "/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column3">
                                                <h:outputText id="outputText5" value="#{e.apellido}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText6" value=" Apellido "/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column5">
                                                <h:outputText id="outputText9" value="#{e.direccion}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText10" value=" Dirección  "/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column6">
                                                <h:outputText id="outputText11" value="#{e.celular}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText12" style="left: 45%" value=" Celular "/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column7">
                                                <h:outputText id="outputText13" value="#{e.rol}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText14" value=" Rol    "/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column10">
                                                <h:outputText id="outputText19" value="#{e.usuario}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText28" value=" Usuario "/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column8">
                                                <h:outputText id="outputText15" value="#{e.estado}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText16" value=" Estado "/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column9">
                                                <h:outputText id="outputText17" value="#{e.fechaRegistro}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText18" value=" Fecha Registro "/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column1">
                                                <ice:panelGrid id="gridPanel1">
                                                    <h:commandLink action="#{AdministrarPersonal.linkActionEditar_action}" id="linkActionEditar"
                                                        style="color: #003333; text-decoration: underline" value="Editar"/>
                                                </ice:panelGrid>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText20" value=" Opción "/>
                                                </f:facet>
                                            </h:column>
                                        </ice:dataTable>
                                    </div>
                                </ice:panelLayout>
                            </ice:panelLayout>
                        </div>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
