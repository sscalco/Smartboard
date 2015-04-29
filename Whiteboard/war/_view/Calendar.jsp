<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="_view/Calendar.css">
	<div id="Title">
		<title>SmartBoard</title>
	</div>
</head>
<body>
	<h1>SmartBoard: Calendar</h1>
	<div id="Options">
	<h3><form action="${pageContext.request.contextPath}/hub" method="post"><button type="submit" name="account" value="true">My Account</button> | <button type="submit" name="help" value="true">Help</button> | <button type="submit" name="logout" value="true">Log Out</button></form></h3>
	</div>
	<div id="Calendar">
		<TABLE BORDER=3 CELLSPACING=65 CELLPADDING=70> 
		<TR>
			<TD COLSPAN="7" ALIGN=center><B>May 2015</B></TD> 
		</TR>
		<TR> 
			<TD COLSPAN="7" ALIGN=center><I>One more month til summer!</I></TD>
		</TR>
		<TR> 
			<TD ALIGN=center>Sun</TD>
			<TD ALIGN=center>Mon</TD>
			<TD ALIGN=center>Tue</TD>
			<TD ALIGN=center>Wed</TD>
			<TD ALIGN=center>Thu</TD>
			<TD ALIGN=center>Fri</TD>
			<TD ALIGN=center>Sat</TD>
		</TR>
		<TR> 
			<TD ALIGN=center></TD>
			<TD ALIGN=center></TD>
			<TD ALIGN=center></TD>
			<TD ALIGN=center></TD>
			<TD ALIGN=center></TD>
			<TD ALIGN=center>1</TD>
			<TD ALIGN=center>2</TD>
		</TR>
		<TR> 
			<TD ALIGN=center>3</TD>
			<TD ALIGN=center>4</TD>
			<TD ALIGN=center>5</TD>
			<TD ALIGN=center>6</TD>
			<TD ALIGN=center>7</TD>
			<TD ALIGN=center>8</TD>
			<TD ALIGN=center>9</TD>
		</TR>
		<TR> 
			<TD ALIGN=center>10</TD>
			<TD ALIGN=center>11</TD>
			<TD ALIGN=center>12</TD>
			<TD ALIGN=center>13</TD>
			<TD ALIGN=center>14</TD>
			<TD ALIGN=center>15</TD>
			<TD ALIGN=center>16</TD>
		</TR>
		<TR> 
			<TD ALIGN=center>17</TD>
			<TD ALIGN=center>18</TD>
			<TD ALIGN=center>19</TD>
			<TD ALIGN=center>20</TD>
			<TD ALIGN=center>21</TD>
			<TD ALIGN=center>22</TD>
			<TD ALIGN=center>23</TD>
		</TR>
		<TR> 
			<TD ALIGN=center>24</TD>
			<TD ALIGN=center>25</TD>
			<TD ALIGN=center>26</TD>
			<TD ALIGN=center>27</TD>
			<TD ALIGN=center>28</TD>
			<TD ALIGN=center>29</TD>
			<TD ALIGN=center>30</TD>
		</TR>
		<TR> 
			<TD ALIGN=center>31</TD>
			<TD ALIGN=center></TD>
			<TD ALIGN=center></TD>
			<TD ALIGN=center></TD>
			<TD ALIGN=center></TD>
			<TD ALIGN=center></TD>
			<TD ALIGN=center></TD>
		</TR>
	</TABLE>	
</body>
</html>
