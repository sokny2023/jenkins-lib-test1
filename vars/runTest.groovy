import org.devkh.Frontend
import org.devkh.Backend
import org.devkh.Database

def call(Map projectType) {
    if (projectType.frontend) {
        Frontend.runTests(this)
    }
    if (projectType.backend) {
        Backend.runTests(projectType.backend,this)
    }
    if (projectType.database) {
        Database.runTests()
    }
}