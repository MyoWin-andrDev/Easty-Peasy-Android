package com.myowin.eastypeasy.repository.restaurant_detail

import com.myowin.eastypeasy.data.network.safeApiCall
import com.myowin.eastypeasy.model.dto.RestaurantModel
import com.myowin.eastypeasy.util.Constant
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RestoDetailRepositoryImpl @Inject constructor(
    private val client : HttpClient
) : RestoDetailRepository {
    override suspend fun fetchRestaurantDetail(restaurantId: Int): Result<RestaurantModel> {
        return safeApiCall {
            client.get(Constant.BASE_URL_RESTAURANT + 1 ).body()
        }
    }
}