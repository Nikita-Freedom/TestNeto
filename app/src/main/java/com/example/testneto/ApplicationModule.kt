package com.example.testneto

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.RealmConfiguration

@Module
@InstallIn(SingletonComponent::class)
interface ApplicationModule {
  companion object {
    @Provides
    fun provideRealmDefaultConfiguration(): RealmConfiguration {
      return RealmConfiguration.Builder()
        .name("mviSampleDb")
        .allowQueriesOnUiThread(true)
        .allowWritesOnUiThread(true)
        .build()
    }
  }
}

