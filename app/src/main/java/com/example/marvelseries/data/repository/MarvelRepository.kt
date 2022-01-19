package com.example.marvelseries.data.repository

import com.example.marvelseries.data.remote.MarvelApi
import com.example.marvelseries.domain.model.CharactersResponse
import com.example.marvelseries.util.Constants.PRIVATE_API_KEY
import com.example.marvelseries.util.Constants.PUBLIC_API_KEY
import com.example.marvelseries.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.math.BigInteger
import java.security.MessageDigest
import javax.inject.Inject

class MarvelRepository @Inject constructor(private val repository: MarvelApi) {
    var currentTimeStamp = ""

    fun getCharacters(): Flow<Resource<ArrayList<CharactersResponse.Data.Result>>> = flow {
        try {
            emit(Resource.Loading())
            val hash = generateHash()
            val characters = repository.getCharacters(ts = currentTimeStamp, apiKey = PUBLIC_API_KEY, hash = hash)
            //Emit response

            emit(Resource.Success(characters.data.results))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred ${e.code()}"))

        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }

    fun generateHash(): String  {
        currentTimeStamp = System.currentTimeMillis().toString()
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest("${currentTimeStamp}${PRIVATE_API_KEY}${PUBLIC_API_KEY}".toByteArray())).toString(16).padStart(32, '0')
    }

}