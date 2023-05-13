package com.example.helix.utils

import java.util.regex.Pattern

fun isEmailValid(email: String): Boolean {
    val emailRegex = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,}$"
    return email.matches(Regex(emailRegex, RegexOption.IGNORE_CASE))
}

fun isFullNameValid(fullname: String): Boolean{
    val fullNameRegex =  "^[a-zA-Z]+( [a-zA-Z]+)*$"
    return fullname.matches(Regex(fullNameRegex));
}