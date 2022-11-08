# angry-balls
angry-balls optimizing and factoring code


HOWTO:

FILE > PROJET STUCTURE > LIBRAIRIES > + 
> malibrairiegui.jar 
> malibrairiesonique.jar
> mesmaths_sources_avec_awt.jar

Si pas de projet source
clique droit sur src -> mark directory as source 

Src>Base>TestAngryBalls | Run TestAngryBalls


SON:
> Gèrer dans TestAngryBalls ligne 33

```java
File repertoireSon = new File(file.getAbsoluteFile(),"src" + File.separatorChar + "bruits");
```
Modifier ce path pour qu'il corresponde au dossier src>base>bruits
