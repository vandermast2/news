package com.apps.sam.newsexample.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class NewsModel : RealmObject {
    @PrimaryKey
    var id: Long = 0

    open var type:String = "Type 1"

    var name: String


    constructor() : this(System.currentTimeMillis())

    constructor(id: Long) : super() {
        this.id = id
        this.name = "NewsModel $id"
    }

}