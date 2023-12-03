package com.example.t3_mobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.t3_mobile.model.Medicamento

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MedicamentosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MedicamentosFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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

        val listaMedicamentos = listOf(
            Medicamento(1, "med a", "12:00", 1, 2, "quilogramas"),
            Medicamento(2, "med b", "02:00", 1, 3, "comprimidos"),
            Medicamento(3, "med c", "04:00", 3, 1, "mililitros"),
            Medicamento(4, "med d", "12:00", 7, 2, "quilos"),
            Medicamento(5, "med e", "12:00", 1, 2, "quilos")
        )

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_medicamentos, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MedicamentosFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MedicamentosFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}