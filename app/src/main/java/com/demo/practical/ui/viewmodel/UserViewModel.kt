package com.demo.practical.ui.viewmodel

import com.demo.practical.data.pojo.Data
import com.demo.practical.data.repository.UserRepository
import com.demo.practical.ui.base.APILiveData
import com.demo.practical.ui.base.BaseViewModel
import javax.inject.Inject

class UserViewModel @Inject constructor(private val userRepository: UserRepository) : BaseViewModel() {

    val userLiveData = APILiveData<Data>()

    fun getImages() {
        userRepository.getImages()
    }
}