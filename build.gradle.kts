plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.9.10"
    id("org.jetbrains.intellij") version "1.15.0"
}

group = "com.jetbrains"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.10.1")
}

intellij {
    version.set("2023.1.5")
    type.set("IU")
    plugins.set(listOf())
}

tasks {
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    patchPluginXml {
        sinceBuild.set("231")
        untilBuild.set("242.*")
    }

    signPlugin {
        val chain = System.getenv("CERTIFICATE_CHAIN")
        val key = System.getenv("PRIVATE_KEY")
        val pass = System.getenv("PRIVATE_KEY_PASSWORD")
        
        if (chain != null && key != null && pass != null) {
            certificateChain.set(chain)
            privateKey.set(key)
            password.set(pass)
        }
    }

    publishPlugin {
        val publishToken = System.getenv("PUBLISH_TOKEN")
        if (publishToken != null) {
            token.set(publishToken)
        }
    }
}
