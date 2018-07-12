package com.arkarzaw.mm_healthcare.datas.VOs

import com.google.gson.annotations.SerializedName

class AuthorVO {

    @SerializedName("author-id")
    var authorId : Long = 0

    @SerializedName("author-name")
    var name : String? = null

    @SerializedName("author-picture")
    var authorPic : String? = null

}