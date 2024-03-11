package com.bing.bing.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bing.bing.http.Http
import com.bing.bing.model.SignupModel
import com.bing.bing.model.SignupRequest
import com.bing.bing.model.SignupResult
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch


class SignupViewModel: ViewModel() {

    private val _signupResult: MutableSharedFlow<SignupResult> = MutableSharedFlow()
    val signupResult = _signupResult.asSharedFlow()

    suspend fun signup(result: SignupRequest) {
       viewModelScope.launch {
           flow<SignupModel> {
               val model = Http.api.signup(result)
               Log.e("message",model.code.toString())
               if (model.code == 200) {
                   _signupResult.emit(model.result!!)
               }
               Log.e("message",model.message)
           }.onStart {

           }.catch {

           }.collect()
       }
    }

}