package com.apps.sam.newsexample.model

import android.util.Log
import io.realm.Realm
import io.realm.RealmResults
import javax.inject.Inject


class Model @Inject
internal constructor() {

    fun getObjects(realm: Realm): RealmResults<NewsModel> {
        return realm.where(NewsModel::class.java).findAll()
    }

    fun addObject(count:Long) {
        Realm.getDefaultInstance().use { it.executeTransactionAsync { it.insertOrUpdate(NewsModel(count)) } }
    }

    fun log(log: Any) {
        Log.d("Realm Example", log.toString())
    }

    fun clearRealm() {
        Realm.getDefaultInstance().use({ it.executeTransaction { it.deleteAll() } })
    }

}
