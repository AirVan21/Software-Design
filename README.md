# Software Design Course in SPbAU
  
    Implementation of simple command line interpreter
---
## Installation steps:

    1. Clone repo
    2. Open project in Intellij IDEA
    3. Install [ANTLR v4 grammar plugin](https://plugins.jetbrains.com/plugin/7358?pr=)
    4. Open ShellGrammar.g4 file (grammar file)
    5. Configure ANTLRv4 (right click menu)
    6. Choose "generate parse tree visitor"
    7. Generate ANTLRv4 classes (Ctrl + Shift + G)
    8. Mark "gen" folder as "Generated Sources Root"
## Testing:

Run ```mvn install``` in root directory

## Supported funtionality:
   * cat
   * echo
   * wc
   * pwd
   * exit
   * key = value (environment variables)
   * $ and |
   * full and weak quoting