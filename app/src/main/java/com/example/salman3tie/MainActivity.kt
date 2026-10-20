package com.example.salman3tie

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.salman3tie.databinding.ActivityMainBinding
import com.example.salman3tie.pertemuan_2.SecondActivity
import com.example.salman3tie.pertemuan_3.ThirdActivity
import com.example.salman3tie.pertemuan_4.FourthActivity
import com.example.salman3tie.pertemuan_5.FifthActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.e("onCreate", "MainActivity dibuat pertama kali")

        // Tombol menuju Pertemuan 2 (SecondActivity)
        binding.btnToSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        // Tombol menuju Pertemuan 3 (ThirdActivity)
        binding.btnToThird.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        // Tombol menuju Pertemuan 4 (FourthActivity)
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
            startActivity(intent)
        }

        // Tombol menuju Pertemuan 5 (FifthActivity)
        binding.btnToFifth.setOnClickListener {
            val intent = Intent(this, FifthActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: MainActivity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "MainActivity dihapus dari stack")
    }
}
