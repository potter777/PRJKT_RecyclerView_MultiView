package me.projekt401.projkt.ui.secondScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.projekt401.projkt.models.Base
import me.projekt401.projkt.network.FakeApiBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class SecondScreenViewModel : ViewModel() {

    companion object {
        const val IN_PROGRESS = "IN_PROGRESS"
        const val SUCCESS = "SUCCESS"
        const val ERROR = "ERROR"
    }

    private val _requestStatus = MutableLiveData<String>()
    val requestStatus : LiveData<String>
        get() = _requestStatus

    private val _questionsInfo = MutableLiveData<Base>()
    val questionsInfo : LiveData<Base>
        get() = _questionsInfo

    fun getQuestions() {
        _requestStatus.postValue(IN_PROGRESS)
        FakeApiBuilder.retrofitServiceBuilder.getQuestions().enqueue( object : Callback<Base> {
            override fun onFailure(call: Call<Base>, t: Throwable) {
                _requestStatus.postValue(ERROR)
            }

            override fun onResponse(call: Call<Base>, response: Response<Base>) {
                if (response.isSuccessful) {
                    _questionsInfo.postValue(response.body() as Base)
                    _requestStatus.postValue(SUCCESS)
                } else {
                    _requestStatus.postValue(ERROR)
                }
            }

        } )
    }

    init {
        Timber.i("SecondScreenViewModel created...")
        _questionsInfo.postValue(null)
    }
}