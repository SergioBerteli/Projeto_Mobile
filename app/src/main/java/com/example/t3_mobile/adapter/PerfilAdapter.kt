package com.example.t3_mobile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.t3_mobile.R
import com.example.t3_mobile.model.Usuario
import com.example.t3_mobile.adapter.PerfilAdapter.*

class PerfilAdapter(
    private val listaUsuario: List<Usuario>
): Adapter<UsuarioViewHolder>() {

    inner class  UsuarioViewHolder(
        val itemView: View
    ): ViewHolder(itemView){
        val textNome:TextView = itemView.findViewById(R.id.TV_LP_nome)
        val textIdade:TextView = itemView.findViewById(R.id.TV_LP_IDADE)
        val textGenero:TextView = itemView.findViewById(R.id.TV_LP_genero)
        val btnEditar:ImageButton = itemView.findViewById(R.id.BTN_LP_EDITAR)
        val btnEntrar:ImageButton = itemView.findViewById(R.id.btn_LP_ENTRAR)
        val btnDeletar:ImageButton = itemView.findViewById(R.id.BTN_LP_DELETAR)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val itemView = layoutInflater.inflate(
            R.layout.item_lista_medicamentos,
            parent,
            false
        )

        return UsuarioViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaUsuario.size
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = listaUsuario[position]
        holder.textNome.text = "Nome: ${usuario.nome}"
        holder.textIdade.text = "Idade: ${usuario.idade.toString()} anos"
        holder.textGenero.text = "Genero: ${usuario.genero}"
        holder.btnEditar.setOnClickListener{
            Toast.makeText(
                holder.textNome.context, "Editar ${usuario.nome}", Toast.LENGTH_LONG
            ).show()
        }
    }

}