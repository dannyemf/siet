<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Empleado
    Created on : 03/06/2010, 08:57:55 PM
    Author     : Administrator
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="html1">
            <head id="head1" title="SIET - PERSONAL TÉCNICO">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
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
                            <ice:panelLayout id="panecuerpo" style="border: 1px dotted #999999; height: 470px; top: 5px; position: relative; width: 960px">
                                <ice:outputLabel id="label1" style="left: 30%; top: 72px; position: absolute" value="Bienvenido:"/>
                                <ice:outputLabel id="label2"
                                    style="background-color: rgb(255, 255, 255); color: rgb(0, 51, 51); font-size: 18px; left: 30%; top: 20px; position: absolute; width: 214px" value="PERSONAL TÉCNICO"/>
                                <ice:panelLayout id="panelLayout2" style="border-width: 1px; border-style: solid; border-color: rgb(255, 255, 255) rgb(255, 255, 255) rgb(255, 255, 255) rgb(255, 255, 255); background-color: #304357; height: 100%; left: 0px; top: 0px; position: absolute; width: 25%">
                                    <ice:outputLabel id="label3"
                                        style="background-color: rgb(48, 67, 87); color: rgb(255, 255, 255); left: 5%; top: 24px; position: absolute; text-align: center; width: 90%" value="OPCIONES :"/>
                                    <ice:commandButton action="#{PaginaEmpleado.btnclientes_action}" id="btnclientes" image="/resources/btnCliReg.png"
                                        style="height: 45px; left: 5%; top: 120px; position: absolute; width: 90%"
                                        title="Administrar los clientes registrados en el sistema" value="CLIENTES REGISTRADOS"/>
                                    <ice:commandButton action="#{PaginaEmpleado.btnproyectos_action}" id="btnproyectos" image="/resources/admObra.png"
                                        style="height: 45px; left: 5%; top: 168px; position: absolute; width: 90%" title="Lista los trámites de los clientes" value="PROYECTOS "/>
                                    <ice:commandButton action="#{PaginaEmpleado.button1_action}" id="btnmodificar" image="/resources/btnModifD.png"
                                        style="background-color: rgb(0, 102, 51); color: rgb(255, 255, 255); height: 45px; left: 5%; top: 72px; position: absolute; width: 90%"
                                        title="Modificar mi información personal o cambiar mi clave" value="Modificar Datos"/>
                                    <ice:commandButton action="#{PaginaEmpleado.btnsalir_action}" id="btnsalir" image="/resources/cerrarcesion.png"
                                        style="height: 45px; left: 5%; top: 216px; position: absolute; width: 90%" title="Salir del sistema de forma segura" value="SALIR"/>
                                </ice:panelLayout>
                                <ice:outputText id="outputText1"
                                    style="font-size: 12px; font-style: oblique; font-weight: bold; left: 40%; top: 72px; position: absolute; width: 141px" value="#{PaginaEmpleado.servicioEmpleado.empleadoLogeado.nombres} #{PaginaEmpleado.servicioEmpleado.empleadoLogeado.apellido}"/>
                                <ice:graphicImage id="graphicImage2" style="left: 384px; top: 144px; position: absolute" value="/resources/casa_ok.jpeg"/>

                                <ice:panelGrid columns="2" styleClass="panelAyuda">
                                    <div title="Manual de usuario (pdf)">
                                        <ice:outputResource attachment="false" fileName="ayuda.pdf" id="orAyuda" image="/resources/helppdf_button.png"
                                            label="Ayuda" mimeType="application/pdf" resource="#{PaginaEmpleado.recursoAyuda}" shared="true"/>
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
