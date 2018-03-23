package com.djcps.boot.commons.utils;

import javax.websocket.Session;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * webSocket的session管理
 *
 * @author Chengw
 * @create 2018/3/21 10:00.
 * @since 1.0.0
 */
public class WebSocketUtils {

    private static Map<String, Session> onlineMap = new ConcurrentHashMap<String, Session>();

    private static final String PREFIX = "cps_";

    /**
     * 添加session
     *
     * @param userId
     * @param session
     */
    public static void put(String userId, Session session) {
        onlineMap.put(userId, session);
    }

    /**
     * 获取session
     *
     * @param userId
     * @return
     */
    public static Session get(String userId) {
        return onlineMap.get(getKey(userId));
    }

    /**
     * 移除session
     *
     * @param userId
     */
    public static void remove(String userId) {
        onlineMap.remove(getKey(userId));
    }

    /**
     * 校验是否连接是否有效
     *
     * @param userId
     * @return
     */
    public static boolean hasConnection(String userId) {
        return onlineMap.containsKey(getKey(userId));
    }

    /**
     * 获取除自己之外的session
     *
     * @param userId
     * @return
     */
    public static List<Session> getOtherSession(String userId) {
        return onlineMap.entrySet().stream().filter(
                a -> !a.equals(getKey(userId))).map(m -> {
            return m.getValue();
        }).collect(Collectors.toList());
    }

    /**
     * 获取除自己之外的用户
     *
     * @param userId
     * @return
     */
    public static List<String> getOtherUserId(String userId) {
        return onlineMap.entrySet().stream().filter(
                a -> !a.equals(getKey(userId))).map(m -> {
            return m.getKey().substring(PREFIX.length());
        }).collect(Collectors.toList());
    }

    /**
     * 追加前缀
     *
     * @param userId
     * @return
     */
    private static String getKey(String userId) {
        return new StringBuilder().append(PREFIX).append(userId).toString();
    }
}
