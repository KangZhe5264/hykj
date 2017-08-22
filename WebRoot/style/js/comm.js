/**
 * 作者:杨殊缘
 * 创建时间:2017-08-07 15:59:12
 * 修改时间:
 */
/**
 * 对rem变量进行初始化操作,方便自适应
 * ~请注意验证本方法是否兼容
 */
function initRem()
{
	var html = document.getElementsByTagName('html')[0];
	var body = document.getElementsByTagName('body')[0];

	var width = html.offsetWidth?html.offsetWidth/640 * 10:body.offsetWidth/640 * 10;//定制自适应信息

	//var width = $("html").innerWidth()/640 * 10;//定制自适应信息
	html.style.fontSize = width + "px";

	//兼容性设定
	if(html.style.fontSize != (width + "px"))
	{
		body.style.fontSize = width + "px";
//		body.style.width = html.offsetWidth +"px";
	}
	//$("html").css("font-size",width + "px");//定制rem大小
}
/**
 * 获取浏览器支持的本地数据库
 * @return 数据库链接 打开到本地数据库的链接
 */
function getContent()
{
	var indexedDB = window.indexedDB || window.webkitIndexedDB || window.mozIndexedDB || window.msIndexedDB; 
	if(indexedDB){ 
		return indexedDB.open();
	}
	else
	{
		alert("不支持indexedDB");
	}
}

//-----------------------------------------------------------
/**
 * 事件绑定兼容的方法
 * @param {Element} obj 需要绑定事件的元素
 * @param {String} type 需要绑定的事件-不需要on
 * @param {Function} fn 需要绑定的事件-不需要()
 */
function addEvent(obj,type,fn){
	if(obj.addEventListener){//W3C
		obj.addEventListener(type,fn,false);
	}
	else if(obj.attachEvent){//IE浏览器
		obj.attachEvent('on'+type,fn);
	}
}
/**
 * 跨浏览器兼容移除事件监听
 * @param {Element} obj 需要绑定事件的元素
 * @param {String} type 需要绑定的事件-不需要on
 * @param {Function} fn 需要绑定的事件-不需要()
 */
function removeEvent(obj,type,fn){
	if(obj.removeEventListener){//W3C
		obj.removeEventListener(type,fn,false);
	}
	else if(obj.detachEvent){//IE浏览器
		obj.detachEvent('on'+type,fn);
	}
}
/**
 * 跨浏览器兼容取得目标对象，取得触发事件的当前对象
 * @param {Object} evt 需要找寻触发事件的元素
 */
function getTarget(evt){
	if(evt.target){//W3C，相当于this
		return evt.target;
	}
	else if(window.event.srcElement){//IE浏览器，在Ie中this ===window
		return window.event.srcElement;
	}
}
/**
 * 对指定的地址进行跳转
 * @param {Object} url 需要跳转的地址 eg. /java/demo.java
 */
function to_url(url)
{
//	测试正式场合中使用哪个合适
//	window.location.replace(url);//不能回退
//	window.location.assign(url);//可以回退
	window.location.href = createURL(url);//不建议使用
}
function createURL(url)
{
	//将/*/*/**.java格式字符串以/切割出前两个 即空白和*
	var project = window.location.pathname.split("/",2)[1];
	//重新拼接url字符串
	url = window.location.protocol +"//"+ window.location.hostname +":"+ location.port + "/" + project + url;
	
	return url;
}
/**
 * 兼容的方式获取ajax对象
 */
function get_ajax()
{
	var request = false; 
	try { 
		request = new XMLHttpRequest(); 
	} catch (trymicrosoft) { 
		try { 
			request = new ActiveXObject("Msxml2.XMLHTTP"); 
		} catch (othermicrosoft) { 
			try { 
				request = new ActiveXObject("Microsoft.XMLHTTP"); 
			} catch (failed) { 
				request = false; 
			} 
		} 
	} 
	if (!request) 
		alert("Error initializing XMLHttpRequest!");
	else
		return request;
}
/**
 * 检测ajax请求成功
 * @param {Object} ajax
 */
