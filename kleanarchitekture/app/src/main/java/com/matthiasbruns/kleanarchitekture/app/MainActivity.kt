package com.matthiasbruns.kleanarchitekture.app

import android.content.Context
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.matthiasbruns.kleanarchitekture.app.conductor.ConductorComponent
import com.matthiasbruns.kleanarchitekture.app.conductor.ConductorModule
import com.matthiasbruns.kleanarchitekture.app.conductor.RouterProvider
import com.matthiasbruns.kleanarchitekture.app.feature.post.PostComponent
import com.matthiasbruns.kleanarchitekture.app.feature.post.PostModule
import com.matthiasbruns.kleanarchitekture.app.feature.post.list.PostListController
import com.matthiasbruns.kleanarchitekture.app.feature.user.UserComponent
import com.matthiasbruns.kleanarchitekture.app.feature.user.UserModule
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ActionBarProvider, RouterProvider {

    companion object {

        fun instance(context: Context): MainActivity? = context  as? MainActivity
    }

    //region Dagger

    private lateinit var component: ConductorComponent

    val postComponent: PostComponent by lazy { component.plus(PostModule()) }

    val userComponent: UserComponent by lazy { component.plus(UserModule()) }

    //endregion

    private lateinit var router: Router

    override val actionBar: ActionBar?
        get() = supportActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        router = Conductor.attachRouter(this, controller_container, savedInstanceState)
        component = KleanApp.instance(this)
                ?.component
                ?.plus(ConductorModule(this)) ?: throw Error("Could not initiate dagger")

        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(PostListController()))
        }
    }

    override fun provide(): Router = router

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed()
        }
    }
}
