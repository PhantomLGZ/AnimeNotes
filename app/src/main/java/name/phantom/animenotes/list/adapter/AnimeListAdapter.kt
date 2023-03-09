package name.phantom.animenotes.list.adapter

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import name.phantom.animenotes.R
import name.phantom.animenotes.list.data.WorkItem


/**
 * @description
 * @author Phantom
 * @since 2022/5/16
 */
class AnimeListAdapter : BaseQuickAdapter<WorkItem, BaseViewHolder>(R.layout.item_anime_list),
    LoadMoreModule {

    override fun convert(holder: BaseViewHolder, item: WorkItem) {
        holder.also {
            it.setText(R.id.tvTitle, item.chineseName)
            it.setText(R.id.tvSummary, item.summary)
            Glide.with(context)
                .load(item.imageUrl)
                .into(it.getView(R.id.ivImage))
        }
    }

}