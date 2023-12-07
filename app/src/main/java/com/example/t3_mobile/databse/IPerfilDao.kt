package com.example.t3_mobile.databse

import com.example.t3_mobile.model.Usuario

interface IPerfilDao {
    fun salvar(perfil: Usuario): Boolean
    fun atualizar(perfil: Usuario): Boolean
    fun deletar(id: Int):Boolean
    fun listar():List<Usuario>
}