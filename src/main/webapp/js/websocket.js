/** 申请一个WebSocket对象，参数是需要连接的服务器端的地址，
 * 同http协议使用http://开头一样，
 * WebSocket协议的URL使用ws://开头，
 * 另外安全的WebSocket协议使用wss://开头
 */
var ws = new WebSocket("ws://127.0.0.1:8888");
ws.onopen = function ()//当websocket创建成功时，即会触发onopen事件
{
    var content = document.getElementById("content").value;
    if (content == null || content == "") {
        ws.send("Huangpeng");//用于叫消息发送到服务端 注：此处为用户名
    } else {
        ws.send(content);
    }
};
ws.onmessage = function (evt)//当客户端收到服务端发来的消息时，会触发onmessage事件，参数evt.data中包含server传输过来的数据
{
    document.getElementById("span").innerHTML = "当前在线人数为：" + evt.data;
};
ws.onclose = function (evt)//当客户端收到服务端发送的关闭连接的请求时，触发onclose事件
{
    document.getElementById("span").innerHTML ="WebSocketClosed!";
};
ws.onerror = function (evt)//如果出现连接，处理，接收，发送数据失败的时候就会触发onerror事件
{
    document.getElementById("span").innerHTML ="WebSocketError!";
};
