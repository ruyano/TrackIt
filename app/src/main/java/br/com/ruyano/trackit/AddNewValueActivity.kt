package br.com.ruyano.trackit

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.InputType
import android.view.MenuItem
import android.view.View
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_new_value.*
import java.text.SimpleDateFormat
import java.util.*

class AddNewValueActivity : AppCompatActivity() {

    private val myCalendar = Calendar.getInstance()
    private val datePickerListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
        myCalendar.set(Calendar.YEAR, year)
        myCalendar.set(Calendar.MONTH, monthOfYear)
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        et_date.setText(getStringFromCalendar(myCalendar))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_value)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        et_date.setText(getStringFromCalendar(myCalendar))
        et_date.setOnClickListener { showDatePicker() }
        et_weight.requestFocus()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    fun getStringFromCalendar(calendar: Calendar): String {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale("pt", "BR"))
        return sdf.format(calendar.time)
    }

    private fun showDatePicker() {
        DatePickerDialog(this,
            datePickerListener,
            myCalendar.get(Calendar.YEAR),
            myCalendar.get(Calendar.MONTH),
            myCalendar.get(Calendar.DAY_OF_MONTH)).show()
    }

}

