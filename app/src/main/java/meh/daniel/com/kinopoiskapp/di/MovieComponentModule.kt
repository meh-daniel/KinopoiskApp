package meh.daniel.com.kinopoiskapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton
import meh.daniel.com.kinopoiskapp.data.MovieRepositoryImpl
import meh.daniel.com.kinopoiskapp.data.network.KinopoiskApi
import meh.daniel.com.kinopoiskapp.data.storage.MovieDataBase
import meh.daniel.com.kinopoiskapp.domain.MovieRepository
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class SerialComponentModule {

    @Provides
    @Singleton
    fun provideKinopoiskApi(
        @Named("retrofitKinopoiskBuilder") retrofit: Retrofit
    ) : KinopoiskApi {
        return retrofit.create(KinopoiskApi::class.java)
    }


    @Provides
    @Singleton
    fun provideCreateMovieDataBase(
        @ApplicationContext context: Context
    ): MovieDataBase {
        return MovieDataBase.invoke(context)
    }

    @Provides
    @Singleton
    fun provideSerialRepository(
        api: KinopoiskApi,
        db: MovieDataBase,
    ) : MovieRepository {
        return MovieRepositoryImpl(api, db)
    }

}