function ajax_success(request)
{
	if (request.readyState == 4) 
	{
		if (request.status == 200) 
		{
			return true;
		} 
		else if (request.status == 404) 
		{
			return false;
		} 
		else if (request.status == 403) 
		{
			return false;
		} 
		else
			return false; 
	}
	return false;
}
/**
 * 时间日期格式转化 yyyy/MM/dd HH:mm:ss
 */
function get_time()
{
	var current = new Date();
	var date = "";
	date = date + current.getFullYear()+"/";
	date = date + (current.getMonth()>8?"":"0") + (current.getMonth()+1) + "/";
	date = date + (current.getDate()>9?"":"0") + current.getDate()+" ";
	date = date + (current.getHours()>9?"":"0") + current.getHours()+":";
	date = date + (current.getMinutes()>9?"":"0") + current.getMinutes()+":";
	date = date + (current.getSeconds()>9?"":"0") + current.getSeconds()+"";
	
	return date;
}
/**
 * 阻止事件继续冒泡
 * @param {Event} event
 */
function stop_event(event)
{
	if(event)
		event.preventDefault();
	else
		window.event.returnValue = false;
}

/**
 * 通过地址蓝进行数据交互时获取参数
 * @param  {String} att key值存在返回特定的值
 * @return {String}      value
 */
function get_urlAttr(att)
{
	var attr = window.location.href.split("?")[1];
	if(!attr)
		return null;

	//attr参数存在
	attr = attr.split("&");
	var object = new Array();
	for (var i = attr.length - 1; i >= 0; i--) {
		var temp = attr[i].split("=");
		object[temp[0]] = temp[1];
	}
	if(att)//函数需要返回某个特定的参数
	{
		return object[att];
	}

	return object;
}

//--------------------微信相关配置
/**
 * 初始化微信相关配置信息-暂时用不到
 */
function init_wx()
{
	wx.config({
    	"debug": true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
    	"appId": '', // 必填，公众号的唯一标识
    	"timestamp": "", // 必填，生成签名的时间戳
    	"nonceStr": '',//必填，生成签名的随机串
   		"signature": '',// 必填，签名，见附录1
    	"jsApiList": [] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
	});
	
	wx.ready(function(){
		// config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
		alert("接口验证成功");
	});
	
	wx.error(function(res){
    	// config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
		alert("接口调用失败");
	});
}




/*-------------------------------------------------------------------------*/
function init_house_index()
{
	initRem();
	var section = document.body.getElementsByTagName("section")[0];
	if(section)
	{
		var divs = section.getElementsByTagName("div");
		for(var index = 0; index < divs.length; index++)
			addEvent(divs[index],"click",open_house);
	}
	
	var quantity = document.getElementById("quantity");
	if(quantity)
		addEvent(quantity,"change",change_quantity);
		
	var pay = document.getElementsByTagName("button")[0];
	if(pay)
		addEvent(pay,"click",destine_house);
}
//-----------------------------------
/**
 * 微信前段打开房间型号信息进行订单操作
 * @param {Event} event
 */
function open_house(event)
{
	var house = getTarget(event).getAttribute("data");
	if(house)
	{
		var ajax = get_ajax();
		ajax.open("POST",createURL("/house/house.java"),true);
		ajax.onreadystatechange = function(){
			if(ajax_success(ajax))
			{
				//将返回值转化为json对象
				var data = eval('(' + ajax.responseText + ')');
				if(data.flag)
				{
					//使用data作为临时变量使用
					data = data.msg;
					
					document.getElementById("contact_phone").value = data.contact_phone;
					document.getElementsByTagName("a")[0].setAttribute("href",createURL("/house/info.java?house="+house));
					document.getElementById("quantity").setAttribute("data",house);
					document.getElementById("amount").value = data.price;
					document.getElementById("amount").setAttribute("data",data.price);
					var section = document.getElementsByTagName("section");
					section[0].setAttribute("class", "none");
					section[1].removeAttribute("class");
				}
				else
					alert(data.msg)
			}
		}
		var body =	"house=" + house +
					"&requestBody=" + get_time();
		//这行代码很关键，用来把字符串类型的参数序列化成Form Data 
		ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		ajax.send(body);
	}
}

