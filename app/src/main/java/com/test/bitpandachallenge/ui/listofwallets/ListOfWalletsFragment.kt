package com.test.bitpandachallenge.ui.listofwallets

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.test.bitpandachallenge.R
import com.test.bitpandachallenge.databinding.FragmentListOfWalletsBinding
import com.test.bitpandachallenge.di.ViewModelProviderFactory
import com.test.bitpandachallenge.secondtask.ContactsComponent
import com.test.bitpandachallenge.utils.ClickListener
import dagger.android.support.DaggerFragment
import timber.log.Timber
import javax.inject.Inject

class ListOfWalletsFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    private lateinit var viewModel: ListOfWalletsViewModel
    private lateinit var binding: FragmentListOfWalletsBinding
    private var filter = "none"

    private val adapter = ListOfWalletsAdapter(ClickListener {
        this.findNavController().navigate(
            ListOfWalletsFragmentDirections
                .actionListOfWalletsFragmentToDetailsViewFragment(it)
        )
    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_list_of_wallets,
            container, false
        )

        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this, factory).get(ListOfWalletsViewModel::class.java)


        binding.recyclerViewListOfWalletsFragment.adapter = adapter

        viewModel.wallets("default").observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })

        // Testing second task
        val contacts = ContactsComponent().getRecentContacts()
        for (contact in contacts) {
            Timber.d("* id: ${contact.id}, data: ${contact.data},  last_used: ${contact.last_used.unix} *")
            println(contact.id + " " + contact.data + " " + contact.last_used.unix)
        }
        // Testing second task end

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.fiat_wallet -> {
                filter = "fiat"
            }
            R.id.crypto_wallet -> filter = "crypto"
            R.id.metal_wallet -> filter = "metal"
            R.id.balance -> filter = "balance"
            R.id.default_list -> filter = "default"
        }
        viewModel.wallets(filter).observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        viewModel.wallets(filter).observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

}