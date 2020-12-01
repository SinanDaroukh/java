# Compte Rendu du TP9
#### Rendu par Sinan DAROUKH
[![made-with-Markdown](https://img.shields.io/badge/Made%20with-Markdown-1f425f.svg)](http://commonmark.org)

Le but de ce TP étant de corriger et améliorer un des tps précédemment réalisé. 
J'ai choisi de repartir du TP4/TP6 et d'implémenter les principes suivants :
- Principe 0-6 / Fundamentals-6 : Encapsulate
- Principe 2-1 / Confidential-1 : Purge sensitive information from exceptions
- Principe 3-2 / Inject-2 : Avoid dynamic SQL
- Principe 4-5 / Extend-5 : Limit the extensibility of classes and methods
- Principe 6-9 / Mutable-9 : Make public static fields final
- Principe 6-10 / Mutable-10 : Ensure public static final field values are constants


# Principe 0-6 / Fundamentals-6 : Encapsulate
Ici, il ne faut juste exposer ce qui est nécessaire. Les attributs doivent être privés et les accesseurs ne doivent pas être systématiquement créés.

Précedemment dans ma classe Coordinates, j'avais généré les accesseurs par réflexe... C'est une mauvaise habitude car les setters ne sont pas utilisés, et ne le seront pas...

Code avant modification :
```java
public class Coordinates {
    ...
    private String lon;
    public String getLongitude() { return lon; }
    public void setLongitude(String longitude) { this.lon = longitude; }
    ...
}
```
Code après modification :
```java
public class Coordinates {
    ...
    private String lon;
    public String getLongitude() { return lon; }
    ...
}
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

# Principe 3-2 / Inject-2 : Avoid dynamic SQL
Il est bien connu que les instructions SQL créées dynamiquement, y compris les entrées non fiables, sont soumises à l'injection de commandes. Ainsi, il faut les éviter au maximum, pour ce faire on utilisera donc des prepared statements. 

```java
public static void insertWeatherFetched(Weather weather) throws SQLException {
    String sql = "INSERT INTO weather(fetchedAt) VALUES(?)";
    try (Connection conn = DriverManager.getConnection(url);
    PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, weather.getDt());
        pstmt.executeUpdate();
        System.out.println("Query has been added to database");
    }
    catch (SQLException e) {
        throw e;
    }
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

Précedemment :
```java
String API_KEY = "fdec5664d19caf22895d3aaf207d3d43";
```

Actuellement :
```java
package Utils;
public final class Constantes {
    public static final String API_KEY = "fdec5664d19caf22895d3aaf207d3d43";
}
```

# Principe 6-10 / Mutable-10 : Ensure public static final field values are constants
Le but est ici de s'assurer que les champs déclarés en public static final sont bien constant.

Précedemment :
```java
import Utils.Constantes;
```

Actuellement :
```java
import static Utils.Constantes.API_KEY;
```







