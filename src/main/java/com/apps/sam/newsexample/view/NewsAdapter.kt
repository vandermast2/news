package com.apps.sam.newsexample.view

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apps.sam.newsexample.R
import com.apps.sam.newsexample.model.NewsModel
import com.apps.sam.newsexample.view.NewsAdapter.MyViewHolder
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import kotlinx.android.synthetic.main.item.view.*


/**
 * Created by Sam on 9/26/2017.
 */
class NewsAdapter(var dataList: OrderedRealmCollection<NewsModel>,
                  val context: Context) : RealmRecyclerViewAdapter<NewsModel, MyViewHolder>(dataList, true) {

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder?.bindView(dataList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder
            = MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        fun bindView(dataObject: NewsModel) {
            itemView.title.text = dataObject.name
            itemView.type.text = dataObject.type
            itemView.message.text = context.getText(R.string.message)
            itemView.card.setOnClickListener {
                context.startActivity(Intent(context, MessageActivity::class.java).
                        putExtra("id", dataObject.name).
                        putExtra("type", dataObject.type).
                        putExtra("message", context.getText(R.string.message)))
            }
        }
    }


}



