package com.ariqandrean.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etWidth: EditText
    private lateinit var etHeight: EditText
    private lateinit var etLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etWidth = findViewById(R.id.edt_width)
        etHeight = findViewById(R.id.edt_height)
        etLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)
    }

    /**
     *
     */
    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_calculate){
            val inputLength = etLength.text.toString().trim()
            val inputWidth = etWidth.text.toString().trim()
            val inputHeight = etHeight.text.toString().trim()

//            simpleCode
//            val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
//            tvResult.text = volume.toString()

//            not simple code if the field is empty
            var isEmptyFields = false
            if (inputLength.isEmpty()){
                isEmptyFields = true
//                menampilkan eror
                etLength.error = "Field ini tidak boleh kosong"
            }
            if (inputWidth.isEmpty()){
                isEmptyFields = true
                etWidth.error = "Field ini tidak boleh kosong"
            }
            if (inputHeight.isEmpty()){
                isEmptyFields = true
                etHeight.error = "Field ini tidak boleh kosong"
            }

            if (!isEmptyFields){
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tvResult.text = volume.toString()
            }
        }
    }
}