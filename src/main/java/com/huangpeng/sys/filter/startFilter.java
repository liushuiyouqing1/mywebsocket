package com.huangpeng.sys.filter;

import com.huangpeng.sys.modules.websocket.CallDemo;
import com.huangpeng.sys.modules.websocket.MyWebSocket;
import org.java_websocket.WebSocketImpl;

import javax.servlet.*;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Timer;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2017-12-15 上午11:11
 * 类名: startFilter
 * </pre>
 **/
public class startFilter implements Filter {
    /**
     * 初始化
     */
    public void init(FilterConfig fc) throws ServletException {
        this.startWebsocketOnline();
        Timer timer = new Timer();//设置30s后再启动死循环向前台推消息
        timer.schedule(new CallDemo(),30*1000);
    }

    /**
     * 启动socket服务
     */
    public void startWebsocketOnline() {
        System.out.println("开始启动websocket");
        WebSocketImpl.DEBUG = false;
        int port = 8888; // 端口随便设置，只要不跟现有端口重复就可以
        MyWebSocket s = null;
        try {
            s = new MyWebSocket(port);
            s.start();
        } catch (UnknownHostException e) {
            System.out.println("startWebsocketOnline启动websocket失败！");
            e.printStackTrace();
        }
        System.out.println("startWebsocketOnline启动websocket成功！");
    }

    public void destroy() {
        // TODO Auto-generated method stub
    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        // TODO Auto-generated method stub
    }
}
