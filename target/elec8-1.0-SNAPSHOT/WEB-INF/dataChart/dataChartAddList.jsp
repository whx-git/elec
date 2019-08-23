<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray"
	border="1" id="filesTb2" align="center"
	style="BORDER-RIGHT:gray 1px solid; BORDER-TOP:gray 1px solid; BORDER-LEFT:gray 1px solid; WIDTH:700; WORD-BREAK:break-all; BORDER-BOTTOM:gray 1px solid; BORDER-COLLAPSE:collapse; BACKGROUND-COLOR:#f5fafe; WORD-WRAP:break-word">

	<tr
		style="FONT-WEIGHT:bold;FONT-SIZE:12pt;HEIGHT:25px;BACKGROUND-COLOR:#afd1f3">
		<td class="ta_01" align="center" width="20%"
			background="../images/tablehead.jpg" height=20>
			编号
		</td>
		<td class="ta_01" align="center" width="80%"
			background="../images/tablehead.jpg" height=20>
			已上传文件
		</td>
	</tr>
	<c:forEach items="${elecFileuploads}" var="upload" varStatus="vs">
		<tr onmouseover="this.style.backgroundColor = 'white'"
			onmouseout="this.style.backgroundColor = '#F5FAFE';">
			<td class="ta_01" align="center" width="20%">
				${vs.count}
			</td>
			<td class="ta_01" align="center" width="80%">
				<a href="#" onclick="openWindow('${upload.fileurl}','700','400');">国家电网SoTower平台使用手册.doc</a>
			</td>
		</tr>


	</c:forEach>


</table>
