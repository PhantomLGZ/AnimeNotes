package name.phantom.animenotes.list

import name.phantom.animenotes.base.BaseActivity
import name.phantom.animenotes.databinding.ActivityWorkAddBinding

/**
 * @description
 * @author Phantom
 * @since 2022/5/27
 */
class WorkAddActivity : BaseActivity<ActivityWorkAddBinding>() {

    override fun inflateViewBinding(): ActivityWorkAddBinding =
        ActivityWorkAddBinding.inflate(layoutInflater)

}