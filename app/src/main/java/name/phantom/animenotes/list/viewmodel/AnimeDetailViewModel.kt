package name.phantom.animenotes.list.viewmodel

import androidx.lifecycle.MutableLiveData
import name.phantom.animenotes.base.http.BaseViewModel
import name.phantom.animenotes.base.http.RetrofitHelper
import name.phantom.animenotes.list.IListHttpServer
import name.phantom.animenotes.list.data.WorkDetailReq
import name.phantom.animenotes.list.data.WorkDetailRes

/**
 * @description
 * @author Phantom
 * @since 2022/5/24
 */
class AnimeDetailViewModel : BaseViewModel() {

    private val iListHttpServer = RetrofitHelper.getHttpServer(IListHttpServer::class.java)

    val animeDetailRes = MutableLiveData<WorkDetailRes>()

    fun getAnimeDetail(req: WorkDetailReq) {
        requestWithCoroutine(req, animeDetailRes) { iListHttpServer.queryAnimeListByWorkId(it) }
    }
}