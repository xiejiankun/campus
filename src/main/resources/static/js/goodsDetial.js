
//获取对象
var $=function(id){
	return document.getElementById(id);
}

//用小图变大图
var changeGoodsImage=function(thumb){
	$("showGoodsPicture").src=thumb.src;
	var lis=$("goodsList").getElementsByTagName("li");
	for (var i = 0; i < lis.length; i++) {
		(lis[i]).getElementsByTagName('img')[0].style.borderColor="";
	}
	thumb.style.borderColor="red";
}

//标签改变样式
var changeGoodsInfo=function(tab){
	var index=0;
	var lis=$("goodsTabs").getElementsByTagName('li');
	for (var i = 0; i < lis.length; i++) {
		lis[i].className="";

	if (tab==lis[i]) {
		tab.className="tab_active";
		index=i;
	 }
	}
//标签下的内容改变
var articles=$("abc").getElementsByTagName('article');
for (var i = 0; i < articles.length; i++) {
	articles[i].className="none";
	if (i==index) {
		articles[i].className="";
	}
}
}

/*放大镜*/
//获取元素的纵坐标
function getTop(elements){
	var top=elements.offsetTop;
	var parent=elements.offsetParent;
	while(parent!=null){
		top+=parent.offsetTop;
		parent=parent.offsetParent;
	};
	return top;
}

function getLeft(elements){
	var left=elements.offsetLeft;
	var parent=elements.offsetParent;
	while(parent!=null){
       left+=parent.offsetLeft;
       parent=parent.offsetParent;
	};
	return left;
}

//图片放大镜
function zoomPic(){

	var box=$("box");
	var showGoodsPicture=$("showGoodsPicture");
	var canvas=$("canvas");
	var shade=$("shade");
	if (showGoodsPicture==null) {
		return false;
	}

	box.onmouseout=function(){
		shade.style.display="none";
		canvas.style.display="none";
		document.body.style.cursor="default";
	};

	//绑定鼠标移动所触发的事件
	box.onmousemove=function(e){
        var w=document.getElementById("showGoodsPicture").naturalWidth;
        var h=document.getElementById("showGoodsPicture").naturalHeight;
        console.log(w);
        console.log(h);
	    document.body.style.cursor="move";
	    var box=document.getElementById("box");
		//大图片在页面中的位置
		var boxX=getLeft(box);
		var boxY=getTop(box);

		var shadeX=e.pageX-boxX-100;
		var shadeY=e.pageY-boxY-100;

		//边界处理
		if(shadeX<0) {shadeX=0;}
		if (shadeX>200) { shadeX=200;}
		if (shadeY<0) {shadeY=0;}
		if (shadeY>200) {shadeY=200;}

		//画布绘制
		var context=canvas.getContext("2d");
		shade.style.display="block";
		shade.style.left=shadeX+"px";
		shade.style.top=shadeY+"px";
		canvas.style.display="inline";
		context.clearRect(0,0,400,400);
        
		var img=new Image();
		img.src=showGoodsPicture.src;
		img.onload=function(){
           
context.drawImage(img,(shade.offsetLeft)*w/400,(shade.offsetTop)*h/400,w/2,h/2,0,0,400,400);
		}
		
		
	}
}

window.onload=function(){
	zoomPic();
}
