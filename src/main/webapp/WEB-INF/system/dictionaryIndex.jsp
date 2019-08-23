<%@ page import="com.whx.elec8.ConstantsKeys" %>
<%@ page import="java.util.List" %>
<%@ page import="com.whx.elec8.domain.ElecPopedom" %>
<%@ page import="java.util.TreeSet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="p" uri="http://whx.popedom/jstl/fake" %>

<%@ page language="java"  pageEncoding="UTF-8"%>








<HTML>
	<HEAD>
		<title>系统设置</title>		
		<LINK href="${pageContext.request.contextPath }/css/Style.css" type="text/css" rel="stylesheet">
		<script language="javascript" src="${pageContext.request.contextPath }/script/function.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/script/pub.js"></script>
		<script language="javascript">
		
			
			
		function changetype(){
		
		  if(document.Form1.keyword.value=="jerrynew"){
		    
		     
		  	 var textStr="<input type=\"text\" name=\"keywordname\" maxlength=\"50\" size=\"24\"> ";
		     document.getElementById("newtypename").innerHTML="类型名称：";
		     document.getElementById("newddlText").innerHTML=textStr;
		     
			  //前端框架的ajax
			 // 第一个参数:后台给我们返回一个局部页面
			 //第二个参数:ajax请求后台的url
			 //第三个参数:需要提交给后台的表单
		     Pub.submitActionWithForm('Form2','getDatas.html','Form1');
		    
		  }else{
		    
		    var textStr="";
		    document.getElementById("newtypename").innerHTML="";
		    document.getElementById("newddlText").innerHTML=textStr;
		     
		    Pub.submitActionWithForm('Form2','getDatas.html','Form1');
		  }  
	   }
	   
     function saveDict(){
	      
	      if(document.Form1.keyword.value=="jerrynew"){
	          if(Trim(document.Form1.keywordname.value)==""){
	             alert("请输入类型名称");
	             return false;
	          }
	          
	         var allkeywords= document.Form1.keyword;
	         for(var i=0;i<allkeywords.length;i++){
	    
	            if(allkeywords[i].value==Trim(document.Form1.keywordname.value)){           

	               alert("已存在此类型名称,请重新输入");
	               return false;
	             }
	             
	         }
	         
	          document.Form2.keywordname.value=document.Form1.keywordname.value;
	          document.Form2.typeflag.value="new";
	          
	      }else{
	      
	          document.Form2.keyword.value=document.Form1.keyword.value;
	          document.Form2.typeflag.value="add";	
	      }
	      var tbl=document.getElementById("dictTbl");
	      for (i=1;i<tbl.rows.length;i++){   
		   	  	var name = tbl.rows[i].cells[1].getElementsByTagName("input")[0].value;
		   	  	if(Trim(name)==""){
		   	  	    alert("名称不能为空！");
		   	  	    
		   	  	    return false;
	   	  	    }
	   	  }
	   	  for(k=1;k<=tbl.rows.length-2;k++)
		  {
	 	  	for(m=k+1;m<=tbl.rows.length-1;m++)
	 	  	{     
		  	  	var name1 = tbl.rows[k].cells[1].getElementsByTagName("input")[0].value;
		  	  	var name2 = tbl.rows[m].cells[1].getElementsByTagName("input")[0].value;
		  	  	if(name1 == name2){
		  	  		alert("名称不能相同！"); 
		  	  		 return false;
		        }	
		    }
		  }
	      document.Form2.action="/modifyDatas.html";
	      document.Form2.submit();     
	}    
  
     
     
     
       

 function insertRows(){ 

  var tempRow=0; 
  var tbl=document.getElementById("dictTbl");
  tempRow=tbl.rows.length; 
  var Rows=tbl.rows;//类似数组的Rows 
  var newRow=tbl.insertRow(tbl.rows.length);//插入新的一行 
  var Cells=newRow.cells;//类似数组的Cells 
  for (i=0;i<3;i++)//每行的3列数据 
  { 
     var newCell=Rows[newRow.rowIndex].insertCell(Cells.length); 
     newCell.align="center"; 
     switch (i) 
    { 
      case 0 : newCell.innerHTML=""+tempRow+"";break; 
      case 1 : newCell.innerHTML="<input name=\"itemname\" type=\"text\" id=\""+tempRow+"\" size=\"45\" maxlength=25>";break; 
      case 2 : newCell.innerHTML="<a href='javascript:delTableRow(\""+tempRow+"\")'><img src=${pageContext.request.contextPath }/images/delete.gif width=15 height=14 border=0 style=CURSOR:hand></a>";break;

    } 
    //alert(newCell.innerHTML);
  } 
 } 


