package xyz.prfn.android.habitica.models.user

import android.util.SparseIntArray
import xyz.prfn.android.habitica.R
import xyz.prfn.android.habitica.models.BaseObject
import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass(embedded = true)
open class ContributorInfo : RealmObject(), BaseObject {
    companion object {
        val CONTRIBUTOR_COLOR_DICT: SparseIntArray = SparseIntArray()

        init {
            CONTRIBUTOR_COLOR_DICT.put(0, R.color.contributor_0)
            CONTRIBUTOR_COLOR_DICT.put(1, R.color.contributor_1)
            CONTRIBUTOR_COLOR_DICT.put(2, R.color.contributor_2)
            CONTRIBUTOR_COLOR_DICT.put(3, R.color.contributor_3)
            CONTRIBUTOR_COLOR_DICT.put(4, R.color.contributor_4)
            CONTRIBUTOR_COLOR_DICT.put(5, R.color.contributor_5)
            CONTRIBUTOR_COLOR_DICT.put(6, R.color.contributor_6)
            CONTRIBUTOR_COLOR_DICT.put(7, R.color.contributor_7)
            CONTRIBUTOR_COLOR_DICT.put(8, R.color.contributor_mod)
            CONTRIBUTOR_COLOR_DICT.put(9, R.color.contributor_staff)
        }
    }

    var admin = false
    var contributions: String? = null
    var level = 0
    var text: String? = null
    val contributorColor: Int
        get() {
            var rColor = R.color.text_primary
            if (CONTRIBUTOR_COLOR_DICT[level, -1] > 0) {
                rColor = CONTRIBUTOR_COLOR_DICT[level]
            }
            return rColor
        }
}
