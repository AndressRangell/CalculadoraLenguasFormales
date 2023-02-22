package andres.rangel.calculadoralenguasformales

import andres.rangel.calculadoralenguasformales.databinding.ActivityChainOperationsBinding
import android.os.Bundle
import android.text.InputType
import android.view.View.INVISIBLE
import androidx.appcompat.app.AppCompatActivity

class ChainOperationsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChainOperationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChainOperationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val operation = intent.getStringExtra("operation") ?: ""

        when (operation) {
            "length" -> {
                binding.tvTitle.text = "Calcular Longitud"
                binding.etChainTwo.visibility = INVISIBLE
            }
            "concatenation" -> {
                binding.tvTitle.text = "Calcular Concatenación"
                binding.etChainTwo.hint = "Ingrese la cadena B"
            }
            "empowerment" -> {
                binding.tvTitle.text = "Calcular Potenciación"
                binding.etChainTwo.hint = "Ingrese el exponente"
                binding.etChainTwo.inputType = InputType.TYPE_CLASS_NUMBER
            }
            "inverse" -> {
                binding.tvTitle.text = "Calcular Inversa"
                binding.etChainTwo.visibility = INVISIBLE
            }
        }

        binding.btnCalculate.setOnClickListener {
            when (operation) {
                "length" -> calculateLength()
                "concatenation" -> calculateConcatenation()
                "empowerment" -> calculateEmpowerment()
                "inverse" -> calculateInverse()
            }
        }
    }

    private fun calculateInverse() {
        binding.tvAnswer.text = "A^R = ${binding.etChainOne.text.toString().reversed()}"
    }

    private fun calculateEmpowerment() {
        var chainB = ""
        val exponent = binding.etChainTwo.text.toString()
        for (i in 1..exponent.toInt()) {
            chainB += binding.etChainOne.text.toString()
        }
        binding.tvAnswer.text = "A^$exponent = $chainB"
    }

    private fun calculateConcatenation() {
        binding.tvAnswer.text =
            "A.B = ${binding.etChainOne.text.toString() + binding.etChainTwo.text.toString()}"
    }

    private fun calculateLength() {
        binding.tvAnswer.text = "|A| = ${binding.etChainOne.text.toString().length}"
    }
}