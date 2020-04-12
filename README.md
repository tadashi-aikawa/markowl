Markowl
=======

Markdown extended plugin for JetBrains IDEs and owl🦉

Features
--------

* Format Table
* Draw H1/H2 Line

Support encodings

* UTF-8
* SJIS


### Format Table

![](docs/images/format-table.gif)

### Draw H1/H2 Line

![](docs/images/draw-header-line.gif)


For developers
--------------

### Run on development instance

```console
gradle runIde
```

### Build distribution

```console
gradle buildPlugin
```

### Release

- [ ] Update `build.gradle`
    - [ ] version
    - [ ] changeNotes
- [ ] Build distribution
- [ ] Commit
- [ ] Tagged
- [ ] Push
    - [ ] With `--tags`
    - [ ] Without `--tags`
- [ ] Upload `build/distributions/markowl-${version}.zip` to [JetBrains market]

[JetBrains market]: https://plugins.jetbrains.com/plugin/edit?pluginId=14116
