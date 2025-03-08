package xyz.prfn.android.habitica.modules

import android.content.Context
import xyz.prfn.android.habitica.data.ApiClient
import xyz.prfn.android.habitica.data.ChallengeRepository
import xyz.prfn.android.habitica.data.CustomizationRepository
import xyz.prfn.android.habitica.data.FAQRepository
import xyz.prfn.android.habitica.data.InventoryRepository
import xyz.prfn.android.habitica.data.SetupCustomizationRepository
import xyz.prfn.android.habitica.data.SocialRepository
import xyz.prfn.android.habitica.data.TagRepository
import xyz.prfn.android.habitica.data.TaskRepository
import xyz.prfn.android.habitica.data.TutorialRepository
import xyz.prfn.android.habitica.data.UserRepository
import xyz.prfn.android.habitica.data.implementation.ChallengeRepositoryImpl
import xyz.prfn.android.habitica.data.implementation.CustomizationRepositoryImpl
import xyz.prfn.android.habitica.data.implementation.FAQRepositoryImpl
import xyz.prfn.android.habitica.data.implementation.InventoryRepositoryImpl
import xyz.prfn.android.habitica.data.implementation.SetupCustomizationRepositoryImpl
import xyz.prfn.android.habitica.data.implementation.SocialRepositoryImpl
import xyz.prfn.android.habitica.data.implementation.TagRepositoryImpl
import xyz.prfn.android.habitica.data.implementation.TaskRepositoryImpl
import xyz.prfn.android.habitica.data.implementation.TutorialRepositoryImpl
import xyz.prfn.android.habitica.data.implementation.UserRepositoryImpl
import xyz.prfn.android.habitica.data.local.ChallengeLocalRepository
import xyz.prfn.android.habitica.data.local.CustomizationLocalRepository
import xyz.prfn.android.habitica.data.local.FAQLocalRepository
import xyz.prfn.android.habitica.data.local.InventoryLocalRepository
import xyz.prfn.android.habitica.data.local.SocialLocalRepository
import xyz.prfn.android.habitica.data.local.TagLocalRepository
import xyz.prfn.android.habitica.data.local.TaskLocalRepository
import xyz.prfn.android.habitica.data.local.TutorialLocalRepository
import xyz.prfn.android.habitica.data.local.UserLocalRepository
import xyz.prfn.android.habitica.data.local.implementation.RealmChallengeLocalRepository
import xyz.prfn.android.habitica.data.local.implementation.RealmCustomizationLocalRepository
import xyz.prfn.android.habitica.data.local.implementation.RealmFAQLocalRepository
import xyz.prfn.android.habitica.data.local.implementation.RealmInventoryLocalRepository
import xyz.prfn.android.habitica.data.local.implementation.RealmSocialLocalRepository
import xyz.prfn.android.habitica.data.local.implementation.RealmTagLocalRepository
import xyz.prfn.android.habitica.data.local.implementation.RealmTaskLocalRepository
import xyz.prfn.android.habitica.data.local.implementation.RealmTutorialLocalRepository
import xyz.prfn.android.habitica.data.local.implementation.RealmUserLocalRepository
import xyz.prfn.android.habitica.helpers.AppConfigManager
import xyz.prfn.android.habitica.helpers.PurchaseHandler
import xyz.prfn.android.habitica.ui.viewmodels.MainUserViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UserRepositoryModule {
    @Provides
    fun providesSetupCustomizationRepository(
        @ApplicationContext context: Context
    ): SetupCustomizationRepository {
        return SetupCustomizationRepositoryImpl(context)
    }

    @Provides
    fun providesTaskLocalRepository(realm: Realm): TaskLocalRepository {
        return RealmTaskLocalRepository(realm)
    }

    @Provides
    fun providesTaskRepository(
        localRepository: TaskLocalRepository,
        apiClient: ApiClient,
        authenticationHandler: AuthenticationHandler,
        appConfigManager: AppConfigManager
    ): TaskRepository {
        return TaskRepositoryImpl(
            localRepository,
            apiClient,
            authenticationHandler,
            appConfigManager
        )
    }

    @Provides
    fun providesTagLocalRepository(realm: Realm): TagLocalRepository {
        return RealmTagLocalRepository(realm)
    }

    @Provides
    fun providesTagRepository(
        localRepository: TagLocalRepository,
        apiClient: ApiClient,
        authenticationHandler: AuthenticationHandler
    ): TagRepository {
        return TagRepositoryImpl(localRepository, apiClient, authenticationHandler)
    }

    @Provides
    fun provideChallengeLocalRepository(realm: Realm): ChallengeLocalRepository {
        return RealmChallengeLocalRepository(realm)
    }

    @Provides
    fun providesChallengeRepository(
        localRepository: ChallengeLocalRepository,
        apiClient: ApiClient,
        authenticationHandler: AuthenticationHandler
    ): ChallengeRepository {
        return ChallengeRepositoryImpl(localRepository, apiClient, authenticationHandler)
    }

    @Provides
    fun providesUserLocalRepository(realm: Realm): UserLocalRepository {
        return RealmUserLocalRepository(realm)
    }

    @Provides
    fun providesUserRepository(
        localRepository: UserLocalRepository,
        apiClient: ApiClient,
        authenticationHandler: AuthenticationHandler,
        taskRepository: TaskRepository,
        appConfigManager: AppConfigManager
    ): UserRepository {
        return UserRepositoryImpl(
            localRepository,
            apiClient,
            authenticationHandler,
            taskRepository,
            appConfigManager
        )
    }

    @Provides
    fun providesSocialLocalRepository(realm: Realm): SocialLocalRepository {
        return RealmSocialLocalRepository(realm)
    }

    @Provides
    fun providesSocialRepository(
        localRepository: SocialLocalRepository,
        apiClient: ApiClient,
        authenticationHandler: AuthenticationHandler
    ): SocialRepository {
        return SocialRepositoryImpl(localRepository, apiClient, authenticationHandler)
    }

    @Provides
    fun providesInventoryLocalRepository(
        realm: Realm
    ): InventoryLocalRepository {
        return RealmInventoryLocalRepository(realm)
    }

    @Provides
    fun providesInventoryRepository(
        localRepository: InventoryLocalRepository,
        apiClient: ApiClient,
        authenticationHandler: AuthenticationHandler,
        remoteConfig: AppConfigManager
    ): InventoryRepository {
        return InventoryRepositoryImpl(
            localRepository,
            apiClient,
            authenticationHandler,
            remoteConfig
        )
    }

    @Provides
    fun providesFAQLocalRepository(realm: Realm): FAQLocalRepository {
        return RealmFAQLocalRepository(realm)
    }

    @Provides
    fun providesFAQRepository(
        localRepository: FAQLocalRepository,
        apiClient: ApiClient,
        authenticationHandler: AuthenticationHandler
    ): FAQRepository {
        return FAQRepositoryImpl(localRepository, apiClient, authenticationHandler)
    }

    @Provides
    fun providesTutorialLocalRepository(realm: Realm): TutorialLocalRepository {
        return RealmTutorialLocalRepository(realm)
    }

    @Provides
    fun providesTutorialRepository(
        localRepository: TutorialLocalRepository,
        apiClient: ApiClient,
        authenticationHandler: AuthenticationHandler
    ): TutorialRepository {
        return TutorialRepositoryImpl(localRepository, apiClient, authenticationHandler)
    }

    @Provides
    fun providesCustomizationLocalRepository(realm: Realm): CustomizationLocalRepository {
        return RealmCustomizationLocalRepository(realm)
    }

    @Provides
    fun providesCustomizationRepository(
        localRepository: CustomizationLocalRepository,
        apiClient: ApiClient,
        authenticationHandler: AuthenticationHandler
    ): CustomizationRepository {
        return CustomizationRepositoryImpl(localRepository, apiClient, authenticationHandler)
    }

    @Provides
    @Singleton
    fun providesPurchaseHandler(
        @ApplicationContext context: Context,
        apiClient: ApiClient,
        userViewModel: MainUserViewModel,
        appConfigManager: AppConfigManager
    ): PurchaseHandler {
        return PurchaseHandler(context, apiClient, userViewModel, appConfigManager)
    }
}
