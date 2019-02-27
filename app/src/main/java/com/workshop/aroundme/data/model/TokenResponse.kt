package com.workshop.aroundme.data.model

data class TokenResponse (
            var token:String,
            var ExpiresIn:Int,
            var tokenType:String)