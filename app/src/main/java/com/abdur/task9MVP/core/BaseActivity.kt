package com.abdur.task9MVP.core

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

abstract class BaseActivity: AppCompatActivity() {

    abstract fun setLayoutId(): Int
    abstract fun setToolbar(): Toolbar
    abstract val isHomeUpButtonEnable: Boolean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        setActionBar(setToolbar(), isHomeUpButtonEnable)
        Logger.addLogAdapter(AndroidLogAdapter())
    }

    private fun setActionBar(toolbar: Toolbar, isHomeUpButtonEnable: Boolean)
    {
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(isHomeUpButtonEnable)
        supportActionBar?.setDisplayHomeAsUpEnabled(isHomeUpButtonEnable)
    }

    fun showTost(text: String)
    {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}