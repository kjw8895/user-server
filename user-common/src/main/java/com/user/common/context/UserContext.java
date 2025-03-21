package com.user.common.context;

import com.user.common.application.dto.UserInfo;

public class UserContext {
    private static final ThreadLocal<UserInfo> user = new ThreadLocal<>();

    public static void set(UserInfo info) {
        user.set(info);
    }

    public static UserInfo get() {
        return user.get();
    }

    public static void clear() {
        user.remove();
    }
}
