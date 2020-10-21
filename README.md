Markowl
=======

Markdown extended plugin for JetBrains IDEs and owl🦉

![](docs/images/demo.gif)


Features
--------

Support encodings

* UTF-8
* SJIS


### Format Table

![](docs/images/format-table.gif)

| Action         | Default shortcut key |
| -------------- | -------------------- |
| Format Table   | `Alt + ;`            |


### Draw Header Line

![](docs/images/draw-header-line.gif)

| Action       | Default shortcut key |
| ------------ | -------------------- |
| Draw H1 Line | `Alt + -`            |
| Draw H2 Line | `Alt + =`            |


### Draw Header Prefix

![](docs/images/draw-header-prefix.gif)

| Action         | Default shortcut key |
| -------------- | -------------------- |
| Draw H1 Prefix | `Alt + 1`            |
| Draw H2 Prefix | `Alt + 2`            |
| Draw H3 Prefix | `Alt + 3`            |
| Draw H4 Prefix | `Alt + 4`            |
| Draw H5 Prefix | `Alt + 5`            |


FAQ
---

### How can I change shortcut keys? I can't or don't want to use default shortcut keys

You can configure them in `Keymap`. Please see the official documentation for details.

ex: IntelliJ IDEA: [Keymap \- Help \| IntelliJ IDEA](https://www.jetbrains.com/help/idea/settings-keymap.html)

![](docs/images/keymap.png)

(IntelliJ IDEA for Windows)


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

- [ ] Update `plugin.xml` and commit (OPTIONAL)
- [ ] Update `build.gradle`
    - [ ] changeNotes
- [ ] make release version=x.y.z
- [ ] Upload `build/distributions/markowl-${version}.zip` to [JetBrains market]

[JetBrains market]: https://plugins.jetbrains.com/plugin/14116-markowl
