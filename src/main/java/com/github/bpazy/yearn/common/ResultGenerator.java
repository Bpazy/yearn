package com.github.bpazy.yearn.common;

import lombok.experimental.UtilityClass;

/**
 * @author ziyuan
 */
@UtilityClass
public class ResultGenerator {
    private static final String OK = "OK";
    private static final String FAIL = "FAIL";

    public static Result ok() {
        return ok(null);
    }

    public static Result ok(String message) {
        return ok(message, null);
    }

    public static Result ok(String message, Object data) {
        return Result.builder()
                .code(OK)
                .message(message)
                .data(data)
                .build();
    }

    public static Result fail() {
        return fail(null);
    }

    public static Result fail(String message) {
        return fail(message, null);
    }

    public static Result fail(String message, Object data) {
        return Result.builder()
                .code(FAIL)
                .message(message)
                .data(data)
                .build();
    }
}
