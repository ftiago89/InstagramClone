package com.felipe.instagram.register.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.felipe.instagram.R
import com.felipe.instagram.common.view.CustomDialog

class RegisterPhotoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val customDialog = CustomDialog(requireContext())
        customDialog.setTitle(R.string.app_name)
        customDialog.addButtons( R.string.photo, R.string.gallery){}

        customDialog.show()
    }
}