package com.example.t3_mobile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.t3_mobile.R
import com.example.t3_mobile.model.Medicamento
import com.example.t3_mobile.adapter.MedicamentosAdapter.*

class MedicamentosAdapter(
    private val listaMedicamento: List<Medicamento>
): Adapter<MedicamentoViewHolder>() {
    inner class MedicamentoViewHolder(
        val itemView: View
    ): RecyclerView.ViewHolder(itemView){
        val textNome: TextView = itemView.findViewById(R.id.TV_LM_NOME)
        val textPeriodo: TextView = itemView.findViewById(R.id.TV_LM_PERIODO)
        val textConsumido: TextView = itemView.findViewById(R.id.TV_LM_CONSUMIDO)
        val textResto: TextView = itemView.findViewById(R.id.TV_LM_RESTO)
        val btnEditar: ImageButton = itemView.findViewById(R.id.BTN_LM_EDITAR)
        val btnDeletar: ImageButton = itemView.findViewById(R.id.BTN_LM_DELETAR)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicamentoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val itemView = layoutInflater.inflate(
            R.layout.item_lista_medicamentos,
            parent,
            false
        )

        return MedicamentoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaMedicamento.size
    }

    override fun onBindViewHolder(holder: MedicamentoViewHolder, position: Int) {
        var medicamento = listaMedicamento[position]
        holder.textNome.text = medicamento.nome
        holder.textPeriodo.text = "Proximo horário: ${medicamento.periodo}"
        holder.textResto.text = "${medicamento.unidade_medida} restantes: ${medicamento.qtd_meta}"
        holder.textConsumido.text = "${medicamento.unidade_medida} consumidos(as): ${medicamento.qtd_atual}"
    }
}