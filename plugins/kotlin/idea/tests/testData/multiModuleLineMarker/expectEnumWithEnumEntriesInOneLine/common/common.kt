package test

expect enum class <!LINE_MARKER("descr='Has actuals in jvm module'")!>Enum<!> {
    <!LINE_MARKER("descr='Has actuals in jvm module'")!>A<!>, B, C, D
}

/*
LINEMARKER: Has actuals in JVM
TARGETS:
jvm.kt
actual enum class <1>Enum {
*//*
LINEMARKER: Has actuals in JVM
TARGETS:
jvm.kt
    <1>A, <2>B, <3>C, <4>D
*/
