package com.myowin.eastypeasy.repository.restaurant

import android.util.Log
import com.myowin.eastypeasy.data.network.safeApiCall
import com.myowin.eastypeasy.model.dto.RestaurantModel
import com.myowin.eastypeasy.util.Constant
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RestaurantRepositoryImpl @Inject constructor(
    private val client : HttpClient
) : RestaurantRepository {
//    override suspend fun fetchRestaurantDetail(restaurantId: Int): Result<RestaurantModel> {
//        return safeApiCall {
//            val resResponse = client.get(Constant.BASE_URL_RESTAURANT + restaurantId ).body<RestaurantModel>()
//            Log.d("ResResponse",resResponse.toString())
//            resResponse
//        }
//    }
}