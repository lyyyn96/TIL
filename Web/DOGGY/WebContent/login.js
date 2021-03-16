$(document).ready(function() {
	$("#loginBtn").click(function() {
		var id = $("#id").val();
		var pw = $("#pw").val();
		var name = $("#name").val();

		alert(id + ":" + pw +":"+name);

		$.post("main",{
					id: id,
					pw: pw,
					name: name
				},
				function(data, status) {
					$("#msgDiv").html(data);
				}
		);
	});
});