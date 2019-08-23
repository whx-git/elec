<%@ page language="java" pageEncoding="UTF-8"%>


<html>

	<head>
		<title>仪器设备管理</title>
		<link href="${pageContext.request.contextPath }/css/Style.css" type="text/css" rel="stylesheet" />
		<script language="javascript" src="${pageContext.request.contextPath }/script/public.js" charset="gb2312"></script>
		<script language="javascript" src="${pageContext.request.contextPath }/script/function.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
		<script language="javascript" src="${pageContext.request.contextPath }/script/pub.js"></script>
		<script language="javascript" src="${pageContext.request.contextPath }/script/changePageBackUp.js"></script>

<SCRIPT type="text/javascript">

  function jsJumpToBeginDevice(){

     changeformvalue();
	 document.F1.pageNo.value="1";
	 Pub.submitActionWithForm('Form1','changePageDevice.do','F1'); 
  }

  function jsJumpToEndDevice(){

	 changeformvalue();
	 document.F1.pageNo.value=document.Form1.sumPage.value;
	 Pub.submitActionWithForm('Form1','changePageDevice.do','F1'); 

  }
  
  function jsNextDevice(){

     changeformvalue();
	 document.F1.direction.value="NEXT";
	 document.F1.goPage.value=""; 
     Pub.submitActionWithForm('Form1','changePageDevice.do','F1'); 
}

  function jsPreviousDevice(){

     changeformvalue();
	 document.F1.direction.value="PREVIOUS";
	 document.F1.goPage.value="";
     Pub.submitActionWithForm('Form1','changePageDevice.do','F1'); 
 }
 
  function jsJumptoDevice(){

     changeformvalue();
	 var gopage=parseInt(document.F1.goPage.value);
	 var sumpage=parseInt(document.F1.sumPage.value);
	
	 if(gopage<=sumpage&&gopage>=1)
	 {	 	
	 	document.F1.pageNo.value=document.F1.goPage.value;
        Pub.submitActionWithForm('Form1','changePageDevice.do','F1');   
	 }else{
	    alert("不存在此页，请重新输入页数"); 
	 }
 }
  
  function  gotosearchDevice(){
     changeformvalue();
     Pub.submitActionWithForm('Form1','searchDevice.do','F1');   
  }
  
  function changeformvalue(){
	
    document.F1.direction.value=document.Form1.direction.value;
	document.F1.goPage.value=document.Form1.goPage.value;
	document.F1.typeView.value=document.Form1.typeView.value;
	document.F1.pageNo.value=document.Form1.pageNo.value;
	document.F1.changeFlag.value=document.Form1.changeFlag.value;
	document.F1.sumPage.value=document.Form1.sumPage.value;
	document.F1.lastRecordIndex.value=document.Form1.lastRecordIndex.value;
	
 }
 
	function JctSelectChange(mySelect)
	{
	   if (mySelect.selectedIndex != "" && document.F1.devType.selectedIndex != "")
	    {
	    	devTuzhi.style.display = ""
	    
	    } else {
	    	devTuzhi.style.display = "none"
	    }
	}
	
	function DevTypeSelectChange(mySelect)
	{
	   if (mySelect.selectedIndex != "" && document.F1.jctId.selectedIndex != "")
	    {
	    	devTuzhi.style.display = ""
	    
	    } else {
	    	devTuzhi.style.display = "none"
	    }
	}
	
		function upload(fn){
			var jctId=document.F1.jctId.value;
			if(jctId==0){
          		alert("请先选择所属单位");
          	return;
       		}
			
			var str = "initUpload.do?belongTo=" + fn
						+ "&jctId=" + jctId + "&projid=" + document.F1.jctId.selectedIndex + "-" + document.F1.devType.selectedIndex;
			
			OpenWindow('uploadInit',str,800,450);
		}	
	function returnMethod(){
		return confirm("确认要删除吗？");
	}
</SCRIPT>
</head>

