package com.example.marvelseries.data.remote

import com.example.marvelseries.domain.model.CharacterDetailResponse
import com.example.marvelseries.domain.model.CharactersResponse
import com.example.marvelseries.domain.model.ComicsResponse
import com.example.marvelseries.domain.model.SeriesResponse
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

    @GET("characters/{characterId}")
    suspend fun getCharacterById(
        @Path("characterId") characterId: Int,
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String

    ): CharacterDetailResponse

    @GET("characters/{characterId}/comics")
    suspend fun getCharacterComics(
        @Path("characterId") characterId: Int,
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): ComicsResponse

    @GET("characters/{characterId}/series")
    suspend fun getCharacterSeries(
        @Path("characterId") characterId: Int,
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): SeriesResponse

}