/**
 * 订房系统的index
 * 会员用户在输入预定房间数时改变用户需要支付的费用数额
 * @param {Event} event
 */
function change_quantity(event)
{
	var quantity = getTarget(event);
	var amount = document.getElementById("amount");
	amount.value = quantity.value * amount.getAttribute("data");
}

/**
 * 订房系统index
 * 会员确认进行预定支付
 * @param {Object} event
 */
function destine_house(event)
{
	var contact_phone = document.getElementById("contact_phone").value;
	var house = document.getElementById("quantity").getAttribute("data");
	var quantity = document.getElementById("quantity").value;
	var arrive_time = document.getElementById("arrive_time").value;
	var active_time = document.getElementById("active_time").value;
	var amount = document.getElementById("amount").value;
	var price = document.getElementById("amount").getAttribute("data");
	
	if(!contact_phone)
		return;
	if(!house)
		return;
	if(!quantity)
		return;
	if(!arrive_time)
		return;
	if(!active_time)
		return;
	if(!amount)
		return;
	if(!price)
		return;
	
	var ajax = get_ajax();
	ajax.open("POST",createURL("/house/destine.java"),true);
	ajax.onreadystatechange = function(){
		if(ajax_success(ajax))
		{
			//将返回值转化为json对象
			var data = eval('(' + ajax.responseText + ')');
			alert(data);
			location.go(-1);
		}
	};
	var body =	"contact_phone=" + contact_phone +
				"&house=" + house +
				"&quantity=" + quantity +
				"&arrive_time=" + arrive_time +
				"&active_time=" + active_time +
				"&amount=" + amount +
				"&price=" + price +
				"&requestBody=" + get_time();
	//这行代码很关键，用来把字符串类型的参数序列化成Form Data 
	ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	ajax.send(body);
}
//-------------------------------------------------------------------------

function init_house_manager()
{
	initRem();
	var section = document.getElementsByTagName("section")[0];
	if(section)
	{
		var divs = section.getElementsByTagName("div");
		for (var index = 0; index < divs.length; index++) {
			var btns = divs[index].getElementsByTagName("button");
			if(btns.length > 0)
			{
				addEvent(btns[0],"click",change_house);
				addEvent(btns[1],"click",change_state);
			}
			else//特例,此处处理一个a标签
			{
				var a = divs[index].getElementsByTagName("a")[0];
				if(a)
					addEvent(a,"click",add_house);
			}
		}
	}
	
	section = document.getElementsByTagName("section")[1];
	if(section)
	{
		var divs = section.getElementsByTagName("div")[0].getElementsByTagName("div");
		addEvent(divs[0],"click",toggle_div);
		addEvent(divs[1],"click",toggle_div);
		var uls = section.getElementsByTagName("ul");
		if(uls[0])
		{
			var lis = uls[0].getElementsByTagName("li");
			for(var index = 0; index < lis.length; index++)
			{
				var button = lis[index].getElementsByTagName("button");
				button[0].setAttribute("data","1");
				addEvent(button[0],"click",auditing);
				button[1].setAttribute("data","0");
				addEvent(button[1],"click",auditing);
			}
			
		}
		if(uls[1])
		{
			var lis = uls[1].getElementsByTagName("li");
			for(var index = 0; index < lis.length; index++)
			{
				var button = lis[index].getElementsByTagName("button");
				button[0].setAttribute("data","1");
				addEvent(button[0],"click",back_order);
				button[1].setAttribute("data","0");
				addEvent(button[1],"click",back_order);
			}
		}
	}

	/*首次加载默认刷新一次*/
	refur_this();
	window.interval = setInterval("refur_this()",1000*60*5);
	
}
//----------------------------------------------------------------------
/**
 * 订房系统house_manager
 * 后台管理中要进行修改已有房间类型的价格的先行步骤
 * @param {Object} event
 */
