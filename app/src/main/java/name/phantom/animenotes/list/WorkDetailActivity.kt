package name.phantom.animenotes.list

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import name.phantom.animenotes.base.BaseActivity
import name.phantom.animenotes.list.adapter.AnimeDetailViewPagerAdapter
import name.phantom.animenotes.databinding.ActivityWorkDetailBinding
import name.phantom.animenotes.list.data.WorkDetailReq
import name.phantom.animenotes.list.data.WorkDetailRes
import name.phantom.animenotes.list.viewmodel.AnimeDetailViewModel

/**
 * @description
 * @author Phantom
 * @since 2022/5/24
 */
class WorkDetailActivity : BaseActivity<ActivityWorkDetailBinding>() {

    private var viewModel: AnimeDetailViewModel? = null
    private var viewPagerAdapter: AnimeDetailViewPagerAdapter? = null
    private var data: WorkDetailRes? = null
    private var mediator: TabLayoutMediator? = null

    override fun inflateViewBinding(): ActivityWorkDetailBinding =
        ActivityWorkDetailBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        viewModel = ViewModelProvider(this)[AnimeDetailViewModel::class.java]
        viewModel?.let { vm ->
            vm.animeDetailRes.observe(this) { setAnimeDetail(it) }
            vm.error.observe(this) { showToast(it.message) }
            vm.getAnimeDetail(WorkDetailReq(intent.getIntExtra("workId", 0)))
        }

        viewPagerAdapter = AnimeDetailViewPagerAdapter(data, supportFragmentManager, lifecycle)
        binding.viewPager.adapter = viewPagerAdapter

        mediator = TabLayoutMediator(binding.appbar.tabLayout, binding.viewPager) { tab, position ->
            tab.text = data?.animeList?.get(position)?.chineseName ?: "第${position + 1}期"
        }
    }

    private fun setAnimeDetail(data: WorkDetailRes) {
        this.data = data
        binding.appbar.toolbar.title = data.chineseName
        Glide.with(this)
            .load(data.imageUrl)
            .into(binding.appbar.ivToolbar)
        mediator?.attach()
    }
}