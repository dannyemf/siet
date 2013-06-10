<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : SubirDocumentacionCliente
    Created on : 01/06/2010, 11:25:11 PM
    Author     : Administrator
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="html1">
            <head id="head1" title="SIET - SUBIR DOCUMENTACION CLIENTE&#xa;">
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
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid rgb(153, 153, 153); height: 470px; top: 5px; position: relative; width: 960px" layout="">
                                <ice:inputFile actionListener="#{SubirDocumentacionCliente.fileUpcedula_processAction}" autoUpload="true" id="fileUpcedula"
                                    progressListener="#{ServicioDocumentacion.progresoCargaArchivo}" style="left: 408px; top: 96px; position: absolute"
                                    uploadDirectory="tmpupload" validatorExpression="#{SubirDocumentacionCliente.fileUpcedula_validate}" width="334"/>
                                <ice:graphicImage value="/resources/visto.jpeg" rendered="#{ServicioDocumentacion.progreso eq 100}" width="22" height="22" style="left: 750px; top: 96px; position: absolute"></ice:graphicImage>
                                <ice:outputProgress id="outputProgress1" instanceName="fileUpcedula" style="left: 408px; top: 125px; position: absolute"
                                    styleClass="uploadProgressBar" value="#{ServicioDocumentacion.progreso}"/>

                                <ice:inputFile actionListener="#{SubirDocumentacionCliente.fileUplibreta_processAction}" autoUpload="true" id="fileUplibreta"
                                    progressListener="#{ServicioDocumentacion.progresoCargaArchivo2}" style="left: 408px; top: 160px; position: absolute"
                                    uploadDirectory="tmpupload" validatorExpression="#{SubirDocumentacionCliente.fileUplibreta_validate}" width="334"/>
                                <ice:graphicImage value="/resources/visto.jpeg" rendered="#{ServicioDocumentacion.progreso2 eq 100}" width="22" height="22" style="left: 750px; top: 160px; position: absolute"></ice:graphicImage>
                                <ice:outputProgress id="outputProgress2" instanceName="fileUplibreta" style="left: 408px; top: 190px; position: absolute"
                                    styleClass="uploadProgressBar" value="#{ServicioDocumentacion.progreso2}"/>

                                <ice:inputFile actionListener="#{SubirDocumentacionCliente.fileUpescritura_processAction}" autoUpload="true"
                                    id="fileUpescritura" preservePath="true" progressListener="#{ServicioDocumentacion.progresoCargaArchivo3}"
                                    style="left: 408px; top: 225px; position: absolute" uploadDirectory="tmpupload"
                                    validatorExpression="#{SubirDocumentacionCliente.fileUpescritura_validate}" width="334"/>
                                     <ice:graphicImage value="/resources/visto.jpeg" rendered="#{ServicioDocumentacion.progreso3 eq 100}" width="22" height="22" style="left: 750px; top: 225px; position: absolute"></ice:graphicImage>
                                <ice:outputProgress id="outputProgress3" instanceName="fileUplibreta" style="left: 408px; top: 260px; position: absolute"
                                    styleClass="uploadProgressBar" value="#{ServicioDocumentacion.progreso3}"/>

                                <ice:inputFile actionListener="#{SubirDocumentacionCliente.fileUpcertRegistra_processAction}" autoUpload="true"
                                    id="fileUpcertRegistra" progressListener="#{ServicioDocumentacion.progresoCargaArchivo4}"
                                    style="left: 408px; top: 290px; position: absolute" uploadDirectory="tmpupload"
                                    validatorExpression="#{SubirDocumentacionCliente.fileUpcertRegistra_validate}" width="334"/>
                                     <ice:graphicImage value="/resources/visto.jpeg" rendered="#{ServicioDocumentacion.progreso4 eq 100}" width="22" height="22" style="left: 750px; top: 295px; position: absolute"></ice:graphicImage>
                                <ice:outputProgress id="outputProgress4" instanceName="fileUplibreta" style="left: 408px; top: 320px; position: absolute"
                                    styleClass="uploadProgressBar" value="#{ServicioDocumentacion.progreso4}"/>

                                <ice:inputFile actionListener="#{SubirDocumentacionCliente.fileUpfototerreno_processAction}" autoUpload="true"
                                    id="fileUpfototerreno" preservePath="true" progressListener="#{ServicioDocumentacion.progresoCargaArchivo5}"
                                    style="left: 408px; top: 355px; position: absolute" uploadDirectory="tmpupload"
                                    validatorExpression="#{SubirDocumentacionCliente.fileUpfototerreno_validate}" width="334"/>
                                     <ice:graphicImage value="/resources/visto.jpeg" rendered="#{ServicioDocumentacion.progreso5 eq 100}" width="22" height="22" style="left: 750px; top: 360px; position: absolute"></ice:graphicImage>
                                <ice:outputProgress id="outputProgress5" instanceName="fileUplibreta" style="left: 408px; top: 390px; position: absolute"
                                    styleClass="uploadProgressBar" value="#{ServicioDocumentacion.progreso5}"/>
                                <ice:outputLabel id="label1" style="left: 216px; top: 100px; position: absolute" value="Cédula:"/>
                                <ice:outputLabel id="label2" style="left: 216px; top: 160px; position: absolute" value="Libreta de Ahorros:"/>
                                <ice:outputLabel id="label3" style="left: 216px; top: 230px; position: absolute" value="Escritura:"/>
                                <ice:outputLabel id="label4" style="left: 216px; top: 300px; position: absolute" value="Certificado del Registro:"/>
                                <ice:outputLabel id="label5" style="left: 216px; top: 360px; position: absolute" value="Fotografía del Terreno:"/>
                                <ice:commandButton action="#{SubirDocumentacionCliente.btnaceptar_action}" id="btnaceptar" image="/resources/btnAceptar.png"
                                    style="height: 46px; left: 603px; top: 420px; position: absolute; width: 143px" value="Aceptar"/>
                                <ice:outputLabel id="label6" style="left: 0px; top: 10px; position: absolute; text-align: center; width: 100%" value="Bienvenido al Sistema de Registro para vivienda de la Entidad Técnica &quot;SU CASA PROPIA&quot;"/>
                                <ice:outputLabel id="label7"
                                    style="background-color: rgb(255, 255, 255); font-size: 18px; font-weight: bold; left: 0px; top: 40px; position: absolute; text-align: center; width: 100%" value="DOCUMENTACIÓN PARA TRÁMITE DE VIVIENDA"/>
                                <ice:commandButton action="#{SubirDocumentacionCliente.btnvolver_action}" id="btnvolver" image="/resources/btnVolver.png"
                                    style="height: 48px; left: 216px; top: 420px; position: absolute; width: 141px" value="VOLVER"/>
                                <ice:messages errorClass="errorMessage" fatalClass="fatalMessage" id="messages1" infoClass="infoMessage" showSummary="true"
                                    style="height: 240px; left: 96px; top: 120px; position: absolute; width: 72px" warnClass="warnMessage"/>
                                <ice:outputResource attachment="false" fileName="ayuda.pdf" id="orAyuda" label="Ayuda" mimeType="application/pdf"
                                    resource="#{LoginCliente.recursoAyuda}" shared="true" style="color: rgb(255, 0, 0); font-size: 14px; top: 22px; left: 800px; top: 25px; position: absolute; width: 100px"/>
                            </ice:panelLayout>
                        </div>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
