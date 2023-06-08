package com.zireddinismayilov.ziraddinapp

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import java.util.Calendar

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setUpLangugesSpinner()
        setUpDateEditText()
        setUpLoginButton()
    }

    fun setUpLangugesSpinner() {
        val languages = arrayOf("Azerbaijani", "Turkish", "English", "Russian", "Arabic")
        val langiage_spinner = findViewById<Spinner>(R.id.spinner)
        langiage_spinner.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, languages)
    }

    fun setUpDateEditText() {
        val dateEditText = findViewById<EditText>(R.id.editTextDate)

        dateEditText.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this, { n, selectedYear, selectedMonth, selectedDay ->
                    val selectedDate: String
                    if (selectedDay < 9) {
                        selectedDate = "0$selectedDay-${selectedMonth + 1}-$selectedYear"
                    } else if (selectedMonth < 9) {
                        selectedDate = "$selectedDay-0${selectedMonth + 1}-$selectedYear"
                    } else if (selectedMonth < 9 && selectedDay < 9) {
                        selectedDate = "0$selectedDay-0${selectedMonth + 1}-$selectedYear"
                    } else {
                        selectedDate = "$selectedDay-${selectedMonth + 1}-$selectedYear"
                    }
                    dateEditText.setText(selectedDate)
                }, year, month, day
            )

            datePickerDialog.show()
        }
    }

    fun setUpLoginButton() {
        val loginBtn = findViewById<Button>(R.id.button_login)
        loginBtn.setOnClickListener {
            val name = findViewById<EditText>(R.id.editTextName).text.toString().trim()
            val surname = findViewById<EditText>(R.id.editTextSurname).text.toString().trim()
            val date = findViewById<EditText>(R.id.editTextDate).text.toString()
            val checkBox = findViewById<CheckBox>(R.id.checkBoxTermsOfUse)
            if (name.isNotEmpty() && surname.isNotEmpty() && date.isNotEmpty() && checkBox.isChecked) {
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Please fill all requirements!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}