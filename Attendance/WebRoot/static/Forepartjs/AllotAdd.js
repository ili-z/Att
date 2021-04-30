layui.use(['form','layer','layedit','laydate','upload'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        laypage = layui.laypage,
        upload = layui.upload,
        layedit = layui.layedit,
        laydate = layui.laydate,
        $ = layui.jquery;
  
    

    $("#menuAjax").click(function(){
    	
    	var mname = $("#mname").val();  //权限名
	    var parentid = $("#father").val();  //父级
	    var type2 = $("#type2").val();  //请求类型
	    var mbtn = $("#mbtn").val();//方法体
	    var js = $("#js").val();  //按钮代码
	    var isdelete = 0;
	    if(type2 == 1 || type2==2){
        	alert("31212211111")
        	mbtn = null;
        }
	    var data2 = {
        		"mname":mname,
        		"parentid":parentid,
        		"type2":type2,
        		"js":js,
        		"mbtn":mbtn,
        		"isdelete": isdelete
    	};
	    //权限名
        if(mname == "" || mname == null){
        	layer.msg("权限名不能为空");
        	return false;
        }
        
        //类型
        if(type2 == 0 || type2.size == 0){
        	layer.msg("请选择类型");
        	return false;
        }
        
        if(type2 != 1){
        	if(parentid == 0){
        		layer.msg("菜单或按钮不能没有上级");
            	return false;
        	}
        }
        if(type2 == 3){
        	if(mbtn == null || mbtn.length < 30 || mbtn==""){
            	layer.msg("按钮代码格式错误");
            	return false;
            }
        }
        if(type2 == 3){
        	mbtn = mname;
        } 
        
        
        //ajax提交
        $.ajax({
        	url:"http://localhost:8080/Attendance/JurisdictionServlet?action=insertAllot",
        	type:"post",
        	data:data2,
        	success:function(data){
        		//var info = eval('(' + data + ')')
        		alert(data)
        		if(data > 0){
    	 			top.layer.msg("权限新增成功");
    	 			layer.closeAll("iframe");
    	            //刷新父页面
    	 			parent.layui.table.reload("test");
    	 		}else{
    	 			top.layer.msg("权限新增失败");
    	 		}
        	}
        })
        return false;
    })
    
    /*-----------类型选择下拉框的点击事件----------*/
    form.on('select(type2)', function(data){
    	var type = data.value;
    	alert(type);
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
         alert("2____"+type2)
        $.get("http://localhost:8080/Attendance/JurisdictionServlet?action=seleType&type="+type2,function (res) {

            var dom = $("#father");
           
            if(type2 != 1){
            	var date = eval('(' + res + ')');
            	var html = '<option value="0">请选择</option>';
                $.each(date,function (index, item) {
                    html += '<option value="'+item.id+'">'+item.qname+'</option>';
                });
            }else{
                var html = '<option value="0">目录没有上一级</option>';
            }
            dom.html(html);
            //重新渲染下拉列表
            form.render("select");
        });
    });
    /*-----------类型选择下拉框的点击事件-- end --------*/

    
})
	/*---- 点击获取按钮代码事件 ------*/
	function tongyiType(obj){
		$("#mbtn").val('');
    	var info =  $(obj).html();
    	$("#mbtn").val(info);
    }
	/*---- 点击获取按钮代码事件 -- end ----*/
    