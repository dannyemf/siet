<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Cliente
    Created on : 01/06/2010, 11:16:51 PM
    Author     : Administrator
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="html1">
            <head id="head1" title="SIET- CLIENTE">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
            </head>
            <body id="body1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height: 100%; left: 0px; top: 0px; position: absolute; width: 100%">
                        <div align="center">
                            <ice:panelLayout id="panecabeza" style="border-width: 0px; border-style: dotted; height: 100px; top: 0%; position: relative; width:960px">
                                <ice:graphicImage height="100px" id="graphicImage1" value="/resources/cabeza.jpg" width="960px"/>
                            </ice:panelLayout>
                        </div>
                        <div align="center">
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid rgb(0, 51, 51); height: 470px; left: 0px; top: 5px; position: relative; width: 960px">
                                <ice:outputLabel id="label1"
                                    style="background-color: rgb(255, 255, 255); font-size: 18px; font-style: italic; left: 30%; top: 48px; position: absolute; text-align: left; width: 190px" value="BIENVENIDO"/>
                                <ice:panelLayout id="panelLayout2" style="border-width: 1px; border-style: solid; border-color: rgb(255, 255, 255) rgb(255, 255, 255) rgb(255, 255, 255) rgb(255, 255, 255); background-color: #304357; height: 100%; left: 0px; top: 0px; position: absolute; width: 25%">
                                    <ice:outputLabel id="label7"
                                        style="background-color: rgb(48, 67, 87); color: rgb(255, 255, 255); font-size: 18px; left: 0px; top: 24px; position: absolute; text-align: center; width: 100%" value="OPCIONES :"/>
                                    <ice:commandButton action="#{PaginaCliente.btnsubirdoc_action}" id="btnsubirdoc" image="/resources/btnSubirD.png"
                                        style="border-color: rgb(0, 0, 0); height: 45px; left: 5%; top: 72px; position: absolute; width: 90%"
                                        title="Ingrese aquí para subir la documentación: cédula, plano, etc." value="Subir Documentación"/>
                                    <ice:commandButton action="#{PaginaCliente.btnmodificarinf_action}" id="btnmodificarinf" image="/resources/btnModifD.png"
                                        style="background-color: rgb(51, 102, 0); color: rgb(255, 255, 255); height: 45px; left: 5%; top: 120px; position: absolute; width: 90%"
                                        title="Aquí usted puede cambiar sus datos personales y la clave" value="Modificar Información"/>
                                    <ice:commandButton action="#{PaginaCliente.btnsalir_action}" id="btnsalir" image="/resources/cerrarcesion.png"
                                        style="height: 45px; left: 5%; top: 216px; position: absolute; width: 90%" title="Salir del sistema de forma segura" value="Salir"/>
                                    <ice:commandButton action="#{PaginaCliente.btntipovivienda_action}" id="btntipovivienda"
                                        image="/resources/btnSeleccTipoV.png" style="height: 45px; left: 5%; top: 168px; position: absolute; width: 90%"
                                        title="Aquí usted puede incribirse a un proyecto de vivienda" value="Selecionar el tipo de Vivienda"/>
                                </ice:panelLayout>

                                <ice:outputText id="outputText1" style="left: 30%; top: 75px; position: absolute; text-align: left; width: 261px" value="#{ServicioCliente.clienteLogeado.nombre} #{ServicioCliente.clienteLogeado.apellido}"/>

                                <div style="left: 30%; top: 120px; position: absolute; text-align: left; width: 400px">
                                    <p style="text-align: justify">
                                        Estimado cliente, usted ha ingresado al sistema "Su casa propia". Con la finalidad de que su trámite sea aprobado sírvase verificar los siguientes pasos:
                                    </p>

                                    <ul style="text-align: justify">
                                        <li>Documentación (Botón subir documentos)</li>
                                        <li>Datos personales (Botón modificar datos)</li>
                                        <li>Seleccionar el tipo de vivienda (Botón selección tipo de vivienda)</li>
                                    </ul>
                                </div>

                                <ice:panelGrid columns="2" styleClass="panelAyuda">
                                    <div title="Manual de usuario (pdf)">
                                        <ice:outputResource id="orAyuda" attachment="false" fileName="ayuda.pdf" label="Ayuda" mimeType="application/pdf" image="/resources/helppdf_button.png"
                                        resource="#{ServicioAyuda.recursoAyuda}" shared="true"/>
                                    </div>
                                </ice:panelGrid>
                                
                            </ice:panelLayout>
                        </div>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
