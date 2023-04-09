package com.aliahmed.data.repository

class ApiException(val code: String? = null, message: String? = null, localMessage: String? = null) : RuntimeException(message)
