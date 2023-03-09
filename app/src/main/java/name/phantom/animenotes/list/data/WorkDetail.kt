package name.phantom.animenotes.list.data

/**
 * @description
 * @author Phantom
 * @since 2022/5/24
 */
data class WorkDetailReq(
    val workId: Int
)

data class WorkDetailRes(
    val chineseName:String,
    val imageUrl: String,
    val animeList: List<AnimeDetailData>
)

data class AnimeDetailData(
    val id: Int,
    val workId: Int,
    val chineseName: String,
    val episodes: Int,
    val originalRunStart: String,
    val originalRunEnd: String,
    val watchedTime: String
)
