package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.databinding.FragmentListingFragmentBinding
import com.udacity.shoestore.databinding.NewlayoutBinding
import com.udacity.shoestore.models.Shoe


class listing_fragment : Fragment() {

    private val viewModel:DetailsFragmentViewmodel by activityViewModels()
    var shoe: Shoe = Shoe("","","","")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentListingFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_listing_fragment, container, false
        )

        //viewModel= ViewModelProvider(this).get(DetailsFragmentViewmodel::class.java)
        Log.i("this","view model is created")

        binding.setLifecycleOwner (this)

        viewModel.shoelist.observe (viewLifecycleOwner, Observer{ shoelist ->
            for (shoe in shoelist) {
// inflate layouts with shoe info for each one
                DataBindingUtil.inflate<NewlayoutBinding>(layoutInflater, R.layout.newlayout, binding.Linearlayout1,true)
                    .apply { this.shoemodel = shoe }
        }})

        binding.actionbutton2.setOnClickListener {
            findNavController().navigate(listing_fragmentDirections.actionListingFragmentToDetailsFragment())
        }
        return binding.root
    }

    //val shoeargs by navArgs<ScoreFragmentArgs>()
    //binding.scoreText.text = shoeargs.score.toString()

    //should initialize the array....
}