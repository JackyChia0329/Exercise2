package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cal = findViewById(R.id.buttonCalculate) as Button
        val res = findViewById(R.id.buttonReset) as Button
        val kg = editTextWeight
        val cm = editTextHeight
        val bmi = resultBmi
        val img :ImageView = findViewById(R.id.imageViewProfile)
        img.setImageResource(R.drawable.empty)

        cal.setOnClickListener{

            val KG =  kg.text.toString().toDouble()
            val CM = cm.text.toString().toInt()*0.01
            val result =String.format ("%.2f",KG/(CM*CM))

            bmi.setText(result)
            if((KG/(CM*CM))<18.5){
                img.setImageResource(R.drawable.under)

            }else {
                if((KG/(CM*CM))>18.5&&(KG/(CM*CM))<24.9){
                    img.setImageResource(R.drawable.normal)

                }else{
                    img.setImageResource(R.drawable.over)

                }
            }

        }
        res.setOnClickListener{
            kg.setText("")
            cm.setText("")
            bmi.setText("")
        }

    }
}
