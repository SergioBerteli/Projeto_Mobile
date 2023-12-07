package com.example.t3_mobile.databse

import android.content.ContentValues
import android.content.Context
import android.provider.ContactsContract.Data
import android.util.Log
import com.example.t3_mobile.model.Usuario

class PerfilDAO(context: Context): IPerfilDao {
    private val escrita = DatabaseHelper(context).writableDatabase
    private val leitura = DatabaseHelper(context).readableDatabase
    override fun salvar(perfil: Usuario): Boolean {

        val valores = ContentValues()
        valores.put(DatabaseHelper.TP_NOME, perfil.nome)
        valores.put(DatabaseHelper.TP_IDADE, perfil.idade)
        valores.put(DatabaseHelper.TP_GENERO, perfil.genero)
        try {
            escrita.insert(
                DatabaseHelper.TABLE_PERFIL,
                null,
                valores
            )
            Log.i("database", "Perfil adicionado à tabela" +
                    " ${DatabaseHelper.TABLE_PERFIL}")
        } catch (e: Exception) {
            Log.i("database", "Erro ao adicionar Perfil à tabela ${DatabaseHelper.TABLE_PERFIL}")
            return false
        }
        return true
    }

    override fun atualizar(perfil: Usuario): Boolean {
        val args = arrayOf(perfil.id.toString())
        val conteudo = ContentValues()
        conteudo.put(DatabaseHelper.TP_NOME, perfil.nome)
        conteudo.put(DatabaseHelper.TP_IDADE, perfil.idade)
        conteudo.put(DatabaseHelper.TP_GENERO, perfil.genero)

        try {
            escrita.update(
                DatabaseHelper.TABLE_PERFIL,
                conteudo,
                "${DatabaseHelper.TP_COD} = ?",
                args
            )
        } catch (e: Exception) {

            return false
        }
        return true
    }

    override fun deletar(id: Int): Boolean {
        val args = arrayOf(id.toString())
        try {
            escrita.delete(
                DatabaseHelper.TABLE_PERFIL,
                "${DatabaseHelper.TP_COD} = ?",
                args
            )
        } catch (e: Exception) {
            Log.i("database", "Erro ao deletar registro.")
            return false
        }
        Log.i("database", "Registro deletado com sucesso.")
        return true
    }

    override fun listar(): List<Usuario> {
        val listaPerfis = ArrayList<Usuario>()

        val sql = "SELECT * FROM ${DatabaseHelper.TABLE_PERFIL}"
        val cursor = leitura.rawQuery(sql, null)

        val iCodigo = cursor.getColumnIndex(DatabaseHelper.TP_COD)
        val iNome = cursor.getColumnIndex(DatabaseHelper.TP_NOME)
        val iIdade = cursor.getColumnIndex(DatabaseHelper.TP_IDADE)
        val iGenero = cursor.getColumnIndex(DatabaseHelper.TP_GENERO)

        while (cursor.moveToNext()) {
            val codPerfil = cursor.getInt(iCodigo)
            val nome = cursor.getString(iNome)
            val idade = cursor.getInt(iIdade)
            val genero = cursor.getString(iGenero)

            listaPerfis.add(
                Usuario(codPerfil, nome, genero, idade)
            )

            Log.i("database", "Usuario ${nome} adicionado ao banco de dados")
        }

        return listaPerfis
    }

}