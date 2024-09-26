package org.devkh

class Database {
    static def runTests() {
        println "Running database tests..."
        sh """
            # Assuming you have a script to run database tests
            ./run_db_tests.sh
        """
    }

    static def migrate() {
        println "Running database migrations..."
        sh """
            # Assuming you're using a tool like Flyway or Liquibase
            flyway migrate
        """
    }
}