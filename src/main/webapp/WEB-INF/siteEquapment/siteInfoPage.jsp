<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<table cellspacing="0" cellpadding="0" width="90%" align="center" bgcolor="#f5fafe" border="0">
    <TR>
        <TD align="center" background="${pageContext.request.contextPath }/images/cotNavGround.gif" width=25><img src="${pageContext.request.contextPath }/images/yin.gif" width="15"></TD>
        <TD class="DropShadow" background="${pageContext.request.contextPath }/images/cotNavGround.gif" width=80>站点信息列表</TD>
        <td class="ta_01" align="right" >
            <input type="button" name="BT_Search" style="font-size:12px; color:black; height=20;width=50" value="查询" id="BT_Search" onclick="gotoquery('querySiteInfoDatas.html')" >

            <input style="font-size:12px; color:black; height=20;width=50" id="BT_Add" type="button" value="添加" name="BT_Add" onclick="openWindow('siteInfoAdd.jsp','700','350')" />
            <input type="button" name="excelimport" style="font-size:12px; color:black; height=20;width=50"    value="导入"    id="excelimport"  onclick="openWindow('siteInfoImport.jsp?fn=1','600','400')" >
            <input type="button" name="excelExport" style="font-size:12px; color:black; height=20;width=50"    value="导出"    id="excelExport"  onClick="exeportExcel()" >
            <input type="button" name="setexcelExport" style="font-size:12px; color:black; height=20;width=80"  value="导出设置" id="setexcelExport"  onClick="openWindow('siteInfoExport.jsp','600','400')"  >

        </td>
    </TR>
</table>
<table cellspacing="1" cellpadding="0" width="90%" align="center" bgcolor="#f5fafe" border="0">
    <tr>
        <td class="ta_01" align="center" bgcolor="#f5fafe">
            <table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray" border="1" id="DataGrid1" style="BORDER-RIGHT:gray 1px solid; BORDER-TOP:gray 1px solid; BORDER-LEFT:gray 1px solid; WIDTH:100%; WORD-BREAK:break-all; BORDER-BOTTOM:gray 1px solid; BORDER-COLLAPSE:collapse; BACKGROUND-COLOR:#f5fafe; WORD-WRAP:break-word">
                <tr style="FONT-WEIGHT:bold;FONT-SIZE:12pt;HEIGHT:25px;BACKGROUND-COLOR:#afd1f3">
                    <td align="center" width="5%"  height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">序号</td>
                    <td align="center" width="10%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">所属单位</td>

                    <td align="center" width="10%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">归属地</td>

                    <td align="center" width="10%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">站点代号</td>
                    <td align="center" width="13%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">站点名称</td>
                    <td align="center" width="10%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">站点类别</td>
                    <td align="center" width="10%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">通讯方式</td>
                    <td align="center" width="10%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">安装地点</td>

                    <td width="7%" align="center" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">编辑</td>
                    <td width="7%" align="center" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">删除</td>

                </tr>

                <c:forEach items="${pageBean.beans}" var="station" varStatus="vs">
                    <tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">

                        <td align="center" width="5%">&nbsp;${vs.count}</td>
                        <td align="center" width="10%">${station.jctid}</td>

                        <td align="center" width="10%">${station.attributionground}</td>

                        <td align="center" width="10%">${station.stationcode}</td>
                        <td align="center" width="13%" style="HEIGHT: 22px">
                            <a href="#" onclick="openWindow('siteInfoView.html?&stationid=${station.stationid}','700','350');" class="cl_01">
                                    ${station.stationname}</a></td>
                        <td align="center" width="10%">${station.stationtype}</td>
                        <td align="center" width="10%">${station.contacttype}</td>
                        <td align="center" width="10%">${station.jcfrequency}</td>

                        <td align="center" style="HEIGHT: 22px">
                            <a href="#" onclick="openWindow('siteInfoEdit.jsp?editflag=1&stationid=4028d0931a519a19011a519e52e30001','700','350');">
                                <img src="${pageContext.request.contextPath }/images/edit.gif" border="0" style="CURSOR:hand"></a></td>
                        <td align="center" style="HEIGHT: 22px">
                            <a href="javascript:gotopage('removestation.do?stationid=4028d0931a519a19011a519e52e30001','nowpage')" onclick="returnMethod()">
                                <img src="${pageContext.request.contextPath }/images/delete.gif" width="15" height="14" border="0" style="CURSOR:hand"></a></td>

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