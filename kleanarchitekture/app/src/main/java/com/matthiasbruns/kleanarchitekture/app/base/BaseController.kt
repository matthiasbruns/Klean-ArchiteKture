package com.matthiasbruns.kleanarchitekture.app.base

import android.os.Bundle
import android.support.v7.app.ActionBar
import com.bluelinelabs.conductor.Controller
import com.matthiasbruns.kleanarchitekture.app.ActionBarProvider


abstract class BaseController : Controller {

    protected constructor() {}

    protected constructor(args: Bundle) : super(args) {}

    protected val actionBar: ActionBar?
        get() = (activity as? ActionBarProvider)?.actionBar
}