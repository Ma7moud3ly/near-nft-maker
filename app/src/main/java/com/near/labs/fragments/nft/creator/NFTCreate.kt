package com.near.labs.fragments.nft.creator

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.children
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.near.labs.R
import com.near.labs.data.NFT
import com.near.labs.data.NFTProperty
import com.near.labs.databinding.FragmentNftCreateBinding
import com.near.labs.databinding.ItemNftPropertyBinding
import com.near.labs.fragments.nft.NFTBase


class NFTCreate : NFTBase() {
    private lateinit var binding: FragmentNftCreateBinding
    private val PICK_FILE = 1
    private var imageUri: Uri? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNftCreateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initCategories()


        binding.nfCreateHeader.headerExit.setOnClickListener { activity?.finish() }

        binding.nftCreateAddMore.setOnClickListener { appendProperty() }

        binding.nftCreateNext.setOnClickListener { getNFTDetails() }

        binding.nftSelectFile.setOnClickListener { pickImage() }


    }

    private fun getNFTDetails() {
        if (imageUri == null) {
            binding.nftSelectFile.setIconResource(R.drawable.circle_un_check)
            binding.nftCreateScroll.scrollTo(0, 0)
            Toast.makeText(
                requireContext(),
                getString(R.string.nft_creator_no_file_msg),
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        val title: String = binding.nftCreateTitle.text.toString()
        if (title.isEmpty()) {
            binding.nftCreateTitle.requestFocus()
            Toast.makeText(
                requireContext(),
                getString(R.string.nft_creator_empty_title_msg),
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        val description: String = binding.nftCreateDescription.text.toString()
        val category: String = binding.nftCreateCategories.selectedItem.toString()
        val properties = readProperties()

        val nft = NFT(
            title = title,
            description = description,
            id = "1234",
            image = "",
            imageUri = imageUri,
            category = category,
            properties = properties
        )

        val action = NFTCreateDirections.actionNFTCreateToNFTPreview(nft = nft)

        findNavController().navigate(action)
    }

    private fun pickImage() {
        val intent = Intent()
        intent.type = "*/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_FILE)
    }

    private fun appendProperty() {
        val container = binding.nftCreatePropertyContainer
        val item: ItemNftPropertyBinding =
            ItemNftPropertyBinding.inflate(LayoutInflater.from(activity))
        container.addView(item.root)
    }

    private fun readProperties(): List<NFTProperty> {
        val properties = mutableListOf<NFTProperty>()
        val container = binding.nftCreatePropertyContainer
        container.children.forEach {
            val key =
                it.findViewById<TextInputEditText>(R.id.nft_create_property_key).text.toString()
            val value =
                it.findViewById<TextInputEditText>(R.id.nft_create_property_value).text.toString()

            if (key.isNotEmpty() && value.isNotEmpty()) properties.add(NFTProperty(key, value))
        }

        return properties
    }

    private fun initCategories() {
        val spinner: Spinner = binding.nftCreateCategories
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.nft_categories,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == PICK_FILE) {
            imageUri = data?.data
            binding.nftSelectFile.setIconResource(R.drawable.circle_check)
        }
    }

}