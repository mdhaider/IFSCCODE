package com.nehal.ifsccode.repository


import com.nehal.ifsccode.model.IfscResponse
import com.nehal.ifsccode.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PostRepository {

    fun getPost(ifsc:String): Flow<IfscResponse> = flow {
        val postList = RetrofitBuilder.ROUTES.getPost(ifsc)
        emit(postList)
    }.flowOn(Dispatchers.IO)
}