/*
 * Copyright (c) 2022 Matthias Geisler (bitPogo) / All rights reserved.
 *
 * Use of this source code is governed by Apache v2.0
 */

package tech.antibytes.project.example.app

import kotlinx.coroutines.flow.StateFlow

interface AppContract {
    interface SampleViewModel {
        val flow: StateFlow<String>

        fun doSomething()
    }
}
