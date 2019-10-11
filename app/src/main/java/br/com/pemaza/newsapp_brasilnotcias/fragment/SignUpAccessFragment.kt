package br.com.pemaza.newsapp_brasilnotcias.fragment


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.pemaza.newsapp_brasilnotcias.R
import br.com.pemaza.newsapp_brasilnotcias.logic.SignUpViewModel
import kotlinx.android.synthetic.main.fragment_sign_up_access.*


class SignUpAccessFragment : Fragment() {

    lateinit var signUpViewModel: SignUpViewModel


    override fun onStart() {
        super.onStart()
        signUpViewModel = ViewModelProviders.of(activity!!).get(SignUpViewModel::class.java)

        et_email.setText(signUpViewModel.user?.email)
        et_password.setText(signUpViewModel.user?.password)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up_access, container, false)


        return view
    }

    override fun onPause() {
        super.onPause()

        signUpViewModel.updateAccessData(et_email.text.toString(), et_password.text.toString())
    }




}