function change_house(event)
{
	var input = getTarget(event).parentNode.getElementsByTagName("input")[0];
	if("disabled" == input.getAttribute("disabled"))
	{
		input.removeAttribute("disabled");
		getTarget(event).innerHTML = "保存";
	}
	else
	{
		var house = getTarget(event).getAttribute("data");
		var price = input.value;
		
		var ajax = get_ajax();
		ajax.open("post",createURL("/house/change_house.java"),true);
		ajax.onreadystatechange = function(){
			if(ajax_success(ajax))
			{
				//将返回值转化为json对象
				var data = eval('(' + ajax.responseText + ')');
				if(data.flag)
				{
					input.setAttribute("disabled","disabled");
					getTarget(event).innerHTML = "修改";
					alert(data.msg);
				}
				else
				{
					input.value = data.msg;
					alert("保存失败");
				}
			}
		};
		var body =	"house=" + house +
					"&price=" + price +
					"&requestBody=" + get_time();
		//这行代码很关键，用来把字符串类型的参数序列化成Form Data 
		ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		ajax.send(body);
	}
}

/**
 * house_manager
 * 修改指定房型的营业状态,客满或者可以接待
 * @param {Object} event
 */
function change_state(event)
{
	var house = getTarget(event).getAttribute("data");
	if(house)
	{
		var ajax = get_ajax();
		ajax.open("post",createURL("/house/change_state.java"),true);
		ajax.onreadystatechange = function(){
			if(ajax_success(ajax))
			{
				//将返回值转化为json对象
				var data = eval('(' + ajax.responseText + ')');
				alert(data);
				location.replace(location.href);
			}
		};
		var body =	"house=" + house +
					"&requestBody=" + get_time();
		//这行代码很关键，用来把字符串类型的参数序列化成Form Data 
		ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		ajax.send(body);
	}
}

/**
 * house_manager
 * 添加一个输入框让用户添加一间房型
 * @param {Object} event
 */
function add_house(event)
{
	var a = getTarget(event);
	var temp = document.createElement("div");
	var label = document.createElement("label");
	label.innerHTML = "房间类型名称:";
	temp.appendChild(label);
	var input = document.createElement("input");
	input.setAttribute("type","text");
	input.setAttribute("name","type");
	temp.appendChild(input);
	label = document.createElement("label");
	label.innerHTML = "房间类型价格:";
	temp.appendChild(label);
	input = document.createElement("input");
	input.setAttribute("type","number");
	input.setAttribute("name","price");
	temp.appendChild(input);
	var submit = document.createElement("button");
	submit.innerHTML = "添加";
	addEvent(submit,"click",add_house2);
	temp.appendChild(submit);
	
	a.parentNode.parentNode.insertBefore(temp,a.parentNode);
	
}

/**
 * house_manager
 * 将会员新增加的房间类型信息收集起来并提交
 * @param {Event} event
 */
function add_house2(event)
{
	var type = getTarget(event).parentNode.getElementsByTagName("input")[0].value;
	var price = getTarget(event).parentNode.getElementsByTagName("input")[1].value;
	
	if(!type)
		return;
	if(!price)
		return;
	
	var ajax = get_ajax();
	ajax.open("post",createURL("/house/add_house.java"),true);
	ajax.onreadystatechange = function(){
		if(ajax_success(ajax))
		{
			//将返回值转化为json对象
			var data = eval('(' + ajax.responseText + ')');
			if(data.flag)
				//刷新该页
				location.replace(location.href);//用当前页面的地址替换到当前页面
			else
			{
				alert("添加失败:"+data.msg);
			}
		}
	};
	var body =	"type=" + type +
				"&price=" + price +
				"&requestBody=" + get_time();
	//这行代码很关键，用来把字符串类型的参数序列化成Form Data 
	ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	ajax.send(body);
}

