package com.example.pruebabetterfly.core.entities

import java.util.*
import kotlin.collections.ArrayList

data class ECharacter (val id:Int, val name:String, val status:String, val species:String,
                       val type:String,val gender:String,val origin:EOriginCharacter,
                       val location:ELocation, val image:String,val episode:ArrayList<String>,
                       val url:String,val created:Date)