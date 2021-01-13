# la-factory
TP La Factory (SPRING BOOT / DATA-JPA / HIBERNATE)

## Routes
### Utilisateur
- Home : ```/```
- Connexion : ```/login```
- Déconnexion : ```/logout```
- Détail d'un origami : ```/origami/{id}```

### Administration
- Home : ```/admin```
- Liste des catégories : ```/admin/categories```
  - Création d'une nouvelle catégorie : ```/admin/categories/showNewCategoryForm```
  - Modification d'une catégorie : ```/admin/categories/showFormForCategoryUpdate/{id}```
  - Supression d'une catégorie : ```/admin/categories/deleteCategory/{id}```
- Liste des origamis : ```/admin/origamis```
  - Création d'un nouvel origami : ```/admin/origamis/showNewOrigamiForm```
  - Modification d'un origami : ```/admin/origamis/showFormForOrigamiUpdate/{id}```
  - Supression d'un origami : ```/admin/origamis/deleteOrigami/{id}```
- Liste des étapes d'origami : ```/admin/steps```
  - Création d'une nouvelle étape : ```/admin/steps/showNewStepForm```
  - Modification d'une étape : ```/admin/steps/showFormForStepUpdate/{id}```
  - Supression d'une étape : ```/admin/steps/deleteStep/{id}```
