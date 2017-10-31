package com.javahe.kotlindemo.bean

/**
 * Created by zfc on 2017/10/31.
 *
 * result 结果集
 * msg 结果信息
 * retCode 响应码
 */
data class LoginResponse(val result: LoginResultResponse, val msg: String, val retCode: String)
