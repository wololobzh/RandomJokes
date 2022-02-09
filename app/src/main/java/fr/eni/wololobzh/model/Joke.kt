package fr.eni.wololobzh.model

import com.squareup.moshi.Json

data class Joke(
    val id:String,
    @Json(name="icon_url")val image:String,
    @Json(name="value")val joke:String
)
