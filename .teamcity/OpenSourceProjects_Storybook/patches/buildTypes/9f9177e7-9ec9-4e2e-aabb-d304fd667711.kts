package OpenSourceProjects_Storybook.patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2017_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with uuid = '9f9177e7-9ec9-4e2e-aabb-d304fd667711' (id = 'OpenSourceProjects_Storybook_Test')
accordingly, and delete the patch script.
*/
changeBuildType("9f9177e7-9ec9-4e2e-aabb-d304fd667711") {
    expectSteps {
        script {
            name = "Test"
            scriptContent = """
                #!/bin/sh
                
                set -e -x
                
                yarn
                yarn test --core --coverage --runInBand --teamcity
            """.trimIndent()
            dockerImage = "node:%docker.node.version%"
        }
    }
    steps {
        update<ScriptBuildStep>(0) {
            scriptContent = """
                #!/bin/sh
                
                set -e -x
                
                yarn
                yarn bootstrap --core
                yarn test --core --coverage --runInBand --teamcity
            """.trimIndent()
        }
    }
}
