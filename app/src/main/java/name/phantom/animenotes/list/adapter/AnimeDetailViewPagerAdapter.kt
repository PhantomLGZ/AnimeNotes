package name.phantom.animenotes.list.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import name.phantom.animenotes.list.AnimeDetailFragment
import name.phantom.animenotes.list.data.WorkDetailRes

/**
 * @description
 * @author Phantom
 * @since 2022/5/24
 */
class AnimeDetailViewPagerAdapter(
    private val data: WorkDetailRes?,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = data?.animeList?.size ?: 1

    override fun createFragment(position: Int): Fragment {
        return AnimeDetailFragment(position)
    }
}