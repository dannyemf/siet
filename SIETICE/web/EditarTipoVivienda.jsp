<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : EditarTipoVivienda
    Created on : 11/09/2010, 09:28:30 PM
    Author     : Principal
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="html1">
            <head id="head1">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
                <script type="text/javascript">
                        //document.getElementById('xx').getAttribute(attributeName)
                    </script>
                <script id="script-entrada" language="javascript" src="./js/Entrada.js"></script>
            </head>
            <body id="body1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelLayout id="panetodo" style="border-width: 0px; border-style: dotted; height: 170%; left: 0px; top: 0px; position: absolute; width: 100%">
                        <div align="center">
                            <ice:panelLayout id="panecabeza" style="border-width: 0px; border-style: dotted; height: 100px; position: relative; width: 960px">
                                <ice:graphicImage height="100%" id="graphicImage1" value="/resources/cabeza.jpg" width="100%"/>
                            </ice:panelLayout>
                        </div>
                        <div align="center">
                            <ice:panelLayout id="panecuerpo" style="border: 1px solid rgb(153, 153, 153); height: 830px; top: 5px; position: relative; width: 960px; -rave-layout: grid">
                                <ice:outputLabel id="label1"
                                    style="background-color: rgb(255, 255, 255); font-size: 18px; left: 0px; top: 24px; position: absolute; text-align: center; width: 100%" value="TIPOS DE MATERIALES Y ACABADOS"/>
                                <ice:outputLabel id="label2" style="left: 564px; top: 72px; position: absolute" value="Seleccionar Estructura:"/>
                                <ice:outputLabel id="label3" style="left: 756px; top: 72px; position: absolute" value="Selecionar Cubierta:"/>
                                <ice:outputLabel id="label4" style="height: 18px; left: 756px; top: 648px; position: absolute; width: 117px" value="Selecionar Piso : "/>
                                <ice:outputLabel id="label5" style="left: 756px; top: 480px; position: absolute; width: 165px" value="Selecionar Cielo Razo:"/>
                                <ice:outputLabel id="label7" style="left: 564px; top: 288px; position: absolute" value="Seleccionar Puertas:"/>
                                <ice:outputLabel id="label8" style="left: 756px; top: 288px; position: absolute" value="Selecionar Ventanas:"/>
                                <ice:outputLabel id="label9" style="left: 564px; top: 648px; position: absolute; width: 165px" value="Selecionar Paredes:"/>
                                <ice:outputLabel id="label11" style="left: 564px; top: 480px; position: absolute" value="Selecionar Revestido:"/>
                                <ice:graphicImage height="118" id="imgEstructura" style="left: 564px; top: 144px; position: absolute"
                                    url="../resources/ESTRUCTURA_#{ServicioVivienda.tipoViviendaEdicion.estructura}.jpg"
                                    value="/resources/ESTRUCTURA_#{ServicioVivienda.tipoViviendaEdicion.estructura}.jpg" width="189"/>
                                <ice:graphicImage height="118" id="imgCubierta" style="left: 756px; top: 144px; position: absolute"
                                    value="/resources/CUBIERTA_#{ServicioVivienda.tipoViviendaEdicion.cubierta}.jpg" width="165"/>
                                <ice:graphicImage height="118" id="imgPiso" style="left: 756px; top: 696px; position: absolute"
                                    value="/resources/PISO_#{ServicioVivienda.tipoViviendaEdicion.piso}.jpg" width="165"/>
                                <ice:graphicImage height="118" id="imgCielorazo" style="left: 756px; top: 528px; position: absolute"
                                    value="/resources/CIELORAZO_#{ServicioVivienda.tipoViviendaEdicion.cielorazo}.jpg" width="165"/>
                                <ice:graphicImage height="120" id="imagepuertas" style="left: 564px; top: 336px; position: absolute"
                                    value="/resources/PUERTAS_#{ServicioVivienda.tipoViviendaEdicion.puertas}.jpg" width="189"/>
                                <ice:graphicImage height="120" id="imageventanas" style="left: 756px; top: 336px; position: absolute"
                                    value="/resources/VENTANAS_#{ServicioVivienda.tipoViviendaEdicion.ventanas}.jpg" width="165"/>
                                <ice:graphicImage height="118" id="graphiimgparedes" style="left: 564px; top: 696px; position: absolute"
                                    value="/resources/PAREDES_#{ServicioVivienda.tipoViviendaEdicion.paredes}.jpg" width="189"/>
                                <ice:graphicImage height="118" id="graphicImrevestido" style="left: 564px; top: 528px; position: absolute"
                                    value="/resources/REVESTIDO_#{ServicioVivienda.tipoViviendaEdicion.revestido}.jpg" width="189"/>
                                <!--ice:graphicImage height="120" id="image8" style="left: 504px; top: 408px; position: absolute" value="/resources/closets.jpg" width="192"/-->
                                <ice:selectOneMenu id="dropdowncubierta" partialSubmit="true" style="left: 754px; top: 94px; position: absolute; width: 96px" value="#{ServicioVivienda.tipoViviendaEdicion.cubierta}">
                                    <f:selectItems id="dropdown1SelectItems1" value="#{EditarTipoVivienda.cubierta}"/>
                                </ice:selectOneMenu>
                                <ice:selectOneMenu id="dropdownpiso" partialSubmit="true"
                                    style="height: 21px; left: 754px; top: 670px; position: absolute; width: 95px" value="#{ServicioVivienda.tipoViviendaEdicion.piso}">
                                    <f:selectItems id="dropdown1SelectItems2" value="#{EditarTipoVivienda.piso}"/>
                                </ice:selectOneMenu>
                                <ice:selectOneMenu id="dropdowncielorazo" partialSubmit="true" style="left: 754px; top: 502px; position: absolute; width: 96px" value="#{ServicioVivienda.tipoViviendaEdicion.cielorazo}">
                                    <f:selectItems id="dropdown1SelectItems3" value="#{EditarTipoVivienda.cielorazo}"/>
                                </ice:selectOneMenu>
                                <ice:selectOneMenu id="dropdownpuertas" partialSubmit="true"
                                    style="height: 24px; left: 562px; top: 310px; position: absolute; width: 120px" value="#{ServicioVivienda.tipoViviendaEdicion.puertas}">
                                    <f:selectItems id="dropdown1SelectItems4" value="#{EditarTipoVivienda.puertas}"/>
                                </ice:selectOneMenu>
                                <ice:selectOneMenu id="dropdownventanas" partialSubmit="true" style="left: 754px; top: 310px; position: absolute; width: 95px" value="#{ServicioVivienda.tipoViviendaEdicion.ventanas}">
                                    <f:selectItems id="dropdown1SelectItems5" value="#{EditarTipoVivienda.ventanas}"/>
                                </ice:selectOneMenu>
                                <ice:commandButton action="#{EditarTipoVivienda.btnaceptar_action}" id="btnaceptar" image="/resources/btnAceptar.png"
                                    style="height: 48px; left: 15%; top: 780px; position: absolute; width: 15%" value="ACEPTAR"/>
                                <ice:selectOneMenu id="dropestructura" immediate="true" partialSubmit="true"
                                    style="left: 562px; top: 94px; position: absolute; width: 95px" value="#{ServicioVivienda.tipoViviendaEdicion.estructura}">
                                    <f:selectItems id="dropdown1SelectItems" value="#{EditarTipoVivienda.estructura}"/>
                                </ice:selectOneMenu>
                                <ice:outputLabel id="label12" style="height: 20px; left: 84px; top: 84px; position: absolute" value="Nombre del Tipo"/>
                                <ice:inputText id="txttipoV" label="Tipo" required="true" requiredMessage="Nombre: Ingrese el nombre"
                                    style="height: 23px; left: 214px; top: 82px; position: absolute; width: 143px" value="#{ServicioVivienda.tipoViviendaEdicion.tipo}"/>
                                <ice:inputFile action="#{EditarTipoVivienda.fileUploadPlano_action}"
                                    actionListener="#{EditarTipoVivienda.fileUploadPlano_processAction}" autoUpload="true" id="fileUploadPlano"
                                    inputTextSize="25" style="left: 84px; top: 300px; position: absolute" title="Plano" uploadDirectory="tmpupload" width="270"/>
                                <ice:outputLabel id="lblPlano" style="left: 84px; top: 264px; position: absolute; width: 45px" value="Plano"/>
                                <ice:commandButton action="#{EditarTipoVivienda.btncancelar_action}" id="btncancelar" image="/resources/btnVolver.png"
                                    immediate="true" style="height: 48px; left: 30%; top: 780px; position: absolute; width: 15%" value="CANCELAR"/>
                                <ice:outputLabel id="label6" style="left: 84px; top: 156px; position: absolute; width: 81px" value="Area : ( m2)"/>
                                <ice:inputText id="txtrarea" onchange="toEntero(this);" onkeyup="toEntero(this);" partialSubmit="true"
                                    style="height: 23px; left: 214px; top: 154px; position: absolute; width: 143px" value="#{ServicioVivienda.tipoViviendaEdicion.area}"/>
                                <ice:selectOneMenu id="dropparedes" partialSubmit="true" style="left: 562px; top: 670px; position: absolute; width: 95px" value="#{ServicioVivienda.tipoViviendaEdicion.paredes}">
                                    <f:selectItems id="dropdown1SelectItems6" value="#{EditarTipoVivienda.paredes}"/>
                                </ice:selectOneMenu>
                                <ice:selectOneMenu id="droprevestido" partialSubmit="true" style="left: 562px; top: 502px; position: absolute; width: 119px" value="#{ServicioVivienda.tipoViviendaEdicion.revestido}">
                                    <f:selectItems id="dropdown1SelectItems7" value="#{EditarTipoVivienda.revestido}"/>
                                </ice:selectOneMenu>
                                <ice:outputLabel id="label15" style="left: 84px; top: 228px; position: absolute; width: 93px" value="Presupuesto:"/>
                                <ice:inputText id="txtrpresupuesto" partialSubmit="true" readonly="true"
                                    style="height: 23px; left: 214px; top: 226px; position: absolute; width: 143px" value="#{ServicioVivienda.tipoViviendaEdicion.presupuesto}"/>
                                <ice:outputLabel id="label17" style="left: 84px; top: 336px; position: absolute" value="Ambientes :"/>
                                <ice:inputTextarea id="textAmbientes"
                                    style="font-size: 14px; height: 144px; left: 82px; top: 370px; position: absolute; width: 275px" value="#{TipoVivienda.servicioVivienda.tipoViviendaEdicion.ambientes}"/>
                                <ice:outputLabel id="label18" style="left: 84px; top: 192px; position: absolute; width: 93px" value="Valor por m²:"/>
                                <ice:inputText id="txtrvalormetro" onchange="toEntero(this);" onkeyup="toEntero(this);" partialSubmit="true"
                                    style="height: 23px; left: 214px; top: 190px; position: absolute; width: 143px" value="#{ServicioVivienda.tipoViviendaEdicion.valormetro}"/>
                                <!--width="216"/&gt;/-->
                                <ice:graphicImage height="24" id="gimVistoPlano" rendered="#{ServicioVivienda.renderPlano}"
                                    style="left: 216px; top: 264px; position: absolute" value="/resources/visto.jpeg" width="24"/>
                                <ice:outputLabel id="label10" style="left: 84px; top: 120px; position: absolute; text-align: left; width: 69px" value="Proyecto:"/>
                                <ice:selectOneMenu id="somProy" label="Proyecto" required="true" requiredMessage="Proyecto: Seleccione proyecto"
                                    style="height: 23px; left: 214px; top: 118px; position: absolute; width: 143px" value="#{EditarTipoVivienda.proyectoId}">
                                    <f:selectItems id="somProyItems" value="#{EditarTipoVivienda.proyectos}"/>
                                </ice:selectOneMenu>
                                <ice:message for="txttipoV" id="msgNom" style="height: 22px; left: 372px; top: 84px; position: absolute; width: 141px"/>
                                <ice:message for="somProy" id="msgProy" style="left: 372px; top: 120px; position: absolute; width: 141px"/>
                            </ice:panelLayout>
                        </div>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
