import org.devkh.Frontend
import org.devkh.Backend
import org.devkh.Database

def call(Map projectType) {
    if (projectType.frontend) {
        Frontend.build(this)
    }
    if (projectType.backend) {
        Backend.build(projectType.backend, this)
    }
    if (projectType.database) {
        Database.migrate(this)
    }
}