package sample

actual class <!LINE_MARKER("descr='Has expects in top module'")!>A<!> {
    actual fun <!LINE_MARKER("descr='Has expects in top module'")!>foo<!>(): Int = 45
    fun fromBottom(): Int = 0
}

fun <!LINE_MARKER!>main<!>() {
    A().foo()

    // Any behaviour is acceptable, as the code is erroneous.
    // At the time of writing this test, we resolve to nearest A, i.e.
    //  'fromBottom' is resolved, and 'fromLeft' is not.
    A().<!UNRESOLVED_REFERENCE!>fromLeft<!>()
    A().fromBottom()
}
