<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page language="java" pageEncoding="UTF-8"%>




<html>

	<head>
		<title>设备购置计划</title>
		<link href="${pageContext.request.contextPath }/css/Style.css" type="text/css" rel="stylesheet" />
		<script language="javascript" src="${pageContext.request.contextPath }/script/function.js"></script>
		<script language="javascript" src="${pageContext.request.contextPath }/script/pub.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
		
<script language="javascript">


function CheckOthers(form)
{
	for (var i=0;i<form.elements.length;i++)
	{
		var e = form.elements[i];
			if (e.checked==false)
			{
				e.checked = true;// form.chkall.checked;
			}
			else
			{
				e.checked = false;
			}
			e.checked = false;
	}
}

function CheckAll(form)
{
	for (var i=0;i<form.elements.length;i++)
	{
		var e = form.elements[i];
			e.checked = true// form.chkall.checked;
	}
}


  function jsNext(){
     
     changeformvalue();
	 document.F1.direction.value="NEXT";
	 document.F1.goPage.value=""; 
	 Pub.submitActionWithForm('Form1','changePage.do','F1');     

  }
  function jsPrevious(){

     changeformvalue();
	 document.F1.direction.value="PREVIOUS";
	 document.F1.goPage.value="";
     Pub.submitActionWithForm('Form1','changePage.do','F1');     
  }	
  
  function jsJumpToBegin(){
     changeformvalue();
	 document.F1.pageNo.value="1";
	 Pub.submitActionWithForm('Form1','changePage.do','F1');     
 }

  function jsJumpToEnd(){
    changeformvalue();
	document.F1.pageNo.value=document.Form1.sumPage.value;
    Pub.submitActionWithForm('Form1','changePage.do','F1');     
  }
  
  function jsJumpto(){
  
     changeformvalue();
	 var gopage=parseInt(document.F1.goPage.value);
	 var sumpage=parseInt(document.F1.sumPage.value);
	
	 if(gopage<=sumpage&&gopage>=1)
	 {	 	
	 	document.F1.pageNo.value=document.F1.goPage.value;
        Pub.submitActionWithForm('Form1','changePage.do','F1');   
	 }
	 else{
	    alert("不存在此页，请重新输入页数"); 
	 }
}
   
  function changeformvalue(){
	
    document.Form1.jctId.value=document.F1.jctId.value;
	document.Form1.devName.value=document.F1.devName.value;
	document.Form1.planDatef.value=document.F1.planDatef.value;
	document.Form1.planDatet.value=document.F1.planDatet.value;
	document.Form1.devType.value=document.F1.devType.value;



	
	}

  function  searchplan(){
     changeformvalue();
     Pub.submitActionWithForm('Form1','queryDatas.html','Form1');

  }
function  exportplan(){
	changeformvalue();
	document.Form1.action="/exportPlans.html";
	document.Form1.submit();

}
  function jsPlanNext(){

     changeformvalue();  
	 document.F1.direction.value="";
	 document.F1.goPage.value="";
	 Pub.submitActionWithForm('Form1','devicePlanNextDate.do','F1');   
  }
  
  
  function jsDPToD(){
  
     changeformvalue();
	 document.F1.direction.value="";
	 document.F1.goPage.value="";
	 
	 var devplan=document.Form1.devPlanId;
	 var devplanid="";
	 var flag=0;
	
	 if(typeof(devplan)=="undefined"){ 
	    return;
	 }
	 
	 if(typeof(devplan.length)!="undefined"){   //多个
	 
	     for(var i=0;i<devplan.length;i++){
	         if(devplan[i].checked==true){
	            
	            devplanid+=devplan[i].value+",";  
	            flag=1;       
	         }     
	     }
	 }else{                                  //只有一个


	    if(devplan.checked==true){
	            
	            devplanid+=devplan.value+",";  
	            flag=1;       
	     }       	
	 }
	  
	 document.F1.plantodev.value=devplanid;
	 
	 if(flag==1){
	   Pub.submitActionWithForm('Form1','devicePlanToDevice.do','F1');
	 }	 
  }
  
  
  function savewithopener(path){
     
     changeformvalue();
     document.F1.pageNo.value="1";
	 document.F1.direction.value="";
	 document.F1.goPage.value=document.F1.pageNo.value;
	 Pub.submitActionWithForm('Form1',path,'F1');  
 }
 function returnMethod(){
	 return confirm("确认要删除？");
 }
