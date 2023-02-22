package andres.rangel.calculadoralenguasformales

import andres.rangel.calculadoralenguasformales.databinding.ActivityMainBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAlphabets.setOnClickListener {
            startActivity(Intent(this, AlphabetMenuActivity::class.java))
        }

        binding.btnChains.setOnClickListener {
            startActivity(Intent(this, ChainMenuActivity::class.java))
        }

        binding.btnLanguages.setOnClickListener {
            startActivity(Intent(this, LanguageMenuActivity::class.java))
        }
    }
}