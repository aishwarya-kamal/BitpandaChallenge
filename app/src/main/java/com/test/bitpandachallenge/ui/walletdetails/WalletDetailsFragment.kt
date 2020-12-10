package com.test.bitpandachallenge.ui.walletdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.test.bitpandachallenge.R
import com.test.bitpandachallenge.databinding.FragmentWalletDetailsBinding
import com.test.bitpandachallenge.di.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class WalletDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    private lateinit var viewModelWalletDetails: WalletDetailsViewModel
    private lateinit var binding: FragmentWalletDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_wallet_details,
            container, false
        )

        binding.lifecycleOwner = this

        viewModelWalletDetails =
            ViewModelProvider(this, factory).get(WalletDetailsViewModel::class.java)

        val args = WalletDetailsFragmentArgs.fromBundle(requireArguments())

        binding.textViewPriceDetailsViewFragment.text = resources
            .getString(
                R.string.price_details_view, viewModelWalletDetails.convertToPriceWithPrecision(
                    args.domain.price, args.domain.precision
                ).toString()
            )

        return binding.root

    }

}