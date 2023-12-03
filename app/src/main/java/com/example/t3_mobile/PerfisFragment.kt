package com.example.t3_mobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.t3_mobile.adapter.PerfilAdapter
import com.example.t3_mobile.databinding.FragmentPerfisBinding
import com.example.t3_mobile.model.Usuario

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PerfisFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PerfisFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private var _binding: FragmentPerfisBinding? = null


    private val binding get() = _binding!!

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
        _binding = FragmentPerfisBinding.inflate(inflater, container, false)
        val view = binding.root

        _binding!!.btnAddPerfil.setOnClickListener {
            replaceFragment(AdicionaPerfilFragment())
        }

        val listaUsuario = listOf(
            Usuario(1, "Jonas", "Homem", 21),
            Usuario(2, "Paulo", "Homem", 29),
            Usuario(3, "Sergio", "Homem", 40),
            Usuario(4, "Ana", "Mulher", 18),
            Usuario(5, "Hevnadro", "Mulher", 24)
        )
        var recyclerUsuario = _binding!!.RVP
        recyclerUsuario.adapter = PerfilAdapter(listaUsuario)
        recyclerUsuario.layoutManager = LinearLayoutManager(view.context)

        recyclerUsuario.addItemDecoration(DividerItemDecoration(
            view.context,
            RecyclerView.VERTICAL
        ))

        return view
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PerfisFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PerfisFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager= parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainframe,fragment)
        fragmentTransaction.commit()
    }
}