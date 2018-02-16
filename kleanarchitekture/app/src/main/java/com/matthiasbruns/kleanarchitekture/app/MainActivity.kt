package com.matthiasbruns.kleanarchitekture.app

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.matthiasbruns.kleanarchitekture.app.feature.post.list.PostListController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ActionBarProvider {

    private lateinit var router: Router

    override val actionBar: ActionBar?
        get() = supportActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        router = Conductor.attachRouter(this, controller_container, savedInstanceState)
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(PostListController()))
        }
    }

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed()
        }
    }
}
