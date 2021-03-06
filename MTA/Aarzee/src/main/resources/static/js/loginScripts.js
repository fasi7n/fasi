 jQuery(document).ready(function () {
    	   $("#password, #passwordConfirm").keyup(verifyConfirmPassword);
    	});
 
 
 function verifyConfirmPassword() {
    
	var orignalPass = $("#password").val();
    var confirmPass = $("#passwordConfirm").val();

    if (orignalPass != confirmPass){
        $("#verifyPassMsg").html("Your Passwords Do NOT Match");
        $('#registerSubmitButton').prop('disabled', true);
       
    }
    
    else if(orignalPass.match(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[-!@#$%^&*()_+|~=`{}\[\]:";'<>?,.\/])[a-zA-Z0-9-!@#$%^&*()_+|~=`{}\[\]:";'<>?,.\/]{8,}$/)
    		&& confirmPass.match(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[-!@#$%^&*()_+|~=`{}\[\]:";'<>?,.\/])[a-zA-Z0-9-!@#$%^&*()_+|~=`{}\[\]:";'<>?,.\/]{8,}$/) )
    	{
    	 $("#verifyPassMsg").html("Looks Good!");
    	 $('#registerSubmitButton').prop('disabled', false);
    	
    	}
    
    else if(orignalPass.match(/^(?=.*[^a-z])(?=.*[^A-Z])(?=.*^\d)(?=.*[^-!@#$%^&*()_+|~=`{}\[\]:";'<>?,.\/])[^a-zA-Z0-9-!@#$%^&*()_+|~=`{}\[\]:";'<>?,.\/]{8,}$/)
    		&& confirmPass.match(/^(?=.*[^a-z])(?=.*[^A-Z])(?=.*^\d)(?=.*[^-!@#$%^&*()_+|~=`{}\[\]:";'<>?,.\/])[^a-zA-Z0-9-!@#$%^&*()_+|~=`{}\[\]:";'<>?,.\/]{8,}$/) )
    	{
    	 $("#verifyPassMsg").html("Passwords DO NOT meet requirements!");
    	 $('#registerSubmitButton').prop('disabled', false);
    	 $('#passwordRules').show();
    	
    	}
    
    else
    	{
        $("#verifyPassMsg").html("Passwords Match");
    	$('#registerSubmitButton').prop('disabled', false);
 		}
}
 
 jQuery(document).ready(function() {
 $("#password").keyup(function() {
	 
	 var password = $(this).val();	 
	
	 
	 	if (password.match(/[a-z]/)) {
		   $('#smallCase').removeClass('notAllowedPassRules').addClass('allowedPassRules');
		} 
	 	else {
		     $('#smallCase').removeClass('allowedPassRules').addClass('notAllowedPassRules');
		}

		
		if (password.match(/[A-Z]/)) {
		   $('#capsCase').removeClass('notAllowedPassRules').addClass('allowedPassRules');
		}
		else {
		     $('#capsCase').removeClass('allowedPassRules').addClass('notAllowedPassRules');
		}

		
		if (password.match(/\d/)) {
		   $('#numberCase').removeClass('notAllowedPassRules').addClass('allowedPassRules');
		} 
		else {
		     $('#numberCase').removeClass('allowedPassRules').addClass('notAllowedPassRules');
		}
		
		
		if (password.match(/[-!@#$%^&*()_+|~=`{}\[\]:";'<>?,.\/]/)) {
			$('#specialCase').removeClass('notAllowedPassRules').addClass('allowedPassRules');
		} 
		 else {
			  $('#specialCase').removeClass('allowedPassRules').addClass('notAllowedPassRules');
		}
		
		
		 if (password.length<8) {
			$('#lengthCase').removeClass('allowedPassRules').addClass('notAllowedPassRules');
		} 
		 else {
			  $('#lengthCase').removeClass('notAllowedPassRules').addClass('allowedPassRules');
		}
		 
		
	    
	}).focus(function() {
	    $('#passwordRules').show();
	    
	}).blur(function() {
	    $('#passwordRules').hide();
	    
	});
 });
 
 
 jQuery(document).ready(function(){
	 
	 $('#email').bind('change', function() {
		    verifyEmailExists($('#email').val());
		});
	 
 });
 
 function verifyEmailExists(email) {
	 
	 var data = 'email='+ encodeURIComponent(email);
	 console.log("IN VERIFY EMAIL EXISTS");
		    $.ajax({
		        		    	
		    	url: "/registrationAction/verifyEmailTaken",
		    	data: data,
		        cache: false,
		        async:false,
		        success: function(data) {
		        	if(data!="allowedToCreate")
		        		{
		        		$('#errorEmailExists').html('Email Already Exists - Please Choose Another One');
			            $('#registerSubmitButton').prop('disabled', true);
		        		}
		        	else
		        	$('#errorEmailExists').html('Congratulations! - That e-Mail is available');
		        }
		    });
		
 }
 

 /*
 
jQuery(document).ready(function () {
	 
		//$('searchSenderForm').submit(function(e) {   
		
	//	$("#searchSenderForm").submit(function(evt) {

	 $('#searchSenderEmail').bind('change', function() {
		 
			evt.preventDefault();
			evt.stopPropagation();
			console.log("SUCCESS CALL FOR SEARCH");
			
			var email = $("#email").val();
			var phone = $("#phone").val();
			var firstName = $("#firstName").val();
			var lastName = $("#lastName").val();
		
			var selectedInput="";
			var selectedInputName="";
		
			if($("#email").val()!='')
			{
			selectedInput = $("#email").val();
			selectedInputName = "senderEmail";
			}
			else if($("#phone").val()!='')
			{
			selectedInput = $("#phone").val();
			selectedInputName = "primaryPhone";
			}
			else if($("#firstName").val()!='')
			{
				selectedInput = $("#firstName").val();
				selectedInputName = "firstName";
			}
			else if($("#lastName").val()!='')
			{
			selectedInput = $("#lastName").val();
			selectedInputName = "lastName";
			}
	
			var searchJson = {"selectedInputName":selectedInputName, "selectedInput":selectedInput};
			searchSenderAjaxCall(encodeURIComponent(searchJson));
		
		   
		}); 
	   
});
	   
	   
function searchSenderAjaxCall(searchJson) {
			  
	$.ajax({
    	
		url: "/search",
		type: "POST",
		contentType: "application/json",		
		dataType : 'json',
		data: JSON.stringify(searchJson),
        cache: false,
        async:false,        
        success: function(result) {
        	$("#searchResultTemp1").html(result);
            $('#searchResultTemp2').append("<option value='-1'>Select User</option>");
            for ( var i = 0, len = result.length; i < len; ++i) {
                var senderDetails = result[i];
                $('#searchUsersSpace').append("<option value=\"" + user.name + "\">" + user.name + " " + user.address+ " " + user.phone + " " + user.zipCode +"</option>");
            } 
        }

    });

}
*/
 
jQuery(document).ready(function testFunction() {
	
		$("#searchSenderButton").on('click', function(e) {  
			console.log("SUCCESS CALL FOR SEARCH NOn SUBMIT TYPE");	
			evt.preventDefault();
			evt.stopPropagation();
			console.log("SUCCESS CALL FOR SEARCH NOn SUBMIT TYPE");	
		$.ajax({
    	
		url: "/search",
		//type: "POST",
		contentType: "application/json",		
		dataType : 'json',
		data: JSON.stringify(searchJson),
        cache: false,
        async:false,
        
        success: function(result) {
        	$("#searchResultTemp").html(result);
        	console.log(result);
        }

		});
	    });
  });

