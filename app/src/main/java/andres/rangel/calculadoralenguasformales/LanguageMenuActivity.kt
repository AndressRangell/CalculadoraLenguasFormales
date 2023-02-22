package andres.rangel.calculadoralenguasformales

import andres.rangel.calculadoralenguasformales.databinding.ActivityLanguageMenuBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LanguageMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLanguageMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLanguageMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConcatenation.setOnClickListener {
            val intent = Intent(this, LanguageOperationsActivity::class.java)
            intent.putExtra("operation", "concatenation")
            startActivity(intent)
        }

        binding.btnEmpowerment.setOnClickListener {
            val intent = Intent(this, LanguageOperationsActivity::class.java)
            intent.putExtra("operation", "empowerment")
            startActivity(intent)
        }

        binding.btnInverse.setOnClickListener {
            val intent = Intent(this, LanguageOperationsActivity::class.java)
            intent.putExtra("operation", "inverse")
            startActivity(intent)
        }

        binding.btnUnion.setOnClickListener {
            val intent = Intent(this, LanguageOperationsActivity::class.java)
            intent.putExtra("operation", "union")
            startActivity(intent)
        }

        binding.btnIntersection.setOnClickListener {
            val intent = Intent(this, LanguageOperationsActivity::class.java)
            intent.putExtra("operation", "intersection")
            startActivity(intent)
        }

        binding.btnSubtraction.setOnClickListener {
            val intent = Intent(this, LanguageOperationsActivity::class.java)
            intent.putExtra("operation", "subtraction")
            startActivity(intent)
        }

        binding.btnKleene.setOnClickListener {
            val intent = Intent(this, LanguageOperationsActivity::class.java)
            intent.putExtra("operation", "kleene")
            startActivity(intent)
        }

        binding.btnPositive.setOnClickListener {
            val intent = Intent(this, LanguageOperationsActivity::class.java)
            intent.putExtra("operation", "positive")
            startActivity(intent)
        }
    }
}