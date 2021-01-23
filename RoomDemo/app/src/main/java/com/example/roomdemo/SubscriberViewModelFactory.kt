package com.example.roomdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import db.SubscriberRepository
import java.lang.IllegalArgumentException

class SubscriberViewModelFactory(private val repo:SubscriberRepository ):ViewModelProvider.Factory {
     override fun <T : ViewModel?> create(modelClass: Class<T>): T {
         if(modelClass.isAssignableFrom(SubscriberViewModel::class.java)){
             return SubscriberViewModel(repo) as T
         }
         throw IllegalArgumentException("Unkown View Model Class")
     }
 }