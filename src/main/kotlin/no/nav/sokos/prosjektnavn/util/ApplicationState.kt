package no.nav.sokos.prosjektnavn.util

import no.nav.sokos.prosjektnavn.metrics.Metrics
import kotlin.properties.Delegates

class ApplicationState(
    alive: Boolean = true,
    ready: Boolean = false
) {
    var alive: Boolean by Delegates.observable(alive) { _, _, newValue ->
        if (!newValue) Metrics.appStateReadyFalse.inc()
    }
    var ready: Boolean by Delegates.observable(ready) { _, _, newValue ->
        if (!newValue) Metrics.appStateRunningFalse.inc()
    }
}
