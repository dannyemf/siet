<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : logincliente
    Created on : 01/06/2010, 10:47:38 PM
    Author     : Administrator
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="html1">
            <head id="head1" title="SIET - LOGIN CLIENTE">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
                <script id="script-entrada" language="javascript" src="./js/Entrada.js"></script>
            </head>
            <body id="body1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height: 100%; left: 0px; top: 0px; position: absolute; width: 100%">
                        <div align="center">
                            <ice:panelLayout id="panecabeza" style="border-width: 0px; border-style: dotted; height: 100px; top: 0%; position: relative; width: 960px">
                                <ice:graphicImage height="100%" id="graphicImage1" style="height: 100px; width: 960px" value="/resources/cabeza.jpg" width="100%"/>
                            </ice:panelLayout>
                        </div>
                        <div align="center">
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid #cccccc; height: 470px; top: 5px; position: relative; width: 960px; -rave-layouy: grid;">
                                <ice:panelLayout id="panelLayout2" style="border-width: 1px; border-color: rgb(0, 0, 0); background-color: rgb(48, 67, 87); height: 100%; left: 0px; top: 0px; position: absolute; width: 25%; -rave-layouy: grid;">
                                    <ice:outputLabel id="label2"
                                        style="color: rgb(255, 255, 255); font-size: 14px; left: 0px; top: 32px; position: absolute; text-align: center; width: 239px" value="Clientes Registrados"/>
                                    <ice:inputText id="txtcedula" maxlength="10" onchange="toEntero( this);" onkeyup="toEntero( this);" partialSubmit="true"
                                        style="left: 118px; top: 54px; position: absolute; width: 100px" title="Ingrese su número de cédula" value="#{LoginCliente.cedula}"/>
                                    <ice:outputLabel id="outputText1" style="color: rgb(204, 0, 0); top: 108px; " value="#{LoginCliente.mensaje}"/>
                                    <ice:inputSecret action="#{LoginCliente.btnaceptar_action}" id="inputSecret1"
                                        style="height: 24px; left: 118px; top: 78px; position: absolute; width: 100px" title="Ingrese la clave" value="#{LoginCliente.clave}"/>
                                    <ice:commandLink action="#{LoginCliente.commandLink1_action}" id="commandLink1"
                                        style="color: rgb(255, 0, 0); height: 22px; left: 0px; top: 160px; position: absolute; text-align: center; text-decoration: underline; width: 100%" value="Olvido su Clave"/>
                                    <ice:outputLabel id="label1" style="color: rgb(255, 255, 255); left: 24px; top: 56px; position: absolute" value="Cedula:"/>
                                    <ice:commandButton action="#{LoginCliente.btnaceptar_action}" id="btnaceptar" image="/resources/OKok.png"
                                        style="height: 30px; left: 20%; top: 120px; position: absolute; text-align: center; width: 60%"
                                        title="Presione aquí para ingresar" value="Ingresar"/>
                                    <ice:commandButton action="#{LoginCliente.btnvolver_action}" id="btnvolver" image="/resources/volveok.png"
                                        style="height: 30px; left: 48px; top: 330px; position: absolute; width: 60%" title="Regresar a la página principal" value="submit"/>
                                    <ice:commandButton action="#{LoginCliente.btnregistrarse_action}" id="btnregistrarse" image="/resources/registrarok.png"
                                        style="height: 30px; left: 48px; top: 282px; position: absolute; width: 60%"
                                        title="¡Si aún no se ha registrado!&#xa;&#xa;En esta sección puede registrase para poder acceder a los servicios de esta entidad" value="REGISTRARSE"/>
                                    <ice:outputLabel id="label3"
                                        style="color: rgb(255, 255, 255); font-size: 12px; height: 41px; left: 24px; top: 228px; position: absolute; text-align: justify; width: 80%" value="Si aún no esta inscrito en el sistema presione el siguiente boton"/>
                                    <ice:outputLabel id="label5" style="color: rgb(255, 255, 255); left: 24px; top: 80px; position: absolute" value="Clave:"/>
                                </ice:panelLayout>
                                <ice:panelLayout id="panelLayout55" style="border: 0px solid rgb(0, 0, 0); height: 100%; left: 27%; top: 0px; position: absolute; width: 65%">
                                    <ice:outputLabel id="label6"
                                        style="background-color: rgb(255, 255, 255); font-size: 24px; left: 0px; top: 24px; position: absolute; text-align: center; width: 621px" value="BIENVENIDOS"/>                                    
                                    <ice:graphicImage id="graphicImage2" style="height: 380px; left: 0%; top: 60px; position: absolute; width: 680px" value="/resources/pasos%20cliente2.png"/>
                                </ice:panelLayout>

                                <ice:panelGrid columns="2" styleClass="panelAyuda">
                                    <div title="Manual de usuario (pdf)">
                                        <ice:outputResource id="orAyuda" attachment="false" fileName="ayuda.pdf" label="Ayuda" mimeType="application/pdf" image="/resources/helppdf_button.png"
                                        resource="#{LoginCliente.recursoAyuda}" shared="true"/>
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
