package com.example.t3_mobile.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ComprarMedicamento (
    var id: Int,
    var nome: String,
    var qtd: Int
): Parcelable