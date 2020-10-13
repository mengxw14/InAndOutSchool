package com.mxw.inandoutschool

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name.setText(SPUtils.getString(this@MainActivity,"name"))
        id.setText(SPUtils.getString(this@MainActivity,"id"))
        resource.setText(SPUtils.getString(this@MainActivity,"resource"))
        if (Build.VERSION.SDK_INT >= 21) {
            val decorView = window.decorView
            val option = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
            decorView.systemUiVisibility = option
            window.statusBarColor = Color.TRANSPARENT
        }
        val actionBar = supportActionBar
        actionBar!!.hide()
        btn_in.setOnClickListener {
            getImg("in")
        }
        btn_out.setOnClickListener {
            getImg("out")
        }
    }

//    override fun onClick(p0: View?) {
//        var s:String? = null
//        when(p0?.id){
//            R.id.btn_in -> s = "in"
//            R.id.btn_out -> s = "out"
//        }
//        if (s != null) {
//            getImg(s)
//        }
//    }
    private fun getImg(s: String){
        var intent = Intent(this, ImageActivity::class.java)
        with(intent){
            putExtra("name", name.text.toString())
            putExtra("id", id.text.toString())
            putExtra("resource", resource.text.toString())
            putExtra("style", s)
        }
        SPUtils.putString(this@MainActivity,"name",name.text.toString())
        SPUtils.putString(this@MainActivity,"id",id.text.toString())
        SPUtils.putString(this@MainActivity,"resource",resource.text.toString())
        startActivity(intent)
    }
}