<body>
		   <form name="F1" method="post"  id="F1" style="margin:0px;">
		   
		      	    <input type="hidden" name="typeView" value="" >
				    <input type="hidden" name="direction" value="">
                    <input type="hidden" name="pageNo" value="" >
                    <input type="hidden" name="sumPage" value="" > 
                    <input type="hidden" name="lastRecordIndex" value="" >
                    <input type="hidden" name="changeFlag" value="" >
                    <input type="hidden" name="goPage" value="" >
                    <input type="hidden" name="plantodev" value="" >
		   
		   
			<table cellspacing="1" cellpadding="0" width="90%" align="center" bgcolor="#f5fafe" border="0">
			<tr>
			 <td class="ta_01" align="center" background="${pageContext.request.contextPath }/images/b-info.gif">
			 <font face="宋体" size="2"><strong>仪器设备管理</strong></font>
			 </td>
		   </tr>
		    <TR height=10><td></td></TR>	
				
				<tr>
					<td>
						<table cellpadding="0" cellspacing="0" border="0" width="100%">
							<tr>
								<td width="100" class="ta_01" align="center" bgcolor="#f5fafe" height="22">所属单位：
								</td>
								<td class="ta_01" >
									<select name="jctId" id="jctId" class="bg" onChange=JctSelectChange(this)>
									
						<option value="">全部</option>
											
						<option value="1">北京</option>	
		
						<option value="2">上海</option>	
						
						<option value="3">深圳</option>	
						
						<option value="4">厦门</option>	
						
						<option value="5">成都</option>	
						
						<option value="6">海尔滨</option>	
						
						<option value="7">长春</option>	
						
						<option value="8">沈阳</option>	
						
						<option value="9">广州</option>	
						
						<option value="10">西安</option>	
						
						<option value="11">南宁</option>	
						
						<option value="12">天津</option>	
						
						<option value="13">海南</option>	
							
					</select>
								</td>
								<td width="100" class="ta_01" align="center" bgcolor="#f5fafe" height="22">设备名称：


								</td>
								<td class="ta_01" >
									<input name="devName" type="text" id="devName"  size="28" value="" />
								</td>
							</tr>
							<tr>
								<td class="ta_01" align="center" bgcolor="#f5fafe" height="22">设备类型：</td>
								<td class="ta_01" width="300" >
									<select name="devType" id="devType" class="bg" onChange=DevTypeSelectChange(this)>
					<option value="">全部</option>
					
											<option value="1">
												电力设备dd
											</option>
											
				
											<option value="2">
												电机设备
											</option>
											
				
											<option value="3">
												通讯设备
											</option>
											
				
											<option value="4">
												防雷设备
											</option>
											
				
											<option value="5">
												办公设备
											</option>
											
				
											<option value="6">
												电视机房设备
											</option>
											
				
											<option value="7">
												发电机房设备
											</option>
											
				
				
					</select>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<span  id="devTuzhi" style="DISPLAY: none">
					<input id="btnTuzhi" type="button" value=" 详细" name="btnTuzhi" onclick="upload('5');" style="font-size:12px; color:black; height=20">
					</span>
			 </td>

								<td width="100" class="ta_01" align="center" bgcolor="#f5fafe" height="22"> 使用日期：


								</td>
								<td class="ta_01"  width="247">
									<input name="useDatef" type="text" id="useDatef" size="10"  onclick="WdatePicker()"> ~ 
					<input name="useDatet" type="text" id="useDatet" size="10"  onclick="WdatePicker()">
					
								</td>
							</tr>
							
							<tr>
					<td width="100" class="ta_01" align="center" bgcolor="#f5fafe" height="22">
					 设备状态：</td>
					<td class="ta_01" align="left" ><font face="宋体" color="red">
					<select name="devState" id="devState" class="bg">
					<option value="">全部</option>
					
					
											<option value="1">
												正常
											</option>
											
				
											<option value="2">
												检修
											</option>
											
				
											<option value="3">
												维修
											</option>
											
				
				
					</select></font></td>
					
					
					<td class="ta_01" align="center" bgcolor="#f5fafe" height="22">计划时间：


					</td>
					
					<td class="ta_01"   width="300" >
					
					<input name="planDatef" type="text" id="planDatef" size="10" value=""  onclick="WdatePicker()" >
					~
					<input name="planDatet" type="text" id="planDatet" size="10" value="" onclick="WdatePicker()">
					</td>
				</tr>	
				</table>
		   </td>
		</tr>
	</table>
  </form>			
  <br>		
 <form name="Form1" method="post"  id="Form1" style="margin:0px;">
	 <table cellpadding="0" cellspacing="0" border="0" width="90%" align="center">
		<TR>
			<TD align="center" background="${pageContext.request.contextPath }/images/cotNavGround.gif" width="25"><img src="${pageContext.request.contextPath }/images/yin.gif" width="15"></TD>
			<TD class="DropShadow" background="${pageContext.request.contextPath }/images/cotNavGround.gif" width="80">设备信息列表</TD>
			<td  align="right" class="ta_01" >
				<INPUT name="BT_Search" type="button"  id="BT_Search" value="查询" style="font-size:12px; color:black; height=20;width=50"  onclick="gotosearchDevice()">  
				
				<input name="BT_export" type="button" " id="BT_export" value="导出" style="font-size:12px; color:black; height=20;width=50" onClick="openWindow('exportSarDevice.do','600','400')" >
			    <input type="button" name="setexcelExport" style="font-size:12px; color:black; height=20;width=80"  value="导出设置" id="setexcelExport"  onClick="openWindow('equapmentExport.jsp','600','400')"  >
				
			</td>
		</TR>
