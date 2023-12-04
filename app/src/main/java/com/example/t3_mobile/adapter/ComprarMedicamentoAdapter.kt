package com.example.t3_mobile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.t3_mobile.R
import com.example.t3_mobile.model.ComprarMedicamento
import com.example.t3_mobile.adapter.ComprarMedicamentoAdapter.*

class ComprarMedicamentoAdapter(
    private val listaComprarMedicamento: List<ComprarMedicamento>
): Adapter<ComprarMedicamentoViewHolder>() {

    inner class ComprarMedicamentoViewHolder(
        val itemView: View
    ):ViewHolder(itemView) {
        val textLembrete:TextView = itemView.findViewById(R.id.TV_LC_ITEM)
        val btnEditar:ImageButton = itemView.findViewById(R.id.BTN_LC_EDITAR)
        val btnDeletar:ImageButton = itemView.findViewById(R.id.BTN_LC_DELETE)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComprarMedicamentoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val itemView = layoutInflater.inflate(
            R.layout.item_lista_compras,
            parent,
            false
        )

        return ComprarMedicamentoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaComprarMedicamento.size
    }

    override fun onBindViewHolder(holder: ComprarMedicamentoViewHolder, position: Int) {
        val med = listaComprarMedicamento[position]
        holder.textLembrete.text = "${med.qtd} ${med.nome}"
    }
}