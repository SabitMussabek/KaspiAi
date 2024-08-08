package kz.kaspi.ai.di

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory


val appModule = module {
    singleOf(::provideJsonFormant)
    singleOf(::provideOkHttpClient)
    singleOf(::provideRetrofit)
}

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
    jsonFormat: Json,
): Retrofit {
    val contentType = "application/json".toMediaType()
    return Retrofit.Builder()
        .baseUrl("restcountries.com/v3.1/")
        .client(okHttpClient)
        .addConverterFactory(jsonFormat.asConverterFactory(contentType))
        .build()
}

private fun provideJsonFormant(): Json {
    return Json {
        ignoreUnknownKeys = true
        isLenient = true
        encodeDefaults = true
        prettyPrint = false
        explicitNulls = false
    }
}

private fun provideOkHttpClient(): OkHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(provideHttpLoggingInterceptor())
        .build()


private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return interceptor
}
