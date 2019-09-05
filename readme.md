# demo-spring-security

Mini TP effectué pour apprendre à utiliser Spring Security.

Requête pour s'authentifier comme utilisateur avec les rôles utilisateur et admin :

[POST] http://localhost:8080/auth

```JSON
{
    "nomUtilisateur" : "u1",
    "motDePasse" : "pass1"
}
```

Requête pour s'authentifier comme utilisateur avec le rôle utilisateur :

[POST] http://localhost:8080/auth

```JSON
{
    "nomUtilisateur" : "u2",
    "motDePasse" : "pass2"
}
```

[GET] http://localhost:8080/admin est uniquement accessible après une connexion d'un utilisateur avec le rôle admin

Consulter la base de données h2 :

http://localhost:8080/h2-console
```
User Name : sa
Password : 
```