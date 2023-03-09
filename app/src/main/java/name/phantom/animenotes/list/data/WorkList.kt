package name.phantom.animenotes.list.data

/**
 * @description
 * @author Phantom
 * @since 2022/5/16
 */
data class WorkListReq(
    val temp: String
)

data class WorkListRes(
    val workList: List<WorkItem>
)

data class WorkItem(
    val id: Int,
    val originalName: String,
    val chineseName: String,
    val otherName: List<String>,
    val imageUrl: String,
    val summary: String
)
