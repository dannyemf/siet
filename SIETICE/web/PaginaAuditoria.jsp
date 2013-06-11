<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : PaginaAuditoria
    Created on : 11/12/2010, 11:01:29 PM
    Author     : LENIN 
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
                <script id="script-entrada" language="javascript" src="./js/Entrada.js"></script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height: 100%; left: 0px; top: 0px; position: absolute; width: 100%">
                        <div align="center">
                            <ice:panelLayout id="panecabeza" style="border-width: 0px; border-style: dotted; height: 100px;  top: 0%; position: relative; width:960px">
                                <ice:graphicImage height="100px" id="graphicImage1" value="/resources/cabeza.jpg" width="960px"/>
                            </ice:panelLayout>
                        </div>
                        <div align="center">
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid #999999; height: 470px; top: 5px; position: relative; width: 960px">
                                <ice:panelLayout id="panelLayout2" style="border: 1px solid rgb(0, 0, 0); background-color: rgb(48, 67, 87); height: 100%; position: absolute; width: 35%">
                                    <ice:outputLabel id="label11"
                                        style="color: white; height: 27px; left: 0px; top: 15px; position: absolute; text-align: center; width: 100%" value="Seleccionar Fecha"/>
                                    <ice:selectInputDate id="sidFechaInicial" renderAsPopup="true" renderMonthAsDropdown="true" renderYearAsDropdown="true"
                                        style="height: 212px; left: 24px; top: 45px; position: absolute;" value="#{PaginaAuditoria.fechaInicial}">
                                        <f:convertDateTime dateStyle="short" pattern="dd/MM/yyyy" timeZone="#{PaginaAuditoria.timeZone}"/>
                                    </ice:selectInputDate>
                                    <ice:outputText id="outputText1"
                                        style="color: white; height: 27px; left: 200px; top: 43px; position: absolute; width: 120px" value="&lt;&lt; Fecha Inicial"/>
                                    <ice:selectInputDate id="sidFechaFinal" renderAsPopup="true" renderMonthAsDropdown="true" renderYearAsDropdown="true"
                                        style="height: 212px; left: 24px; top: 100px; position: absolute;" value="#{PaginaAuditoria.fechaFinal}">
                                        <f:convertDateTime dateStyle="short" pattern="dd/MM/yyyy" timeZone="#{PaginaAuditoria.timeZone}"/>
                                    </ice:selectInputDate>
                                    <ice:outputText id="outputText2"
                                        style="color: white; height: 27px; left: 200px; top: 100px; position: absolute; width: 120px" value="&lt;&lt; Fecha Final"/>
                                    <ice:selectOneMenu id="cmbAccion" partialSubmit="true" style="left: 22px; top: 166px; position: absolute; width: 95px" value="#{PaginaAuditoria.accion}">
                                        <f:selectItems id="selectOneMenu1selectItems" value="#{PaginaAuditoria.listaAcciones}"/>
                                    </ice:selectOneMenu>
                                    <ice:outputText id="outputText3"
                                        style="color: white; height: 27px; left: 130px; top: 166px; position: absolute; width: 155px" value="Seleccionar Acción"/>
                                    <ice:selectOneMenu id="cmbEntidad" partialSubmit="true" style="left: 22px; top: 190px; position: absolute; width: 95px" value="#{PaginaAuditoria.entidad}">
                                        <f:selectItems id="selectOneMenu2selectItems" value="#{PaginaAuditoria.listaEntidades}"/>
                                    </ice:selectOneMenu>
                                    <ice:outputText id="outputText4"
                                        style="color: white; height: 27px; left: 130px; top: 190px; position: absolute; width: 155px" value="Seleccionar Entidad"/>
                                    <ice:inputText action="#{PaginaAuditoria.txtCliente_action}" id="txtCliente" maxlength="10" onchange="toEntero(this);"
                                        onkeyup="toEntero(this);" style="left: 22px; top: 235px; position: absolute" value="#{PaginaAuditoria.ciCliente}"/>
                                    <ice:outputText id="outputText5" style="color: white; left: 192px; top: 235px; position: absolute" value="Cédula"/>
                                    <ice:commandButton action="#{PaginaAuditoria.btnGenerar_action}" id="btnGenerar" image="/resources/generarok.png"
                                        style="height: 37px; left: 20%; top: 290px; position: absolute; width: 60%" value="Generar"/>
                                    <ice:commandButton action="#{PaginaAuditoria.btnLimpiar_action}" id="btnLimpiar" image="/resources/limpiarok_1.png"
                                        style="height: 37px; left: 20%; top: 325px; position: absolute; width: 60%" value="Limpiar Todo"/>
                                    <ice:commandButton action="#{PaginaAuditoria.btnAtras_action}" id="btnAtras" image="/resources/volverok.png"
                                        style="height: 37px; left: 20%; top: 360px; position: absolute; width: 60%" value="Atras"/>
                                </ice:panelLayout>
                                <ice:outputLabel id="label17"
                                    style="font-size: 18px; height: 20px; left: 36%; top: 20px; position: absolute; text-align: center; width: 64%" value="LISTA DE ACCESOS AL SISTEMA"/>
                                <ice:panelLayout id="panelLayout55" style="border-width: 0px; border-style: solid; height: 75%; left: 38%; top: 70px; position: absolute; width: 60%">
                                    <div align="center" style="overflow:auto; width:auto; height:300px">
                                        <ice:dataTable id="tablaAuditoria" style="left: 0%; overflow: auto; position: relative; text-align: center; width: 100%"
                                            value="#{PaginaAuditoria.listaAuditoria}" var="a">
                                            <ice:column id="column1" style="width: 220px">
                                                <ice:outputText id="outputText7" value="#{a.fecha}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText8" value="FECHA"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column2">
                                                <ice:outputText id="outputText9" value="#{a.accion}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText10" value="ACCION"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column3">
                                                <ice:outputText id="outputText11" value="#{a.entidad}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText12" value="ENTIDAD"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column4">
                                                <ice:outputText id="outputText13" value="#{a.cliente.nombre} #{a.cliente.apellido}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText14" value="CLIENTE"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column5">
                                                <ice:outputText id="outputText15" value="#{a.empleado.nombres} #{a.empleado.apellido}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText16" value="EMPLEADO"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </div>
                                </ice:panelLayout>

                                <ice:panelGrid columns="2" styleClass="panelAyuda panelAyudaOneButton">
                                            <ice:commandButton id="btnAyuda" image="/resources/help_button.png" immediate="true" actionListener="#{ServicioAyuda.showPopup}" value="Ayuda"
                                            title="Ayuda auditoría"/>
                                </ice:panelGrid>
                                
                            </ice:panelLayout>

                            <!-- Panel Popup Ayuda -->
                            <ice:panelPopup autoCentre="true" draggable="true" id="modalPnlPop" modal="true" styleClass="corePopup" visible="#{ServicioAyuda.visiblePopup}">
                                <f:facet name="header">
                                    <ice:panelGroup styleClass="popupHeaderWrapper">
                                        <ice:outputText styleClass="popupHeaderText" value="Ayuda - Auditoría"/>
                                        <ice:commandButton actionListener="#{ServicioAyuda.closePopup}" alt="Cerrar" id="modalPnlCloseBtn"
                                            image="/resources/popupclose.gif" styleClass="popupHeaderImage" title="Cerrar" type="button"/>
                                    </ice:panelGroup>
                                </f:facet>
                                <f:facet name="body">
                                    <ice:panelGroup styleClass="popupBody" style="width: 500px">
                                        <p><b>Auditoría</b></p>

                                        <p>En esta sección se lista los logs de auditoría.</p>

                                        <p>Un log de auditoría es un registro que guarda información de las acciones realizadas tanto por los empleados como por los clientes, siendo de los siguientes tipo:</p>

                                        <ul>
                                            <li>Inicio de sesión</li>
                                            <li>Cierre de sesión</li>
                                            <li>Creación de un registro en la base de datos</li>
                                            <li>Modificación de un registro en la base de datos</li>
                                            <li>Eliminación de un registro de la base de datos</li>
                                        </ul>

                                        <p>
                                            <b>Generación del reporte</b>
                                            <br/>
                                            <ol>
                                                <li>Seleccione la fecha inicial (Desde cuando quiere revisar los logs)</li>
                                                <li>Seleccione la fecha final (Hasta cuando quiere revisar los logs)</li>
                                                <li>Elija la acción o tipo de operación realizada sobre un registro (Dejar en todos si no desea filtrar por este campo)</li>
                                                <li>Elija la entidad o tipo de usuario del que desee ver los logs de auditoría</li>
                                                <li>Ingrese el número de cédula si desea ver los logs de un cliente o empleado en específico, de lo contrario dejar vacío</li>
                                                <li>Presione el botón buscar</li>
                                            </ol>
                                        </p>

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
