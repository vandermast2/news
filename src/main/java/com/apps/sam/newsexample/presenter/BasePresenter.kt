package com.apps.sam.newsexample.presenter

import com.apps.sam.newsexample.model.Model

open class BasePresenter(var model: Model) {
    fun addObject(count:Long) = model.addObject(count)
    fun deleteAll() = model.clearRealm()
}