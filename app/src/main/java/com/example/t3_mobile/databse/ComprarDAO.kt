package com.example.t3_mobile.databse

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.t3_mobile.ListaComprasFragment
import com.example.t3_mobile.model.ComprarMedicamento

class ComprarDAO(
    context: Context
): IComprarDao {
    private val escrita = DatabaseHelper(context).writableDatabase
    private val leitura = DatabaseHelper(context).readableDatabase
    override fun salvar(compras: ComprarMedicamento): Boolean {
        val valores = ContentValues()
        valores.put(DatabaseHelper.TC_NOME, compras.nome)
        valores.put(DatabaseHelper.TC_QTD, compras.qtd)
        try {
            escrita.insert(
                DatabaseHelper.TABLE_COMPRAS,
                null,
                valores
            )
            Log.i("database", "Medicamento a ser comprado adicionado à tabela" +
                    " ${DatabaseHelper.TABLE_COMPRAS}")
        } catch (e: Exception) {
            Log.i("database", "Erro ao adicionar medicamento a ser comprado à tabela ${DatabaseHelper.TABLE_COMPRAS}")
            return false
        }
        return true
    }

    override fun atualizar(compras: ComprarMedicamento): Boolean {
        try {

        } catch (e: Exception) {

            return false
        }
        return true
    }

    override fun deletar(id: Int): Boolean {
        val args = arrayOf(id.toString())
        try {
            escrita.delete(
                DatabaseHelper.TABLE_COMPRAS,
                "${DatabaseHelper.TC_COD} = ?",
                args
            )
        } catch (e: Exception) {
            Log.i("database", "Erro ao deletar registro.")
            return false
        }
        Log.i("database", "Registro deletado com sucesso.")
        return true
    }

    override fun listar(): List<ComprarMedicamento> {
        val listaCompras = ArrayList<ComprarMedicamento>()

        val sql = "SELECT * FROM ${DatabaseHelper.TABLE_COMPRAS}"
        val cursor = leitura.rawQuery(sql, null)

        val iCodigo = cursor.getColumnIndex(DatabaseHelper.TC_COD)
        val iNome = cursor.getColumnIndex(DatabaseHelper.TC_NOME)
        val iQtd = cursor.getColumnIndex(DatabaseHelper.TC_QTD)

        while (cursor.moveToNext()){
            val codCompra = cursor.getInt(iCodigo)
            val nome = cursor.getString(iNome)
            val qtd = cursor.getInt(iQtd)

            listaCompras.add(
                ComprarMedicamento(codCompra, nome, qtd)
            )
            Log.i("database", "Medicamento $nome adicionado à lista")
        }

        return listaCompras
    }


}