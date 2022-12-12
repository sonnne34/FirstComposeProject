package com.sonne.firstcomposeproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sonne.firstcomposeproject.CatgramModel
import kotlin.random.Random

class MainViewModel : ViewModel() {

    private val initialList = mutableListOf<CatgramModel>().apply {
        repeat(500) {
            add(
                CatgramModel(
                    id = it,
                    title = "Catgram $it",
                    isFollowing = Random.nextBoolean()
                )
            )
        }
    }

    private val _catgram = MutableLiveData<List<CatgramModel>>(initialList)
    val catgram: LiveData<List<CatgramModel>> = _catgram

    fun changeIsFollowing(catgram: CatgramModel) {
        val tempCatgram = _catgram.value?.toMutableList() ?: mutableListOf()
        tempCatgram.replaceAll {
            if (it == catgram) {
                it.copy(isFollowing = !it.isFollowing)
            } else {
                it
            }
        }
        _catgram.value = tempCatgram
    }
}