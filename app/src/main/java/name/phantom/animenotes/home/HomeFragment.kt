package name.phantom.animenotes.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import name.phantom.animenotes.base.BaseFragment
import name.phantom.animenotes.databinding.FragmentHomeBinding

/**
 * @description
 * @author Phantom
 * @since 2022/5/16
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding =
        FragmentHomeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

    }
}