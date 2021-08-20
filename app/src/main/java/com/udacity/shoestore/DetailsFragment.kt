package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.models.Shoe


class DetailsFragment : Fragment() {

    private val viewModel: DetailsFragmentViewmodel by activityViewModels()
    var shoe:Shoe= Shoe("","","","") 
    


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding: FragmentDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_details, container, false
        )

        binding.shoemodel=shoe


        binding.button.setOnClickListener {
            oncancel()
        }

        binding.button2.setOnClickListener {
          // shoe.name= (binding.shoenametext).text.toString()
          // shoe.size= (binding.shoesizetext).text.toString()
          // shoe.company= (binding.shoecompanytext).text.toString()
           // shoe.description= (binding.shoedescriptiontext).text.toString()
            onsave()
        }

    return binding.root
}
    private fun onsave(){
        findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToListingFragment())
       viewModel.saveshoe(shoe)
        println(shoe.name)


    }
    private fun oncancel(){
        findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToListingFragment())
    }
    }
