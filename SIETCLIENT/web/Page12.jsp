<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Page12
    Created on : 03/01/2011, 12:44:32 PM
    Author     : LENIN 
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/xp/xp.css" id="outputStyle2"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelBorder height="10000" id="panelBorder1" renderCenter="#{Page12.panelBorder1Bean.renderCenter}"
                        renderEast="#{Page12.panelBorder1Bean.renderEast}" renderNorth="#{Page12.panelBorder1Bean.renderNorth}"
                        renderSouth="#{Page12.panelBorder1Bean.renderSouth}" renderWest="#{Page12.panelBorder1Bean.renderWest}"
                        style="left: 0px; top: 0px; position: absolute" width="648">
                        <f:facet name="north">
                            <ice:panelGroup id="panelBorder1north" style="">
                                <ice:outputLabel id="outputLabel1" style="font-weight: bold;" value="NORTH"/>
                                <ice:graphicImage id="graphicImage1" style="left: 1px; right: 1px; top: 1px; bottom: 1px; position: fixed" value="/resources/IMAGEN1.jpg" />
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="west">
                            <ice:panelGroup id="panelBorder1west" style=" height:100%;">
                                <ice:outputLabel id="outputLabel2" style="font-weight: bold;" value="WEST"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="east">
                            <ice:panelGroup id="panelBorder1east" style=" height:100%;">
                                <ice:outputLabel id="outputLabel3" style="font-weight: bold;" value="EAST"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="center">
                            <ice:panelGroup id="panelBorder1center" style=" height:100%;">
                                <ice:outputLabel id="outputLabel4" style="font-weight: bold;" value="CENTER"/>
                                <ice:commandButton id="button1" value="submit"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="south">
                            <ice:panelGroup id="panelBorder1south" style=" text-align: center;">
                                <ice:outputLabel id="outputLabel5" style="font-weight: bold;" value="SOUTH"/>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelBorder>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
