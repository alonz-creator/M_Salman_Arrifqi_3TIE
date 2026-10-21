package com.example.salman3tie

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.salman3tie.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Animasi halus saat dibuka
        binding.cardLogo.alpha = 0f
        binding.cardLogo.scaleX = 0.7f
        binding.cardLogo.scaleY = 0.7f
        binding.textAppTitle.alpha = 0f
        binding.textSlogan.alpha = 0f
        binding.progressBar.alpha = 0f

        binding.cardLogo.animate()
            .alpha(1f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(700)
            .start()

        binding.textAppTitle.animate()
            .alpha(1f)
            .translationY(-10f)
            .setDuration(700)
            .setStartDelay(200)
            .start()

        binding.textSlogan.animate()
            .alpha(1f)
            .setDuration(700)
            .setStartDelay(350)
            .start()

        binding.progressBar.animate()
            .alpha(1f)
            .setDuration(500)
            .setStartDelay(500)
            .start()

        // Coroutine delay 2 detik
        lifecycleScope.launch {
            delay(2200)

            // Pengecekan status login di SharedPreferences
            val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
            val isLogin = sharedPref.getBoolean("isLogin", false)

            if (isLogin) {
                // Jika sudah login, langsung ke BaseActivity
                val intent = Intent(this@SplashScreenActivity, BaseActivity::class.java)
                startActivity(intent)
            } else {
                // Jika belum login, ke AuthActivity
                val intent = Intent(this@SplashScreenActivity, AuthActivity::class.java)
                startActivity(intent)
            }
            finish()
        }
    }
}
