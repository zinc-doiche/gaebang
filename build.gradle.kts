import org.hidetake.groovy.ssh.core.Remote
import org.hidetake.groovy.ssh.core.RunHandler
import org.hidetake.groovy.ssh.session.SessionHandler

plugins {
    kotlin("jvm") version "2.1.21"
    id("org.hidetake.ssh") version "2.11.2"
    id("io.papermc.paperweight.userdev") version "2.0.0-beta.17"
}

group = "com.devport"
version = "0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    paperweight.paperDevBundle("1.21.6-R0.1-SNAPSHOT")
}

kotlin {
    jvmToolchain(21)
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

// Get user home directory in a platform-independent way
val userHome = System.getProperty("user.home")
// Construct path to SSH key file
val sshKeyPath = "$userHome${File.separator}.ssh${File.separator}id_rsa_doiche"

val server = Remote(
    mapOf<String, Any>(
        "host" to project.property("host") as String,
        "port" to (project.property("port") as String).toInt(),
        "user" to project.property("user") as String,
        "identity" to File(sshKeyPath)
    )
)

tasks {
    test {
        useJUnitPlatform()
    }

    register(name = "deploy") {

        group = "deploy"

        dependsOn("build")

        doLast {
            ssh.run(delegateClosureOf<RunHandler> {
                session(server, delegateClosureOf<SessionHandler> {
                    val file = "$projectDir/build/libs/${project.name}-${project.version}.jar"
                    val directory = "/home/pi/Desktop/minecraft/${project.name}/plugins"

                    logger.lifecycle("${project.name} 배포 중: $file")

                    put(
                        hashMapOf(
                            "from" to file,
                            "into" to directory
                        )
                    )

                    logger.lifecycle("${project.name} 배포 완료!")
                })
            })
        }
    }
}