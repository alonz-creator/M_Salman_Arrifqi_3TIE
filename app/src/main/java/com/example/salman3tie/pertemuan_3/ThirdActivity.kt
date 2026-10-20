package com.example.salman3tie.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.salman3tie.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inflate layout menggunakan ViewBinding
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Event listener dengan ViewBinding
        binding.btnKirim.setOnClickListener {
            val noTujuan = binding.inputNoTujuan.text.toString()

            Toast.makeText(this, "Nomor Tujuan: $noTujuan", Toast.LENGTH_SHORT).show()

            // Intent untuk berpindah ke ThirdResultActivity
            val intent = Intent(this, ThirdResultActivity::class.java)
            intent.putExtra("NO_TUJUAN", noTujuan)
            startActivity(intent)
        }
    }
}
