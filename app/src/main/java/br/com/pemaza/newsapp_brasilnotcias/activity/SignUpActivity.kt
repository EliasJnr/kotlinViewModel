package br.com.pemaza.newsapp_brasilnotcias.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import br.com.pemaza.newsapp_brasilnotcias.R
import br.com.pemaza.newsapp_brasilnotcias.conf.SectionsPagerAdapter
import br.com.pemaza.newsapp_brasilnotcias.fragment.SignUpPersonalFragment
import kotlinx.android.synthetic.main.activity_sign_up.*
import me.iwf.photopicker.PhotoPicker

class SignUpActivity : AppCompatActivity() {

    lateinit private var mSectionsPagerAdapter: SectionsPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mSectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)

        container.adapter = mSectionsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))

    }

    override fun onStart() {
        super.onStart()
        toolbar.title = resources.getString(R.string.title_activity_sign_up)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == android.R.id.home) {
            finish()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && requestCode == PhotoPicker.REQUEST_CODE && data != null) {

            val photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS)

            val fragment = supportFragmentManager.findFragmentByTag(
                "android:switcher:${container.id}:${mSectionsPagerAdapter.getItemId(0)}"
            ) as SignUpPersonalFragment

            fragment.updatePhoto(photos[0])

        }
    }
}
