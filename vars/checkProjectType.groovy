def call() {
    def type = [:]
    
    if (fileExists('package.json')) {
        type.frontend = 'react'
        if (fileExists('next.config.js')) {
            type.frontend = 'nextjs'
        }
    }
    
    if (fileExists('pom.xml')) {
        type.backend = 'maven'
    } else if (fileExists('build.gradle') || fileExists('build.gradle.kts')) {
        type.backend = 'gradle'
    } else if (fileExists('main.py') && fileExists('requirements.txt')) {
        type.backend = 'fastapi'
    }
    
    if (fileExists('flyway.conf') || fileExists('liquibase.properties')) {
        type.database = 'postgres'
    }
    
    return type
}
// def call() {
//     def type = [:]
    
//     if (fileExists('package.json')) {
//         type['frontend'] = 'react'
//         if (fileExists('next.config.js')) {
//             type['frontend'] = 'nextjs'
//         }
//     }
    
//     if (fileExists('pom.xml')) {
//         type['backend'] = 'maven'
//     } else if (fileExists('build.gradle') || fileExists('build.gradle.kts')) {
//         type['backend'] = 'gradle'
//     } else if (fileExists('main.py') && fileExists('requirements.txt')) {
//         type['backend'] = 'fastapi'
//     }
    
//     if (fileExists('flyway.conf') || fileExists('liquibase.properties')) {
//         type['database'] = 'postgres'
//     }
    
//     return type  // Return a map with keys like 'frontend', 'backend', 'database'
// }
