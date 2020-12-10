package com.test.bitpandachallenge.ui.walletdetails

import androidx.lifecycle.ViewModel
import timber.log.Timber
import javax.inject.Inject

class WalletDetailsViewModel @Inject constructor() : ViewModel() {

    var formattedPrice: String? = null

    fun convertToPriceWithPrecision(price: Double?, precision: Int?): String? {
        if (price == 0.0){
            return "0.0"
        }
        formattedPrice = String.format("%.${precision}f", price)
        Timber.d("*** formatted price: $formattedPrice")
        return formattedPrice.toString()
    }
}