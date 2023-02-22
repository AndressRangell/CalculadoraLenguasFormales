package andres.rangel.calculadoralenguasformales

import andres.rangel.calculadoralenguasformales.databinding.ActivityAlphabetOperationsBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AlphabetOperationsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlphabetOperationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlphabetOperationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val operation = intent.getStringExtra("operation") ?: ""

        when (operation) {
            "membership" -> binding.tvTitle.text = "Calcular Pertenencia"
            "union" -> binding.tvTitle.text = "Calcular Unión"
            "intersection" -> binding.tvTitle.text = "Calcular Intersección"
            "complement" -> binding.tvTitle.text = "Calcular Complemento"
            "absolute" -> binding.tvTitle.text = "Calcular Diferencia Absoluta"
            "symmetric" -> binding.tvTitle.text = "Calcular Diferencia Simétrica"
        }

        binding.btnCalculate.setOnClickListener {
            when (operation) {
                "membership" -> calculateMembership()
                "union" -> calculateUnion()
                "intersection" -> calculateIntersection()
                "complement" -> calculateComplement()
                "absolute" -> calculateAbsoluteDif()
                "symmetric" -> calculateSymmetricDif()
            }
        }
    }

    private fun calculateMembership() {
        val groupA = binding.etGroupA.text.toString()
        val groupB = binding.etGroupB.text.toString()
        if (groupA.isEmpty() || groupB.isEmpty()) {
            binding.tvAnswer.text = getString(R.string.data_error)
        } else {
            if (groupA.split(",").containsAll(groupB.split(","))) {
                binding.tvAnswer.text = "B ϵ A"
            } else {
                binding.tvAnswer.text = "B ∉ A"
            }
        }
    }

    private fun calculateUnion() {
        val groupA = binding.etGroupA.text.toString()
        val groupB = binding.etGroupB.text.toString()
        if (groupA.isEmpty() || groupB.isEmpty()) {
            binding.tvAnswer.text = getString(R.string.data_error)
        } else {
            val union = groupA.split(",").union(groupB.split(","))
            binding.tvAnswer.text = "A U B = $union"
        }
    }

    private fun calculateIntersection() {
        val groupA = binding.etGroupA.text.toString()
        val groupB = binding.etGroupB.text.toString()
        if (groupA.isEmpty() || groupB.isEmpty()) {
            binding.tvAnswer.text = getString(R.string.data_error)
        } else {
            val intersect = groupA.split(",").intersect(groupB.split(",").toSet())
            if (intersect.isEmpty()) {
                binding.tvAnswer.text = "A ∩ B = Ø"
            } else {
                binding.tvAnswer.text = "A ∩ B = $intersect"
            }
        }
    }

    private fun calculateComplement() {
        val groupA = binding.etGroupA.text.toString()
        val groupB = binding.etGroupB.text.toString()
        if (groupA.isEmpty() || groupB.isEmpty()) {
            binding.tvAnswer.text = getString(R.string.data_error)
        } else {
            val complement = groupA.split(",").toSet() - groupB.split(",").toSet()
            if (complement.isEmpty()) {
                binding.tvAnswer.text = "A = B"
            } else {
                binding.tvAnswer.text = "B' = $complement"
            }
        }
    }

    private fun calculateAbsoluteDif() {
        val groupA = binding.etGroupA.text.toString()
        val groupB = binding.etGroupB.text.toString()
        if (groupA.isEmpty() || groupB.isEmpty()) {
            binding.tvAnswer.text = getString(R.string.data_error)
        } else {
            val absoluteDif = groupA.split(",").toSet() - groupB.split(",").toSet()
            if (absoluteDif.isEmpty()) {
                binding.tvAnswer.text = "A = B"
            } else {
                binding.tvAnswer.text = "A \\ B = $absoluteDif"
            }
        }
    }

    private fun calculateSymmetricDif() {
        val groupA = binding.etGroupA.text.toString()
        val groupB = binding.etGroupB.text.toString()
        if (groupA.isEmpty() || groupB.isEmpty()) {
            binding.tvAnswer.text = getString(R.string.data_error)
        } else {
            val symmetricDif =
                (groupA.split(",").toSet() - groupB.split(",").toSet()) + (groupB.split(",")
                    .toSet() - groupA.split(",").toSet())
            if (symmetricDif.isEmpty()) {
                binding.tvAnswer.text = "A = B"
            } else {
                binding.tvAnswer.text = "A ⊕ B = $symmetricDif"
            }
        }
    }
}