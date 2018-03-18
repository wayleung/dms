function getDepartmentMsg(e) {
	$("#updateModal #name").val(e.name);
	$("#updateModal #departmentId").val(e.departmentId);
	$("#updateModal #status").val(e.status);
}

function deleteDepartment(e){
	var json = {
			"departmentId" : e
		};
	$.ajax({
		url : "departments/delete",
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
        url:rootPath+"departments/list",
        dataType:'json',
        async: true,
        success:function(data){
            $.each(data['data'],function(i,item){
            	var list = "<tr id='user_list'>"+"<td>"+item.departmentId+"</td>"+"<td>"+item.name+"</td>"+"<td>"+item.status+"</td>"
        		+"<td><a href='#' data-toggle='modal' data-target='#updateModal' onclick='getDepartmentMsg("
        		+JSON.stringify(item)
        		+")'>Update</a>&nbsp;&nbsp;&nbsp;<a href='#' class='deleteDepartment' onclick=deleteDepartment("+item.departmentId+")>Delete</a></td>"
        		+"</tr>";
            	$('.department_list').append(list);
            });
        }
    });
	
	$(".department_list .update").click(function(){
		console.log("id");
		var id = this.parent().parent().children("td").get(0).innerHTML;
		console.log(id);
	});

	$('.saveDeparment').click(function(){
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
		$.ajax({
	        type:"POST",
	        url:"departments/save",
	        dataType:'json',
	        contentType: "application/json",
	        cache : false,
	        async: false,
	        data: JSON.stringify($('#save-department-form').serializeObject()),
	        success:function(data){
	        	location.reload();
	        }
	    });
	});
	
$('.updateDepartment').click(function(){
		
		var name = $('#update-department-form #name').val();
		var departmentId = $('#update-department-form #departmentId').val();
		var status = $('#update-department-form #status').val();
		
		var json = {
				"name" : name,
				"departmentId" : departmentId,
				"status" : status
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
	        url:"department/update",
	        dataType:'json',
	        contentType: "application/json",
	        cache : false,
	        async: false,
	        data: JSON.stringify(json),
	        success:function(data){
	        	alert("update department operator "+data['msg']);
	        	location.reload();
	        }
	    });
	});
	
});