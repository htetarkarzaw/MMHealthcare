package com.arkarzaw.mm_healthcare.datas.VOs

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import io.reactivex.annotations.NonNull

@Entity(tableName = "HCInfo")
class HCInfoVO {

    @PrimaryKey
    @NonNull
    var id : Long = 0

    var title : String? = null

    var image : String? = null

    @SerializedName("short-description")
    var shortDec : String? = null

    @Embedded
    var author : AuthorVO? = null

    @SerializedName("published-date")
    var pubDate : String? = null

    @SerializedName("complete-url")
    var url : String? = null

}