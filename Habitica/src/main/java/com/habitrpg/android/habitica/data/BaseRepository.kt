package xyz.prfn.android.habitica.data

import xyz.prfn.android.habitica.models.BaseObject

interface BaseRepository {
    val isClosed: Boolean

    fun close()

    fun <T : BaseObject> getUnmanagedCopy(obj: T): T

    fun <T : BaseObject> getUnmanagedCopy(list: List<T>): List<T>
}