</TABLE>
   <table cellpadding="0" cellspacing="0" border="0" width="90%" align="center">			
		<tr>
			<td class="ta_01" align="center" bgcolor="#f5fafe">
				<table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT:gray 1px solid; BORDER-TOP:gray 1px solid; BORDER-LEFT:gray 1px solid; WIDTH:100%; WORD-BREAK:break-all; BORDER-BOTTOM:gray 1px solid; BORDER-COLLAPSE:collapse; BACKGROUND-COLOR:#f5fafe; WORD-WRAP:break-word">
							<tr style="FONT-WEIGHT:bold;FONT-SIZE:12pt;HEIGHT:25px;BACKGROUND-COLOR:#afd1f3">
					<td width="11%" align="center" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">序号</td>
					<td width="15%" align="center" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">名称</td>
					<td width="14%" align="center" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">规格型号</td>
					<td align="center" width="8%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">设备状态</td>
					<td align="center" width="10%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">使用日期</td>
					<td align="center" width="10%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">检修周期</td>
					<td align="center" width="9%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">所属单位</td>
					
					
					<td width="6%" align="center" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">编辑</td>
					<td width="6%" align="center" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">删除</td>		
					
				    </tr>
					
					
							
				    <tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
					<td  align="center">1</td>
					<td  align="center">
					<a href="javascript:;" onClick="openWindow('equapmentView.jsp?editflag=0&devId=ab15b1290c004d53af24bd2ce8845fa4&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=',800,450,'设备详细信息');" class="cl_01">
					UPS123</a></td>
					<td align="left" >FR-UK 3140</td>
					<td align="center"  width="8%">
					正常</td>
					<td align="center"  width="10%">2017-06-25</td>
					<td align="center"  width="10%">
					1月　</td>
					<td align="center"  width="9%" style="HEIGHT: 22px">
					北京</td>
					
					<td align="center" style="HEIGHT: 22px">
										<a href="javascript:;"
											onClick="openWindow('equapmentEdit.jsp?editflag=1&devId=ab15b1290c004d53af24bd2ce8845fa4&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=',800,450,'设备详细信息');">
											<IMG src="${pageContext.request.contextPath }/images/edit.gif" style="CURSOR: hand" border="0" ></a>
					</td>
					<td align="center" style="HEIGHT: 22px">
										<a href="javascript:Pub.submitActionWithForm('Form1','delDevice.do?devId=ab15b1290c004d53af24bd2ce8845fa4&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=','F1')"
											onclick="returnMethod()"> <IMG src="${pageContext.request.contextPath }/images/delete.gif" style="CURSOR: hand" border="0" ></a>
					</td>
					
				</tr>
				
				
							
				    <tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
					<td  align="center">2</td>
					<td  align="center">
					<a href="javascript:;" onClick="openWindow('equapmentView.jsp?editflag=0&devId=aa07b80f0c104ba38ebfb049c375997f&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=',800,450,'设备详细信息');" class="cl_01">
					UPS44444</a></td>
					<td align="left" >FR-UK 3120</td>
					<td align="center"  width="8%">
					正常</td>
					<td align="center"  width="10%">2017-05-28</td>
					<td align="center"  width="10%">
					1月　</td>
					<td align="center"  width="9%" style="HEIGHT: 22px">
					北京</td>
					
					<td align="center" style="HEIGHT: 22px">
										<a href="javascript:;"
											onClick="openWindow('equapmentEdit.jsp?editflag=1&devId=aa07b80f0c104ba38ebfb049c375997f&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=',800,450,'设备详细信息');">
											<IMG src="${pageContext.request.contextPath }/images/edit.gif" style="CURSOR: hand" border="0" ></a>
					</td>
					<td align="center" style="HEIGHT: 22px">
										<a href="javascript:Pub.submitActionWithForm('Form1','delDevice.do?devId=aa07b80f0c104ba38ebfb049c375997f&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=','F1')"
											onclick="returnMethod()"> <IMG src="${pageContext.request.contextPath }/images/delete.gif" style="CURSOR: hand" border="0" ></a>
					</td>
					
				</tr>
				
				
							
				    <tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
					<td  align="center">3</td>
					<td  align="center">
					<a href="javascript:;" onClick="openWindow('equapmentView.jsp?editflag=0&devId=e11c8381ec0f436b992ba0e44dd33cb0&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=',800,450,'设备详细信息');" class="cl_01">
					UPS6666</a></td>
					<td align="left" >FR-UK 3120</td>
					<td align="center"  width="8%">
					正常</td>
					<td align="center"  width="10%">2017-05-27</td>
					<td align="center"  width="10%">
					1月　</td>
					<td align="center"  width="9%" style="HEIGHT: 22px">
					北京</td>
					
					<td align="center" style="HEIGHT: 22px">
										<a href="javascript:;"
											onClick="openWindow('equapmentEdit.jsp?editflag=1&devId=e11c8381ec0f436b992ba0e44dd33cb0&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=',800,450,'设备详细信息');">
											<IMG src="${pageContext.request.contextPath }/images/edit.gif" style="CURSOR: hand" border="0" ></a>
					</td>
					<td align="center" style="HEIGHT: 22px">
										<a href="javascript:Pub.submitActionWithForm('Form1','delDevice.do?devId=e11c8381ec0f436b992ba0e44dd33cb0&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=','F1')"
											onclick="returnMethod()"> <IMG src="${pageContext.request.contextPath }/images/delete.gif" style="CURSOR: hand" border="0" ></a>
					</td>
					
				</tr>
							
				    <tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
					<td  align="center">4</td>
					<td  align="center">
					<a href="javascript:;" onClick="openWindow('equapmentView.jsp?editflag=0&devId=c51da3d47c814b488d4a4206c7a1703f&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=',800,450,'设备详细信息');" class="cl_01">
					UPS789</a></td>
					<td align="left" >FR-UK 3141</td>
					<td align="center"  width="8%">
					正常</td>
					<td align="center"  width="10%">2017-04-28</td>
					<td align="center"  width="10%">
					1月　</td>
					<td align="center"  width="9%" style="HEIGHT: 22px">
					北京</td>
					
					<td align="center" style="HEIGHT: 22px">
										<a href="javascript:;"
											onClick="openWindow('equapmentEdit.jsp?editflag=1&devId=c51da3d47c814b488d4a4206c7a1703f&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=',800,450,'设备详细信息');">
											<IMG src="${pageContext.request.contextPath }/images/edit.gif" style="CURSOR: hand" border="0" ></a>
					</td>
					<td align="center" style="HEIGHT: 22px">
										<a href="javascript:Pub.submitActionWithForm('Form1','delDevice.do?devId=c51da3d47c814b488d4a4206c7a1703f&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=','F1')"
											onclick="returnMethod()"> <IMG src="${pageContext.request.contextPath }/images/delete.gif" style="CURSOR: hand" border="0" ></a>
					</td>
					
				</tr>
				
				
							
				    <tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
					<td  align="center">5</td>
					<td  align="center">
					<a href="javascript:;" onClick="openWindow('equapmentView.jsp?editflag=0&devId=8b788d86e15743af9d99871cd1a625b3&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=',800,450,'设备详细信息');" class="cl_01">
					UPS99999</a></td>
					<td align="left" >FR-UK 3140</td>
					<td align="center"  width="8%">
					维修</td>
					<td align="center"  width="10%">2017-04-30</td>
					<td align="center"  width="10%">
					1月　</td>
					<td align="center"  width="9%" style="HEIGHT: 22px">
					北京</td>
					
					<td align="center" style="HEIGHT: 22px">
										<a href="javascript:;"
											onClick="openWindow('equapmentEdit.jsp?editflag=1&devId=8b788d86e15743af9d99871cd1a625b3&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=',800,450,'设备详细信息');">
											<IMG src="${pageContext.request.contextPath }/images/edit.gif" style="CURSOR: hand" border="0" ></a>
					</td>
					<td align="center" style="HEIGHT: 22px">
										<a href="javascript:Pub.submitActionWithForm('Form1','delDevice.do?devId=8b788d86e15743af9d99871cd1a625b3&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=','F1')"
											onclick="returnMethod()"> <IMG src="${pageContext.request.contextPath }/images/delete.gif" style="CURSOR: hand" border="0" ></a>
					</td>
					
				</tr>
				
				
							
				    <tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
					<td  align="center">6</td>
					<td  align="center">
					<a href="javascript:;" onClick="openWindow('equapmentView.jsp?editflag=0&devId=12a794ed3ae243ffa4dcad631ea756c9&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=',800,450,'设备详细信息');" class="cl_01">
					UPSaaa</a></td>
					<td align="left" >FR-UK 3120</td>
					<td align="center"  width="8%">
					正常</td>
					<td align="center"  width="10%">2017-06-25</td>
					<td align="center"  width="10%">
					5日　</td>
					<td align="center"  width="9%" style="HEIGHT: 22px">
					北京</td>
					
					<td align="center" style="HEIGHT: 22px">
										<a href="javascript:;"
											onClick="openWindow('equapmentEdit.jsp?editflag=1&devId=12a794ed3ae243ffa4dcad631ea756c9&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=',800,450,'设备详细信息');">
											<IMG src="${pageContext.request.contextPath }/images/edit.gif" style="CURSOR: hand" border="0" ></a>
					</td>
					<td align="center" style="HEIGHT: 22px">
										<a href="javascript:Pub.submitActionWithForm('Form1','delDevice.do?devId=12a794ed3ae243ffa4dcad631ea756c9&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=','F1')"
											onclick="returnMethod()"> <IMG src="${pageContext.request.contextPath }/images/delete.gif" style="CURSOR: hand" border="0" ></a>
					</td>
					
				</tr>
				
				
							
				    <tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
					<td  align="center">7</td>
					<td  align="center">
					<a href="javascript:;" onClick="openWindow('equapmentView.jsp?editflag=0&devId=feb787e55063498286b265bcc3f2a80d&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=',800,450,'设备详细信息');" class="cl_01">
					UPSbbb</a></td>
					<td align="left" >FR-UK 3141</td>
					<td align="center"  width="8%">
					正常</td>
					<td align="center"  width="10%">2017-04-28</td>
					<td align="center"  width="10%">
					1　</td>
					<td align="center"  width="9%" style="HEIGHT: 22px">
					北京</td>
					
					<td align="center" style="HEIGHT: 22px">
										<a href="javascript:;"
											onClick="openWindow('equapmentEdit.jsp?editflag=1&devId=feb787e55063498286b265bcc3f2a80d&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=',800,450,'设备详细信息');">
											<IMG src="${pageContext.request.contextPath }/images/edit.gif" style="CURSOR: hand" border="0" ></a>
					</td>
					<td align="center" style="HEIGHT: 22px">
										<a href="javascript:Pub.submitActionWithForm('Form1','delDevice.do?devId=feb787e55063498286b265bcc3f2a80d&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=','F1')"
											onclick="returnMethod()"> <IMG src="${pageContext.request.contextPath }/images/delete.gif" style="CURSOR: hand" border="0" ></a>
					</td>
					
				</tr>
				
				
							
				    <tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
					<td  align="center">8</td>
					<td  align="center">
					<a href="javascript:;" onClick="openWindow('equapmentView.jsp?editflag=0&devId=e6f3ee9d442f4c55baa5da3d5c5cacc7&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=',800,450,'设备详细信息');" class="cl_01">
					UPS电源</a></td>
					<td align="left" ></td>
					<td align="center"  width="8%">
					正常</td>
					<td align="center"  width="10%">2011-08-26</td>
					<td align="center"  width="10%">
					　</td>
					<td align="center"  width="9%" style="HEIGHT: 22px">
					北京</td>
					
					<td align="center" style="HEIGHT: 22px">
										<a href="javascript:;"
											onClick="openWindow('equapmentEdit.jsp?editflag=1&devId=e6f3ee9d442f4c55baa5da3d5c5cacc7&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=',800,450,'设备详细信息');">
											<IMG src="${pageContext.request.contextPath }/images/edit.gif" style="CURSOR: hand" border="0" ></a>
					</td>
					<td align="center" style="HEIGHT: 22px">
										<a href="javascript:Pub.submitActionWithForm('Form1','delDevice.do?devId=e6f3ee9d442f4c55baa5da3d5c5cacc7&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=','F1')"
											onclick="returnMethod()"> <IMG src="${pageContext.request.contextPath }/images/delete.gif" style="CURSOR: hand" border="0" ></a>
					</td>
					
				</tr>
				
				
							
				    <tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
					<td  align="center">9</td>
					<td  align="center">
					<a href="javascript:;" onClick="openWindow('equapmentView.jsp?editflag=0&devId=bf699d06532b4d818666f89998db0c19&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=',800,450,'设备详细信息');" class="cl_01">
					打印机</a></td>
					<td align="left" >BJC-80</td>
					<td align="center"  width="8%">
					正常</td>
					<td align="center"  width="10%">2011-08-26</td>
					<td align="center"  width="10%">
					　</td>
					<td align="center"  width="9%" style="HEIGHT: 22px">
					北京</td>
					
					<td align="center" style="HEIGHT: 22px">
										<a href="javascript:;"
											onClick="openWindow('equapmentEdit.jsp?editflag=1&devId=bf699d06532b4d818666f89998db0c19&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=',800,450,'设备详细信息');">
											<IMG src="${pageContext.request.contextPath }/images/edit.gif" style="CURSOR: hand" border="0" ></a>
					</td>
					<td align="center" style="HEIGHT: 22px">
										<a href="javascript:Pub.submitActionWithForm('Form1','delDevice.do?devId=bf699d06532b4d818666f89998db0c19&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=','F1')"
											onclick="returnMethod()"> <IMG src="${pageContext.request.contextPath }/images/delete.gif" style="CURSOR: hand" border="0" ></a>
					</td>
					
				</tr>
				
				
							
				    <tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
					<td  align="center">10</td>
					<td  align="center">
					<a href="javascript:;" onClick="openWindow('equapmentView.jsp?editflag=0&devId=3ab65799250542dd95bf6750e929818d&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=',800,450,'设备详细信息');" class="cl_01">
					大头鬼</a></td>
					<td align="left" ></td>
					<td align="center"  width="8%">
					正常</td>
					<td align="center"  width="10%">2017-05-28</td>
					<td align="center"  width="10%">
					3周　</td>
					<td align="center"  width="9%" style="HEIGHT: 22px">
					北京</td>
					
					<td align="center" style="HEIGHT: 22px">
										<a href="javascript:;"
											onClick="openWindow('equapmentEdit.jsp?editflag=1&devId=3ab65799250542dd95bf6750e929818d&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=',800,450,'设备详细信息');">
											<IMG src="${pageContext.request.contextPath }/images/edit.gif" style="CURSOR: hand" border="0" ></a>
					</td>
					<td align="center" style="HEIGHT: 22px">
										<a href="javascript:Pub.submitActionWithForm('Form1','delDevice.do?devId=3ab65799250542dd95bf6750e929818d&typeView=设备查询&pageNo=1&sumPage=13&lastRecordIndex=124&changeFlag=receive&direction=','F1')"
											onclick="returnMethod()"> <IMG src="${pageContext.request.contextPath }/images/delete.gif" style="CURSOR: hand" border="0" ></a>
					</td>
					
				</tr>
				
				
				
				
			</table>
			</td>
		</tr>
	
		<tr>
			 <td colspan="2" align="right">
			 <table border="0" width="100%" cellspacing="0" cellpadding="0">
        
           <tr>
             <td width="28%" align="left">总记录数：125条</td> 
             <td width="15%" align="right"></td>                 
             
             <td width="5%" align="center">首页&nbsp;&nbsp;|</td>
             <td width="7%" align="center">上一页&nbsp;&nbsp;&nbsp;|</td>
             
             
			 
             
             <td width="7%" align="center"><u><a href="javascript:jsNextDevice()">下一页&nbsp;&nbsp;&nbsp;|</a></u></td>
             <td width="5%" align="center"><u><a href="javascript:jsJumpToEndDevice()">末页</a></u></td>
             
             <td width="6%" align="center">第1页</td>
             <td width="6%" align="center">共13页</td>
             <td width="18%" align="right">至第<input  type="text" name="goPage"  size="3"  style="width:50px" >页

             <u><a href="#" onClick="javascript:jsJumptoDevice()">确定</a></u></td>
             <td width="3%"></td> 
             <td></td> 
             <td></td>
             <td></td>
             <td></td> 
             <td></td>
             <td><input type="hidden" name="typeView" value="设备查询" >
				  <input type="hidden" name="direction" value="">
                  <input type="hidden" name="pageNo" value="1" >
                  
                   <input type="hidden" name="sumPage" value="13" > 
                   <input type="hidden" name="lastRecordIndex" value="124" >
                  <input type="hidden" name="changeFlag" value="receive" >
             </td> 
           </tr>
         </table>       				
		</td>
	   </tr>
	  
	
	</table>
		</form>
	</body>

</html>

