package custom.scriptDefinition

import kotlin.script.dependencies.*
import kotlin.script.experimental.dependencies.*
import kotlin.script.templates.*
import java.io.File
import kotlin.script.experimental.location.*

class TestDependenciesResolver : AsyncDependenciesResolver {
    suspend override fun resolveAsync(scriptContents: ScriptContents, environment: Environment): DependenciesResolver.ResolveResult {
        return ScriptDependencies(
                classpath = environment["template-classes"] as List<File>
        ).asSuccess()
    }
}

@ScriptExpectedLocations([ScriptExpectedLocation.Everywhere])
@ScriptTemplateDefinition(TestDependenciesResolver::class, scriptFilePattern = "script.kts")
class Template : Base()

open class Base {
    val i = 3
    val str = ""
}