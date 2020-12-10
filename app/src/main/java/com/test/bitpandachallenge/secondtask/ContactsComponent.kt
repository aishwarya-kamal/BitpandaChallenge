package com.test.bitpandachallenge.secondtask

class ContactsComponent {

    /**
     * in the live code this is set after the view loaded; you can assume that this won't be null or empty
     * you can mock or change this if you want
     */
    private var contacts: List<Contact> = listOf(
        Contact("0", "A"),
        Contact("4", "A"),
        Contact("1", "C"),
        Contact("1", "A"),
        Contact("2", "B"),
        Contact("3", "D")
    )

    val lastUsed = Comparator<Contact> { contact1, contact2 ->
        when {
            contact1.last_used.unix > contact2.last_used.unix -> 1
            contact1.last_used.unix == contact2.last_used.unix -> 0
            else -> -1
        }
    }

    /**
     * todo : returned list must
     *  1. hold only unique entries (data NOT id)
     *  2. hold max three entries
     *  3. sorted by "last_used" (if you use a custom sort, i'd suggest to use the unix timestamp)
     */
    fun getRecentContacts(): List<Contact> {
        return contacts
            .distinctBy { it.data }
            .take(3)
            .sortedWith(lastUsed)
    }
}