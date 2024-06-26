package com.l0122095.ulhaq.responsippab01

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film (
    val name: String,
    val year: String,
    val img: Int,
    val duration: String,
    val desc: String,
    val link: String
) : Parcelable