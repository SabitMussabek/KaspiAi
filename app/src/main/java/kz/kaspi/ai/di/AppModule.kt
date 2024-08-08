package kz.kaspi.ai.di

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit


val appModule = module {
//    singleOf()
//    val jsonFormat = Json {
//        ignoreUnknownKeys = true
//        isLenient = true
//        encodeDefaults = true
//        prettyPrint = false
//        explicitNulls = false
//    }
//    val contentType = "application/json".toMediaType()
//    val retrofit = Retrofit.Builder()
//        .baseUrl(url)
//        .client(okHttpClient)
//        .addConverterFactory(jsonFormat.asConverterFactory(contentType))
//        .build()
//
//    return retrofit.create(T::class.java)
}