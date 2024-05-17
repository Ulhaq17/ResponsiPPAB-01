package com.l0122095.ulhaq.responsippab01.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    private val _textProfile1 = MutableLiveData<String>().apply {
        value = "Profile"
    }

    private val _textProfile2 = MutableLiveData<String>().apply {
        value = "Mochammad Dhiya Ulhaq"
    }

    private val _textProfile3 = MutableLiveData<String>().apply {
        value = "L0122095"
    }

    private val _textProfile4 = MutableLiveData<String>().apply {
        value = "Informatika, 2022"
    }

    private val _textProfile5 = MutableLiveData<String>().apply {
        value = "Fakultas Teknologi Informasi & Sains Data"
    }

    private val _textProfile6 = MutableLiveData<String>().apply {
        value = "Universitas Sebelas Maret"
    }

    private val _textProfile7 = MutableLiveData<String>().apply {
        value = "ulhaqmdhiya04@student.uns.ac.id"
    }

    val textProfile1: LiveData<String> = _textProfile1
    val textProfile2: LiveData<String> = _textProfile2
    val textProfile3: LiveData<String> = _textProfile3
    val textProfile4: LiveData<String> = _textProfile4
    val textProfile5: LiveData<String> = _textProfile5
    val textProfile6: LiveData<String> = _textProfile6
    val textProfile7: LiveData<String> = _textProfile7
}