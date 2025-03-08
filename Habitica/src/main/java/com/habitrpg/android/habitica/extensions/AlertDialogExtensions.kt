package xyz.prfn.android.habitica.extensions

import xyz.prfn.android.habitica.R
import xyz.prfn.android.habitica.ui.views.dialogs.HabiticaAlertDialog

fun HabiticaAlertDialog.addOkButton(
    isPrimary: Boolean = true,
    listener: ((HabiticaAlertDialog, Int) -> Unit)? = null
) {
    this.addButton(R.string.ok, isPrimary, false, true, listener)
}

fun HabiticaAlertDialog.addCloseButton(
    isPrimary: Boolean = false,
    listener: ((HabiticaAlertDialog, Int) -> Unit)? = null
) {
    this.addButton(R.string.close, isPrimary, false, true, listener)
}

fun HabiticaAlertDialog.addCancelButton(
    isPrimary: Boolean = false,
    listener: ((HabiticaAlertDialog, Int) -> Unit)? = null
) {
    this.addButton(R.string.cancel, isPrimary, false, true, listener)
}
