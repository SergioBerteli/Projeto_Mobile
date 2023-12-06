package com.example.t3_mobile

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t3_mobile.adapter.ComprarMedicamentoAdapter
import com.example.t3_mobile.databinding.FragmentListaComprasBinding
import com.example.t3_mobile.databse.ComprarDAO
import com.example.t3_mobile.model.ComprarMedicamento

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListaComprasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */



class ListaComprasFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentListaComprasBinding? = null


    private val binding get() = _binding!!

    private var listaCompras = emptyList<ComprarMedicamento>()
    private var comprarMedicamentoAdapter: ComprarMedicamentoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var modo: Boolean = true

        _binding = FragmentListaComprasBinding.inflate(inflater, container, false)
        val view = binding.root

        // Inserção
        _binding!!.BTNLCCOMMIT.setOnClickListener {
            val comprarDao = ComprarDAO(requireContext())
            val compra = ComprarMedicamento(
                -1,
                _binding!!.inpTILCNOME.text.toString(),
                _binding!!.inpTILCQTD.text.toString().toInt()
            )
            if (comprarDao.salvar(compra)){
                Log.i("database", "Medicamento ${compra.nome} inserido")
            } else {
                Log.i("database", "Erro ao salver ${compra.nome}.")
            }

            atualizarListaCompras()
            reloadFragment()
        }




        comprarMedicamentoAdapter = ComprarMedicamentoAdapter(
            {codigo -> confirmarExclusao(codigo)},
            {comprarMedicamento -> editar(comprarMedicamento)}
        )
        binding.RVLC.adapter = comprarMedicamentoAdapter
        binding.RVLC.layoutManager = LinearLayoutManager(view.context)



        // Inflate the layout for this fragment
        return view
    }

    private fun editar(compra: ComprarMedicamento) {
        binding.inpTILCNOME.setText(compra.nome)
        binding.inpTILCQTD.setText(compra.qtd.toString())
    }

    private fun confirmarExclusao(codigo: Int) {



        val alertBuilder = AlertDialog.Builder(requireContext())

        alertBuilder.setTitle("Confirmar exclusão")
        alertBuilder.setMessage("Deseja excluir a compra?")
        alertBuilder.setPositiveButton("Sim"){_, _->

            val compraDAO = ComprarDAO(requireContext())
            compraDAO.deletar(codigo)
            atualizarListaCompras()
        }

        alertBuilder.setNegativeButton("Não"){_, _->}
        alertBuilder.create().show()

        reloadFragment()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListaComprasFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListaComprasFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun atualizarListaCompras(){
        val comprarDAO = ComprarDAO(requireContext())
        listaCompras = comprarDAO.listar()
        comprarMedicamentoAdapter?.adicionarLista(listaCompras)
    }

    override fun onStart() {
        super.onStart()
        atualizarListaCompras()
    }

    private fun reloadFragment(){
        val fragmentManager = parentFragmentManager
        var frq = fragmentManager.findFragmentById(this.id)
        val ft: FragmentTransaction = fragmentManager.beginTransaction()
        if (frq != null) {
            ft.detach(frq)
            ft.attach(frq)
        }
        ft.commit()


    }
}