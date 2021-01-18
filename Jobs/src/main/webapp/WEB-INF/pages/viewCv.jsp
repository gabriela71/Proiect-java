<%-- 
    Document   : viewCv
    Created on : Jan 18, 2021, 4:43:38 PM
    Author     : Alex
--%>

<t:pageTemplate pageTitle="View CV">
    
    <center>
        <embed src="${pageContext.request.contextPath}/CvFile?id=${username}" width="1200px" height="1500px" />
    </center>
    
</t:pageTemplate>