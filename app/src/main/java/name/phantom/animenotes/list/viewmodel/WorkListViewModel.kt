package name.phantom.animenotes.list.viewmodel

import androidx.lifecycle.MutableLiveData
import name.phantom.animenotes.base.http.BaseViewModel
import name.phantom.animenotes.base.http.RetrofitHelper.getHttpServer
import name.phantom.animenotes.list.IListHttpServer
import name.phantom.animenotes.list.data.WorkAddReq
import name.phantom.animenotes.list.data.WorkAddRes
import name.phantom.animenotes.list.data.WorkListReq
import name.phantom.animenotes.list.data.WorkListRes

/**
 * @description
 * @author Phantom
 * @since 2022/5/16
 */
class WorkListViewModel : BaseViewModel() {

    private val iListHttpServer = getHttpServer(IListHttpServer::class.java)

    val workListRes = MutableLiveData<WorkListRes>()

    val addWorkRes = MutableLiveData<WorkAddRes>()

    fun getWorkList(req: WorkListReq) {
        requestWithCoroutine(req, workListRes) { iListHttpServer.getWorkList(it) }
    }

    fun addWork(req: WorkAddReq) {
//        requestWithCoroutine(req, addWorkRes) { iListHttpServer.addWork(it) }
//        requestWithCoroutine(req, addWorkRes) { iListHttpServer.addAnime(it) }
    }
}