# TD3

Le TD3 est divisé en trois sujets: Mockito, DTO et Clean Code. Les trois exercices sont indépendants.

## Exercice: Utiliser Mockito

Implémenter les tests unitaires de `Exam` et `Student` en utilisant _Mockito_.

## Exercice: DTO

Vous avez une application de magasinage en ligne.
_P.S. L'application n'est pas fonctionnelle, car il n'y a pas de Main et il manque des configurations._

L'objet de l'api `CartDto` est utilisé dans toutes les couches de l'application.
Cela n'est pas idéal, car chaque couche devrait dépendre de celles plus stables qu'elle.

1. Modifier l'application pour que `CartDto` ne soit pas utilisé dans le domaine et pour que le sens des dépendances soit respecté.
2. Ajouter un `Assembler` qui a la responsabilité de réhydrater `CartDto` en `Cart`.

## Exercice: Clean Code

Réusiner le code de `Restaurant` en y appliquant les principes de _Clean Code_. 
Utilisez les tests de `RestaurantTest` pour valider que la classe est toujours fonctionnelle suite à votre réusinage.