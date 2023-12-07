package com.example.t3_mobile.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Usuario (
    var id: Int,
    var nome: String,
    var genero: String,
    var idade: Int
) : Parcelable