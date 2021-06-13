package com.example.pruebabetterfly.infrastructure.remote.model

data class ResponseApiRickMorty <T> (val results:T, val info:Info)
data class Info(val count:Int, val pages:Int,val next:String,val prev:String)