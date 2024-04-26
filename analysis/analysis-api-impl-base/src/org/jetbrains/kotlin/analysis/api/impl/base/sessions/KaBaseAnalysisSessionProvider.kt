/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.impl.base.sessions

import com.intellij.openapi.project.Project
import org.jetbrains.kotlin.analysis.api.lifetime.KtLifetimeTokenFactory
import org.jetbrains.kotlin.analysis.api.session.KtAnalysisSessionProvider
import org.jetbrains.kotlin.analysis.providers.lifetime.KtLifetimeTokenProvider

abstract class KaBaseAnalysisSessionProvider(project: Project) : KtAnalysisSessionProvider(project) {
    override val tokenFactory: KtLifetimeTokenFactory by lazy(LazyThreadSafetyMode.PUBLICATION) {
        KtLifetimeTokenProvider.getService(project).getLifetimeTokenFactory()
    }
}
