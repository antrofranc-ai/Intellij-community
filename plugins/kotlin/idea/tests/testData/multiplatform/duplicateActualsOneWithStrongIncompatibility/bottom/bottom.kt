// !RENDER_DIAGNOSTICS_MESSAGES

package foo

actual fun <!LINE_MARKER("descr='Has expects in top module'")!>foo<!><!ACTUAL_WITHOUT_EXPECT("Actual function 'foo'; The following declaration is incompatible because number of value parameters is different:    public expect fun foo(): Int")!>(x: Int)<!>: Int = x
