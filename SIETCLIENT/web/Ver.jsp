<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Ver
    Created on : 19/10/2010, 07:50:11 AM
    Author     : LENIN
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>
                    Ministerio de Desarrollo Urbano y Vivienda "MIDUVI" - Servicio ClienteWeb [Aprovación]
                </title>
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height:250%; left: 0px; top: 0px; position: absolute; width: 100%">
                        <ice:panelLayout id="pane1" style="border-width: 0px; border-style: dotted; background-color: #999999; height: 100%; left: 0px; top: 0%; position: absolute; width: 10%"/>
                        <ice:panelLayout id="panecabeza" style="height: 10%; left: 10%; top: 0%; position: absolute; width: 80%">
                            <ice:graphicImage height="100%" id="graphicImage1" url="/resources/cabeza_1.jpg" value="/resources/cabeza_1.jpg" width="100%"/>
                        </ice:panelLayout>
                        <ice:panelLayout id="panecuerpo" style="border: 1px solid rgb(0, 51, 51); height: 90%; left: 10%; top: 10%; position: absolute; width: 80%">
                            <ice:panelLayout id="panelLayout2" style="background-color: rgb(48, 67, 87); height: 100%; position: absolute; width: 25%">
                                <ice:commandButton action="#{Ver.btnAtras_action}" id="btnAtras" image="/resources/volverok.png" immediate="true"
                                    style="height: 37px; left: 20%; top: 100px; position: absolute; width: 60%" value="Atras"/>
                            </ice:panelLayout>
                            <div align="center">
                                <ice:outputLabel id="label1" style="left: 25%; top: 30px; position: absolute; text-align: center; width: 75%" value="DATOS DE CLIENTES REGISTRADOS EN EL SISTEMA"/>
                            </div>
                            <ice:panelLayout id="panelLayout55" style="border: 0px solid rgb(0, 0, 0); height: 95%; left: 30%; top: 50px; position: absolute; width: 65%">
                                <ice:panelTabSet id="panelTabSet1" selectedIndex="2"
                                    style="left: 0%; top: 10px; position: absolute; text-align: center; width: 100%"
                                    tabChangeListener="#{Ver.panelTabSet1_processTabChange}" tabPlacement="Top" width="696">
                                    <ice:panelTab id="panelTab1" label="Proyecto">
                                        <ice:panelGrid columns="2" id="panelGridProyecto">
                                            <ice:outputText id="lblProyEstado" value="Estado"/>
                                            <ice:inputText id="txtProyEstado" readonly="true" value="#{ServicioProyecto.proyectoEdicion.estado}"/>
                                            <ice:outputText id="lblProyPresupuesto" value="Presupuesto"/>
                                            <ice:inputText id="txtProyPresu" readonly="true" value="#{ServicioProyecto.proyectoEdicion.tipoVivienda.presupuesto}"/>
                                            <ice:outputText id="lblProyUbicacion" value="Ubicacion"/>
                                            <ice:inputTextarea id="txtProyUbica" readonly="true" value="#{ServicioProyecto.proyectoEdicion.ubicacion}"/>
                                        </ice:panelGrid>
                                    </ice:panelTab>
                                    <ice:panelTab id="panelTab2" label="Cliente">
                                        <ice:panelGrid columns="2" id="grodcli">
                                            <ice:outputText id="lblCliCi" value="CI"/>
                                            <ice:inputText id="txtCliCi" readonly="true" value="#{ServicioProyecto.proyectoEdicion.propietario.ci}"/>
                                            <ice:outputText id="lblCliNom" value="Nombres"/>
                                            <ice:inputText id="txtCliNom" readonly="true" value="#{ServicioProyecto.proyectoEdicion.propietario.nombre}"/>
                                            <ice:outputText id="lblCliApp" value="Apellido"/>
                                            <ice:inputText id="txtCliApp" readonly="true" value="#{ServicioProyecto.proyectoEdicion.propietario.apellido}"/>
                                            <ice:outputText id="lblCliCel" value="Celular"/>
                                            <ice:inputText id="txtCliCel" readonly="true" value="#{ServicioProyecto.proyectoEdicion.propietario.celular}"/>
                                            <ice:outputText id="lblCliEst" value="Estado Civil"/>
                                            <ice:inputText id="txtCliEst" readonly="true" value="#{ServicioProyecto.proyectoEdicion.propietario.estadoCivil}"/>
                                            <ice:outputText id="lblCliSex" value="Sexo"/>
                                            <ice:inputText id="txtCliSex" readonly="true" value="#{ServicioProyecto.proyectoEdicion.propietario.sexo}"/>
                                            <ice:outputText id="lblCliFec" value="Fecha Nac"/>
                                            <ice:inputText id="txtCliFec" readonly="true" value="#{ServicioProyecto.proyectoEdicion.propietario.fechaNac}"/>
                                            <ice:outputText id="lblCliDir" value="Direccion"/>
                                            <ice:inputTextarea id="txtCliDir" readonly="true" value="#{ServicioProyecto.proyectoEdicion.propietario.direccion}"/>
                                        </ice:panelGrid>
                                    </ice:panelTab>
                                    <ice:panelTab id="panelTab3" label="TipoVivienda">
                                        <ice:panelGrid columns="2" id="panelGridTipo">
                                            <ice:outputText id="lblTpNombre" value="Nombre Tipo"/>
                                            <ice:inputText id="txtTpNombre" readonly="true" value="#{ServicioProyecto.proyectoEdicion.tipoVivienda.tipo}"/>
                                            <ice:outputText id="lblTpArea" value="Area"/>
                                            <ice:inputText id="txtTpArea" readonly="true" value="#{ServicioProyecto.proyectoEdicion.tipoVivienda.area}"/>
                                            <ice:outputText id="lblTpPresu" value="Presupuesto"/>
                                            <ice:inputText id="txtTpPresu" readonly="true" value="#{ServicioProyecto.proyectoEdicion.tipoVivienda.presupuesto}"/>
                                            <ice:outputText id="lblTpEstr" value="Estructura"/>
                                            <ice:inputText id="txtTpEstr" readonly="true" value="#{ServicioProyecto.proyectoEdicion.tipoVivienda.estructura}"/>
                                            <ice:outputText id="lblTpCielo" value="Cielo  Razo"/>
                                            <ice:inputText id="txtTpCielo" readonly="true" value="#{ServicioProyecto.proyectoEdicion.tipoVivienda.cielorazo}"/>
                                            <ice:outputText id="lblTpParedes" value="Paredes"/>
                                            <ice:inputText id="txtTpParedes" readonly="true" value="#{ServicioProyecto.proyectoEdicion.tipoVivienda.paredes}"/>
                                            <ice:outputText id="lblTpCibierta" value="Cubierta"/>
                                            <ice:inputText id="txtTpCubierta" readonly="true" value="#{ServicioProyecto.proyectoEdicion.tipoVivienda.cubierta}"/>
                                            <ice:outputText id="lblTpRevestido" value="Revestido"/>
                                            <ice:inputText id="txtTprevestido" readonly="true" value="#{ServicioProyecto.proyectoEdicion.tipoVivienda.revestido}"/>
                                            <ice:outputText id="lblTpPiso" value="Piso"/>
                                            <ice:inputText id="txtTpPiso" readonly="true" value="#{ServicioProyecto.proyectoEdicion.tipoVivienda.piso}"/>
                                            <ice:outputText id="lblTpPuer" value="Puertas"/>
                                            <ice:inputText id="txtTpPuer" readonly="true" value="#{ServicioProyecto.proyectoEdicion.tipoVivienda.puertas}"/>
                                            <ice:outputText id="lblTpVent" value="Ventanas"/>
                                            <ice:inputText id="txtTpVent" readonly="true" value="#{ServicioProyecto.proyectoEdicion.tipoVivienda.ventanas}"/>
                                            <ice:outputText id="lblTpPlano" value="Plano"/>
                                            <ice:graphicImage alt="Plano no cargado" height="200" id="imgTpPlano"
                                                value="#{ServicioProyecto.proyectoEdicion.contextPath}planos/#{ServicioProyecto.proyectoEdicion.tipoVivienda.plano}" width="200"/>
                                        </ice:panelGrid>
                                    </ice:panelTab>
                                    <ice:panelTab id="tabDoc" label="Documentacion">
                                        <ice:panelGrid columns="2" id="dridDoc">
                                            <ice:outputText id="lblImgCedula" value="Cedula"/>
                                            <ice:graphicImage alt="No cargada" height="200" id="imgCedula"
                                            value="#{conf.siet_files_server}/documentos/#{ServicioProyecto.proyectoEdicion.propietario.documentacion.imgCedula}" width="200"/>
                                            <ice:outputText id="lblImgCert" value="Certificado"/>
                                            <ice:graphicImage alt="No cargada" height="200" id="imgCert"
                                                value="#{conf.siet_files_server}/documentos/#{ServicioProyecto.proyectoEdicion.propietario.documentacion.imgCertificado}" width="200"/>
                                            <ice:outputText id="lblImgEsc" value="Escritura"/>
                                            <ice:graphicImage alt="No cargada" height="200" id="imgEsc"
                                                value="#{conf.siet_files_server}/documentos/#{ServicioProyecto.proyectoEdicion.propietario.documentacion.imgEscritura}" width="200"/>
                                            <ice:outputText id="lblImgLib" value="Libreta"/>
                                            <ice:graphicImage alt="No cargada" height="200" id="imgLib"
                                                value="#{conf.siet_files_server}/documentos/#{ServicioProyecto.proyectoEdicion.propietario.documentacion.imgLibreta}" width="200"/>
                                            <ice:outputText id="lblImgTerr" value="Terreno"/>
                                            <ice:graphicImage alt="No cargada" height="200" id="imgTerr"
                                                value="#{conf.siet_files_server}/documentos/#{ServicioProyecto.proyectoEdicion.propietario.documentacion.imgTerreno}" width="200"/>
                                        </ice:panelGrid>
                                    </ice:panelTab>
                                    <ice:panelTab id="tabAp" label="Aprobar/Rechazar">
                                        <ice:panelGrid columns="2" id="gridAprobar">
                                            <ice:outputText id="lblObservacion" value="Observacion"/>
                                            <ice:inputTextarea id="txtObservacion" required="true" style="height: 200px; width: 416px" value="#{Ver.observacion}"/>
                                            <ice:outputText id="outputText3"/>
                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtObservacion" id="message1"
                                                infoClass="infoMessage" showSummary="true" warnClass="warnMessage"/>
                                        </ice:panelGrid>
                                        <ice:panelLayout id="gridComApr" layout="flow" style="text-align: center; width: 100%" visible="true">
                                            <ice:commandButton action="#{Ver.btnAprobar_action}" id="btnAprobar" value="Aprobar"/>
                                            <ice:commandButton action="#{Ver.btnRechazar_action}" id="btnRechazar" value="Rechazae"/>
                                        </ice:panelLayout>
                                    </ice:panelTab>
                                </ice:panelTabSet>
                                <ice:panelPopup draggable="true" id="popup" modal="true" rendered="#{Ver.popupShow}" style="width: 300px" visible="#{Ver.popupShow}">
                                    <f:facet name="header">
                                        <ice:panelGrid id="panelGrid1" style="display: block; height: 20px; width: 280px">
                                            <ice:outputText id="outputText1" value="Mensaje"/>
                                        </ice:panelGrid>
                                    </f:facet>
                                    <f:facet name="body">
                                        <ice:panelGrid id="panelGrid2" style="display: block; width: 280px">
                                            <ice:outputText id="outputText2" value="#{Ver.popupMensaje}"/>
                                            <ice:panelLayout id="panelLayout1" layout="flow" style="text-align: center">
                                                <ice:commandButton action="#{Ver.btnPopuAceptar_action}" id="btnPopuAceptar" value="Aceptar"/>
                                            </ice:panelLayout>
                                        </ice:panelGrid>
                                    </f:facet>
                                </ice:panelPopup>
                            </ice:panelLayout>
                        </ice:panelLayout>
                    </ice:panelLayout>
                    <ice:panelLayout id="pane1b" style="border-width: 0px; border-style: dotted; background-color: rgb(153, 153, 153); height: 250%; left: 90%; top: 0%; position: absolute; width: 10%"/>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
