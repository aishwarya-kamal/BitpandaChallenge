package com.test.bitpandachallenge.utils

import com.test.bitpandachallenge.data.local.DomainModel

class ClickListener(val clickListener: (domain: DomainModel) -> Unit) {
    fun onClick(domain: DomainModel) = clickListener(domain)
}