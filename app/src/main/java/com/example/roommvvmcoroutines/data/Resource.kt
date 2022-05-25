package com.example.roommvvmcoroutines.data

import androidx.annotation.StringRes
import com.example.roommvvmcoroutines.R

data class Resource<out T>(val status: ResourceStatus, val data: T? = null, val error: ErrorType? = null)


enum class ResourceStatus {
    SUCCESS,
    ERROR
}


enum class ErrorType(@StringRes val resourceId: Int) {
    NONE(R.string.not_available),
    EMPTY_FIRST_NAME(R.string.empty_first_name_error),
    INVALID_FORMAT_FIRST_NAME(R.string.invalid_format_first_name_error);
}