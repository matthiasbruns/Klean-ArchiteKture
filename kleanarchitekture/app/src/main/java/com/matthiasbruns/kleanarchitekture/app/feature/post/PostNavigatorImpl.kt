package com.matthiasbruns.kleanarchitekture.app.feature.post

import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.matthiasbruns.kleanarchitekture.app.feature.post.detail.PostDetailController
import com.matthiasbruns.kleanarchitekture.app.feature.post.mapper.ParcelablePresentationPostItemMapper
import com.matthiasbruns.kleanarchitekture.app.feature.user.detail.UserDetailController
import com.matthiasbruns.kleanarchitekture.presentation.post.PostNavigator
import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPost
import javax.inject.Inject

class PostNavigatorImpl @Inject constructor(private val router: Router,
                                            private val parcelableMapper: ParcelablePresentationPostItemMapper,
                                            private val changeHandler: ControllerChangeHandler) : PostNavigator {

    override fun openPostDetail(post: PresentationPost) {
        val detailController = PostDetailController.create(parcelableMapper.mapTo(post))

        val transaction = RouterTransaction.with(detailController)
        transaction
                .pushChangeHandler(changeHandler)
                .popChangeHandler(changeHandler)

        router.pushController(transaction)
    }

    override fun openPostAuthor(post: PresentationPost) {
        val detailController = UserDetailController.create(post.userId)

        val transaction = RouterTransaction.with(detailController)
        transaction
                .pushChangeHandler(changeHandler)
                .popChangeHandler(changeHandler)

        router.pushController(transaction)
    }
}