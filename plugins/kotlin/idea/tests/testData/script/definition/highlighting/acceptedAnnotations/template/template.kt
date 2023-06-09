package custom.scriptDefinition

import java.io.File
import kotlin.script.dependencies.*
import kotlin.script.experimental.dependencies.*
import kotlin.script.templates.ScriptTemplateDefinition
import kotlin.script.experimental.location.ScriptExpectedLocation
import kotlin.script.experimental.location.ScriptExpectedLocations

class TestDependenciesResolver : DependenciesResolver {
    @kotlin.script.templates.AcceptedAnnotations(Anno::class)
    override fun resolve(
            scriptContents: ScriptContents,
            environment: Environment
    ): DependenciesResolver.ResolveResult {
        val annoFQN = Anno::class.qualifiedName!!
        assert(scriptContents.annotations.single().annotationClass.qualifiedName == annoFQN)
        return ScriptDependencies(
                classpath = environment["template-classes"] as List<File>,
                imports = listOf(annoFQN)
        ).asSuccess()
    }
}

@Target(AnnotationTarget.FILE)
annotation class Anno

@Target(AnnotationTarget.FILE)
annotation class Anno2

@ScriptExpectedLocations([ScriptExpectedLocation.Everywhere])
@ScriptTemplateDefinition(TestDependenciesResolver::class, scriptFilePattern = "script.kts")
class Template