package org.devkh

class Backend {
    static def runTests(String buildTool, script) {
        println "Running backend tests..."
        switch(buildTool) {
            case 'maven':
                script.sh "mvn test"
                break
            case 'gradle':
                script.sh "./gradlew test"
                break
            case 'fastapi':
                script.sh """
                    pip install -r requirements.txt
                    pytest
                """
                break
            default:
                error "Unsupported build tool: ${buildTool}"
        }
    }

    static def build(String buildTool, script) {
        println "Building backend..."
        switch(buildTool) {
            case 'maven':
                script.sh "mvn package"
                break
            case 'gradle':
                script.sh "./gradlew build"
                break
            case 'fastapi':
                script.sh """
                    pip install -r requirements.txt
                    pip install uvicorn
                    # FastAPI doesn't need a build step, but we can create a requirements.txt
                    pip freeze > requirements.txt
                """
                break
            default:
                error "Unsupported build tool: ${buildTool}"
        }
    }
}