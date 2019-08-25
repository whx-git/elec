
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table border="0" width="100%" cellspacing="0" cellpadding="0">

    <tr>
        <td width="28%" align="left">总记录数：${pageBean.totalResult}</td>
        <td width="15%" align="right"></td>

        <td width="5%" align="center"><u><a href="javascript:gotopage('${pageBean.requestUrl}','start')">首页&nbsp;&nbsp;</a></u></td>
        <td width="7%" align="center"><u><a href="javascript:gotopage('${pageBean.requestUrl}','prev')">上一页&nbsp;&nbsp;&nbsp;</a></u></td>




        <td width="7%" align="center"><u><a href="javascript:gotopage('${pageBean.requestUrl}','next')">下一页&nbsp;&nbsp;&nbsp;|</a></u></td>
        <td width="5%" align="center"><u><a href="javascript:gotopage('${pageBean.requestUrl}','end')">末页</a></u></td>

        <td width="6%" align="center">第${pageBean.pageNo}页</td>
        <td width="6%" align="center">共${pageBean.sumPage}页</td>
        <td width="18%" align="right">至第<input size="1" type="text" name="goPage"  size="3"  style="width:50px">页



            <u><a href="#" onClick="javascript:gotopage('${pageBean.requestUrl}','go')">确定</a></u></td>
        <td width="3%"></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>

        <td> <input type="hidden" name="typeView" value="" >
            <input type="hidden" name="direction" value="">
            <input type="hidden" name="pageNO" value="${pageBean.pageNo}" >
            <input type="hidden" name="sumPage" value="${pageBean.sumPage}" >
            <input type="hidden" name="prevpageNO" value="${(pageBean.pageNo-1)<=1?1:(pageBean.pageNo-1)}" >
            <input type="hidden" name="nextpageNO" value="${(pageBean.pageNo+1)>=pageBean.sumPage?pageBean.sumPage:(pageBean.pageNo+1)}" >
            <input type="hidden" name="lastRecordIndex" value="${pageBean.totalResult}" >
            <input type="hidden" name="changeFlag" value="receive" ></td>
    </tr>
</table>