</script>

	</head>
	<body>
		<table cellspacing="1" cellpadding="0" width="90%" align="center" bgcolor="#f5fafe" border="0">
		
			    <tr>
			      <td class="ta_01" align="center" background="${pageContext.request.contextPath }/images/b-info.gif">
			       <font face="宋体" size="2"><strong>设备购置计划</strong></font>
			     </td>
		        </tr>
		        <TR height=10><td></td></TR>
				<tr>
					<td>
<form name="F1" method="post"  id="F1" style="margin:0px;">
					
				    <input type="hidden" name="typeView" value="" >
				    <input type="hidden" name="direction" value="">
                    <input type="hidden" name="pageNo" value="" >
                    <input type="hidden" name="sumPage" value="" > 
                    <input type="hidden" name="lastRecordIndex" value="" >
                    <input type="hidden" name="changeFlag" value="" >
                    <input type="hidden" name="goPage" value="" >
                    <input type="hidden" name="plantodev" value="" >,
                  
						<table cellpadding="0" cellspacing="0" border="0" width="100%">
							<tr>
								<td width="100" class="ta_01" align="center" bgcolor="#f5fafe" height="22">所属单位：</td>
								<td class="ta_01" >		
									<select name="jctId" id="jctId" style="width:200px">
									
		                            <option value="">全部</option>
		                            
					                
					                <c:forEach items="${jctids}" var="jctid" >
										<option value="${jctid.ddlname}">${jctid.ddlname}</option>
									</c:forEach>

		

											
				                  
				                  
												
					             </select>
								</td>
								<td width="100" class="ta_01" align="center" bgcolor="#f5fafe" height="22">设备名称：</td>
								<td class="ta_01" >
									<input name="devName" type="text" id="devName"  size="22" value="" />
								</td>
							</tr>
							<tr>
								<td class="ta_01" align="center" bgcolor="#f5fafe" height="22">计划时间：</td>
								<td class="ta_01" width="300" >
									<input name="planDatef" type="text" id="planDatef" size="10" value=""  onclick="WdatePicker()">
									~
									<input name="planDatet" type="text" id="planDatet" size="10" value="" onclick="WdatePicker()">
								</td>

				<td width="100" class="ta_01" align="center" bgcolor="#f5fafe" height="22">设备类型：</td>
								<td class="ta_01"  width="247">
									
									<select name="devType" id="devType" style="width:168px">					
									<option value="">全部</option>
					                
					                <c:forEach items="${devtypes}" var="devtype">
										<option value="${devtype.ddlname}">
											${devtype.ddlname}
										</option>
									</c:forEach>

											
				                   

				                   
				                   
										</select> 
								</td>
					</tr>		
		</table>
</form>
							
