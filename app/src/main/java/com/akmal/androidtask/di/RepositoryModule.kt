package com.akmal.androidtask.di

import com.akmal.androidtask.data.repository.OfferRepository
import com.akmal.androidtask.data.repository.impl.OfferRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindOfferRepository(impl: OfferRepositoryImpl): OfferRepository
}