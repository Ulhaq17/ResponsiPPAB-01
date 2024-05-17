package com.l0122095.ulhaq.responsippab01.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.l0122095.ulhaq.responsippab01.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textProfile1: TextView = binding.textProfile1
        val textProfile2: TextView = binding.textProfile2
        val textProfile3: TextView = binding.textProfile3
        val textProfile4: TextView = binding.textProfile4
        val textProfile5: TextView = binding.textProfile5
        val textProfile6: TextView = binding.textProfile6
        val textProfile7: TextView = binding.textProfile7


        profileViewModel.textProfile1.observe(viewLifecycleOwner) {
            textProfile1.text = it
        }

        profileViewModel.textProfile2.observe(viewLifecycleOwner) {
            textProfile2.text = it
        }

        profileViewModel.textProfile3.observe(viewLifecycleOwner) {
            textProfile3.text = it
        }

        profileViewModel.textProfile4.observe(viewLifecycleOwner) {
            textProfile4.text = it
        }

        profileViewModel.textProfile5.observe(viewLifecycleOwner) {
            textProfile5.text = it
        }

        profileViewModel.textProfile6.observe(viewLifecycleOwner) {
            textProfile6.text = it
        }

        profileViewModel.textProfile7.observe(viewLifecycleOwner) {
            textProfile7.text = it
        }


        val myButton = binding.buttonShareProfile
        myButton.setOnClickListener {
            onButtonClick()
        }

        return root
    }

    private fun onButtonClick() {
        val name = binding.textProfile2.text.toString()
        val nim = binding.textProfile3.text.toString()
        val prodiangkatan = binding.textProfile4.text.toString()
        val fakultas = binding.textProfile5.text.toString()
        val universitas = binding.textProfile6.text.toString()
        val email = binding.textProfile7.text.toString()
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"

        val message = "Name: $name\nNIM: $nim\nProdi, Angkatan: $prodiangkatan\n "+
                "Fakultas: $fakultas\nUniversitas: $universitas\nEmail: $email"

        intent.putExtra(Intent.EXTRA_TEXT, message)

        val chooser = Intent.createChooser(intent, "Pilih Aplikasi")
        startActivity(chooser)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}