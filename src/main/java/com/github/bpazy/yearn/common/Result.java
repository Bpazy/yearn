package com.github.bpazy.yearn.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ziyuan
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private static final String OK = "OK";
    private static final String FAIL = "FAIL";

    private String code;
    private String message;
    private Object data;

    public static Result ok() {
        return Result.builder()
                .code(OK)
                .build();
    }

    public static Result fail() {
        return Result.builder()
                .code(FAIL)
                .build();
    }
}
