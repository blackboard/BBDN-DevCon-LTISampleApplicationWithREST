<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/bbNG" prefix="bbNG" %>

<fmt:message var="settingsTitle" key="settings.page.title"/>

<bbNG:genericPage>
    <bbNG:pageHeader>
        <bbNG:breadcrumbBar environment="sys_admin" navItem="admin_plugin_manage">
            <bbNG:breadcrumb>${settingsTitle}</bbNG:breadcrumb>
        </bbNG:breadcrumbBar>

        <bbNG:pageTitleBar title="${settingsTitle}">
        </bbNG:pageTitleBar>

    </bbNG:pageHeader>

    <bbNG:form method="post" action="${actionUrl}" modelAttribute="settings" name="settings" id="settings">
        <bbNG:dataCollection>
            <bbNG:step title="Authentication Settings" instructions="">
                <bbNG:dataElement label="Key" labelFor="key" isRequired="true">
                    <bbNG:textElement name="key" id="key" maxLength="100" size="40" value="${key}"/>
                    <bbNG:elementInstructions text=""/>
                </bbNG:dataElement>
                <bbNG:dataElement label="Secret" labelFor="secret" isRequired="true">
                    <bbNG:textElement name="secret" id="secret" maxLength="100" size="40" value="${secret}"/>
                    <bbNG:elementInstructions text=""/>
                </bbNG:dataElement>
            </bbNG:step>
           <bbNG:step title="REST Settings" instructions="">
                <bbNG:dataElement label="Learn URL" labelFor="learnUrl" isRequired="true">
                    <bbNG:textElement name="learnUrl" id="key" maxLength="100" size="100" value="${learnUrl}"/>
                    <bbNG:elementInstructions text=""/>
                </bbNG:dataElement>
            </bbNG:step>
            
            <bbNG:stepSubmit cancelUrl="${cancelUrl}"/>

        </bbNG:dataCollection>
    </bbNG:form>

</bbNG:genericPage>

