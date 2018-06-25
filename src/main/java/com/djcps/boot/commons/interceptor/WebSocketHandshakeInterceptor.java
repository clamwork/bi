package com.djcps.boot.commons.interceptor;

import com.djcps.log.DjcpsLogger;
import com.djcps.log.DjcpsLoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * @author
 */
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {

    private DjcpsLogger logger = DjcpsLoggerFactory.getLogger(WebSocketHandshakeInterceptor.class);

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        logger.debug("beforeHandshake {} {} {}  {}",request,response,wsHandler,attributes);
        if (request instanceof ServletServerHttpRequest) {
        }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        logger.debug("beforeHandshake {} {} {}  {}",request,response,wsHandler,exception);
    }
}