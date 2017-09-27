package com.apps.sam.newsexample.di

import com.apps.sam.newsexample.view.MainActivity
import javax.inject.Singleton

@Singleton
@dagger.Component
interface Component {
    fun inject(component: MainActivity)
}
