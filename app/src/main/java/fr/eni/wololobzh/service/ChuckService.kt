package fr.eni.wololobzh.service

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import fr.eni.wololobzh.model.Joke
import fr.eni.wololobzh.service.ChuckService.Companion.retrofit
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ChuckService {

    companion object {
        val BASE_URL = "https://api.chucknorris.io/jokes/"
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL).build()
    }

    @GET("random")
    suspend fun randomFact(): Joke
}

object ChuckApi {
    val retrofitServiceChuck : ChuckService by lazy { retrofit.create(ChuckService::class.java) }
}