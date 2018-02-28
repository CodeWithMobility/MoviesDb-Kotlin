package com.mobiledev.popularmovies.utils

/**
 * Created by Manu on 2/28/2018.
 */
import android.app.Dialog
import android.content.Context
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.mobiledev.popularmovies.R


/**
 * Created by Manu on 11/3/2017.
 */

class DialogUtil {

    fun okFunc(context: Context, message: String, title: String, mOnDialogSelectedListener: OnDialogSelectedListener, dialogIndex: Int) {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.ok_dialog_layout)
        dialog.window!!.attributes.windowAnimations = R.style.DialogTheme
        /* My Cancel Button , and its listener */
        val mTitleView = dialog.findViewById(R.id.ok_dialog_title) as TextView
        mTitleView.text = title
        val mMessageView = dialog.findViewById(R.id.ok_dialog_message) as TextView
        mMessageView.text = message


        val okButton = dialog.findViewById(R.id.okButton) as Button
        okButton.setOnClickListener {
            Log.e("Constants == ?", dialogIndex.toString())
            mOnDialogSelectedListener.onDialogClick(DialogConstants.DIALOG_BUTTON_OK, null, dialogIndex)
            dialog.dismiss()
        }
        dialog.show()
    }


    fun doubleFunc(context: Context, message: String, title: String, mOnDialogSelectedListener: OnDialogSelectedListener, dialogIndex: Int) {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.double_dialog_layout)
        dialog.window!!.attributes.windowAnimations = R.style.DialogTheme
        /* My Cancel Button , and its listener */
        val mTitleView = dialog.findViewById(R.id.ok_dialog_title) as TextView
        mTitleView.text = title
        val mMessageView = dialog.findViewById(R.id.ok_dialog_message) as TextView
        mMessageView.text = message
        val yesButton = dialog.findViewById(R.id.YesButton) as Button
        yesButton.setOnClickListener{
            mOnDialogSelectedListener.onDialogClick(DialogConstants.DIALOG_BUTTON_OK, null, dialogIndex)
            dialog.dismiss()
        }
        val NoButton = dialog.findViewById(R.id.NoButton) as Button
        NoButton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }




    interface OnDialogSelectedListener {
        fun onDialogClick(selectedIndex: Int, mObj: Any?, dialogIndex: Int)
    }
}