layui.use(['form','table',], function(){
	var form = layui.form
    layer = parent.layer === undefined ? layui.layer : top.layer,
    laypage = layui.laypage,
    upload = layui.upload,
    layedit = layui.layedit,
    laydate = layui.laydate,
    $ = layui.jquery;
  var table = layui.table;
  var insTb = table.render({
            elem: '#test',
            url: 'http://localhost:8080/Attendance/JurisdictionServlet?action=selectAllJurisdiction',
            toolbar: '#button',
            page : true,
            height: '500',
            limit : 10,
            limits : [10,15,20,25],
            cols: [[
            	{type: 'radio'},
            	{field: 'id', title: '权限编号', width: 110, align: 'center'},
                {field: 'qname', title: '权限名称', width: 110, align: 'center'},
              /*  {field: 'button', title: '权限路径', align: 'center'},*/
                {field: 'url', title: '请求路径', align: 'center'},
                {field: 'js', title: 'js路径',  align: 'center'},
                {field: 'type', width: 110, align: 'center', title: '类型', templet: function (d) {
                    if (d.type == 3) {
                        return '<span class="layui-badge layui-bg-orange">按钮</span>';
                    }
                    if (d.type == 2) {
                        return '<span class="layui-badge layui-bg-blue">目录</span>';
                    } else {
                        return '<span class="layui-badge layui-bg-green">菜单</span>';
                    }
            }}
            ]]
        });
		//监听工具栏
		table.on('toolbar(test)', function(obj){
			var checkStatus = table.checkStatus(obj.config.id);
			var data = checkStatus.data;
			var userid = "";
			for(i=0;i<data.length;i++){
				userid = data[i].id;
			}
		    switch(obj.event){
		      case 'deleteAllot':
		    	  alert(userid)
		    	  delMenu(userid);
		      break;
		      case 'insertAllot':	//新增权限
		    	  layer.open({
		        		title : "添加权限",
		        		type : 2,
		        		content : "Background/MenuInsert.jsp",
		        		area:['450px','500px'],
		    	  })
		      break;
		      
		      case 'updateAllot':	//修改权限
		    	  updateAllot(userid);
		      break;
			        
		      case 'login':	//转发到登录页面   退出登录
					location.href("http://localhost:8080/Attendance/Forepart/Login.jsp");
		      break;
		    };
		 });
		
	   //---------删除权限-------
		function delMenu(userid){
	    	
			if(userid == 0){
				layer.msg("请选择一行进行删除");
			}else{
				$.ajax({
	    			url:"http://localhost:8080/Attendance/JurisdictionServlet?action=deleteAllot",
	    			data:{"id":userid},
	    			type:"post",
	    			dataType:"json",
	    			success:function(data){
	    				var info = eval("("+data+")");
	    				if(data == 1){
	    					layer.msg("删除成功");
	    					insTb.reload();
	    				}else{
	    					layer.msg("删除失败");
	    				}
	    			}
	    		})
			}
			
	    		
	    }
		
		form.on('select(type2)', function(data){
	    	var type = data.value;
	        var dom = $("#goodsid");
	        var mname = $("#mname").val();  //权限
	        dom.html("");
	        if(type == 3){
	        	$("#mbtn").val('');
	        	$("#iconclass").css("display","none");
	        	$("#btnclss").css("display","block");
	        	$("#btn").css("display","block");
	        	$.get("http://localhost:8080/Attendance/JurisdictionServlet?action=Juris",function (res) {
	        		var result = eval('(' + res + ')');
	        		var btntype = $('#btnType');
	        		var html = '<span value="0"></span>';
	                $.each(result,function (index, item) {
	                	html += '<span class="btnType4" onclick="tongyiType(this)">'+item.button+'</span> ';
	                });
	                btntype.html(html);
	        	})
	        }else{
	        	$("#iconclass").css("display","block");
	        	$("#btnclss").css("display","none");
	        	$("#btn").css("display","none");
	        }
	        var type2 = $("#type2").val()
	        $.get("http://localhost:8080/Attendance/JurisdictionServlet?action=seleType&type="+type2,function (res) {
	            var dom = $("#father");
	           
	            if(type2 == 2){
	            	/*var date = eval('(' + res + ')');
	            	var html = '<option value="0">请选择</option>';
	                $.each(date,function (index, item) {
	                    html += '<option value="'+item.id+'">'+item.qname+'</option>';
	                });*/
	            }else{
	                var html = '<option value="0">目录没有上一级</option>';
	            }
	            dom.html(html);
	            //重新渲染下拉列表
	            form.render("select");
	        });
	    });

		
       /*---------修改权限------*/
        function updateAllot(userid){
        	if(userid == 0){
				layer.msg("请选择一行进行修改");
			}else{
        		layer.open({
              		 type:2,
              		 title:"修改权限",
              		 area:['600px','500px'],
              		 content:"http://localhost:8080/Attendance/Background/MenuUpdate.jsp",
              		 success:function(layero, index){
              			 $.post("http://localhost:8080/Attendance/JurisdictionServlet?action=JurId",{"id":userid},function(data){
              				var info = eval('(' + data + ')');
              				var body = layui.layer.getChildFrame('body', index);
              				body.find("#id").val(info.id);
              				body.find("#mname").val(info.qname);  //权限名
              				var select = 'dd[lay-value='+(info.type)+']';
              				alert(select+"/******")
              				body.find("#type2").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
              				body.find("#js").val(info.js);
              				body.find("#mbtn").val(info.button);		//按钮代码
              				//当前上级
              				var menuid3 = info.parentid;
              				if(select==1){
              					alert(info.type+"/--------****")
              					body.find("#fatherType2").html("没有上级菜单");
              				}else{
              				$.post("http://localhost:8080/Attendance/JurisdictionServlet?action=AllotName",{"pid":menuid3},function(res){
              			    var result = eval('(' + res + ')');
  		                    body.find("#fatherType2").val(result.qname);
  		                    
              				})
              				}
              			 })
                	}
          	    })
        	}
        };
});

function tongyiType(obj){
	$("#mbtn").val('');
	var info =  $(obj).html();
	$("#mbtn").val(info);
}