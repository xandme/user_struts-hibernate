/**
 * 网页跳转
 */
$(document).ready(function()
{
	$('#certain').on("click", function() {
		var pageNum = $('#pageNum').val().trim();
//		alert("OK");
		$.post("lendaction", {
			pageNow : pageNum
		}, function(result) {
			alert(resutl);
		});
	})
})