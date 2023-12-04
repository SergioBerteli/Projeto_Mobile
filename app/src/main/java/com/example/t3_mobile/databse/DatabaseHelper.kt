package com.example.t3_mobile.databse

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper (
    context : Context
): SQLiteOpenHelper(
    context,
    "cuideDeMim",
    null,
    1
) {

    companion object{
        const val NOME_BANCO = "cuideDeMim"
        const val TABLE_COMPRAS = "ComprarMedicamento"
        const val TC_COD = "id"
        const val TC_NOME = "nome"
        const val TC_QTD = "qtd"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "CREATE TABLE ComprarMedicamento (" +
                "id integer PRIMARY KEY AUTOINCREMENT," +
                "nome varchar(100) NOT NULL," +
                "qtd integer NOT NULL" +
                ");"
        try {
            db?.execSQL(sql)
            Log.i("database", "Sucesso ao criar a tabela")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("database", "Erro ao criar a tabela")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}