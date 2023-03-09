package name.phantom.animenotes.base.http.entity

/**
 * @description
 * @author Phantom
 * @since 2022/5/16
 */
open class BaseData<T : Any?>(
    private val code: String?,
    private val msg: String?,
    val data: T?
) {
    fun success(): Boolean = code == "200"

    fun getCode(): String? = code

    fun getMsg(): String? = msg
}