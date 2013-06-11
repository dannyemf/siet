<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : AdministradorSistema
    Created on : 08/06/2010, 12:08:18 PM
    Author     : Administrator
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="html1">
            <head id="head1" title="SIET - ADMINISTRADOR DEL SISTEMA">
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
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid #cccccc; height: 470px; top: 5px; position: relative; width: 960px">
                                <ice:outputLabel id="label1"
                                    style="font-size: 18px; font-weight: bold; left: 0%; top: 10px; position: absolute; text-align: center; width: 100%" value="ADMINISTRADOR DEL SISTEMA"/>
                                <ice:outputText id="outputText1"
                                    style="font-size: 12px; font-style: oblique; font-weight: bold; left: 60%; top: 170px; position: absolute; text-align: left; width: 141px" value="#{PaginaAdministradorSistema.servicioEmpleado.empleadoLogeado.nombres} #{PaginaAdministradorSistema.servicioEmpleado.empleadoLogeado.apellido}"/>
                                <ice:outputLabel id="label3" style="font-size: 18px; font-style: italic; left: 60%; top: 40px; position: absolute" value="Bienvenido"/>
                                <ice:graphicImage height="118" id="image2"
                                    style="border: 1px solid black; height: 100px; left: 60%; top: 70px; position: absolute" url="/resources/sinfoto.png" width="95"/>
                                <ice:panelLayout id="panelLayout2" style="border-width: 1px; border-style: solid; border-color: rgb(255, 255, 255) rgb(255, 255, 255) rgb(255, 255, 255) rgb(255, 255, 255); background-color: rgb(48, 67, 87); height: 100%; left: 0px; top: 0px; position: absolute; width: 25%">
                                    <ice:commandButton action="#{PaginaAdministradorSistema.btnproyecto1_action}" id="btnproyecto1"
                                        image="/resources/admObra.png" style="height: 45px; left: 5%; top: 198px; position: absolute; width: 90%"
                                        title="Administra los trámites de los clientes" value="ADMINISTRAR PROYECTOS"/>
                                    <ice:commandButton action="#{PaginaAdministradorSistema.btnpersonal_action}" id="btnpersonal"
                                        image="/resources/btnAdminPer.png" style="height: 45px; left: 5%; top: 102px; position: absolute; width: 90%"
                                        title="Administra los usuarios del sistema" value="ADMINISTRAR PERSONAL"/>
                                    <ice:outputLabel id="label2"
                                        style="background-color: rgb(48, 67, 87); color: rgb(255, 255, 255); font-size: 16px; left: 0px; top: 72px; position: absolute; text-align: center; width: 100%" value="OPCIONES :"/>
                                    <ice:commandButton action="#{PaginaAdministradorSistema.btnclienteregis_action}" id="btnclienteregis"
                                        image="/resources/btnAdminCli.png" style="height: 45px; left: 5%; top: 150px; position: absolute; width: 90%"
                                        title="Administra la información de los clientes registrados" value="ADMINISTRAR CLIENTES"/>
                                    <ice:commandButton action="#{PaginaAdministradorSistema.admintipovivienda_action}" id="admintipovivienda"
                                        image="/resources/btnTiposVivi.png" style="height: 45px; left: 5%; top: 246px; position: absolute; width: 90%"
                                        title="Administra los tipos de vivienda asociados a un proyecto" value="Administrar Tipos de Vivienda"/>
                                    <ice:graphicImage id="graphicImage2" style="left: 48px; top: 312px; position: absolute" value="/resources/stugan.gif"/>
                                </ice:panelLayout>
                                <ice:panelLayout id="panelLayout3" style="border: 1px solid rgb(204, 204, 204); background-color: #304357; height: 100%; left: 75%; top: 0px; position: absolute; width: 25%">
                                    <ice:commandButton action="#{PaginaAdministradorSistema.btnAuditoria_action}" id="btnAuditoria"
                                        image="/resources/btnAuditoriai.png" style="height: 45px; left: 5%; top: 72px; position: absolute; width: 90%"
                                        title="Generación de reportes de logs de auditoría" value="Generar Reportes"/>
                                    <ice:commandButton action="#{PaginaAdministradorSistema.btnGenerarReportes_action}" id="btnGenerarReportes"
                                        image="/resources/btnGeneRepor.png" style="height: 45px; left: 5%; top: 120px; position: absolute; width: 90%"
                                        title="Generación de reportes de trámites" value="Generar Reportes"/>
                                    <ice:commandButton action="#{PaginaAdministradorSistema.btnRespaldos_action}" id="btnRespaldos"
                                        image="/resources/btnRespaldos.png" style="height: 45px; left: 5%; top: 168px; position: absolute; width: 90%"
                                        title="Creación, eliminación y restauración de la base de datos" value="RESPALDOS"/>
                                    <ice:commandButton action="#{PaginaAdministradorSistema.btnsalir_action}" id="btnsalir" image="/resources/cerrarcesion.png"
                                        style="height: 45px; left: 5%; top: 264px; position: absolute; width: 90%" title="Salir del sistema de forma segura" value="SALIR"/>
                                    <ice:commandButton action="#{PaginaAdministradorSistema.btnProyectos_action}" id="btnProyectos"
                                        image="/resources/btnProyectosEjecu.png" style="height: 45px; left: 5%; top: 216px; position: absolute; width: 90%"
                                        title="Administración de los proyectos" value="PROYECTO EJECUCION"/>
                                </ice:panelLayout>
                                
                                <ice:panelGrid columns="2" styleClass="panelAyuda" style="left: 810px">
                                    <div title="Manual de usuario (pdf)">
                                        <ice:outputResource attachment="false" fileName="ayuda.pdf" id="orAyuda" image="/resources/helppdf_button.png"
                                            label="Ayuda" mimeType="application/pdf" resource="#{PaginaAdministradorSistema.recursoAyuda}" shared="true"/>
                                    </div>
                                </ice:panelGrid>

                                <ice:graphicImage id="graphicImage3" style="height: 280px; left: 30%; top: 200px; position: absolute; width: 40%" value="/resources/page_admin.png"/>
                            </ice:panelLayout>
                        </div>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
