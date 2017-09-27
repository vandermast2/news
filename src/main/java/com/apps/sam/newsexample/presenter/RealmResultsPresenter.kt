package com.apps.sam.newsexample.presenter

import com.apps.sam.newsexample.model.Model
import io.realm.Realm
import javax.inject.Inject

class RealmResultsPresenter @Inject
internal constructor(model: Model) : BasePresenter(model) {

    var realm: Realm? = null

    fun getObjects() = model.getObjects(realm!!)

    fun onCreate() {
        if (realm != null && !realm!!.isClosed) {
            realm?.close()
        }
        realm = Realm.getDefaultInstance()
    }

    fun onDestroy() {
        realm?.close()
    }

}