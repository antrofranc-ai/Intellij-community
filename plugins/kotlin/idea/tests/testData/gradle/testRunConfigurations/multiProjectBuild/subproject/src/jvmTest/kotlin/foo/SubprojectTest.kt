// !RENDER_TAGS: PROJECT, SETTINGS

package foo

import org.junit.Test

class <lineMarker descr="Run Test" project="subproject", settings=":subproject:cleanJvmTest :subproject:jvmTest --tests \"foo.SubprojectTest\"">SubprojectTest</lineMarker> {
    @Test
    fun <lineMarker descr="Run Test" project="subproject", settings=":subproject:cleanJvmTest :subproject:jvmTest --tests \"foo.SubprojectTest.otherTest\"">otherTest</lineMarker>() {

    }
}