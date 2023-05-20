# scala-platform
A tiny library for determining what platform you are running on at runtime.

--------

To use this library, add the following dependency to your `build.sbt`:

```scala
"lgbt.princess" %%% "platform" % "1.0.0"
```

--------

The entirety of the library is a `Platform` object with the
following interface:

```scala
package lgbt.princess.platform

object Platform {
  final val isJVM    = ???
  final val isJS     = ???
  final val isNative = ???
}
```

with the methods returning the appropriate value on each platform.
