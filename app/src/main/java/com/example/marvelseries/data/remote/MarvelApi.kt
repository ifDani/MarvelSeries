package com.example.marvelseries.data.remote

import com.example.marvelseries.domain.model.CharacterDetailResponse
import com.example.marvelseries.domain.model.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    @GET("characters")
    suspend fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("offset") offset: Int = 0
    ): CharactersResponse

//    "${System.currentTimeMillis()}5ed46ef9028ad9bb7350ac291b71cabf3905470111dcdd67a46ecc742f688671dd054631"
    @GET("characters/{characterId}")
    suspend fun getCharacterById(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Path("characterId") characterId: String
    ): CharacterDetailResponse

}