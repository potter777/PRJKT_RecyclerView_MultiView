package me.projekt401.projkt.network

import me.projekt401.projkt.models.Base
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface FakeApi {

    @Headers("x-api-key: PMAK-5ed9c8d843aab10034a30ab8-ed2a9276212081cdf166e836d20dfd390c")
    @GET("/questions")
    fun getQuestions() : Call<Base>
}