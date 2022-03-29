package com.generation.task4e5

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.generation.task4e5.databinding.FragmentSegundoBinding
import com.generation.task4e5.model.Temas

class SegundoFragment : Fragment() {

    private lateinit var binding : FragmentSegundoBinding
    private val mainViewmodel : MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentSegundoBinding.inflate(layoutInflater, container, false)

        mainViewmodel.listTemas()

        mainViewmodel.myTemasResponse.observe(viewLifecycleOwner){
            response -> Log.d("Requisicao", response.body().toString())
            spinnerTemas(response.body())


        }


     binding.voltar1.setOnClickListener {

            val autor = binding.editTextTextPersonName.text.toString()
            val titulo = binding.editTextTextPersonName4.text.toString()
            val descricao = binding.editTextTextPersonName3.text.toString()
            val data = binding.editTextTextPersonName6.text.toString()
            val hora = binding.editTextTextPersonName7.text.toString()

            if (autor.isEmpty()|| titulo.isEmpty() ||descricao.isEmpty() || data.isEmpty()  ||hora.isEmpty()) {
                Toast.makeText(
                    context,  "Preencha todos os campos!", Toast.LENGTH_LONG
                ).show()
            } else {

                findNavController().navigate(
                    R.id.action_segundoFragment_to_listFragment


                )
            }
        }


        return binding.root
    }
    fun spinnerTemas(temas: List<Temas>?){

        if(temas != null){
            binding.spinner.adapter = ArrayAdapter(
                requireContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, temas)







        }


    }


}