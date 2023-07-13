package com.felipe.instagram.common.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.felipe.instagram.R

class CustomDialog(context: Context) : Dialog(context) {

    private lateinit var linearLayout: LinearLayout
    private lateinit var txtViewTitle: TextView
    private lateinit var txtButtons: Array<TextView>
    private var titleId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_dialog)

        linearLayout = findViewById(R.id.dialog_container)
        txtViewTitle = findViewById(R.id.dialog_title)
    }

    fun addButtons(vararg texts: Int, listener: View.OnClickListener) {
        txtButtons = Array(texts.size) {
            TextView(context)
        }

        texts.forEachIndexed { index, textId ->
            txtButtons[index].id = textId
            txtButtons[index].setText(textId)
            txtButtons[index].setOnClickListener {
                listener.onClick(it)
                dismiss()
            }
        }
    }

    override fun setTitle(titleId: Int) {
        this.titleId = titleId
    }

    override fun show() {
        super.show()

        titleId?.let {
            txtViewTitle.setText(it)
        }

        val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        layoutParams.setMargins(30, 50, 30, 50)

        for (textView in txtButtons) {
            linearLayout.addView(textView, layoutParams)
        }
    }
}