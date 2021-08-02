package com.samadhan.nytimes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.samadhan.nytimes.R
import com.samadhan.nytimes.databinding.RowArticleListItemBinding
import com.samadhan.nytimes.interfaces.IArticleSelectionListener
import com.samadhan.nytimes.model.Results
import java.util.*

class ArticleListAdapter (private var iArticleSelectionListener: IArticleSelectionListener) : RecyclerView.Adapter<ArticleListAdapter.DataViewHolder>() {
    private val data: MutableList<Results>

    init {
        this.data = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_article_list_item,
            FrameLayout(parent.context), false)
        return DataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val article = data[position]
        holder.setViewModel(article)
        holder.viewBinding!!.root.setOnClickListener {
            iArticleSelectionListener.onArticleSelected(article)
        }
    }

    fun updateData(data: List<Results>?) {
        this.data.clear()
        if (!data.isNullOrEmpty()) {
            this.data.addAll(data)
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onViewAttachedToWindow(holder: DataViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.bind()
    }

    override fun onViewDetachedFromWindow(holder: DataViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.unBind()
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var viewBinding: RowArticleListItemBinding? = null

        init {
            bind()
        }

        fun bind() {
            if (null == viewBinding) {
                viewBinding = DataBindingUtil.bind(itemView)
            }
        }

        fun unBind() {
            if (null != viewBinding) {
                viewBinding!!.unbind()
            }
        }

        fun setViewModel(viewModel: Results) {
            if (null != viewBinding) {
                viewBinding!!.result = viewModel
            }
        }
    }
}