package name.phantom.animenotes.list.data

/**
 * @description
 * @author Phantom
 * @since 2022/5/25
 */
data class WorkAddReq(
    val id: Int? = null,
    val originalName: String,
    val chineseName: String,
    val otherName: List<String>,
    val imageUrl: String,
    val summary: String
)

data class WorkAddRes(
    val test: String
)
