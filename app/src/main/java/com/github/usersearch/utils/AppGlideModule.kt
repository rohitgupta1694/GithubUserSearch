package com.github.usersearch.utils

import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

@GlideModule
class AppGlideModule : AppGlideModule() {
    override fun isManifestParsingEnabled(): Boolean {
        return false
    }
}