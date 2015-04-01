$.ajax({
	url : ctx + '/rest/list/users',
	dataType : 'json',
	success : function(users) {
		var html = '';
		$.each(users, function() {
			html += '<tr><td>' + this.nickname + '</tr></td>';
		});
		$('#userlist').html(html);
	}
})