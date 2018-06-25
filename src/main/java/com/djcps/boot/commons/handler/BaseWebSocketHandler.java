package com.djcps.boot.commons.handler;

import com.djcps.log.DjcpsLogger;
import com.djcps.log.DjcpsLoggerFactory;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * WebSocket 定义头部信息
 * @author Chengw
 * @create 2018/3/22 17:02.
 * @since 1.0.0
 */
public class BaseWebSocketHandler extends TextWebSocketHandler{

    private DjcpsLogger logger = DjcpsLoggerFactory.getLogger(BaseWebSocketHandler.class);

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {
        logger.debug("handleBinaryMessage : {}   {}",session,message);
        super.handleBinaryMessage(session, message);
    }
}
