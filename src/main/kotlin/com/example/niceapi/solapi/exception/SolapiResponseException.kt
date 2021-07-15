package com.example.niceapi.solapi.exception

import retrofit2.HttpException

class SolapiResponseException(
    error: String,
    exception: HttpException
) : Exception(error, exception)