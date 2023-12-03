package com.example.t3_mobile.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Medicamento (
    var id: Int,
    var nome: String,
    var periodo: String,
    var qtd_atual: Int,
    var qtd_meta: Int,
    var unidade_medida: String
) : Parcelable

