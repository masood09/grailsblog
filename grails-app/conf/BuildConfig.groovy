grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    // test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    test: false,
    // configure settings for the run-app JVM
    run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the run-war JVM
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    def mysqlConnectorJavaVersion = "5.1.27"
    def postgresqlVersion = "9.1-901.jdbc4"
    def postgresqlOrgVersion = "9.3-1100-jdbc41"
    def gebVersion = "0.9.2"
    def seleniumVersion = "2.37.0"
    def tomcatVersion = "7.0.47"
    def scaffoldingVersion = "2.0.1"
    def cacheVersion = "1.1.1"
    def springSecurityCoreVersion = "2.0-RC2"
    def slugGeneratorVersion = "0.3.1"
    def hibernateVersion = "3.6.10.4"
    def hibernate4Version = "4.1.11.4"
    def databaseMigrationVersion = "1.3.8"
    def jqueryVersion = "1.10.2.2"
    def resourcesVersion = "1.2.1"
    def zippedResourcesVersion = "1.0.1"
    def cachedResourcesVersion = "1.1"
    def yuiMinifyResourcesVersion = "0.1.5"

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
        mavenRepo 'http://repo.spring.io/milestone'

        // For Geb snapshot
        mavenRepo "http://oss.sonatype.org/content/repositories/snapshots"
    }

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
        // runtime "mysql:mysql-connector-java:$mysqlConnectorJavaVersion"
        // runtime "postgresql:postgresql:$postgresqlVersion"
        runtime "org.postgresql:postgresql:jar:$postgresqlOrgVersion"

        test "org.seleniumhq.selenium:selenium-firefox-driver:$seleniumVersion"
        test "org.gebish:geb-spock:$gebVersion"
    }

    plugins {
        // plugins for the build system only
        build ":tomcat:$tomcatVersion"

        // plugins for the compile step
        compile ":scaffolding:$scaffoldingVersion"
        compile ":cache:$cacheVersion"
        compile ":spring-security-core:$springSecurityCoreVersion"
        compile ":slug-generator:$slugGeneratorVersion"

        // plugins needed at runtime but not for compilation
        runtime ":hibernate:$hibernateVersion" // or ":hibernate4:$hibernate4Version"
        // runtime ":database-migration:$databaseMigrationVersion"
        // runtime ":jquery:$jqueryVersion"
        runtime ":resources:$resourcesVersion"
        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:$zippedResourcesVersion"
        //runtime ":cached-resources:$cachedResourcesVersion"
        //runtime ":yui-minify-resources:$yuiMinifyResourcesVersion"

        test ":geb:$gebVersion"
    }
}
