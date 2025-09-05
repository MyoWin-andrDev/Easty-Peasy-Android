package com.myowin.eastypeasy.data.network
object ApiUrls {

    private const val BASE_URL = "https://example.com/api"

    // Restaurants
    const val GET_RESTAURANTS = "$BASE_URL/restaurants"

    // Users
    const val GET_USERS = "$BASE_URL/users"
    const val GET_USER_DETAILS = "$BASE_URL/users/{id}"

    // Todos (example from JSONPlaceholder)
    const val GET_TODOS = "https://jsonplaceholder.typicode.com/todos"

    // Authentication
    const val LOGIN = "$BASE_URL/auth/login"
    const val REGISTER = "$BASE_URL/auth/register"

}