<br>							
<form name="Form1" id="Form1" style="margin:0px;">

	<input type="hidden" name="jctId" value="jctId">
	<input type="hidden" name="devName" value="devName">
	<input type="hidden" name="planDatef" value="planDatef">
	<input type="hidden" name="planDatet" value="planDatet">
	<input type="hidden" name="devType" value="devType ">

  <table cellpadding="0" cellspacing="0" border="0" width="100%" bgcolor="#f5fafe">	        
	 <TR>
		<TD align="center" background="${pageContext.request.contextPath }/images/cotNavGround.gif" width="25"><img src="${pageContext.request.contextPath }/images/yin.gif" width="15"></TD>
			<TD class="DropShadow" background="${pageContext.request.contextPath }/images/cotNavGround.gif" width="100">设备计划信息列表</TD>										
			<td>
			   	
			    	
			     &nbsp;&nbsp;<input type="button" height=20 style="font-size:12px; color:black; height=20;width=50" name="chkall" value="全选" onClick="CheckAll(this.form)">
			     <input type="button" height=20 style="font-size:12px; color:black; height=20;width=50"  name="chkOthers" value="取消" onClick="CheckOthers(this.form)">
				 
				 	
			</td>
			<td class="ta_01" align="right"  >
			    <input name="BT_Search" type="button" style="font-size:12px; color:black; height=20;width=50" id="BT_Search" value="查询"  onclick="searchplan()"/>
					
				<input name="BT_Add" type="button" style="font-size:12px; color:black; height=20;width=50" id="BT_Add" onClick="openWindow('planAdd.jsp',800,450);" value="添加" />
				<input name="BT_import" type="button" style="font-size:12px; color:black; height=20;width=50" id="BT_import" onClick="openWindow('planImportView.html','600','450');" value="导入">

				<input type="button" name="chkall" height=20 style="font-size:12px; color:black; height=20;width=50"  value="购置" onclick="jsDPToD()">
				<input type="button" name="chkall2" height=20 style="font-size:12px; color:black; height=20;width=80"  value="计划顺延" onclick="jsPlanNext()">

                <input type="button" name="BT_ex" value="导出"  id="BT_ex"     onClick="exportplan()" style="font-size:12px; color:black; height=20;width=50">
                <input type="button" name="BT_ex" value="导出设置"  id="BT_ex"  onClick="openWindow('planExportView.html?XorJ=J','600','450');" style="font-size:12px; color:black; height=20;width=80">
				
			</td>
	</TR>		
  </table>		
  	
  <table cellpadding="0" cellspacing="0" border="0" width="100%" bgcolor="#f5fafe">			
		<tr>
					<td class="ta_01" align="center" bgcolor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT:gray 1px solid; BORDER-TOP:gray 1px solid; BORDER-LEFT:gray 1px solid; WIDTH:100%; WORD-BREAK:break-all; BORDER-BOTTOM:gray 1px solid; BORDER-COLLAPSE:collapse; BACKGROUND-COLOR:#f5fafe; WORD-WRAP:break-word">
							<tr style="FONT-WEIGHT:bold;FONT-SIZE:12pt;HEIGHT:25px;BACKGROUND-COLOR:#afd1f3">
								<td align="center" width="5%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">序号</td>
								<td align="center" width="22%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">名称</td>
								<td align="center" width="9%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">数量</td>
								<td align="center" width="9%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">金额</td>
								<td align="center" width="14%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">规格型号</td>
								<td align="center" width="9%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">用途</td>
								<td align="center" width="11%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">使用单位</td>
									
								<td width="9%" align="center" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">是否购置</td>
								
								
								<td width="5%" align="center" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">编辑</td>
								<td width="5%" align="center" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">删除</td>
								
							</tr>
							
							<c:forEach items="${pageBean.beans}" var="plan" varStatus="vs">
								<tr onMouseOver="this.style.backgroundColor = 'white'" onMouseOut="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR:hand; HEIGHT:22px" align="center" width="5%">
										${vs.count}
									</td>
									<td align="center"  width="22%">
										<a href="javascript:;" onClick="openWindow('planView.html?editflag=0&devPlanId=${plan.devplanid}',800,450,'设备详细信息');" class="cl_01">${plan.devname}</a></td>
									<td align="center"  width="9%">${plan.quality}</td>
									<td align="center"  width="9%">	${plan.devexpense}</td>
									<td align="center"  width="14%">
										${plan.spectype}
									</td>

									<td align="center"  width="9%">
										${plan.useness}
									</td>
									<td align="center"  width="11%" style="HEIGHT: 22px">
										${plan.useunit}</td>

									<td align="center" >
										<input type="checkbox" id="devPlanId"  name="devPlanId" value="${plan.devplanid}" />
									</td>


									<td align="center">
										<a href="javascript:;"
										   onClick="openWindow('planEdit.jsp?editflag=1&devPlanId=5cb793a299f64ae9a17953749715121d&typeView=设备购置计划查询&pageNo=1&sumPage=37&lastRecordIndex=369&changeFlag=receive&direction=',800,450);">
											<IMG src="${pageContext.request.contextPath }/images/edit.gif" style="CURSOR: hand" border="0" ></a>
									</td>
									<td align="center" >
										<a href="javascript:Pub.submitActionWithForm('Form1','delDevicePlan.do?editflag=1&devPlanId=5cb793a299f64ae9a17953749715121d&typeView=设备购置计划查询&pageNo=1&sumPage=37&lastRecordIndex=369&changeFlag=receive&direction=','F1')"
										   onclick="returnMethod()"> <IMG src="${pageContext.request.contextPath }/images/delete.gif" style="CURSOR: hand"  border="0"></a>
									</td>

								</tr>
							</c:forEach>



		</table>
	</td>
  </tr>			
					
	
		<tr>
			<td colspan="2" align="right">
			<jsp:include page="/WEB-INF/pageUI.jsp"></jsp:include>
			</td>
			</tr>								
			</table>
			
		</form>
	</body>

</html>
