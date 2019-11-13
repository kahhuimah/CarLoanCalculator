package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtCarPrice = findViewById<TextView>(R.id.txtCarPrice)
        val txtDownPay = findViewById<TextView>(R.id.txtDownPay)
        val txtLoanPeriod = findViewById<TextView>(R.id.txtLoanPeriod)
        val txtInterestRate = findViewById<TextView>(R.id.txtInterestRate)

        val btnCalculate = findViewById<TextView>(R.id.btnCalculate)

        btnCalculate.setOnClickListener(){
            val carPrice:String = txtCarPrice.text.toString()
            val carPriceValue:Double = carPrice.toDouble()
            val downPay:String = txtDownPay.text.toString()
            val downPayValue:Double = downPay.toDouble()
            val carLoanR:Double = carPriceValue - downPayValue
            txtCarLoan.text = "Car Loan: " + "%.2f".format(carLoanR)

            val interestRate:String = txtInterestRate.text.toString()
            val interestRateValue:Double = interestRate.toDouble()
            val loanPeriod:String = txtLoanPeriod.text.toString()
            val loanPeriodValue:Double = loanPeriod.toDouble()
            val InterestR:Double = carLoanR * interestRateValue * loanPeriodValue
            txtInterest.text =  "Interest: " + "%.2f".format(InterestR)

            val monthlyRepaymentR:Double = (carLoanR + InterestR) / loanPeriodValue / 12
            txtMonthlyRepayment.text = "Monthly Repayment: "+ "%.2f".format(monthlyRepaymentR)
        }

    }
}
