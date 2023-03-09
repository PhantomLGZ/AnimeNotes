package name.phantom.animenotes.list

import name.phantom.animenotes.base.http.IHttpServer
import name.phantom.animenotes.base.http.entity.BaseData
import name.phantom.animenotes.list.data.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @description
 * @author Phantom
 * @since 2022/5/16
 */
interface IListHttpServer : IHttpServer {

    @POST("work/all")
    suspend fun getWorkList(@Body req: WorkListReq): Response<BaseData<WorkListRes>>

    @POST("work/add")
    suspend fun addWork(@Body req: WorkAddReq): Response<BaseData<WorkAddRes>>

    @POST("anime/add")
    suspend fun addAnime(@Body req: WorkAddReq): Response<BaseData<WorkAddRes>>

    @POST("anime/queryByWorkId")
    suspend fun queryAnimeListByWorkId(@Body req: WorkDetailReq): Response<BaseData<WorkDetailRes>>
}