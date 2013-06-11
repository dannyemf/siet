<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : LoginAdmin
    Created on : 10/06/2010, 01:17:14 AM
    Author     : Administrator
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="html1">
            <head id="head1">
                <title>
                    Entidadsucasapropia - LoginAdmin
                </title>
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
                <script id="script-entrada" url="/js/Entrada.js"></script>
            </head>
            <body id="body1" style="-rave-layout: grid">
                <ice:form id="form1" title="entidadsucasapropia - login Admin">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height: 100%; left: 0px; top: 0%; position: absolute; width:100%">
                        <ice:panelLayout id="pane1" style="border-width: 0px; border-style: dotted; background-color: #999999; height: 100%; left: 0px; top: 0%; position: absolute; width: 10%"/>
                        <ice:panelLayout id="panecabeza" style="border-width: 0px; border-style: dotted; height: 25%; left: 10%; top: 0%; position: absolute; width:80%">
                            <ice:graphicImage height="100%" id="graphicImage1" value="/resources/cabeza.jpg" width="100%"/>
                        </ice:panelLayout>
                        <ice:panelLayout id="panecuerpo" style="border: 1px solid #003333; height: 75%; left: 10%; top: 25%; position: absolute; width: 80%">
                            <ice:panelLayout id="panelLayout2" style="border: 1px solid rgb(0, 0, 0); background-color: #304357; height: 100%; left: 0px; top: 0px; position: absolute; width: 25%"/>
                            <ice:panelLayout id="panelLayout1" style="border-width: 1px; border-style: solid; border-color: rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0); background-color: rgb(255, 255, 255); height: 189px; left: 40%; top: 72px; position: absolute; width: 309px">
                                <ice:outputLabel id="label3"
                                    style="background-color: rgb(255, 255, 255); color: #000000; left: 0px; top: 0px; position: absolute; text-align: center; width: 309px" value="ADMINISTRADOR DEL SISTEMA"/>
                                <ice:outputLabel id="label1" style="left: 24px; top: 48px; position: absolute; width: 131px" value="Usuario:"/>
                                <ice:inputText id="txtusuario1" required="true" style="left: 166px; top: 46px; position: absolute; width: 120px" value="#{LoginAdmin.usuario}"/>
                                <ice:outputLabel id="label2" style="left: 24px; top: 72px; position: absolute; width: 127px" value="Contraseña:"/>
                                <ice:inputSecret id="secretField1" redisplay="true" required="true"
                                    style="left: 166px; top: 70px; position: absolute; width: 120px" value="#{LoginAdmin.clave}"/>
                                <h:outputText id="outputText1" style="color: rgb(255, 0, 0); left: 24px; top: 100px; position: absolute;Width: 237px" value="#{LoginAdmin.mensaje}"/>
                                <ice:commandButton action="#{LoginAdmin.btnvolveradm1_action}" id="btnvolveradm1" image="/resources/btnInicio_1.png"
                                    immediate="true" partialSubmit="true" style="height: 45px; left: 24px; top: 120px; position: absolute; width: 120px" value="submit"/>
                                <ice:commandButton action="#{LoginAdmin.btningresar1_action}" id="btningresar1" image="/resources/btnIngreso123.png"
                                    style="height: 45px; left: 168px; top: 120px; position: absolute; width: 120px" value="submit"/>
                            </ice:panelLayout>
                        </ice:panelLayout>
                        <ice:panelLayout id="pane1b" style="border-width: 0px; border-style: dotted; background-color: #999999; height: 100%; left: 90%; top: 0%; position: absolute; width: 10%"/>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
