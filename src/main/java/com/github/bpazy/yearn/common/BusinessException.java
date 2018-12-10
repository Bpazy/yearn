package com.github.bpazy.yearn.common;

import lombok.NoArgsConstructor;

/**
 * @author ziyuan
 */
@NoArgsConstructor
public class BusinessException extends RuntimeException {
    public BusinessException(String msg) {
        super(msg);
    }
}
