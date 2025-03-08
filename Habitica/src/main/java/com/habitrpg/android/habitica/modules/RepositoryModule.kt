package xyz.prfn.android.habitica.modules

import android.content.Context
import xyz.prfn.android.habitica.data.ApiClient
import xyz.prfn.android.habitica.data.ContentRepository
import xyz.prfn.android.habitica.data.implementation.ContentRepositoryImpl
import xyz.prfn.android.habitica.data.local.ContentLocalRepository
import xyz.prfn.android.habitica.data.local.implementation.RealmContentLocalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.realm.Realm

@InstallIn(SingletonComponent::class)
@Module
open class RepositoryModule {
    @Provides
    open fun providesRealm(): Realm {
        return Realm.getDefaultInstance()
    }

    @Provides
    fun providesContentLocalRepository(realm: Realm): ContentLocalRepository {
        return RealmContentLocalRepository(realm)
    }

    @Provides
    fun providesContentRepository(
        contentLocalRepository: ContentLocalRepository,
        apiClient: ApiClient,
        @ApplicationContext context: Context,
        authenticationHandler: AuthenticationHandler
    ): ContentRepository {
        return ContentRepositoryImpl(
            contentLocalRepository,
            apiClient,
            context,
            authenticationHandler
        )
    }
}
