
        List<Pet> pets = new ArrayList<>(petService.getPetsStream());
        pets.forEach(System.out::println);

// Ejercicio 1: Filtrar gatos y perros por género
// Supón que tienes una lista de Pet con gatos y perros.
// Puedes utilizar un Predicate para filtrar por género
// (por ejemplo, MALE o FEMALE).

    System.out.println("Solo masculinos");

    List<Pet> listDogs = pets.stream()
        //.filter(pet -> pet instanceof Dog)
        .filter(pet -> pet.getGender() == Gender.MALE)
        .peek(System.out::println)
        .toList();

// Otra alternativa
 Map<String, Long> countAnimals = pets.stream()
                .filter(pet -> pet.getGender() == Gender.MALE)
                .peek(System.out::println)
                .collect(Collectors.groupingBy(
                        pet -> pet instanceof Dog ? "dog" : "cat",
                        Collectors.counting()
                ));
        System.out.println(countAnimals);

// Ejercicio 2: Usar BiPredicate para filtrar por género y tipo de animal
// Supón que tienes un BiPredicate para comprobar dos condiciones: tipo de animal y género.

 BiPredicate<Pet, Gender> isOfGender = (pet, gender) -> pet.getGender() == gender;
       System.out.println("Male pets");
       List<Pet> malePets = pets.stream()
                .filter(pet -> isOfGender.test(pet, Gender.MALE))
                .toList();
       malePets.forEach(System.out::println);

// Ejercicio 3: Contar cuántos gatos tienen una habilidad especial
// Puedes utilizar un Predicate para filtrar a los gatos que
// tienen una habilidad especial y luego contar cuántos de ellos existen.

        System.out.println("* catWithSpecialSkills ");
        Predicate<Pet> isCat = pet-> pet instanceof Cat;
        Predicate<Pet> hasSpecialSkill = pet->pet.getSpecialSkill() != null;

        long catWithSpecialSkills = pets.stream()
                .filter(isCat)
                .filter(hasSpecialSkill)
                .peek(System.out::println)
                .count();

        System.out.println("total cats: "+catWithSpecialSkills);

// Ejercicio 4: Aplicar un Function para cambiar el nombre de todos los perros
// Si quieres aplicar una transformación a los elementos,
// como cambiar el nombre de todos los perros a "Rex", puedes usar un Function.

        System.out.println("*renameAllDogsRex");
        var finalName = "Rex";
        Predicate<Pet> isDog = pet -> pet instanceof Dog;

        Function<Pet, Pet> renamePet = pet -> {
            pet.setName(finalName);
            return pet;
        };

        List<Pet> renameAllDogsRex = pets.stream()
                .filter(isDog)
                .map(renamePet)
                .toList();

        System.out.println(renameAllDogsRex);

// Ejercicio 5: Usar UnaryOperator para aumentar el peso de los gatos en un 10%
// si necesitas modificar un solo atributo de todos los gatos,
// puedes usar un UnaryOperator para aplicar una transformación en cada uno.

        System.out.println("*catsWithIncreaseWeight");

        Predicate<Pet> isCat = pet-> pet instanceof Cat;

        UnaryOperator<Pet> increaseCatWeight = pet->{
            pet.setWeight(pet.getWeight() * 1.10f);
            return pet;
        };

        List<Pet> catsWithIncreaseWeight = pets.stream()
                .filter(isCat)
                .map(increaseCatWeight)
                .toList();

// Ejercicio 6:
// En este caso, usas un Consumer para realizar una acción,
// como mostrar información adicional sobre los gatos y perros.

        System.out.println("*showAdditionalInformation");

        Consumer<Pet> printPetDetails = pet -> {
            if (pet instanceof Dog) {
                System.out.print("Woff Wofff: ");

            } else {
                System.out.print("Meoww!!: ");
            }
            System.out.println(
                    pet.getName()+" Gender: "+
                    pet.getGender()+" Age: "+
                    pet.getAge()
            );
        };
        pets.stream().forEach(printPetDetails);

// Ejercicio 7: Usar Optional para evitar valores nulos
// Si tienes valores nulos en algunos campos (por ejemplo, specialSkill),
// puedes usar Optional para evitar NullPointerException.

        System.out.println("*petsWithSpecialSkills");

        List<Pet> petsWithSpecialSkills = pets.stream()
                .filter(pet->Optional.ofNullable(pet.getSpecialSkill()).isPresent())
                //.filter(pet -> Main.hasSpecialSkill(pet).isPresent())
                .toList();

        petsWithSpecialSkills.forEach(System.out::println);

    public static Optional<String> hasSpecialSkill(Pet pet){
        return Optional.ofNullable(pet.getSpecialSkill())
                .filter(skill -> !skill.isEmpty());
    }