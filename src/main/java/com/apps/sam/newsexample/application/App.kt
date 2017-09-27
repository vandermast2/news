package com.apps.sam.newsexample.application

import android.app.Application
import com.apps.sam.newsexample.di.Component
import com.apps.sam.newsexample.di.DaggerComponent
import io.realm.Realm
import io.realm.RealmConfiguration

class App : Application() {

    lateinit var component: Component

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val config = RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(config)

        component = DaggerComponent.create()
    }
}
