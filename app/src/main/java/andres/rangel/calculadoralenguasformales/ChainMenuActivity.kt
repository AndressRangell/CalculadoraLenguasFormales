package andres.rangel.calculadoralenguasformales

import andres.rangel.calculadoralenguasformales.databinding.ActivityChainMenuBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ChainMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLength.setOnClickListener {
            val intent = Intent(this, ChainOperationsActivity::class.java)
            intent.putExtra("operation", "length")
            startActivity(intent)
        }

        binding.btnConcatenation.setOnClickListener {
            val intent = Intent(this, ChainOperationsActivity::class.java)
            intent.putExtra("operation", "concatenation")
            startActivity(intent)
        }

        binding.btnEmpowerment.setOnClickListener {
            val intent = Intent(this, ChainOperationsActivity::class.java)
            intent.putExtra("operation", "empowerment")
            startActivity(intent)
        }

        binding.btnInverse.setOnClickListener {
            val intent = Intent(this, ChainOperationsActivity::class.java)
            intent.putExtra("operation", "inverse")
            startActivity(intent)
        }
    }
}