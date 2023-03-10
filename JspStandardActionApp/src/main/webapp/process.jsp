<%@ page%>
<jsp:useBean id="employee" class="com.getitdone.in.dto.Employee" scope="request"/>
<jsp:setProperty name="employee" property="*" />
<jsp:useBean id="service" class="com.getitdone.in.service.EmployeeServiceImpl" scope="application"/>
<%
  service.getSalaryDetails(employee);
%>

<table border='1' align="center">
<caption>Salary details.</caption>
<tr>
<th>Employee Name</th>
<td><jsp:getProperty property="ename" name="employee"/></td>
</tr>
<tr>
<th>Employee Address</th>
<td><jsp:getProperty property="eaddress" name="employee"/></td>
</tr>
<tr>
<th>Employee Salary</th>
<td><jsp:getProperty property="esalary" name="employee"/></td>
</tr>
<tr>
<th>Gross Salary</th>
<td><jsp:getProperty property="grossSalary" name="employee"/></td>
</tr>
<tr>
<th>Net Salary</th>
<td><jsp:getProperty property="netSalary" name="employee"/></td>
</tr>

</table>
<br/>
<br/>
<h2 style="color:blue;text-align:center;"><a href="./index.html">HomePage</a></h2>

