function Login(){
	var name = $("#name").val();
	var pwd = $("#pwd").val();
	var item = {
			"name":name,
			"pwd":pwd
	}
	alert(name);
	$.ajax({
		url:"http://localhost:8080/Attendance/UserServlet?action=Login",
		type:"post",
		data:item,
		success: function(result){
			var cs = eval('(' + result + ')');
			if(cs.id > 0){
				location.href = "http://localhost:8080/Attendance/JurisdictionServlet?action=seleUserMenu";
			}
		}
	})
}