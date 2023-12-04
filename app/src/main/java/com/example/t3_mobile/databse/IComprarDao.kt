package com.example.t3_mobile.databse

import com.example.t3_mobile.model.ComprarMedicamento

interface IComprarDao {
    fun salvar(compras: ComprarMedicamento):Boolean
    fun atualizar(compras: ComprarMedicamento): Boolean
    fun deletar(id: Int): Boolean
    fun listar(): List<ComprarMedicamento>
}