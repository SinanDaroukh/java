# Compte Rendu du TP9
#### Rendu par Sinan DAROUKH
[![made-with-Markdown](https://img.shields.io/badge/Made%20with-Markdown-1f425f.svg)](http://commonmark.org)

Le but de ce TP étant de corriger et améliorer un des tps précédemment réalisé. 
J'ai choisi de repartir du TP4 et d'implémenter les principes suivants :
- Principe 0-6 / Fundamentals-6 : Encapsulate
- Principe 2-1 / Confidential-1 : Purge sensitive information from exceptions
- Principe 4-5 / Extend-5 : Limit the extensibility of classes and methods

# Principe 0-6 / Fundamentals-6 : Encapsulate
Ici, il ne faut juste exposer ce qui est nécessaire. Les attributs doivent être privés et les accesseurs ne doivent pas être systématiquement créés.

Précedemment dans ma classe Coordinates, j'avais généré les accesseurs par réflexe... C'est une mauvaise habitude car les setters ne sont pas utilisés, et ne le seront pas...

Code avant modification :
```java
    private String lon;
    public String getLongitude() { return lon; }
    public void setLongitude(String longitude) { this.lon = longitude; }
```
Code après modification :
```java
    private String lon;
    public String getLongitude() { return lon; }
```

# Principe 2-1 / Confidential-1 : Purge sensitive information from exceptions
Ici, le but est de retirer toutes les informations qui pourrait être donner à un attaquant lorsque notre programme plante. Ainsi, il faut éviter au maximum d'imprimer la stack des appels car elle pourrait donner des informations cruciales pour réaliser une attaque.

Précedemment : 
```java
    try {
        WeatherFetcher weatherFetcher = new WeatherFetcher();
        weather = weatherFetcher.getWeatherAt(args[0]);
    } catch (Exception e){
        e.printStackTrace();
    }
```
Actuellement :
```java
    try {
        WeatherFetcher weatherFetcher = new WeatherFetcher();
        weather = weatherFetcher.getWeatherAt(args[0]);
    } catch (Exception e){
            System.err.println("A fatal error has occured...");
            throw new Exception();
    }
```

# Principe 4-5 / Extend-5 : Limit the extensibility of classes and methods
Dans le cas où un method ou classe n'a pas vocation à être héritée, il faut la placer en final.

Précedemment : 
```java
public class Wind {
    private Double speed;
    private Double deg;
    private Double gust;
    ...
}
```

Actuellement : 
```java
public final class Wind {
    private final Double speed;
    private final Double deg;
    private final Double gust;
    ...
}
```

# Principe 6-9 / MUTABLE-9 : Make public static fields final
Le but, ici, est de passer toutes nos constantes en finales afin qu'elles deviennent immuables.




