package xyz.prfn.android.habitica.ui.fragments.social.challenges

import xyz.prfn.android.habitica.models.social.Group

data class ChallengeFilterOptions(
    var showByGroups: List<Group>,
    var showOwned: Boolean = false,
    var notOwned: Boolean = false
)
