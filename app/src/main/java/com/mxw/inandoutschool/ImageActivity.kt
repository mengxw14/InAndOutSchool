package com.mxw.inandoutschool

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_image.*
import java.sql.Time

class ImageActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        if (Build.VERSION.SDK_INT >= 21) {
            val decorView = window.decorView
            val option = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
            decorView.systemUiVisibility = option
            window.statusBarColor = Color.TRANSPARENT
        }
        val actionBar = supportActionBar
        actionBar!!.hide()
        val intent = intent
        main_time.text = TimeUtil.getTime(System.currentTimeMillis() / 1000,TimeUtil.timeTag)
        if (intent.getStringExtra("style") == "in"){
            main_inorout.text = "允许出校"
        }else{
            main_inorout.text = "欢迎返校"
        }
        main_number.text = intent.getStringExtra("id")
        main_name.text = intent.getStringExtra("name")
        main_resource.text = intent.getStringExtra("resource")
    }
}