package name.phantom.animenotes.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.listener.OnItemClickListener
import name.phantom.animenotes.R
import name.phantom.animenotes.base.BaseFragment
import name.phantom.animenotes.databinding.FragmentListBinding
import name.phantom.animenotes.list.adapter.AnimeListAdapter
import name.phantom.animenotes.list.data.WorkAddReq
import name.phantom.animenotes.list.data.WorkItem
import name.phantom.animenotes.list.data.WorkListReq
import name.phantom.animenotes.list.data.WorkListRes
import name.phantom.animenotes.list.viewmodel.WorkListViewModel

/**
 * @description
 * @author Phantom
 * @since 2022/5/16
 */
class WorkListFragment : BaseFragment<FragmentListBinding>() {

    private val adapter = AnimeListAdapter()
    private var viewModel: WorkListViewModel? = null

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentListBinding =
        FragmentListBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onResume() {
        super.onResume()
        if (adapter.data.isEmpty()) {
            refresh()
        }
    }

    private fun init() {
        viewModel = ViewModelProvider(this)[WorkListViewModel::class.java]
        viewModel?.run {
            workListRes.observe(viewLifecycleOwner) { animeList(it) }
            error.observe(viewLifecycleOwner) { showToast(it.message) }
        }
        adapter.also {
            it.setEmptyView(R.layout.view_base_empty)
            it.setOnItemClickListener(onItemClickListener)
        }
        binding?.run {
            swipeRefreshLayout.setOnRefreshListener {
                refresh()
            }
            recyclerView.also {
                it.adapter = adapter
                it.layoutManager = LinearLayoutManager(this@WorkListFragment.context)
            }
            btAdd.setOnClickListener {
                viewModel?.addWork(
                    WorkAddReq(
                        originalName = "???????????????????????????",
                        chineseName = "?????????????????????",
                        otherName = listOf("?????????????????????"),
                        imageUrl = "https://img.moegirl.org.cn/common/6/60/Teibo_KV.jpg",
                        summary = "???????????????????????????????????????????????????????????????????????????????????????\n" +
                                "?????????????????????????????????????????????????????????????????????\n" +
                                "???????????????????????????????????????????????????????????????????????????"
                    )
                )
            }
        }

    }

    private fun refresh() {
        binding?.swipeRefreshLayout?.isRefreshing = false
        viewModel?.getWorkList(WorkListReq(""))
    }

    private fun animeList(data: WorkListRes) {
        adapter.setNewInstance(data.workList.toMutableList())
    }

    private val onItemClickListener = OnItemClickListener { adapter, _, position ->
        val item = adapter.getItem(position) as WorkItem
        findNavController().navigate(
            R.id.action_nav_list_to_nav_activity_work_detail,
            bundleOf("workId" to item.id)
        )
    }
}