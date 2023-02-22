package andres.rangel.calculadoralenguasformales

import andres.rangel.calculadoralenguasformales.databinding.ActivityAlphabetMenuBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AlphabetMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlphabetMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlphabetMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMembership.setOnClickListener {
            val intent = Intent(this, AlphabetOperationsActivity::class.java)
            intent.putExtra("operation", "membership")
            startActivity(intent)
        }

        binding.btnUnion.setOnClickListener {
            val intent = Intent(this, AlphabetOperationsActivity::class.java)
            intent.putExtra("operation", "union")
            startActivity(intent)
        }

        binding.btnIntersection.setOnClickListener {
            val intent = Intent(this, AlphabetOperationsActivity::class.java)
            intent.putExtra("operation", "intersection")
            startActivity(intent)
        }

        binding.btnComplement.setOnClickListener {
            val intent = Intent(this, AlphabetOperationsActivity::class.java)
            intent.putExtra("operation", "complement")
            startActivity(intent)
        }

        binding.btnAbsoluteDifference.setOnClickListener {
            val intent = Intent(this, AlphabetOperationsActivity::class.java)
            intent.putExtra("operation", "absolute")
            startActivity(intent)
        }

        binding.btnSymmetricDifference.setOnClickListener {
            val intent = Intent(this, AlphabetOperationsActivity::class.java)
            intent.putExtra("operation", "symmetric")
            startActivity(intent)
        }
    }
}