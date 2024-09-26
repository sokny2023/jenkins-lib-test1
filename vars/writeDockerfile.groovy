def call(def projectType) {
    def dockerfileType

    if (projectType instanceof Map) {
        if (projectType.frontend == 'nextjs') {
            dockerfileType = 'next'
        } else if (projectType.frontend == 'react') {
            dockerfileType = 'react'
        } else {
            error "Unsupported frontend type: ${projectType.frontend}"
        }
    } else if (projectType instanceof String) {
        dockerfileType = projectType
    } else {
        error "Unsupported projectType: ${projectType}"
    }

    def dockerfileContent = libraryResource("${dockerfileType}-dockerfile")
    writeFile file: 'Dockerfile', text: dockerfileContent
    println "Dockerfile for ${dockerfileType} has been written to the project root."
}