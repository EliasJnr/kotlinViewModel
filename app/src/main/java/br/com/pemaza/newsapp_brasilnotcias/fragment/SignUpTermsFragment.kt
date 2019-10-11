package br.com.pemaza.newsapp_brasilnotcias.fragment


import android.arch.lifecycle.ViewModelProviders
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import br.com.pemaza.newsapp_brasilnotcias.R
import br.com.pemaza.newsapp_brasilnotcias.logic.SignUpViewModel
import kotlinx.android.synthetic.main.fragment_sign_up_terms.*
import me.drakeet.materialdialog.MaterialDialog

class SignUpTermsFragment : Fragment(), CompoundButton.OnCheckedChangeListener,
    View.OnClickListener {

    lateinit var signUpViewModel: SignUpViewModel


    override fun onStart() {
        super.onStart()
        signUpViewModel = ViewModelProviders.of(activity!!).get(SignUpViewModel::class.java)

        cb_terms.setOnCheckedChangeListener(this)
        bt_send.setOnClickListener(this)
        onCheckedChanged(null, signUpViewModel.user?.statusTerms ?: false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up_terms, container, false)

        view.findViewById<CheckBox>(R.id.cb_terms)
            .setOnCheckedChangeListener(this)

        view.findViewById<Button>(R.id.bt_send)
            .setOnClickListener(this)

        return view
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        bt_send.isEnabled = isChecked
    }

    override fun onClick(v: View?) {
        val layout = LayoutInflater.from(activity).inflate(R.layout.dialog_personal, null, false)


        val tvName = layout.findViewById<TextView>(R.id.tv_name)
        tvName.text = signUpViewModel.user?.name

        val tvProfession = layout.findViewById<TextView>(R.id.tv_profession)
        tvProfession.text = signUpViewModel.user?.profession

        val uriImg = Uri.parse(signUpViewModel.user?.imagePath)
        val ivProfile = layout.findViewById<ImageView>(R.id.iv_profile)
        ivProfile.setImageURI(uriImg)

        MaterialDialog(activity)
            .setContentView(layout)
            .setCanceledOnTouchOutside(true)
            .show()
    }

    override fun onPause() {
        super.onPause()
        signUpViewModel.updateTermsData(cb_terms.isChecked)
    }

}
