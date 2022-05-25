package com.example.roommvvmcoroutines.di

import android.content.Context
import com.example.roommvvmcoroutines.data.F1Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = F1Database.getInstance(context)

    @Singleton
    @Provides
    fun provideF1DriverDao(f1Database: F1Database) = f1Database.f1DriverDao()
}