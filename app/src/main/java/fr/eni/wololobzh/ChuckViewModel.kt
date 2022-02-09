package fr.eni.wololobzh

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.eni.wololobzh.model.Joke
import fr.eni.wololobzh.service.ChuckApi
import kotlinx.coroutines.launch

class ChuckViewModel : ViewModel() {
    val joke = MutableLiveData<Joke>()

    fun randomBlague()
    {
        viewModelScope.launch {
            joke.value = ChuckApi.retrofitServiceChuck.randomFact()
        }
    }
}