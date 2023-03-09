package name.phantom.animenotes.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import name.phantom.animenotes.R
import name.phantom.animenotes.base.BaseFragment
import name.phantom.animenotes.databinding.FragmentAnimeDetailBinding
import name.phantom.animenotes.list.data.AnimeDetailData
import name.phantom.animenotes.list.viewmodel.AnimeDetailViewModel

/**
 * @description
 * @author Phantom
 * @since 2022/5/24
 */
class AnimeDetailFragment(private val position: Int) : BaseFragment<FragmentAnimeDetailBinding>() {

    private val viewModel: AnimeDetailViewModel by activityViewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAnimeDetailBinding =
        FragmentAnimeDetailBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        viewModel.let {
            it.animeDetailRes.observe(viewLifecycleOwner) { fillInData(it.animeList[position]) }
        }
    }

    private fun fillInData(data: AnimeDetailData) {
        binding?.let {
            it.tvOriginalRun.text = getString(R.string.content_original_run).format(
                data.originalRunStart,
                data.originalRunEnd
            )
            it.tvEpisodes.text = data.episodes.toString()
            it.tvWatchedTime.text = data.watchedTime
        }
    }
}