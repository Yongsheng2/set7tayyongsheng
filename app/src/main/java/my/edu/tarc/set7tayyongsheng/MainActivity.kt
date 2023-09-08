package my.edu.tarc.set7tayyongsheng

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.edu.tarc.set7tayyongsheng.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCal.setOnClickListener {
            if(binding.editTextNumberLoanAmt.text.isEmpty()){
                binding.editTextNumberLoanAmt.setError("Please insert the loan amount")
            }
            else if(binding.editTextNumberDPayment.text.isEmpty()){
                binding.editTextNumberDPayment.setError("Please insert the down payment amount")
            }
            else if(binding.editTextNumberloanPeriod.text.isEmpty()){
                binding.editTextNumberloanPeriod.setError("Please insert the loan period (in years)")
            }
            else{
                val name = binding.spinnerName.selectedItemPosition
                val loan_amt = binding.editTextNumberLoanAmt.text.toString().toFloat()
                val down_pay = binding.editTextNumberDPayment.text.toString().toFloat()
                val load_period = binding.editTextNumberloanPeriod.text.toString().toFloat()

                if (name == 0) {
                    binding.textViewI.text =
                        ((loan_amt - down_pay) * load_period * (3.01 / 100)).toString()
                    val interest = binding.textViewI.text.toString().toFloat()
                    binding.textViewR.text =
                        ((loan_amt - down_pay + interest) / (12 * load_period)).toString()
                } else if (name == 1) {
                    binding.textViewI.text =
                        ((loan_amt - down_pay) * load_period * (2.96 / 100)).toString()
                    val interest = binding.textViewI.text.toString().toFloat()
                    binding.textViewR.text =
                        ((loan_amt - down_pay + interest) / (12 * load_period)).toString()
                } else if (name == 2) {
                    binding.textViewI.text =
                        ((loan_amt - down_pay) * load_period * (2.86 / 100)).toString()
                    val interest = binding.textViewI.text.toString().toFloat()
                    binding.textViewR.text =
                        ((loan_amt - down_pay + interest) / (12 * load_period)).toString()
                }
            }
        }

        binding.buttonreset.setOnClickListener{
            binding.editTextNumberLoanAmt.text.clear()
            binding.editTextNumberDPayment.text.clear()
            binding.editTextNumberloanPeriod.text.clear()
            binding.textViewI.text = ""
            binding.textViewR.text = ""
        }

        binding.buttonPhone.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:031234567"))
            startActivity(intent)
        }

        binding.buttonEmail.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("mailto:abc@gmail.com"))
            startActivity(intent)
        }
    }
}