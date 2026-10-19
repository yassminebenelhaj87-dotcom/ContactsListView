# ContactsListView

Une application Android simple développée en Kotlin permettant d'afficher, sélectionner et modifier une liste de contacts.

# Fonctionnalités

- **Affichage de la liste des contacts** : Utilisation d'une `ListView` avec un `ArrayAdapter` pour présenter la liste initiale.
- **Sélection d'un contact** : Un clic sur un contact l'active visuellement et remplit automatiquement le champ de saisie (`EditText`).
- **Modification d'un contact** : Mise à jour du nom du contact sélectionné via le bouton **Modifier** ou la touche de validation du clavier (**IME Done**).
- **Validation des données** :
  - Vérification qu'un contact est sélectionné avant toute modification.
  - Alerte si le champ du nouveau nom est vide.
  - Notifications par `Toast` et messages d'erreur explicites.

# Technologies

- **Langage** : Kotlin
- **Compile SDK** : 35
- **Min SDK** : 24 (Android 7.0)
- **Target SDK** : 35
- **Interface Utilisateur** : Material Components, `AppCompatActivity`, `ListView`, `EditText`, `Button`
- **Build System** : Gradle (Version Catalog `libs.versions.toml` & Kotlin DSL)
