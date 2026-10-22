sbt-salad-days
==============

sbt plugin to reduce Scaladoc JAR file size.

Most of a Scaladoc JAR is web fonts and scripts bundled with the HTML, not documentation.
This plugin leaves those files out when packaging, which roughly halves the JAR on Scala 3 and shrinks it by about a quarter on Scala 2.
The documentation itself stays complete.
Pages fall back to the browser's default fonts, some icons may show as plain text, and the Scala 3 search-by-type-signature feature is unavailable.
That is an acceptable trade-off because Scaladoc JARs are rarely opened directly: IDEs use the sources JAR, and people mostly read API docs on the web.

setup
-----

```scala
addSbtPlugin("com.eed3si9n" % "sbt-salad-days" % "0.2.0")
```
