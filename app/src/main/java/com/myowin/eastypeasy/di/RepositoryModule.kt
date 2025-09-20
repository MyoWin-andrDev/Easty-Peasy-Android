package com.myowin.eastypeasy.di

import com.myowin.eastypeasy.repository.home.HomeRepository
import com.myowin.eastypeasy.repository.home.HomeRepositoryImpl
import com.myowin.eastypeasy.repository.menu.MenuItemRepository
import com.myowin.eastypeasy.repository.menu.MenuItemRepositoryImpl
import com.myowin.eastypeasy.repository.restaurant.RestaurantRepository
import com.myowin.eastypeasy.repository.restaurant.RestaurantRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository

    @Binds
    @Singleton
    abstract fun bindRestaurantDetailRepository(
        restaurantDetailRepositoryImpl : RestaurantRepositoryImpl
    ): RestaurantRepository

    @Binds
    @Singleton
    abstract fun bindMenuItemRepositoryRepository(
        menuItemRepositoryImpl: MenuItemRepositoryImpl
    ) : MenuItemRepository
}
