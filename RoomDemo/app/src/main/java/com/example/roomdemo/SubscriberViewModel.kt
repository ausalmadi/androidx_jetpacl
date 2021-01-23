package com.example.roomdemo

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import db.Subscriber
import db.SubscriberRepository
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository):ViewModel(),Observable {
    val subscribers = repository.subscribers
    @Bindable
    val inputName = MutableLiveData<String>()
    @Bindable
    val inputEmail = MutableLiveData<String>()
    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()
    @Bindable
    val clearAllOrDeleteButtonText = MutableLiveData<String>()
    init {
        clearAllOrDeleteButtonText.value = "Clear All"
        saveOrUpdateButtonText.value = "Save"
    }
        fun saveOrUpdate(){
            val name = inputName.value!!
            val email = inputEmail.value!!
            insert(Subscriber(id = 0,name,email))
            inputEmail.value = null
            inputEmail.value = null
        }
        fun clearOrDelete(){
            deleteAll()
        }
        fun insert(subscriber: Subscriber) = viewModelScope.launch {
            repository.insert(subscriber)
        }

    fun update(subscriber: Subscriber) = viewModelScope.launch {
        repository.updat(subscriber)
    }

    fun delete(subscriber: Subscriber) = viewModelScope.launch {
        repository.delete(subscriber)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}