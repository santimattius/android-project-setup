# Android Convention Plugins
Shared your gradle configurations using plugins and Version Catalog. Fork: https://github.com/android/nowinandroid/tree/main/build-logic 

## Keep your configuration consistent

Every module introduces configuration overhead. If the number of your modules reaches a certain threshold, managing consistent configuration becomes a challenge. For example, it’s important that modules use dependencies of the same version. If you need to update a large number of modules just to bump a dependency version, it is not only an effort but also a room for potential mistakes. To solve this problem, you can use one of the gradle’s tools to centralize your configuration:

- [Version catalogs](https://docs.gradle.org/current/userguide/platforms.html) are a type safe list of dependencies generated by Gradle during sync. It’s a central place to declare all your dependencies and is available to all the modules in a project.
- Use [convention plugins](https://docs.gradle.org/current/samples/sample_convention_plugins.html) to share build logic between modules.

