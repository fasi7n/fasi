jQuery(document).ready(function () {
	 
		//$('searchSenderForm').submit(function(e) {   
		
	$("#searchSenderForm").submit(function(evt) {

	 //$('#searchSenderEmail').bind('change', function() {
		
			console.log("SUCCESS CALL FOR SEARCH");
			evt.preventDefault();
			evt.stopPropagation();
			console.log("SUCCESS CALL FOR SEARCH");
			
			var searchInput =  {};
			
			var email = $("#searchSenderEmail").val();
			var phone = $("#searchSenderPhone").val();
			var firstName = $("#searchSenderFirstName").val();
			var lastName = $("#searchSenderLastName").val();
		
			var selectedInputValue="";
			var selectedInputName="";
		
			if($("#searchSenderEmail").val()!='')
			{
			console.log("REACHED IN EMAIL")
			selectedInputValue = $("#searchSenderEmail").val();
			console.log(selectedInputValue);
			selectedInputName = "senderEmail";
			
			searchInput["senderEmail"] = $("#searchSenderEmail").val();
			console.log("HERE IS GOOD " + searchInput.senderEmail);
			
			
			}
			else if($("#phone").val()!='')
			{
				selectedInputValue = $("#phone").val();
			selectedInputName = "primaryPhone";
			}
			else if($("#firstName").val()!='')
			{
				selectedInputValue = $("#firstName").val();
				selectedInputName = "firstName";
			}
			else if($("#lastName").val()!='')
			{
			selectedInputValue = $("#lastName").val();
			selectedInputName = "lastName";
			}
	
			var searchJson = {"selectedInputName":selectedInputName, "selectedInputValue":selectedInputValue};
			searchSenderAjaxCall(searchJson);
			
			console.log(searchJson);
		
		   
		}); 
	   
});
	   
	   
function searchSenderAjaxCall(searchJson) {
			  
	$.ajax({
    	
		url: "/search",
		type: "POST",
		contentType: "application/json",		
		dataType : 'json',
		data: JSON.stringify(searchJson),
		//data: searchJson,
        cache: false,
        async:false,        
        success: function(result) {
        	$("#searchResultTemp1").html(result);
            $('#searchResultTemp2').append("<option value='-1'>Select User</option>");
            for ( var i = 0, len = result.length; i < len; ++i) {
                var senderDetails = result[i];
                $('#searchUsersSpace').html("<option value=\"" + senderDetails.FIRSTNAME + "\">" + senderDetails.LASTNAME + " " + senderDetails.PRIMARY_PHONE+ " " + senderDetails.SENDER_EMAIL + " " + "</option>");
            } 
        }

    });

}

