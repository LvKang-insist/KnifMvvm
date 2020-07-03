package com.example.module_home

import javax.inject.Inject

class UserAImpl @Inject constructor() : User {
    override fun getName(): String {
        return "345"
    }
}