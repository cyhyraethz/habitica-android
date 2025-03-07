package xyz.prfn.android.habitica.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import xyz.prfn.android.habitica.R
import com.habitrpg.common.habitica.extensions.inflate

class SimpleSpinnerAdapter(context: Context, resource: Int) : ArrayAdapter<CharSequence>(
    context,
    resource,
    R.id.textView,
    context.resources.getTextArray(resource)
) {
    override fun getDropDownView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val view = parent.inflate(R.layout.spinner_item, false)
        (view as? TextView)?.text = getItem(position)
        return view
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val view = convertView ?: parent.inflate(android.R.layout.simple_spinner_item, false)
        (view as? TextView)?.text = getItem(position)
        return view
    }
}
