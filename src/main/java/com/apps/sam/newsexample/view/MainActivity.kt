package com.apps.sam.newsexample.view

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.apps.sam.newsexample.R
import com.apps.sam.newsexample.application.App
import com.apps.sam.newsexample.model.NewsModel
import com.apps.sam.newsexample.presenter.RealmResultsPresenter
import io.realm.OrderedRealmCollection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var presenter: RealmResultsPresenter
    private var adapter: NewsAdapter? = null
    private var handler: Handler = Handler()
    private var count:Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).component.inject(this)
        presenter.onCreate()
        count = presenter.getObjects().size.toLong()
        adapter = NewsAdapter(presenter.getObjects() as OrderedRealmCollection<NewsModel>, this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter
        fab.setOnClickListener({
            presenter.deleteAll()
            count=0})
        startTimer()

    }

    var runnable: Runnable = Runnable {
        presenter.addObject(count++)
        startTimer()
    }

    fun startTimer() {
        handler.postDelayed(runnable, 10000)
    }

    fun cancelTimer() {
        handler.removeCallbacks(runnable)
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
        cancelTimer()
    }

}