/**
 * house_manager
 * 将操作员对订单的审核操作进行提交
 * @param {Object} event
 */
function auditing(event)
{
	var option = getTarget(event).getAttribute("data");
	var serial = getTarget(event).parentNode.getAttribute("data");
	
	if(!option)
		return;
	if(!serial)
		return;
		
	var ajax = get_ajax();
	ajax.open("post",createURL("/house/auditing.java"),true);
	ajax.onreadystatechange = function(){
		if(ajax_success(ajax))
		{
			//将返回值转化为json对象
			var data = eval('(' + ajax.responseText + ')');
			alert(data);
			refur_this();
		}
	};
	var body =	"option=" + option +
				"&serial=" + serial +
				"&requestBody=" + get_time();
	//这行代码很关键，用来把字符串类型的参数序列化成Form Data 
	ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	ajax.send(body);	
}

/**
 * house_manager
 * 对订单执行退单操作,关于退款的的先行操作-申请验证码验证
 * @param {Object} event
 */
function back_order(event)
{
	//将必要的参数信息转为全局变量
	window.option = getTarget(event).getAttribute("data");
	window.serial = getTarget(event).parentNode.getAttribute("data");
	
	//弹出框进行验证码确认			
	var temp = document.createElement("div");
	var input = document.createElement("input");
	input.setAttribute("type","text");
	input.setAttribute("placeholder","请为张先生的退单输入验证码");
	input.style.width = "12rem";
	
	var button = document.createElement("button");
	button.innerHTML = "确定";
	button.style.fontSize = "1.4rem";
	button.style.padding = "0.4rem 2rem";
	button.style.marginLeft = "0.7rem";
	addEvent(button,"click",back_order2);
	
	temp.appendChild(input);
	window.check_num = input;
	temp.appendChild(button);
	
	button = document.createElement("button");
	button.innerHTML = "取消";
	button.style.fontSize = "1.4rem";
	button.style.padding = "0.4rem 2rem";
	button.style.marginLeft = "0.7rem";
	addEvent(button,"click",cencal_option);
	
	temp.appendChild(button);
	
	temp.style.backgroundColor = "lightpink";
	temp.style.fontSize = "1.4rem";
	temp.style.position = "absolute";
	temp.style.padding = "3rem 2rem";
	var body = document.getElementsByTagName('body')[0];
	temp.style.top = window.scrollY + (window.innerHeight - temp.offsetHeight)/2 + "px";
	
	//temp.style.left = (html.offsetWidth?(html.offsetWidth - temp.offsetWidth)/2:(body.offsetWidth - temp.offsetWidth)/2) + "px";
	body.appendChild(temp);
	temp.style.left = window.scrollX + (window.innerWidth - temp.offsetWidth)/2 + "px";
	//请求对指定账户发送手机短信验证码
	var ajax = get_ajax();
	ajax.open("post",createURL("/house/check_msg.java"),true);
	ajax.onreadystatechange = function(){
		if(ajax_success(ajax))
		{
			//将返回值转化为json对象
			var data = eval('(' + ajax.responseText + ')');
			alert(data);
		}
	};
	var body =	"serial=" + window.serial +
				"&requestBody=" + get_time();
	//这行代码很关键，用来把字符串类型的参数序列化成Form Data 
	ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	ajax.send(body);
}

/**
 * house_manager
 * 对订单执行退单操作,关于退款的
 * @param {Object} event
 */
