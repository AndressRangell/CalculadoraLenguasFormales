package andres.rangel.calculadoralenguasformales

import andres.rangel.calculadoralenguasformales.databinding.ActivityLanguageOperationsBinding
import android.os.Bundle
import android.view.View.INVISIBLE
import androidx.appcompat.app.AppCompatActivity

class LanguageOperationsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLanguageOperationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLanguageOperationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val operation = intent.getStringExtra("operation") ?: ""

        when (operation) {
            "concatenation" -> binding.tvTitle.text = "Calcular Concatenación"
            "empowerment" -> {
                binding.tvTitle.text = "Calcular Potenciación"
                binding.etLangTwo.hint = "Ingrese el exponente"
            }
            "inverse" -> {
                binding.tvTitle.text = "Calcular Inversa"
                binding.etLangTwo.visibility = INVISIBLE
            }
            "union" -> binding.tvTitle.text = "Calcular Unión"
            "intersection" -> binding.tvTitle.text = "Calcular Intesección"
            "subtraction" -> binding.tvTitle.text = "Calcular Resta"
            "kleene" -> {
                binding.tvTitle.text = "Calcular Clausura de Kleene"
                binding.etLangTwo.visibility = INVISIBLE
            }
            "positive" -> {
                binding.tvTitle.text = "Calcular Clausura Positiva"
                binding.etLangTwo.visibility = INVISIBLE
            }
        }

        binding.btnCalculate.setOnClickListener {
            when (operation) {
                "concatenation" -> calculateConcatenation()
                "empowerment" -> calculateEmpowerment()
                "inverse" -> calculateInverse()
                "union" -> calculateUnion()
                "intersection" -> calculateIntersection()
                "subtraction" -> calculateSubtraction()
                "kleene" -> calculateKleene()
                "positive" -> calculatePositive()
            }
        }
    }

    private fun calculatePositive() {
        val one = binding.etLangOne.text.toString()
        if (one.isEmpty()) {
            binding.tvAnswer.text = "Datos Incorrectos"
        } else {
            val langOne = one.split(",").toMutableList()
            var langFinal = mutableListOf<String>()
            langFinal.addAll(langOne)
            for (i in 1..5) {
                langFinal = langFinal.union(calculatePotentLang2(langOne.toMutableList(), i))
                    .toMutableList()
            }
            binding.tvAnswer.text = "V* = $langFinal"
        }
    }

    private fun calculateKleene() {
        val one = binding.etLangOne.text.toString()
        if (one.isEmpty()) {
            binding.tvAnswer.text = "Datos Incorrectos"
        } else {
            val langOne = one.split(",").toMutableList()
            var langFinal = mutableListOf<String>()
            langFinal.add("λ")
            langFinal.addAll(langOne)
            for (i in 1..5) {
                langFinal = langFinal.union(calculatePotentLang2(langOne.toMutableList(), i))
                    .toMutableList()
            }
            binding.tvAnswer.text = "V* = $langFinal"
        }
    }

    private fun calculatePotentLang2(langOne: MutableList<String>, exponent: Int): MutableList<String> {
        val langFinal = mutableListOf<String>()
        langOne.forEach { langFinal.add(it) }
        val langTwo = mutableListOf<String>()
        for (i in 2..exponent) {
            for (j in langOne) {
                for (k in langFinal) {
                    if (j == "λ" && k == "λ") {
                        langTwo.add("λ")
                    } else if (j == "λ") {
                        langTwo.add(k)
                    } else if (k == "λ") {
                        langTwo.add(j)
                    } else {
                        langTwo.add(j + k)
                    }
                }
            }
            langFinal.clear()
            langFinal.addAll(langTwo)
            langTwo.clear()
        }
        return langFinal
    }

    private fun calculateSubtraction() {
        val one = binding.etLangOne.text.toString()
        val two = binding.etLangTwo.text.toString()
        if (one.isEmpty() || two.isEmpty()) {
            binding.tvAnswer.text = "Datos Incorrectos"
        } else {
            val langOne = one.split(",").toMutableList()
            val langTwo = two.split(",").toMutableList()
            val subtraction = (langOne.toSet() - langTwo.toSet()).toMutableList()
            val langFinal = mutableListOf<String>()
            if (subtraction.contains("λ")) {
                subtraction.remove("λ")
                langFinal.add("λ")
            }
            subtraction.forEach { langFinal.add(it) }
            if (langFinal.isEmpty()) {
                binding.tvAnswer.text = "L1 = L2"
            } else {
                binding.tvAnswer.text = "L1 - L2 = $langFinal"
            }
        }
    }

    private fun calculateIntersection() {
        val one = binding.etLangOne.text.toString()
        val two = binding.etLangTwo.text.toString()
        if (one.isEmpty() || two.isEmpty()) {
            binding.tvAnswer.text = "Datos Incorrectos"
        } else {
            val langOne = one.split(",").toMutableList()
            val langTwo = two.split(",").toMutableList()
            val intersect = langOne.intersect(langTwo.toSet()).toMutableList()
            val intersectFinal = mutableListOf<String>()
            if (intersect.contains("λ")) {
                intersect.remove("λ")
                intersectFinal.add("λ")
            }
            intersect.forEach { intersectFinal.add(it) }
            if (intersectFinal.isEmpty()) {
                binding.tvAnswer.text = "L1 ∩ L2 = Ø"
            } else {
                binding.tvAnswer.text = "L1 ∩ L2 = $intersectFinal"
            }
        }
    }

    private fun calculateUnion() {
        val one = binding.etLangOne.text.toString()
        val two = binding.etLangTwo.text.toString()
        if (one.isEmpty() || two.isEmpty()) {
            binding.tvAnswer.text = "Datos Incorrectos"
        } else {
            val langOne = one.split(",").toMutableList()
            val langTwo = two.split(",").toMutableList()
            val union = langOne.union(langTwo).toMutableList()
            val unionFinal = mutableListOf<String>()
            if (union.contains("λ")) {
                union.remove("λ")
                unionFinal.add("λ")
            }
            union.forEach { unionFinal.add(it) }
            binding.tvAnswer.text = "L1 U L2 = $unionFinal"
        }
    }

    private fun calculateInverse() {
        val one = binding.etLangOne.text.toString()
        if (one.isEmpty()) {
            binding.tvAnswer.text = "Datos Incorrectos"
        } else {
            val langOne = one.split(",").toMutableList()
            val langTwo = mutableListOf<String>()
            langOne.forEach {
                langTwo.add(it.reversed())
            }
            binding.tvAnswer.text = "L^R = $langTwo"
        }
    }

    private fun calculateEmpowerment() {
        val one = binding.etLangOne.text.toString()
        val two = binding.etLangTwo.text.toString()
        if (one.isEmpty() || two.isEmpty()) {
            binding.tvAnswer.text = "Datos Incorrectos"
        } else {
            val langFinal = mutableListOf<String>()
            val langOne = one.split(",")
            langOne.forEach { langFinal.add(it) }
            val langTwo = mutableListOf<String>()
            for (i in 2..two.toInt()) {
                for (j in langOne) {
                    for (k in langFinal) {
                        if (j == "λ" && k == "λ") {
                            langTwo.add("λ")
                        } else if (j == "λ") {
                            langTwo.add(k)
                        } else if (k == "λ") {
                            langTwo.add(j)
                        } else {
                            langTwo.add(j + k)
                        }
                    }
                }
                langFinal.clear()
                langFinal.addAll(langTwo)
                langTwo.clear()
            }
            binding.tvAnswer.text = "L1^${two.toInt()} = $langFinal"
        }
    }

    private fun calculateConcatenation() {
        val one = binding.etLangOne.text.toString()
        val two = binding.etLangTwo.text.toString()
        if (one.isEmpty() || two.isEmpty()) {
            binding.tvAnswer.text = "Datos Incorrectos"
        } else {
            val langFinal = mutableListOf<String>()
            val langOne = one.split(",")
            val langTwo = two.split(",")
            for (i in langTwo) {
                for (j in langOne) {
                    if (i == "λ" && j == "λ") {
                        langFinal.add("λ")
                    } else if (i == "λ") {
                        langFinal.add(j)
                    } else if (j == "λ") {
                        langFinal.add(i)
                    } else {
                        langFinal.add(j + i)
                    }
                }
            }
            binding.tvAnswer.text = "L1.L2 = $langFinal"
        }
    }
}