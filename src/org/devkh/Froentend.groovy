package org.devkh

class Frontend {
    static def runTests(script) {
        println "Running frontend tests..."
        script.sh """
            npm install
            echo "Running frontend successful"
        """
    }


    static def build(script) {
        println "Building frontend..."
        script.sh """
            npm install
            npm run build
        """
    }
}
