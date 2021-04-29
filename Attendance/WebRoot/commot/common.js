/* 主题内容页面 */
function notempty(murl,id,uid,mjs) {
	///LayuiExercise/BusinessLayer?action=seleUserAllHtml
	var item = {
			"murl" : murl,
			"id" : id,
			"uid" : uid,
			"mjs" : mjs
	}
	$("#bodydiv").load(murl+"&id="+id + " #AllPermissions>*",item,function(){
		var sc =  document.createElement("script");
		sc.src= "back/js/"+mjs;  //数据表格的js
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