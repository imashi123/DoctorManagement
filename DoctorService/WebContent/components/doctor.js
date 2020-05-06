
$(document).ready(function()

 {
	 $("#alertSuccess").hide();
	 $("#alertError").hide();
 });

$(document).on("click", "#btnSave", function(event) 
		{  
			$("#alertSuccess").text("");  
			$("#alertSuccess").hide();  
			$("#alertError").text("");  
			$("#alertError").hide(); 
			
			
			var status = validatedoctorForm();  
			if (status != true)  
			{   
				$("#alertError").text(status);   
				$("#alertError").show();   
				return;  
			} 
			
			var type = ($("#hiddoctorIDSave").val() == "") ? "POST" : "PUT"; 
			
			$.ajax( 
			{  
				url : "DoctorAPI",  
				type : type,  
				data : $("#formdoctor").serialize(),  
				dataType : "text",  
				complete : function(response, status)  
				{   
					ondoctorSaveComplete(response.responseText, status);
				} 
			
		}); 
}); 
		
function ondoctorSaveComplete(response, status) 
{  
	if (status == "success")  
	{   
		var resultSet = JSON.parse(JSON.stringify(response)); 
		//console.log(resultSet);
		
		if (status == "success")   
		{    
			$("#alertSuccess").text("Successfully saved.");    
			$("#alertSuccess").show(); 
			$("#divdoctorsGrid2").html(resultSet.data); 
			//console.log(resultSet);
			//location.reload();  
			setTimeout(location.reload.bind(location), 1000)
			//console.log(resultSet);
			//window.location.href ="gg.jsp"


		} else if (status.trim() == "error")   
		{    
			$("#alertError").text(status);    
			$("#alertError").show();   
		} 

		} else if (status == "error")  
		{   
			$("#alertError").text("Error while saving.");   
			$("#alertError").show();  
		} else  
		{   
			$("#alertError").text("Unknown error while saving..");   
			$("#alertError").show();  
		} 

		$("#hiddoctorIDSave").val("");  
		$("#formdoctor")[0].reset(); 
		
}

$(document).on("click", ".btnRemove", function(event) 
{  
	$.ajax(  
	{   
		url : "DoctorAPI",   
		type : "DELETE",   
		data : "doctorID=" + $(this).data("doctorid"),   
		dataType : "text",   
		complete : function(response, status)   
		{    
			ondoctorDeleteComplete(response.responseText, status);   
		}  
	}); 
}); 


function ondoctorDeleteComplete(response, status) 
{  
	if (status == "success")  
	{   
		// var resultSet = JSON.parse(response); 

		if (status.trim() == "success")   
		{    
			$("#alertSuccess").text("Successfully deleted.");    
			$("#alertSuccess").show(); 
			location.reload();
			//$("#divdoctorGrid").html(resultSet.data);   
		} else if (status.trim() == "error")   
		{    
			$("#alertError").text(status);    
			$("#alertError").show();   
		} 

			} else if (status == "error")  
			{   
				$("#alertError").text("Error while deleting.");   
				$("#alertError").show();  
			} else  
			{   
				$("#alertError").text("Unknown error while deleting..");   
				$("#alertError").show();  
			} 
	} 

$(document).on("click", ".btnUpdate", function(event) 
{     
	$("#hiddoctorIDSave").val($(this).closest("tr").find('#hiddoctorIDUpdate').val());     
	$("#doctorCode").val($(this).closest("tr").find('td:eq(0)').text());     
	$("#doctorNic").val($(this).closest("tr").find('td:eq(1)').text());     
	$("#doctorName").val($(this).closest("tr").find('td:eq(2)').text());     
	$("#doctorDesc").val($(this).closest("tr").find('td:eq(3)').text()); 
}); 


function validatedoctorForm() 
{    
	if ($("#doctorCode").val().trim() == "")  
	{   
		return "Insert doctor Code.";   
	}
	  
	if ($("#doctorNic").val().trim() == "")  
	{   
		return "Insert doctor nic.";  
	}
	
	if ($("#doctorName").val().trim() == "")  
	{   
		return "Insert doctor name";  
	} 
  
	if ($("#doctorDesc").val().trim() == "")  
	{   
		return "Insert doctor Description.";
	} 
	 
	 return true;
	
}

