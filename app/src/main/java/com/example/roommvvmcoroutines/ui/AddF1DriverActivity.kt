package com.example.roommvvmcoroutines.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.roommvvmcoroutines.R
import com.example.roommvvmcoroutines.data.ErrorType
import com.example.roommvvmcoroutines.data.ResourceStatus
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddF1DriverActivity : AppCompatActivity() {

    private val addF1DriverViewModel: AddF1DriverViewModel by viewModels()

    private lateinit var rootContainer: View
    private lateinit var buttonAddF1Driver: Button
    private lateinit var inputFirstName: EditText
    private lateinit var inputLastName: EditText
    private lateinit var inputAge: EditText
    private lateinit var inputPodiums: EditText
    private lateinit var inputTeam: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_f1_driver)

        title = "Add F1 Driver"

        rootContainer = findViewById(R.id.rootContainer)
        buttonAddF1Driver = findViewById(R.id.addF1Driver)
        inputFirstName = findViewById(R.id.firstName)
        inputLastName = findViewById(R.id.lastName)
        inputAge = findViewById(R.id.age)
        inputPodiums = findViewById(R.id.podiums)
        inputTeam = findViewById(R.id.team)

        buttonAddF1Driver.setOnClickListener {
            addF1DriverViewModel.addF1Driver(inputFirstName.text.toString(),
            inputLastName.text.toString(),
            inputTeam.text.toString(),
            inputAge.text.toString().toInt(),
            inputPodiums.text.toString().toInt())
        }

        addF1DriverViewModel.isDriverAdded.observe(this) {
            when (it.status) {
                ResourceStatus.SUCCESS -> {
                    clearAllUserInput()
                    showDriverAddedSuccessfullyMessage()
                }
                else -> {
                    showError(it.error)
                }
            }
        }
    }


    private fun clearAllUserInput() {
        inputFirstName.text.clear()
        inputLastName.text.clear()
        inputAge.text.clear()
        inputPodiums.text.clear()
        inputTeam.text.clear()
    }


    private fun showDriverAddedSuccessfullyMessage() {
        Snackbar.make(rootContainer, R.string.driver_added_successfully, Snackbar.LENGTH_LONG)
            .show()
    }


    private fun showGenericErrorMessage() {
        Snackbar.make(rootContainer, R.string.something_went_wrong_error, Snackbar.LENGTH_LONG)
            .show()
    }


    private fun showError(errorType: ErrorType?) {
        when (errorType) {
            ErrorType.EMPTY_FIRST_NAME, ErrorType.INVALID_FORMAT_FIRST_NAME -> {
                inputFirstName.error = getString(errorType.resourceId)
            }
            else -> {
                showGenericErrorMessage()
            }
        }
    }
}