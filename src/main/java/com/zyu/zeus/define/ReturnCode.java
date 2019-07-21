package com.zyu.zeus.define;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *  错误码描述一共四位:XXYY
 *  XX:00 严重错误
 *  YY:01 一般错误
 *  YY 由00 开始递增
 */
@AllArgsConstructor
public enum ReturnCode {
    OK                                  (0,        "OK"),
    EX                                  (0100,     "EX"),
    NO_AUTHORITY                        (0101,     "NO_AUTHORITY"),
    NO_PLATFORM_IN_HEADER               (0002,     "NO_PLATFORM_IN_HEADER"),
    ADD_SHOP_FAILED                     (0003,     "ADD_SHOP_FAILED"),
    UPDATE_SHOP_FAILED                  (0004,     "UPDATE_SHOP_FAILED"),
    ADD_SORT_FAILED                     (0005,     "ADD_SORT_FAILED"),
    UPDATE_SORT_FAILED                  (0006,     "UPDATE_SORT_FAILED"),
    ADD_MENU_FAILED                     (0007,     "ADD_MENU_FAILED"),
    UPDATE_MENU_FAILED                  (0010,     "UPDATE_MENU_FAILED"),
    ADD_BILL_FAILED                     (0011,     "ADD_BILL_FAILED"),
    UPDATE_BILL_FAILED                  (0012,     "UPDATE_BILL_FAILED"),
    INCORRECT_PASSWORD                  (0020,     "INCORRECT_PASSWORD"),
    UPDATE_PASSWORD_FAILED              (0021,     "UPDATE_PASSWORD_FAILED"),
    UPDATE_PASSWORD_SUCCESS             (0022,     "UPDATE_PASSWORD_SUCCESS"),
    ADD_ADDRESS_FAILED                  (0023,     "ADD_ADDRESS_FAILED"),
    UPDATE_ADDRESS_FAILED               (0024,     "UPDATE_ADDRESS_FAILED"),
    ADD_USER_FAILED                     (0025,     "ADD_USER_FAILED"),
    UPDATE_USER_FAILED                  (0026,     "UPDATE_USER_FAILED"),
    USER_LOGIN_ERR                      (0027,     "USER_LOGIN_ERR"),
    USER_NOT_EXIST                      (0030,     "USER_NOT_EXIST"),
        ;
    @Getter
    private int errcode;
    @Getter
    private String errmsgKey;

}
