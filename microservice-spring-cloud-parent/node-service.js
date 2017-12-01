var http = require('http');
var url = require('url');
var path = require('path');

//创建server
var server = http.createServer(function(req, res) {
	//获得请求路径
	var pathname = url.parse(req.url).pathname;
	res.writeHead(200, {'content-Type':'application/json;charset=utf-8'});
	
	if(pathname === '/') {
		res.end(JSON.stringify({"index":"欢迎来到首页"}));
	} else if(pathname === '/health.json') {
		res.end(JSON.stringify({"status":"UP"}));
	} else {
		res.end("404");
	}
});

//创建监听
server.listen(8060, function(){
	console.log('listening on localhost:8060');
});