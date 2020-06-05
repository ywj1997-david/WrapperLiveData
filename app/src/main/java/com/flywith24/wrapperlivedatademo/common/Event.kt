package com.flywith24.wrapperlivedatademo.common

/**
 * 使用 包装类 解决 LiveData 粘性事件的问题
 * 详见 https://juejin.im/post/5b2b1b2cf265da5952314b63
 */
open class Event<out T>(private val content: T) {

    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): T = content
}