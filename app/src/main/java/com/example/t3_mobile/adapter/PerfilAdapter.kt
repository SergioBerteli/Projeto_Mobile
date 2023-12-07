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
import com.example.t3_mobile.databinding.ItemListaUsuarioBinding

class PerfilAdapter(
    val onClickExcluir: (Int) -> Unit,
    val onClickEditar: (Usuario) -> Unit
): Adapter<UsuarioViewHolder>() {
    private var listaUsuario: List<Usuario> = emptyList()

    fun adicionarLista(lista:List<Usuario>){
        this.listaUsuario = lista
        notifyDataSetChanged()
    }

    inner class  UsuarioViewHolder(
        itemListaPerfilBinding: ItemListaUsuarioBinding
    ): ViewHolder(itemListaPerfilBinding.root){

        private val binding: ItemListaUsuarioBinding
        init {
            binding = itemListaPerfilBinding
        }

        fun bind(perfil: Usuario){
            binding.TVLPNome.text = perfil.nome
            binding.TVLPGenero.text = perfil.genero
            binding.TVLPIDADE.text = perfil.idade.toString()

            binding.BTNLPDELETAR.setOnClickListener{
                onClickExcluir(perfil.id)
            }

            binding.BTNLPEDITAR.setOnClickListener{
                onClickEditar(perfil)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val itemListaPerfilBinding = ItemListaUsuarioBinding.inflate(
            layoutInflater,
            parent,
            false
        )

        return UsuarioViewHolder(itemListaPerfilBinding)
    }

    override fun getItemCount(): Int {
        return listaUsuario.size
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = listaUsuario[position]
        holder.bind(usuario)
    }
}