# scala-platform
A tiny library for determining what platform you are running on at runtime

The entirety of the library is a `Platform` object with the
following interface:

```scala
object Platform {
  def isJVM: Boolean    = ???
  def isJS: Boolean     = ???
  def isNative: Boolean = ???
}
```

with the methods returning the appropriate value on each platform.
