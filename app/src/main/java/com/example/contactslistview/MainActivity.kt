
package com.example.contactslistview

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val contacts = mutableListOf(
        "Ahmed Ben Ali",
        "Sarra Trabelsi",
        "Mohamed Gharbi",
        "Ines Jaziri",
        "Youssef Mansouri",
        "Amira Chaabane",
        "Karim Bouazizi",
        "Nour Hammami"
    )

    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var etContact: EditText
    private lateinit var btnModifier: Button
    private lateinit var lvContacts: ListView

    private var positionSelectionnee = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etContact = findViewById(R.id.etContact)
        btnModifier = findViewById(R.id.btnModifier)
        lvContacts = findViewById(R.id.lvContacts)

        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_activated_1,
            contacts
        )

        lvContacts.adapter = adapter

        lvContacts.setOnItemClickListener {
                _, _, position, _ ->
            positionSelectionnee = position
            lvContacts.setItemChecked(position, true)
            etContact.setText(contacts[position])
            etContact.setSelection(etContact.text.length)
        }

        btnModifier.setOnClickListener {
            modifierContact()
        }

        etContact.setOnEditorActionListener {
                _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                modifierContact()
                true
            } else {
                false
            }
        }
    }

    private fun modifierContact() {
        if (positionSelectionnee == -1) {
            Toast.makeText(
                this,
                "Sélectionnez d'abord un contact",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val nouveauNom = etContact.text.toString().trim()

        if (nouveauNom.isEmpty()) {
            etContact.error = "Le nom ne peut pas être vide"
            return
        }

        contacts[positionSelectionnee] = nouveauNom
        adapter.notifyDataSetChanged()

        Toast.makeText(
            this,
            "Contact modifié : $nouveauNom",
            Toast.LENGTH_SHORT
        ).show()
    }
}
