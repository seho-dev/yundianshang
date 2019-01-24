<html>
<head>
<meta charset="GBK">
<title>DEMO</title>
</head>
<body>
<#include "header.ftl">

<#--我只是一个注释，我不会有任何输出  -->
${name},hello${message}

<#--定义一个变量属性-->
<#assign linkman="Lucy">
<br>
联系人:${linkman}
<#--定义一个对象的放松调用-->
<#assign text="{'iphone':'152364854','address':'南通市海门市'}"/>
<br>
<#assign data=text?eval/>
电话号码:${data.iphone}  <br> 地址:${data.address}
<br>
电话号码:${data.iphone}  <br> 地址:${data.address}
<br>

<#if success=true>
  你已通过实名认证
<#else>  
  你未通过实名认证
</#if>
<br>
---商品列表----
<#list goodList as good>
<br>
${good_index+1}
 商品名称 ${good.name}   商品价格 ${good.price}<br>
<br>
一共多少  ${goodList?size}  条
<br>
-----时间--------
<br>
时间：${tody?time}<br>
日期：${tody?date}<br>
日期+时间：${tody?datetime}<br>

积分:${point?c}
</#list>

<#--作非空判断-->
<br>
<#if aaa??>
执行ifaaa${aaa}
<#else>
执行o((>ω< ))o
</#if>
<br>
${bbb!'不为空'}
<br>
<#if (point>100)>
黄金会员
</#if>



</body>
</html>
