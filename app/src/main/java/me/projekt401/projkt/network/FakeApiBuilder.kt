package me.projekt401.projkt.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val readTimeoutSeconds : Long = 5
val connectTimeoutSeconds : Long = 5

/* Mock server desde Postman para tests */
private val baseUrl = "https://32622263-e78e-4a31-afa8-52ac85e0de2a.mock.pstmn.io/"

val loggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

val httpClient = OkHttpClient.Builder()
    .readTimeout(readTimeoutSeconds, TimeUnit.SECONDS)
    .connectTimeout(connectTimeoutSeconds, TimeUnit.SECONDS)
    .addInterceptor(loggingInterceptor)
    .build()

val gsonBuilder = GsonBuilder()
    .setLenient()
    .create()

val retrofitBuilder = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
    .baseUrl(baseUrl)
    .client(httpClient)
    .build()


object FakeApiBuilder {
    val retrofitServiceBuilder : FakeApi by lazy {
        retrofitBuilder.create(
            FakeApi::class.java)
    }
}