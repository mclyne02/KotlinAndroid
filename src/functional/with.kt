package functional

fun main() {
    // with()
    // very useful in order to perform many calls on the same object without having to repeat the object name
    // also a good way to structure the code to see that some of the assignments or statements actually belong together

    val props = System.getProperties()

    // Takes a receiver as the first argument and a lambda as the second
    with(props) {
        // You can use something like .list() which is
        props.list(System.out)
        // but since you are in the with function, you can simply omit the props and just call list() directly
        list(System.out)

        println(propertyNames().toList())
        // print out of above line
        // [java.runtime.name, sun.boot.library.path, java.vm.version, java.vm.vendor,
        // java.vendor.url, path.separator, java.vm.name, file.encoding.pkg, user.script,
        // user.country, sun.java.launcher, sun.os.patch.level, java.vm.specification.name,
        // user.dir, java.runtime.version, java.awt.graphicsenv, java.endorsed.dirs, os.arch,
        // java.io.tmpdir, line.separator, java.vm.specification.vendor, user.variant, os.name,
        // sun.jnu.encoding, java.library.path, java.specification.name, java.class.version,
        // sun.management.compiler, os.version, user.home, user.timezone, java.awt.printerjob,
        // file.encoding, java.specification.version, user.name, java.class.path, java.vm.specification.version,
        // sun.arch.data.model, java.home, sun.java.command, java.specification.vendor, user.language,
        // awt.toolkit, java.vm.info, java.version, java.ext.dirs, sun.boot.class.path, java.vendor,
        // file.separator, java.vendor.url.bug, sun.cpu.endian, sun.io.unicode.encoding, sun.desktop, sun.cpu.isalist]

        // You can see that there is a property called user.home
        // you can print this property out as well
        println(getProperty("user.home"))
    }
}