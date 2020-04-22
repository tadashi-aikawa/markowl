Markowl
=======

Markdown extended plugin for JetBrains IDEs and owl🦉

![](docs/images/demo.gif)


Features
--------

| Action            | Demo                                  | Default Shortcut |
| ----------------- | ------------------------------------- | ---------------- |
| Format Table      | ![](docs/images/format-table.gif)     | `Alt + ;`        |
| Draw H1 Line      | ![](docs/images/draw-header-line.gif) | `Alt + -`        |
| Draw H2 Line      | ![](docs/images/draw-header-line.gif) | `Alt + =`        |

Support encodings

* UTF-8
* SJIS


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

- [ ] Update `plugin.xml` (OPTIONAL)
- [ ] Update `build.gradle`
    - [ ] changeNotes
- [ ] make release version=x.y.z
- [ ] Upload `build/distributions/markowl-${version}.zip` to [JetBrains market]

[JetBrains market]: https://plugins.jetbrains.com/plugin/edit?pluginId=14116
