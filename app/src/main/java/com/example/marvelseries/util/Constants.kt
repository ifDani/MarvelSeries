package com.example.marvelseries.util

import com.google.gson.Gson

object Constants {

    const val BASE_URL = "https://gateway.marvel.com:443/v1/public/"
    const val PUBLIC_API_KEY = "11dcdd67a46ecc742f688671dd054631"
    const val PRIVATE_API_KEY = "5ed46ef9028ad9bb7350ac291b71cabf39054701"
    const val ROUTE_TO_CHARLIST = "characters_screen/list={chatlist}"

    fun <A> String.fromJson(type: Class<A>): A {
        return Gson().fromJson(this, type)
    }

    fun <A> A.toJson(): String? {
        return Gson().toJson(this)
    }
}