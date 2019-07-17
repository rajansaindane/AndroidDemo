package com.melayer.androidbatch11june.notification

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Button
import com.melayer.androidbatch11june.R
import com.melayer.androidbatch11june.retrofitdemo.RetrofitDemoActivity
import kotlinx.android.synthetic.main.activity_dialog.*

class DialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        btnShowDialog.setOnClickListener {
           // alertDialog()
            customDialog()
        }
    }


    private fun customDialog(){

        val dialog=Dialog(this@DialogActivity)
        dialog.setContentView(R.layout.custom_dialog)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        val btnLogout=dialog.findViewById<Button>(R.id.btnDialogLogout)
        btnLogout.setOnClickListener {
            startActivity(Intent(this@DialogActivity,RetrofitDemoActivity::class.java)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
            finish()
        }

        val btnCancel=dialog.findViewById<Button>(R.id.btnDialogCancel)
        btnCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

    }


    private fun alertDialog(){

        val builder=AlertDialog.Builder(this@DialogActivity)
        builder.setMessage("Are you sure to Logout ?")
        builder.setPositiveButton("Logout",object :DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                dialog!!.dismiss()
                startActivity(Intent(this@DialogActivity,RetrofitDemoActivity::class.java)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
                finish()
            }
        })
        builder.setNegativeButton("Cancel",object :DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                dialog!!.dismiss()
            }
        })
        builder.create()
        builder.show()
    }
}
