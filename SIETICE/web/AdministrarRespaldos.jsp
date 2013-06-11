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
            <body id="body1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height: 100%; left: 0px; top: 0px; position: absolute; width: 100%">
                        <div align="center">
                            <ice:panelLayout id="panecabeza" style="border-width: 0px; border-style: dotted; height: 100px; left: 0%; top: 0%; position: relative; width: 960px">
                                <ice:graphicImage height="100%" id="graphicImage1" value="/resources/cabeza.jpg" width="100%"/>
                            </ice:panelLayout>
                        </div>
                        <div align="center">
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid rgb(0, 51, 51); height: 470px; left: 0%; top: 5px; position: relative; width: 960px">
                                <ice:panelLayout id="panelLayout2" style="border: 1px solid rgb(0, 0, 0); background-color: rgb(48, 67, 87); height: 100%; position: absolute; width: 35%">
                                    <ice:outputLabel id="label11"
                                        style="color: white; font-size: 16px; height: 27px; left: 0px; top: 20px; position: absolute; text-align: center; width: 100%" value="Seleccionar Fecha de Respaldo"/>
                                    <ice:selectInputDate id="selectInputDate1" renderAsPopup="true"
                                        style="height: 212px; left: 24px; top: 50px; position: absolute;" value="#{AdministrarRespaldos.fechaInicio}">
                                        <f:convertDateTime dateStyle="short" pattern="dd/MM/yyyy" timeZone="#{AdministrarRespaldos.timeZone}"/>
                                    </ice:selectInputDate>
                                    <ice:outputLabel id="label1" style="color: white; height: 27px; left: 200px; top: 47px; position: absolute; width: 120px" value="&lt;&lt; Fecha Inicial"/>
                                    <ice:selectInputDate id="selectInputDate2" renderAsPopup="true"
                                        style="height: 212px; left: 24px; top: 110px; position: absolute;" value="#{AdministrarRespaldos.fechaFin}">
                                        <f:convertDateTime dateStyle="short" pattern="dd/MM/yyyy" timeZone="#{AdministrarRespaldos.timeZone}"/>
                                    </ice:selectInputDate>
                                    <ice:outputLabel id="label16" style="color: white; height: 27px; left: 200px; top: 110px; position: absolute; width: 120px" value="&lt;&lt; Fecha Final"/>
                                    <ice:commandButton action="#{AdministrarRespaldos.btnNuevo_action}" id="btnNuevo" image="/resources/CrearResp.png"
                                        style="height: 37px; left: 20%; top: 200px; position: absolute; width: 60%" value="Crear"/>
                                    <ice:commandButton action="#{AdministrarRespaldos.btnBuscar_action}" id="btnBuscar" image="/resources/buscarwhite.png"
                                        style="height: 37px; left: 20%; top: 250px; position: absolute; width: 60%" value="Buscar"/>
                                    <ice:commandButton action="#{AdministrarRespaldos.btn_salir_action}" id="btn_salir" image="/resources/volverok.png"
                                        style="height: 37px; left: 20%; top: 300px; position: absolute; width: 60%" value="submit"/>
                                    <ice:messages id="messages1" style="left: 10px; top: 150px; position: absolute; width: 320px;"/>
                                </ice:panelLayout>
                                <div align="center">
                                    <ice:outputLabel id="label17"
                                        style="color: rgb(0, 51, 51); font-size: 18px; height: 30px; left: 36%; top: 30px; position: absolute; text-align: center; width: 64%" value="LISTA DE RESPALDOS"/>
                                </div>
                                <ice:panelLayout id="panelLayout55" style="border-width: 0px; border-style: solid; background-color: rgb(255, 255, 255); height: 75%; left: 36%; top: 70px; position: absolute; width: 64%">
                                    
                                        <ice:dataTable headerClass="list-header" id="dataTable1" rowClasses="list-row-even,list-row-odd" rows="8"
                                            style=" width: 80%" value="#{AdministrarRespaldos.model}" var="e">
                                            <h:column id="column11">
                                                <h:outputText id="outputText1" value="#{e.file.name}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText2" value="Nombre"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column2">
                                                <h:outputText id="outputText3" value="#{e.tamaño}"/>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText4" value="Tamaño"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column3">
                                                <h:outputText id="outputText5" value="#{e.fecha}">
                                                    <f:convertDateTime dateStyle="short" pattern="dd/MM/yyyy hh:mm:ss"/>
                                                </h:outputText>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText6" value="Fecha"/>
                                                </f:facet>
                                            </h:column>
                                            <h:column id="column1">
                                                <ice:panelConfirmation acceptLabel="Si" autoCentre="true" cancelLabel="No" draggable="true" id="panel_restaurar"
                                                    message="Desea restaurar la base de datos al punto seleccionado?" rendered="true" title="Restaurar"/>
                                                    
                                                <ice:panelConfirmation acceptLabel="Si" autoCentre="false" cancelLabel="No" draggable="true" id="panel_eliminar"
                                                message="Desea eliminar el respaldo seleccionado?" rendered="true" title="Eliminar"/>

                                                <ice:panelGrid columns="5" id="gridPanel1">
                                                    <ice:outputResource attachment="true" fileName="#{e.file.name}" id="lnkDesc" label="Descargar"
                                                        mimeType="text/x-sql" resource="#{e.recurso}"
                                                        shared="false"/>
                                        | <ice:commandLink
                                                        action="#{AdministrarRespaldos.linkActionRestaurar_action}" id="linkActionRestaurar"
                                                        panelConfirmation="panel_restaurar"
                                                        value="Restaurar"/>
                                        | <ice:commandLink
                                                        action="#{AdministrarRespaldos.linkActionEliminar_action}" id="linkActionEliminar"
                                                        panelConfirmation="panel_eliminar" value="Eliminar"/>
                                                </ice:panelGrid>
                                                <f:facet name="header">
                                                    <h:outputText id="outputText20" value=" Opción "/>
                                                </f:facet>
                                            </h:column>
                                        </ice:dataTable>


                                        <ice:dataPaginator id="paginator"
                                        style=""
                                           for="dataTable1"
                                           fastStep="2"
                                           paginator="true"
                                           paginatorMaxPages="5">
                                                <f:facet name="first">
                                                    <h:graphicImage value="/xmlhttp/css/rime/css-images/arrow-first.gif"
                                                                    style="width: 18px; height: 18px; border: none;"
                                                                    alt="Primer página" title="Primer página"/>
                                                </f:facet>
                                                <f:facet name="last">
                                                    <h:graphicImage value="/xmlhttp/css/rime/css-images/arrow-last.gif"
                                                                    style="width: 18px; height: 18px; border: none;"
                                                                    alt="Última página" title="Última página"/>
                                                </f:facet>
                                                <f:facet name="previous">
                                                    <h:graphicImage value="/xmlhttp/css/rime/css-images/arrow-previous.gif"
                                                                    style="width: 18px; height: 18px; border: none;"
                                                                    alt="Anterior" title="Anterior"/>
                                                </f:facet>
                                                <f:facet name="next">
                                                    <h:graphicImage value="/xmlhttp/css/rime/css-images/arrow-next.gif"
                                                                    style="width: 18px; height: 18px; border: none;"
                                                                    alt="Siguiente" title="Siguiente"/>
                                                </f:facet>
                                                <f:facet name="fastforward">
                                                    <h:graphicImage value="/xmlhttp/css/rime/css-images/arrow-ff.gif"
                                                                    style="width: 18px; height: 18px; border: none;"
                                                                    alt="Avanzar una página" title="Avanzar una página"/>
                                                </f:facet>
                                                <f:facet name="fastrewind">
                                                    <h:graphicImage value="/xmlhttp/css/rime/css-images/arrow-fr.gif"
                                                                    style="width: 18px; height: 18px; border: none;"
                                                                    alt="Retroceder una página" title="Retroceder una página"/>
                                                </f:facet>
                                            </ice:dataPaginator>
                                    
                                </ice:panelLayout>

                                <ice:panelGrid columns="2" styleClass="panelAyuda panelAyudaOneButton">
                                            <ice:commandButton id="btnAyuda" image="/resources/help_button.png" immediate="true" actionListener="#{ServicioAyuda.showPopup}" value="Ayuda"
                                            title="Ayuda respaldos"/>
                                </ice:panelGrid>
                                
                            </ice:panelLayout>

                            <!-- Panel Popup Ayuda -->
                            <ice:panelPopup autoCentre="true" draggable="true" id="modalPnlPop" modal="true" styleClass="corePopup" visible="#{ServicioAyuda.visiblePopup}">
                                <f:facet name="header">
                                    <ice:panelGroup styleClass="popupHeaderWrapper">
                                        <ice:outputText styleClass="popupHeaderText" value="Ayuda - Respaldos"/>
                                        <ice:commandButton actionListener="#{ServicioAyuda.closePopup}" alt="Cerrar" id="modalPnlCloseBtn"
                                            image="/resources/popupclose.gif" styleClass="popupHeaderImage" title="Cerrar" type="button"/>
                                    </ice:panelGroup>
                                </f:facet>
                                <f:facet name="body">
                                    <ice:panelGroup styleClass="popupBody" style="width: 500px">
                                        <p><b>Respaldos.- </b>Un respaldo es un archivo que guarda tanto la estructura como la data de la base de datos sobre la que está operando este sistema.</p>

                                        <p><b>Creación de un respaldo.- </b>Para crear un respaldo presione el botón "crear respaldos" y listo. El respaldo será creado a la fecha actual y si desea listarlo ingrese como fecha final la fecha actual y presione buscar</p>

                                        <p><b>Eliminar un respaldo.- </b>Para eliminar simplemente seleccione el vínculo eliminar de la lista de respaldos. Tenga precación de esta acción ya que si elimina el respaldo ya no podrá hacer una restauración posterior a menos que lo haga manualmente</p>

                                        <p><b>Restaurar un respaldo.- </b>La restauración no es otra cosa que volver la base de datos al estado seleccionado. Haga ésta operación si está completamente seguro de lo que está haciendo y no olvide crear un respaldo antes de restaurar. Tome en cuenta que si hace una restauración a una fecha anterior puede perder registros de la base de datos creados posteriormente a la fecha del respaldo.</p>

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
