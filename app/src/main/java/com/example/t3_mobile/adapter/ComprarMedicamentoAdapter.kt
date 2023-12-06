package com.example.t3_mobile.adapter

import android.util.Log
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
import com.example.t3_mobile.databinding.ItemListaComprasBinding

class ComprarMedicamentoAdapter(
    val onClickExcluir: (Int) -> Unit,
    val onClickEditar: (ComprarMedicamento) -> Unit
): Adapter<ComprarMedicamentoViewHolder>() {

    private var listaComprarMedicamento: List<ComprarMedicamento> = emptyList()
    fun adicionarLista(lista:List<ComprarMedicamento>) {
        this.listaComprarMedicamento = lista
        notifyDataSetChanged()
    }

    inner class ComprarMedicamentoViewHolder(
        itemListaComprasBinding: ItemListaComprasBinding
    ):ViewHolder(itemListaComprasBinding.root) {
        private val binding: ItemListaComprasBinding
        init {
            binding = itemListaComprasBinding
        }

        fun bind(compra: ComprarMedicamento) {
            binding.TVLCITEM.text = "${compra.qtd} ${compra.nome}"

            binding.BTNLCDELETE.setOnClickListener{
                onClickExcluir(compra.id)
            }

            binding.BTNLCEDITAR.setOnClickListener{
                onClickEditar(compra)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComprarMedicamentoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val itemListaComprasBinding = ItemListaComprasBinding.inflate(
            layoutInflater,
            parent,
            false
        )

        return ComprarMedicamentoViewHolder(itemListaComprasBinding)
    }

    override fun getItemCount(): Int {
        return listaComprarMedicamento.size
    }

    override fun onBindViewHolder(holder: ComprarMedicamentoViewHolder, position: Int) {
        val med = listaComprarMedicamento[position]
        holder.bind(med)
    }
}