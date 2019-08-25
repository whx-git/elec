<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page language="java" pageEncoding="UTF-8"%>


<html>
<head>
<LINK href="${pageContext.request.contextPath }/css/Style.css" type="text/css" rel="stylesheet">
<title>站点信息编辑</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" language="JavaScript" src="${pageContext.request.contextPath }/script/function.js" ></script>
<Script language="javascript">
	function check_null(){
	
		 var theForm=document.Form1;
		 
		 if(theForm.jctId.value=="0")
		{
			alert("请选择所属单位");
			theForm.jctId.focus();
			return false;
		} 
	    
	    if(theForm.stationType.value=="0")
		{
			alert("请选择站点类别");
			theForm.stationType.focus();
			return false;
		} 
	     if(Trim(theForm.stationName.value)=="")
		{
			alert("站点名称不能为空");
			theForm.stationName.focus();
			return false;
		} 
		if(Trim(theForm.stationCode.value)=="")
		{
			alert("站点代号不能为空");
			theForm.stationCode.focus();
			return false;
		} 
	   
	   if(theForm.comment.value.length>250){
     
        	alert("备注字符长度不能超过250");
			theForm.comment.focus();
			return false; 
        }
		 
	   document.Form1.action="/modifySiteInfo.html?stationid=${station.stationid}";
	   document.Form1.submit();
	   //window.setTimeout(refreshThisOpener('stationInfo.do'),3000);
		
	}
	
    function refreshThisOpener(sHref){

    opener.gotopage(sHref,"nowpage");  
    window.close ();
   }
 </script>
</head>

<body>
<form name="Form1" method="post" id="Form1">		
<br>					
<table cellSpacing="1" cellPadding="5" width="580" align="center" bgColor="#eeeeee" style="border:1px solid #8ba7e3" border="0"> 
     <tr>
		<td class="ta_01" align="center" colSpan="4" background="${pageContext.request.contextPath }/images/b-info.gif">
		 <font face="宋体" size="2"><strong>站点信息编辑</strong></font>
            <font style="color: red">${resultInfo}</font>
		</td>
     </tr>
    <tr>
    
    <input type="hidden" name="stationid" value="4028d0931a519a19011a519e52e30001">
    
<td width="15%" height="22" align="center" bgColor="#f5fafe" class="ta_01">所属单位：</td>
<td width="35%" class="ta_01" bgColor="#ffffff">
       
        <select name="jctId" id="jctId" style="width:155px">
		
		<option value="">全部</option>
        <c:forEach items="${jctids}" var="jctid">
            <c:if test="${jctid.ddlname.equals(station.jctid)}">
                <option value="${jctid.ddlname}" selected="selected">${jctid.ddlname}</option>
            </c:if>
            <option value="${jctid.ddlname}">${jctid.ddlname}</option>
        </c:forEach>

		</select> <font color="#FF0000">*</font> 
</td>
<td width="15%" height="22" align="center" bgColor="#f5fafe" class="ta_01">站点名称：</td>
<td width="35%" class="ta_01" bgColor="#ffffff">
<input name="stationName" type="text" id="stationName"  size="20" maxlength="25" value="${station.stationname}"> <font color="#FF0000">*</font></td>
</tr>
<tr> 
  <td width="15%" height="22" align="center" bgColor="#f5fafe" class="ta_01">站点代号：</td>
  <td width="35%" class="ta_01" bgColor="#ffffff"><input name="stationCode" type="text" id="Text2"  size="20" maxlength="25" value="${station.stationcode}"> <font color="#FF0000">*</font></td>
  <td width="15%" height="22" align="center" bgColor="#f5fafe" class="ta_01">使用时间：</td>
  <td width="35%" class="ta_01" bgColor="#ffffff" height="30">
  <input name="useStartDate" type="text"  size="20" value="${station.usestartdate}" onclick="WdatePicker()"></td>
 </tr>
<tr> 
  <td width="15%" height="22" align="center" bgColor="#f5fafe" class="ta_01">安装地点：</td>
  <td width="35%" class="ta_01" bgColor="#ffffff">
  <input name="jcfrequency" type="text" id="jcfrequency"  size="20" maxlength="50" value="${station.jcfrequency}"></td>
  <td width="15%" height="22" align="center" bgColor="#f5fafe" class="ta_01">生产厂家：</td>
  <td width="35%" class="ta_01" bgColor="#ffffff">
   <input name="produceHome" type="text" id="produceHome"  size="20" maxlength="25" value="${station.producehome}"></td>
 </tr>
 <tr> 
  <td width="15%" height="22" align="center" bgColor="#f5fafe" class="ta_01">通讯方式：</td>
  <td width="35%" class="ta_01" bgColor="#ffffff">
  <input name="contactType" type="text" id="contactType"  size="20" maxlength="25" value="${station.contacttype}"></td>
  <td width="15%" height="22" align="center" bgColor="#f5fafe" class="ta_01">站点类别：</td>
  <td  width="35%" class="ta_01" bgColor="#ffffff" height="30">
                    <select name="stationType" id="stationType" style="width:160px">
					<option value="0">全部</option>
					<c:forEach items="${stationType}" var="type">
                        <c:if test="${type.ddlname.equals(station.stationtype)}">
                            <option value="${type.ddlname}"  selected>${type.ddlname}</option>
                        </c:if>
                        <option value="${type.ddlname}">${type.ddlname}</option>
                    </c:forEach>
							

					</select><font color="#FF0000">*</font></td>
  </tr>

<tr> 
  <td width="15%" height="22" align="center" bgColor="#f5fafe" class="ta_01">归属地：</td>
  <td width="35%" class="ta_01" bgColor="#ffffff"><input name="attributionGround" type="text" id="attributionGround"  size="20" maxlength="25" value="${station.attributionground}"></td>
  <td width="15%" height="22" align="center" bgColor="#ffffff" class="ta_01"></td>
  <td width="35%" class="ta_01" bgColor="#ffffff" height="30"></td>
</tr>  
<tr>
	<td width="15%" class="ta_01" align="center" bgcolor="#f5fafe">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</td>
	<td width="85%" class="ta_01" bgcolor="#ffffff" colspan="3">
		<textarea name="comment" id="comment" style="width:100%" style="word-break: break-all"  rows="4">${station.comment}</textarea></td>
</tr>


    <tr> 
      <td class="ta_01" style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="4">
        
        
        <input type="button" name="BT_Submit" value="保存" id="BT_Submit" style="font-size:12px; color:black; height=22;width=55" onclick="check_null()"> 
        <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> 
        
        
        <INPUT style="font-size:12px; color:black; height=22;width=55" type="reset" value="关闭"  NAME="Reset1" onclick="window.close();">
      </td>
    </tr>
  </table>
  　
</form>
</body>
</HTML>
