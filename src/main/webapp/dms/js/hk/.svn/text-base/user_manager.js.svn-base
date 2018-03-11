function getUserMsg(e) {
	$("#updateModal #status").val(e.status);
	$("#updateModal #email").val(e.email);
	$("#updateModal #mobile").val(e.mobile);
	$("#updateModal #englishName").val(e.englishName);
	$("#updateModal #name").val(e.name);
	$("#updateModal #userId").val(e.userId);
	$("#updateModal #departmentId").val(e.departmentId);
}

function deleteUser(e){
	var json = {
			"userId" : e
		};
	$.ajax({
		url : "user/delete",
		type : "post",
		dataType:'json',
	    contentType: "application/json",
		async : true,
		data : JSON.stringify(json)
    });
	location.reload();
}
	
$(function () {
	var rootPath = getHostPath() + "/" + "aia6/hk/";
	
	
	
	$.ajax({
        type:"GET",
        url:rootPath+"user/list",
        dataType:'json',
        async: true,
        success:function(data){
            $.each(data['data'],function(i,item){
            	var list = "<tr id='user_list'>"+"<td>"+item.id+"</td>"+"<td>"+item.userId+"</td>"+"<td>"+item.name+"</td>"+"<td>"+item.englishName+"</td>"
            		+"<td>"+item.email+"</td>"+"<td>"+item.mobile+"</td>"+"<td>"+item.status+"</td>"+"<td><a data-toggle='modal' data-target='#updateModal' id='"+item.id+"' href='#' onclick='getUserMsg("
            		+JSON.stringify(item)
            		+")'>Update</a>&nbsp;&nbsp;&nbsp;<a href='#' class='deleteUser' onclick=deleteUser("+item.userId+")>Delete</a></td>"
            		+"</tr>";
            	$('.user_list').append(list);
            });
        }
    });
	
//	$(".user_list .update").click(function(){
//		var id = this.parent().parent().children("td").get(0).innerHTML;
//		console.log(id);
//	});

	$('.saveUser').click(function(){
		//表单转json函数
        $.fn.serializeObject = function(){
                var o = {};
                var a = this.serializeArray();
                $.each(a, function() {
                    if (o[this.name] !== undefined) {
                        if (!o[this.name].push) {
                            o[this.name] = [o[this.name]];
                        }
                        o[this.name].push(this.value || '');
                    } else {
                        o[this.name] = this.value || '';
                    }
                });
                return o;
            };
		var data = JSON.stringify($('#save-user-form').serializeObject());
		$('#addModal').attr("aria-hidden","true");
		$.ajax({
	        type:"POST",
	        url:"user/save",
	        dataType:'json',
	        contentType: "application/json",
	        cache : false,
	        async: false,
	        data: JSON.stringify($('#save-user-form').serializeObject()),
	        success:function(data){
	        	alert("insert user operator "+data['msg']);
	        	location.reload();
	        }
	    });
	});
	
	$('.updateUser').click(function(){
		
		var status = $('#update-user-form #status').val();
		var email = $('#update-user-form #email').val();
		var mobile = $('#update-user-form #mobile').val();
		var englishName = $('#update-user-form #englishName').val();
		var name = $('#update-user-form #name').val();
		var userId = $('#update-user-form #userId').val();
		var departmentId = $('#update-user-form #departmentId').val();
		
		var json = {
				"status" : status,
				"email" : email,
				"mobile" : mobile,
				"englishName" : englishName,
				"name" : name,
				"userId" : userId
		};
		//表单转json函数
        $.fn.serializeObject = function(){
                var o = {};
                var a = this.serializeArray();
                $.each(a, function() {
                    if (o[this.name] !== undefined) {
                        if (!o[this.name].push) {
                            o[this.name] = [o[this.name]];
                        }
                        o[this.name].push(this.value || '');
                    } else {
                        o[this.name] = this.value || '';
                    }
                });
                return o;
            };
		$('#updateModal').attr("aria-hidden","true");
		$.ajax({
	        type:"POST",
	        url:"user/update",
	        dataType:'json',
	        contentType: "application/json",
	        cache : false,
	        async: false,
	        data: JSON.stringify(json),
	        success:function(data){
	        	alert("update user operator "+data['msg']);
	        	location.reload();
	        }
	    });
	});

});