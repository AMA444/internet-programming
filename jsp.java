<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>

<html>
<body>
<%
String driver ="com.mysql.jdbc.Driver";
String connURL="jdbc:mysql://localhost:3306/";
String database="Database";
String userId-"root";
String password="";

try{
Class.forName(driver);
}catch(ClassNotFoundException e)
{ e.printStackTrace(); }

Connection conn=null;
Statement statement=null;
ResultSet resultset=null;


conn=DriverManager.getConnection(connURL+database,userId,password);
statement=conn.createStatement();
String sql=" select name,rate  from beverages";
resultset=statement.executeQuery(sql);
%>
<select>
<%
do
{
 String str=resultset.getstring("name")+" "+resultset.getInt("rate");
%>
<option><%= str %></option>
<%
}while(resultset.next());
conn.close();
}catch(Exception e)
{ e.printStackTrace(); }
%>
</select>
</body>
</html>
