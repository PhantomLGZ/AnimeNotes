package name.phantom.animenotes

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import name.phantom.animenotes.base.BaseActivity
import name.phantom.animenotes.databinding.ActivityMainBinding

/**
 * @description
 * @author Phantom
 * @since 2022/5/16
 */
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun inflateViewBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        binding.run {
            bottomNavigation.setupWithNavController(findNavController(R.id.navHostFragment))
        }
    }

    private var preBackPressedTime = 0L

    override fun onBackPressed() {
        val nowTime = System.currentTimeMillis()
        if (preBackPressedTime != 0L && nowTime - preBackPressedTime < 2000) {
            super.onBackPressed()
        } else {
            preBackPressedTime = nowTime
        }
    }
}