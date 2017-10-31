package com.javahe.kotlindemo.view

import com.javahe.kotlindemo.bean.LoginResponse
import com.javahe.kotlindemo.bean.RegisterResponse

/**
 * Created by zfc on 2017/10/31.
 */
interface ILoginView {

    //注意接口中的方法参数不能加val修饰
    fun loginSuccess(result : LoginResponse)

    fun loginFailed(result: String)

    //注意接口中的方法参数不能加val修饰
    fun registerSuccess(result : RegisterResponse)

    fun registerFailed(result: String)
}