function back_order2(event)
{
	//关闭对话框
	cencal_option(event);
	var option = window.option;
	var serial = window.serial;
	var check_num = window.check_num.value;
	
	if(!option)
		return;
	if(!serial)
		return;
	if(!check_num)
		return;
		
	var ajax = get_ajax();
	ajax.open("post",createURL("/house/back_order.java"),true);
	ajax.onreadystatechange = function(){
		if(ajax_success(ajax))
		{
			//将返回值转化为json对象
			var data = eval('(' + ajax.responseText + ')');
			alert(data);
			refur_this();
		}
	};
	var body =	"option=" + option +
				"&serial=" + serial +
				"&check_num=" + check_num +
				"&requestBody=" + get_time();
	//这行代码很关键，用来把字符串类型的参数序列化成Form Data 
	ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	ajax.send(body);	
}
/**
 * house_manager
 * 更新页面右边的订单状态
 */
function refur_this()
{
	var ajax = get_ajax();
	ajax.open("post",createURL("/house/refur.java"),true);
	ajax.onreadystatechange = function(){
		if(ajax_success(ajax))
		{
			//将返回值转化为json对象
			var data = eval('(' + ajax.responseText + ')');
			if(data.flag)
			{
				var wait = document.getElementsByTagName("section")[1].getElementsByTagName("ul")[0];
				var over = document.getElementsByTagName("section")[1].getElementsByTagName("ul")[1];
				wait.innerHTML = "";
				over.innerHTML = "";
				data = data.msg;
				for(var index = 0; index < data.length; index++)
				{
					if(data[index].auditing == "-1")
					{
						var li = document.createElement("li");
						li.setAttribute("data",data[index].serail);
						wait.appendChild(li);
						
						var label = document.createElement("label");
						label.innerHTML = data[index].userName + "预定" + data[index].type + data[index].amount + "间,预计在" + data[index].arriveTime +"到达,预定时长为" + data[index].activeTime + "。联系电话为" + data[index].contactPhone;                    
						wait.appendChild(label);
						
						var br = document.createElement("br");
						wait.appendChild(br);
						
						var button = document.createElement("button");
						button.innerHTML = "审核";
						button.setAttribute("data","1");
						addEvent(button,"click",auditing);
						wait.appendChild(button);
						
						button = document.createElement("button");
						button.innerHTML = "驳回";
						button.setAttribute("data","0");
						addEvent(button,"click",auditing);
						wait.appendChild(button);
					}
					else
					{
						var li = document.createElement("li");
						li.setAttribute("data",data[index].serail);
						wait.appendChild(li);
						
						var label = document.createElement("label");
						label.innerHTML = data[index].userName + "预定" + data[index].type + data[index].amount + "间,预计在" + data[index].arriveTime +"到达,预定时长为" + data[index].activeTime + "。联系电话为" + data[index].contactPhone;                    
						wait.appendChild(label);
						
						var br = document.createElement("br");
						wait.appendChild(br);
						
						var button = document.createElement("button");
						button.innerHTML = "退单";
						button.setAttribute("data","1");
						addEvent(button,"click",back_order);
						wait.appendChild(button);
						
						button = document.createElement("button");
						button.innerHTML = "逾时订出";
						button.setAttribute("data","0");
						addEvent(button,"click",back_order);
						wait.appendChild(button);
					}
				}
			}
		}
	};
	ajax.send();
}

/**
 * house_manager
 * 关闭弹出框
 * @param {Object} event
 */
function cencal_option(event)
{
	var target = getTarget(event).parentNode;
	target.parentNode.removeChild(target);
}

/**
 * house_manager
 * 页面右边的切换效果
 * @param {Event} event
 */
function toggle_div(event)
{
	var div = getTarget(event).parentNode;
	var divs = div.getElementsByTagName("div");
	if(divs[0].getAttribute("class"))
	{
		divs[0].removeAttribute("class");
		divs[1].setAttribute("class","current");
	}
	else
	{
		divs[1].removeAttribute("class");
		divs[0].setAttribute("class","current");
	}
	
	var section = div.parentNode;
	var uls = section.getElementsByTagName("ul");
	if(uls[0].getAttribute("class"))
	{
		uls[0].removeAttribute("class");
		uls[1].setAttribute("class","none");
	}
	else
	{
		uls[1].removeAttribute("class");
		uls[0].setAttribute("class","none");
	}
}
