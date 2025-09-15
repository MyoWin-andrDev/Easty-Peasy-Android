package com.myowin.eastypeasy.repository.home

import com.myowin.eastypeasy.data.local.DataStoreManager
import com.myowin.eastypeasy.data.network.safeApiCall
import com.myowin.eastypeasy.model.dto.RestaurantModel
import com.myowin.eastypeasy.util.Constant
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepositoryImpl @Inject constructor(
    private val client: HttpClient,
    private val dataStoreManager: DataStoreManager
    // Inject other dependencies like ApiService if needed
) : HomeRepository {

    override val isFirstLaunchFlow: Flow<Boolean>
        get() = dataStoreManager.isFirstLaunch

    override suspend fun finishFirstLaunch() {
//        dataStoreManager.setFirstLaunch(false)
    }

   override suspend fun fetchRestaurants(): Result<List<RestaurantModel>> {
        return safeApiCall {
            client.get(Constant.BASE_URL_RESTAURANT).body<List<RestaurantModel>>()
        }
    }

}
