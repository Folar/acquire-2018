<%@ page import="ackgames.acquire.*"%>
<%response.addHeader("Cache-Control","no-cache");%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!--
Front end to ShowItems servlet.

Taken from More Servlets and JavaServer Pages
from Prentice Hall and Sun Microsystems Press,
http://www.moreservlets.com/.
(C) 2002 Marty Hall; may be freely used or adapted.
-->
<HTML>
<HEAD>
  <TITLE>Order Form</TITLE>
<script language="JavaScript">
function sub() {
    if (!document.getElementById) return;
    obj=document.getElementById("SignIn");
	str = obj.value;
   if(str.length == 0){
		alert("Illegal name specified");
		return false;
	}
	while(str.indexOf(" ")!=-1){
		str= str.substring(0,str.indexOf(" "))+"_"+str.substring(str.indexOf(" ")+1);
	}
   obj.value=str;
	return true;
}
</script>
</HEAD>
<BODY BGCOLOR="#5092E4"><BR<BR>
<H1 ALIGN="CENTER" STYLE="color:white;font-family:sanserif">Acquire</H1>

<FORM ACTION="stage.jsp" onSubmit="return sub();">
  <CENTER>
  <I STYLE="color:white;"> Players:</I><INPUT TYPE="TEXT" NAME="name" ID="SignIn" >
   <BR><BR>
    <INPUT TYPE="SUBMIT" VALUE="Login" >
  </CENTER>
</FORM>

</BODY>
</HTML>

public void jspInit()
{
		BoardGenerator.hackMain();
}