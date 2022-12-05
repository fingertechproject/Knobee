package com.example.knobee

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//  https://stg.knobee.app/dummyApi.json
const val BASE_URL = "https://stg.knobee.app"
interface KnobeeApiService {

    @GET("/dummyApi.json")
   fun getData():Call<Knobee>
}
object KnobeeService{
    val knobeeInstance:KnobeeApiService
    init {
        val retrofit:Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        knobeeInstance = retrofit.create(KnobeeApiService::class.java)
    }
}