<%@page import="model.Doctor"%>
<%@page import="model.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor management</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body> 


<div class="container">
		<div class="row">
			<div class="col-6">

				<h1>Doctor management</h1>
				<form id="formdoctor" name="formdoctor" method="" action="">
					doctor code: 
					<input id="doctorCode" name="doctorCode" type="text"
						class="form-control form-control-sm"> <br> 
					doctor nic:
					<input id="doctorNic" name="doctorNic" type="text"
						class="form-control form-control-sm"> <br> 
					doctor name:
					<input id="doctorName" name="doctorName" type="text"
						class="form-control form-control-sm"> <br> 
					doctor description: 
					<input id="doctorDesc" name="doctorDesc" type="text"
						class="form-control form-control-sm"> <br> 
					<input
						id="btnSave" name="btnSave" type="button" value="Save"
						class="btn btn-primary"> 
					<input type="hidden"
						id="hiddoctorIDSave" name="hiddoctorIDSave" value="">
				</form>

				<div id="alertSuccess" class = "alert alert-success">
					<%
						out.print(session.getAttribute("statusMsg"));
					%>
				</div>

				<div id="alertError" class="alert alert-danger"></div>
				<br>
				<%
					Doctor doctorobj = new Doctor();
					out.print(doctorobj.readDoctor());
				%>
				
				
				
			</div>
		
			
		
		</div>
	</div>


<script src="https://code.jquery.com/jquery-3.5.0.min.js" integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ=" crossorigin="anonymous"></script>
<script type="text/javascript" src="./components/doctor.js"></script>

</body>
</html>