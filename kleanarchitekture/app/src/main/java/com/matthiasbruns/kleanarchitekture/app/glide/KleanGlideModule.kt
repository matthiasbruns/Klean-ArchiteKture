package com.matthiasbruns.kleanarchitekture.app.glide

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions

@GlideModule
class KleanGlideModule : AppGlideModule() {

    var diskCacheSize = 52428800L

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.apply {
            val calculator = MemorySizeCalculator.Builder(context).build()
            setDiskCache(InternalCacheDiskCacheFactory(context, diskCacheSize))

            setMemoryCache(LruResourceCache(calculator.memoryCacheSize.toLong()))
            setBitmapPool(LruBitmapPool(calculator.bitmapPoolSize.toLong()))

            setDefaultRequestOptions(RequestOptions.formatOf(DecodeFormat.PREFER_ARGB_8888))
        }

    }
}