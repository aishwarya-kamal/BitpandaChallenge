package com.test.bitpandachallenge.bindingadapters

import android.view.View
import androidx.databinding.BindingAdapter
import com.test.bitpandachallenge.data.local.DomainModel

object VisibilityBindingAdapter {

    @BindingAdapter("visibility")
    @JvmStatic
    fun setVisibility(view: View, domain: DomainModel) {
        view.visibility = if (domain.metalName.isNullOrBlank() ||
            domain.metalName.isNullOrEmpty()
        ) View.INVISIBLE

        else
            View.VISIBLE
    }

}