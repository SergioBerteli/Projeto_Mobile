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
    2
) {

    companion object{
        const val NOME_BANCO = "cuideDeMim"

        const val TABLE_COMPRAS = "ComprarMedicamento"
        const val TC_COD = "id"
        const val TC_NOME = "nome"
        const val TC_QTD = "qtd"

        const val TABLE_PERFIL = "PerfilTable"
        const val TP_COD = "cod"
        const val TP_NOME = "nome"
        const val TP_IDADE = "idade"
        const val TP_GENERO = "genero"
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

        val sqlPerfil  = "CREATE TABLE PerfilTable(" +
                "cod integer PRIMARY KEY AUTOINCREMENT," +
                "nome varchar(100) NOT NULL," +
                "genero varchar(100) NOT NULL," +
                "idade integer NOT NULL" +
                ");"

        try {
            db?.execSQL(sqlPerfil)
            Log.i("database", "Sucesso ao criar a tabela")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("database", "Erro ao criar a tabela")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}