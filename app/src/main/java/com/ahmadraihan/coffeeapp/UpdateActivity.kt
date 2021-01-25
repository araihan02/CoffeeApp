package com.ahmadraihan.coffeeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class UpdateActivity : AppCompatActivity() {
    lateinit var userDBHelper: DBHelper
    lateinit var inputemail: EditText
    lateinit var inputnama: EditText
    lateinit var inputalamat: EditText
    lateinit var inputjk: EditText
    lateinit var inputtelepon: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        inputemail = findViewById(R.id.input_emailu)
        inputnama = findViewById(R.id.input_namau)
        inputalamat = findViewById(R.id.input_alamatu)
        inputjk = findViewById(R.id.input_jku)
        inputtelepon = findViewById(R.id.input_teleponu)
        userDBHelper = DBHelper(this)
        val bundle = intent.extras
        if (bundle!=null){
            inputemail.setText(bundle.getString("emailk"))
            inputnama.setText(bundle.getString("namak"))
            inputalamat.setText(bundle.getString("alamatk"))
            inputjk.setText(bundle.getString("jkk"))
            inputtelepon.setText(bundle.getString("teleponk"))

        }
    }
    fun updateData(v: View){
        var emailin = inputemail.text.toString()
        var namain = inputnama.text.toString()
        var alamatin = inputalamat.text.toString()
        var jkin = inputjk.text.toString()
        var teleponin = inputtelepon.text.toString()
        userDBHelper.updateData(emailin, namain, alamatin, jkin, teleponin)
        var pindah = Intent(this, RvDbActivity::class.java)
        startActivity(pindah)
    }
    fun cancelData(v: View){
        var pindah = Intent(this, RvDbActivity::class.java)
        startActivity(pindah)
    }
}