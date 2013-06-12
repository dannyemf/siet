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
                            <ice:panelLayout id="panecuerpo" layout="" style="border: 1px solid rgb(153, 153, 153); height: 700px; top: 5px; position: relative; width: 960px">
                                <ice:commandButton action="#{SubirDocumentacionCliente.btnaceptar_action}" id="btnaceptar" image="/resources/btnAceptar.png"
                                    style="height: 46px; left: 606px; top: 606px; position: absolute; width: 143px" title="Guardar la documentación subida" value="Aceptar"/>
                                <ice:outputLabel id="label6" style="left: 0px; top: 10px; position: absolute; text-align: center; width: 100%" value="Bienvenido al Sistema de Registro para vivienda de la Entidad Técnica &quot;SU CASA PROPIA&quot;"/>
                                <ice:outputLabel id="label7"
                                    style="background-color: rgb(255, 255, 255); font-size: 18px; font-weight: bold; left: 0px; top: 40px; position: absolute; text-align: center; width: 100%" value="DOCUMENTACIÓN PARA TRÁMITE DE VIVIENDA"/>
                                <ice:commandButton action="#{SubirDocumentacionCliente.btnvolver_action}" id="btnvolver" image="/resources/btnVolver.png"
                                    style="height: 48px; left: 216px; top: 606px; position: absolute; width: 141px" title="Volver a la página principal" value="VOLVER"/>
                                <ice:messages errorClass="errorMessage" fatalClass="fatalMessage" id="messages1" infoClass="infoMessage" showSummary="true"
                                    style="height: 55px; left: 36px; top: 522px; position: absolute; width: 855px" warnClass="warnMessage"/>
                                <ice:panelGrid columns="2" styleClass="panelAyuda">
                                    <ice:commandButton actionListener="#{ServicioAyuda.showPopup}" id="btnAyuda" image="/resources/help_button.png"
                                        immediate="true" title="Ayuda de la documentación para el trámite" value="Ayuda"/>
                                    <div title="Manual de usuario (pdf)">
                                        <ice:outputResource attachment="false" fileName="ayuda.pdf" id="orAyuda" image="/resources/helppdf_button.png"
                                            label="Ayuda" mimeType="application/pdf" resource="#{LoginCliente.recursoAyuda}" shared="true"/>
                                    </div>
                                </ice:panelGrid>
                                <ice:panelGrid columns="2" id="panelGrid1" style="height: 221px; left: 36px; top: 102px; position: absolute" width="857">
                                    <ice:outputLabel id="label1" value="Cédula:"/>
                                    <ice:panelGrid>
                                        <ice:panelGrid columns="2">
                                            <ice:inputFile actionListener="#{SubirDocumentacionCliente.fileUpcedula_processAction}" autoUpload="true"
                                                id="fileUpcedula" progressListener="#{ServicioDocumentacion.progresoCargaArchivo}"
                                                title="Copia de la cédula (Tipo de archivo: imagen jpg, jpeg, png)" uploadDirectory="tmpupload" validatorExpression="#{SubirDocumentacionCliente.fileUpcedula_validate}"/>
                                            <ice:graphicImage height="22" id="imgVisto" value="/resources/visto.jpeg"
                                                visible="#{ServicioDocumentacion.progreso eq 100}" width="22"/>
                                        </ice:panelGrid>
                                        <ice:outputProgress id="outputProgressCedula" instanceName="fileUpcedula" styleClass="uploadProgressBar" value="#{ServicioDocumentacion.progreso}"/>
                                        <div id="sep1" style="border-top: solid 1px orange; width: 100%; height: 20px;"></div>
                                    </ice:panelGrid>
                                    <ice:outputLabel id="label2" value="Libreta de Ahorros:"/>
                                    <ice:panelGrid>
                                        <ice:panelGrid columns="2">
                                            <ice:inputFile actionListener="#{SubirDocumentacionCliente.fileUplibreta_processAction}" autoUpload="true"
                                                id="fileUplibreta" progressListener="#{ServicioDocumentacion.progresoCargaArchivo2}"
                                                title="Copia de la libreta de ahorros (Tipo de archivo: imagen jpg, jpeg, png)" uploadDirectory="tmpupload" validatorExpression="#{SubirDocumentacionCliente.fileUplibreta_validate}"/>
                                            <ice:graphicImage height="22" id="imgVisto2" value="/resources/visto.jpeg"
                                                visible="#{ServicioDocumentacion.progreso2 eq 100}" width="22"/>
                                        </ice:panelGrid>
                                        <ice:outputProgress id="outputProgressLib" instanceName="fileUplibreta" styleClass="uploadProgressBar" value="#{ServicioDocumentacion.progreso2}"/>
                                        <div id="sep2" style="border-top: solid 1px orange; width: 100%; height: 20px;"></div>
                                    </ice:panelGrid>
                                    <ice:outputLabel id="label3" value="Escritura:"/>
                                    <ice:panelGrid>
                                        <ice:panelGrid columns="2">
                                            <ice:inputFile actionListener="#{SubirDocumentacionCliente.fileUpescritura_processAction}" autoUpload="true"
                                                id="fileUpescritura" preservePath="true" progressListener="#{ServicioDocumentacion.progresoCargaArchivo3}"
                                                title="Copia de la escritura del terreno (Tipo de archivo: imagen jpg, jpeg, png)" uploadDirectory="tmpupload" validatorExpression="#{SubirDocumentacionCliente.fileUpescritura_validate}"/>
                                            <ice:graphicImage height="22" id="imgVisto3" value="/resources/visto.jpeg"
                                                visible="#{ServicioDocumentacion.progreso3 eq 100}" width="22"/>
                                        </ice:panelGrid>
                                        <ice:outputProgress id="outputProgressEsc" instanceName="fileUplibreta" styleClass="uploadProgressBar" value="#{ServicioDocumentacion.progreso3}"/>
                                        <div id="sep3" style="border-top: solid 1px orange; width: 100%; height: 20px;"></div>
                                    </ice:panelGrid>
                                    <ice:outputLabel id="label4" value="Certificado del Registro:"/>
                                    <ice:panelGrid>
                                        <ice:panelGrid columns="2">
                                            <ice:inputFile actionListener="#{SubirDocumentacionCliente.fileUpcertRegistra_processAction}" autoUpload="true"
                                                id="fileUpcertRegistra" progressListener="#{ServicioDocumentacion.progresoCargaArchivo4}"
                                                title="Copia del certificado de registro(Tipo de archivo: imagen jpg, jpeg, png)" uploadDirectory="tmpupload" validatorExpression="#{SubirDocumentacionCliente.fileUpcertRegistra_validate}"/>
                                            <ice:graphicImage height="22" id="imgVisto4" value="/resources/visto.jpeg"
                                                visible="#{ServicioDocumentacion.progreso4 eq 100}" width="22"/>
                                        </ice:panelGrid>
                                        <ice:outputProgress id="outputProgressReg" instanceName="fileUplibreta" styleClass="uploadProgressBar" value="#{ServicioDocumentacion.progreso4}"/>
                                        <div id="sep4" style="border-top: solid 1px orange; width: 100%; height: 20px;"></div>
                                    </ice:panelGrid>
                                    <ice:outputLabel id="label5" value="Fotografía del Terreno:"/>
                                    <ice:panelGrid>
                                        <ice:panelGrid columns="2">
                                            <ice:inputFile actionListener="#{SubirDocumentacionCliente.fileUpfototerreno_processAction}" autoUpload="true"
                                                id="fileUpfototerreno" preservePath="true" progressListener="#{ServicioDocumentacion.progresoCargaArchivo5}"
                                                title="Foto del terreno (Tipo de archivo: imagen jpg, jpeg, png)" uploadDirectory="tmpupload" validatorExpression="#{SubirDocumentacionCliente.fileUpfototerreno_validate}"/>
                                            <ice:graphicImage height="22" id="imgVisto5" value="/resources/visto.jpeg"
                                                visible="#{ServicioDocumentacion.progreso5 eq 100}" width="22"/>
                                        </ice:panelGrid>
                                        <ice:outputProgress id="outputProgressTer" instanceName="fileUplibreta" styleClass="uploadProgressBar" value="#{ServicioDocumentacion.progreso5}"/>
                                        <div id="sep5" style="border-top: solid 1px orange; width: 100%; height: 20px;"></div>
                                    </ice:panelGrid>
                                </ice:panelGrid>
                            </ice:panelLayout>
                            <!-- Panel Popup Ayuda -->
                            <ice:panelPopup autoCentre="true" draggable="true" id="modalPnlPop" modal="true" styleClass="corePopup" visible="#{ServicioAyuda.visiblePopup}">
                                <f:facet name="header">
                                    <ice:panelGroup styleClass="popupHeaderWrapper">
                                        <ice:outputText styleClass="popupHeaderText" value="Ayuda - Subir documentación"/>
                                        <ice:commandButton actionListener="#{ServicioAyuda.closePopup}" alt="Cerrar" id="modalPnlCloseBtn"
                                            image="/resources/popupclose.gif" styleClass="popupHeaderImage" title="Cerrar" type="button"/>
                                    </ice:panelGroup>
                                </f:facet>
                                <f:facet name="body">
                                    <ice:panelGroup style="width: 400px" styleClass="popupBody">
                                        <p>
                                            <b>Documentación para el trámite</b>
                                        </p>
                                        <p>En ésta sección usted debe subir la documentación necesaria para la aprobación del trámite.</p>
                                        <p>Escanee cada uno de los documentos (cédula, libreta de ahorros, escritura, certificado de registro)
                                        y tome una foto a su terreno. Guarde todos estos documento como imagen, pudiendo ser jpg, jpeg o png y
                                        súbalos en el lugar correspondiente para cada documento.</p>
                                        <p>
                                            <b>Nota:</b> Debe subir todos los documentos solicitados para que el trámite sea aprobado</p>
                                        <center>
                                            <ice:commandButton actionListener="#{ServicioAyuda.closePopup}" id="modalPnlCloseButton" type="submit" value="Cerrar"/>
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