function delTableRow(rowNum){ 

   var tbl=document.getElementById("dictTbl");
    
    if (tbl.rows.length >rowNum){ 
      
       tbl.deleteRow(rowNum); 
     
      for (i=rowNum;i<tbl.rows.length;i++)
       {
         tbl.rows[i].cells[0].innerHTML=i;
         tbl.rows[i].cells[2].innerHTML="<a href='javascript:delTableRow(\""+i+"\")'><img src=${pageContext.request.contextPath }/images/delete.gif width=15 height=14 border=0 style=CURSOR:hand></a>";      
      }
   }
} 

	function returnMethod(){
		return saveDict();
	}
    
	 </script>
 </HEAD>
		
	<body>
	 <Form name="Form1" id="Form1"  method="post" style="margin:0px;">
		<table cellSpacing="1" cellPadding="0" width="90%" align="center" bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" colspan=3 align="center" background="${pageContext.request.contextPath }/images/b-info.gif">
						<font face="宋体" size="2"><strong>数据字典维护</strong></font>
					</td>
				</tr>
				<TR height=10><td colspan=3></td></TR>		
				<tr>
					<td class="ta_01" align="right" width="35%" >类型列表：</td>
					<td class="ta_01" align="left"  width="30%" >
						<select name="keyword" class="bg" style="width:180px" onchange="changetype()">
						 <option value="jerrynew"></option>
						 <c:forEach items="${keywords}" var="keyword">
							 <option value="${keyword}">${keyword}</option>

						 </c:forEach>

						 
						</select>
					</td>
						
					 <td class="ta_01"  align="right" width="35%" >					 	    
				    </td>	  		
				</tr>
				
				
				
			    <tr>
			       <td class="ta_01" align="right" width="35%" id="newtypename">类型名称：</td>
				   <td class="ta_01"  align="left" width="30%"  height=20 id="newddlText">
				    <input type="text" name="keywordname" maxlength="25" size=24>	
				   </td>
				   <td class="ta_01"  align="right" width="35%" ></td>
				</tr>
				
				
				<TR height=10><td colspan=3 align="right">
				   <input type="button" name="saveitem" value="添加选项" style="font-size:12px; color:black; height=20;width=80" onClick="insertRows()">
				 </td></TR>   
			</TBODY>
		</table>
		</Form>
		
 <Form name="Form2" id="Form2"  method="post" style="margin:0px;">
    <table cellSpacing="1" cellPadding="0" width="90%" align="center" bgColor="#f5fafe" border="0" >
    <tr>
     <td >
	   <table cellspacing="0"   cellpadding="1" rules="all" bordercolor="gray" border="1" id="dictTbl"
		    style="BORDER-RIGHT:gray 1px solid; BORDER-TOP:gray 1px solid; BORDER-LEFT:gray 1px solid; WIDTH:100%; WORD-BREAK:break-all; BORDER-BOTTOM:gray 1px solid; BORDER-COLLAPSE:collapse; BACKGROUND-COLOR:#f5fafe; WORD-WRAP:break-word">
			
		
						
				<tr style="FONT-WEIGHT:bold;FONT-SIZE:12pt;HEIGHT:25px;BACKGROUND-COLOR:#afd1f3">
					<td class="ta_01" align="center"  width="20%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">编号</td>
					<td class="ta_01" align="center"  width="60%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">名称</td>
					<td class="ta_01" align="center"  width="20%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">删除</td>					
				</tr>
			    
			   
			     <tr>
				   <td class="ta_01" align="center"  width="20%">1</td>
				   <td class="ta_01" align="center"  width="60%">
				   <input name="itemname" type="text"  size="45" maxlength="25"></td>
				   <td class="ta_01" align="center"  width="20%"></td>
				</tr>
	          
	            
			
	     </table>
	   </td>
	 </tr>
  <tr>
     <td >   
	 </td>
 </tr>
 <TR height=10><td colspan=3></td></TR>
  <tr>
     <td align="center" colspan=3>
		<p:checkP have="ec">
			<input type="button" name="saveitem" value="保存" style="font-size:12px; color:black; height=20;width=50" onClick="returnMethod()">
		</p:checkP>


	 </td>
 </tr>
 
       <input type="hidden" name="keywordname" >
       <input type="hidden" name="keyword" >
       <input type="hidden" name="typeflag" >
	 
  </table>
   

   
  </Form>
  </body>
</HTML>


