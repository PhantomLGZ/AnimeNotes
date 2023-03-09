package name.phantom.animenotes.base.http

/**
 * @description
 * @author Phantom
 * @since 2022/5/16
 */
sealed class ViewModelResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : ViewModelResult<T>()
    data class Error(val exception: Exception) :
        ViewModelResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}