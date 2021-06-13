package com.example.pruebabetterfly.presenter.utils.validators

object Validator {
    fun  validateInput(postId:String):Boolean{
        return postId.isBlank()
    }
}