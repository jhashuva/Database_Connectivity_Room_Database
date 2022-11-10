package com.example.studentdata

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class NewStudentActivity : AppCompatActivity() {
    private lateinit var editRollNOView: EditText
    private lateinit var editNameView: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)
        editRollNOView = findViewById(R.id.edit_rollNo)
        editNameView = findViewById(R.id.edit_name)

        val button = findViewById<Button>(R.id.button_save)

        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editRollNOView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val rollNo = editRollNOView.text.toString()
                val name = editRollNOView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY,rollNo,name)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }
    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}