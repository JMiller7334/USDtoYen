package com.example.usdtoyen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.mipmap.ic_launcher)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        val convertNumber = findViewById<EditText>(R.id.idInput)
        val buttonToYen = findViewById<RadioButton>(R.id.idToYen)
        val buttonToUSD = findViewById<RadioButton>(R.id.idToUSD)
        val textResult = findViewById<TextView>(R.id.idResult)
        val buttonConvert = findViewById<Button>(R.id.idButtonConvert)

        buttonConvert.setOnClickListener {
            val MoneyFormat = DecimalFormat("###,###.00")
            val InputToConvert = convertNumber.text.toString().toDouble()
            var convertedResult = 0.00

            if (buttonToYen.isChecked) {
                var conversionRate = 108.47
                if (InputToConvert < 10000.00) {
                    convertedResult = (InputToConvert * conversionRate)
                    textResult.text = "That converts to " + MoneyFormat.format(convertedResult) + " Yen"
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Results must be below 10,000.00 USD.", Toast.LENGTH_LONG).show()
                }
            } else if (buttonToUSD.isChecked) {
                var conversionRate = 0.0092
                convertedResult = (InputToConvert * conversionRate)
                if (convertedResult < 10000.00) {
                    textResult.text = "That converts to " + MoneyFormat.format(convertedResult) + " USD"
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Results must be below 10,000.00 USD.", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
