/* 主题内容页面 */
function sidebar(id,murl,mjs,parentid) {

	alert(id+"/-----------------")
	
	var item = {
			"parentid":parentid,
			"murl" : murl,
			"id" : id,
			"mjs" : mjs
	}
	$("#bodydiv").load(murl+"&id="+id + " #AllPermissions>*",item,function(){
		alert(murl+"----"+id+"----"+mjs);
		var sc =  document.createElement("script");
		sc.src= mjs;  //数据表格的js
		$("body").append(sc);
	})
}









function ono(url,id,uid,mhtml,mjs) {
	alert(mjs);
	var item = {
			"id" : id,
			"uid" : uid,
			"mhtml" : mhtml,
			"mjs" : mjs
	}

	$("#di").load("/BusinessLayer #di>*",item,function(){
		alert("load");
		var sc =  document.createElement("script");
		sc.src= "/back/js/LsMenuAll.js";  //是你数据表格的js
		$("body").append(sc);
	})
}

function non(url,id,uid,mhtml) {
	alert(mjs);
	var item = {
			"id" : id,
			"uid" : uid,
			"mhtml" : mhtml
	}

	$("#di").load(url+" #di>*",item,function(){
		alert("load");
		var sc =  document.createElement("script");
		sc.src= "/back/js/LsMenuAll.js";  //是你数据表格的js
		$("body").append(sc);
	})
}