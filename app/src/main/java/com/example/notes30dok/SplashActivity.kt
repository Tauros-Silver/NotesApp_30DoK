package com.example.notes30dok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.notes30dok.ui.notes.NotesActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val imglogo = findViewById<ImageView>(R.id.imgLogo)

        imglogo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.splash_in))

        Handler().postDelayed({
            imglogo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.splash_out))
            Handler().postDelayed({
                imglogo.visibility = View.GONE
                startActivity((Intent(this, NotesActivity::class.java)))
            }, 500)
        }, 1500)
    }
}
