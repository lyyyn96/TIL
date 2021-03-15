$(document).ready(function() {
	$("#memberInsertBtn").click(function() {
		var id = $("#id").val();
		var pw = $("#pw").val();
		var name = $("#name").val();

		alert(id + ":" + pw + ":" + name);

		$.post("main",
			{
				id: id,
				pw: pw,
				name: name
			},
			function(data, status) {
				alert("Data: " + data + "\nStatus: " + status);
			});
	});
	
});