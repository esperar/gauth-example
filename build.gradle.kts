import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.10"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"
}

group = "esperer"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
	maven { url = uri("https://jitpack.io") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	runtimeOnly("com.mysql:mysql-connector-j")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	implementation("org.springframework.boot:spring-boot-starter-data-redis")


	// feign
	implementation("io.github.openfeign:feign-httpclient:11.9.1")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign:3.1.4")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")

	// annotation processor
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	implementation("com.github.GSM-MSG:GAuth-SDK-Java:v2.0.0")

	implementation("io.jsonwebtoken:jjwt-api:0.11.5")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")


}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
