package com.l0122095.ulhaq.responsippab01.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _textHome1 = MutableLiveData<String>().apply {
        value = "PirateCinema"
    }
    private val _textHome2 = MutableLiveData<String>().apply {
        value = "PirateCinema is an application that contains a list of films for which you can watch the trailers"
    }

    val textHome1: LiveData<String> = _textHome1
    val textHome2: LiveData<String> = _textHome2

}