
# Context
L'objectif est d'implémenter une simulation de la propagation d’un feu de forêt.

Durée indicative de l’exercice : environ 3h/4h



La forêt est représentée par une grille de dimension h x l.

La dimension temporelle est discrétisée. Le déroulement de la simulation se fait donc étape par étape.

Dans l’état initial, une ou plusieurs cases sont en feu.

Si une case est en feu à l’étape t, alors à l’étape t+1 :

·               Le feu s'éteint dans cette case (la case est remplie de cendre et ne peut ensuite plus brûler)

·               et il y a une probabilité p que le feu se propage à chacune des 4 cases adjacentes

La simulation s’arrête lorsqu’il n’y a plus aucune case en feu

Les dimensions de la grille, la position des cases initialement en feu, ainsi que la probabilité de propagation, sont des paramètres du programme stockés dans un fichier de configuration (format libre).

# Project Details
This project is entirely implemented in a client and server-side application using Java 8 and TypeScript.

The client-side application is built using Vue.js and TypeScript, providing an interactive interface for users to simulate fire propagation in a forest grid. The server-side Spring Boot application processes the simulation logic, manages configuration files, and exposes RESTful APIs for seamless communication with the client.
# Configuration
The configuration that will trigger the initial values for the forest is editable in a ``app.config`` file. 
The representation of the values might be displayed in the following format:
```java
forest.height=5
forest.width=5
forest.initialFire=3,1
forest.probability=0.7
```

# Launching the project
Maven is used to encompass all the dependencies versions. Please note that this code base is written in Java 8.
Vite is used as a module bundler to compile and bundle the TS code and to configure the Vue app.

First of all, you need to fire up the backend by installing all the dependencies and launching the server:
```bash
cd .\fireforest-server\
mvn clean install      
mvn spring-boot:run 
```
Then parallelly you'll launch the frontend by installing the needed packages and starting the client app:
```bash
cd .\fireforest-client\     
npm i
npm run build
npm run serve
```
You can test functionally the server by accessing it in ``localhost:8080``.
The client app is accessible in ``localhost:4173/``.

# Demo
![demo](https://i.imgur.com/LFm0IMi.gif)
