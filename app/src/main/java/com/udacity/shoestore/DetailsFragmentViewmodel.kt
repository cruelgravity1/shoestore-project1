package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class DetailsFragmentViewmodel: ViewModel() {


    private val _shoelist = MutableLiveData<MutableList<Shoe>>()
    val shoelist: LiveData<MutableList<Shoe>>
        get() = _shoelist

    //     val shoemodel = MutableLiveData<Shoe>()
//     val shoemodel: LiveData<Shoe>
//        get() = _shoemodel

    init {
        _shoelist.value = initializewithsample()
    }

    fun saveshoe(shoe: Shoe?) {
        shoe?.let {
            _shoelist.value?.add(it)
        }

    }

    private fun initializewithsample(): MutableList<Shoe> {
        return mutableListOf(
            Shoe("Ekin", "10", "Nike", "nice shoes"),
            Shoe("yellowfloats", "10", "banana", "even nicer")
        )
    }
}