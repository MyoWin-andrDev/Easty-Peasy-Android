package com.myowin.eastypeasy.data.network

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import java.io.IOException

suspend fun <T> safeApiCall(apiCall: suspend () -> T): Result<T> {
    return try {
        Result.success(apiCall())
    } catch (e: IOException) {
        Result.failure(IOException("No internet connection", e))
    } catch (e: ClientRequestException) {
        // 4xx errors
        Result.failure(IOException("Client error: ${e.response.status}", e))
    } catch (e: ServerResponseException) {
        // 5xx errors
        Result.failure(IOException("Server error: ${e.response.status}", e))
    } catch (e: Exception) {
        Result.failure(IOException("Unknown error", e))
    }
}
