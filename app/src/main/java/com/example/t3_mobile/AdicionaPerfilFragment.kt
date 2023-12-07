package com.example.t3_mobile

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.t3_mobile.databinding.FragmentAdicionaPerfilBinding
import com.example.t3_mobile.databse.PerfilDAO
import com.example.t3_mobile.model.Usuario

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AdicionaPerfilFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AdicionaPerfilFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentAdicionaPerfilBinding? = null

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
        _binding = FragmentAdicionaPerfilBinding.inflate(inflater, container, false)
        val view = binding.root

        var perfil: Usuario? = null
        var bundle = arguments

        if (bundle!= null) {
            if (Build.VERSION.SDK_INT >= 33) {
                perfil = bundle.getParcelable("perfil", Usuario::class.java)
                if (perfil!=null) {
                    val codigo = perfil.id
                    binding.inpTIAPGENERO.setText(perfil.genero)
                    binding.inpTIAPIDADE.setText(perfil.idade)
                    binding.inpTvApNome.setText(perfil.nome)
                }
            }else {
                perfil = bundle.getParcelable("perfil")
                if (perfil != null) {
                    val codigo = perfil.id
                    binding.inpTIAPGENERO.setText(perfil.genero)
                    binding.inpTIAPIDADE.setText(perfil.idade.toString())
                    binding.inpTvApNome.setText(perfil.nome)
                }
            }
        }

        /*
        *
        * */
        _binding!!.btnAPCOMMIT.setOnClickListener {
            if (perfil!=null) {
                editar(perfil)

            } else {
                salvar()
            }
        }
        return view
    }

    private fun editar(perfil: Usuario) {
        val codigo: Int = perfil.id
        val nome: String = binding.inpTvApNome.text.toString()
        val idade:Int = binding.inpTIAPIDADE.text.toString().toInt()
        val genero:String = binding.inpTIAPGENERO.text.toString()

        val perfilAtualizado = Usuario(codigo, nome, genero, idade)

        val perfilDao = PerfilDAO(requireContext())

        if (perfilDao.atualizar(perfilAtualizado)){
            Log.i("database", "Perfil ${perfilAtualizado.nome} atualziado com sucesso")
        } else {
            Log.i("database", "Falha ao atualziar perfil de ${perfilAtualizado.nome}")
        }

        replaceFragment(PerfisFragment())
    }

    private fun salvar(){
        val perfilDao = PerfilDAO(requireContext())
        val usuario = Usuario(
            -1,
            _binding!!.inpTvApNome.text.toString(),
            _binding!!.inpTIAPGENERO.text.toString(),
            _binding!!.inpTIAPIDADE.text.toString().toInt()
        )

        if (perfilDao.salvar(usuario)){
            Log.i("database", "Perfil ${usuario.nome} salvo com sucesso")
        } else {
            Log.i("database", "Erro ao salver ${usuario.nome}.")
        }

        replaceFragment(PerfisFragment())
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
         * @return A new instance of fragment AdicionaPerfilFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AdicionaPerfilFragment().apply {
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