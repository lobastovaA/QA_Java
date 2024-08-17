import java.util.Arrays;

class Animal {
    static int animalCount = 0;

    public Animal() {
        animalCount++;
    }

    public void run(int distance) {
        System.out.println("Животное пробежало " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println("Животное проплыло " + distance + " м.");
    }
}
class Bowl {
    private int foodAmount;

    public Bowl(int initialAmount) {
        this.foodAmount = initialAmount > 0 ? initialAmount : 0;
    }

    public boolean eat(int amount) {
        if (amount <= foodAmount) {
            foodAmount -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
class Dog extends Animal {
    static int dogCount = 0;

    public Dog() {
        super();
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println("Собака пробежала " + distance + " м.");
        } else {
            System.out.println("Собака не может пробежать такое расстояние.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println("Собака проплыла " + distance + " м.");
        } else {
            System.out.println("Собака не может проплыть такое расстояние.");
        }
    }
}

class Cat extends Animal {
    static int catCount = 0;
    private static final int MAX_RUN_DISTANCE = 200;
    private boolean full;

    public Cat() {
        super();
        catCount++;
        this.full = false;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println("Кот пробежал " + distance + " м.");
        } else {
            System.out.println("Кот не может пробежать такое расстояние.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать.");
    }
    public void eat(Bowl bowl) {
        if (!full) {
            if (bowl.eat(10)) { // Кот пытается съесть 10 единиц еды
                full = true; // Если удалось, кот сыт
                System.out.println("Кот покушал и теперь сыт.");
            } else {
                System.out.println("Коту не хватает еды в миске.");
            }
        } else {
            System.out.println("Кот не голоден.");
        }
    }

    public boolean isFull() {
        return full;
    }

    public static int getCatCount() {
        return catCount;
    }
}
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.run(150);
        dog.swim(5);

        cat.run(250);
        cat.swim(3);

        Bowl bowl = new Bowl(25);
        Cat[] cats = {new Cat(), new Cat(), new Cat()};
        for (Cat cat2 : cats) {
            cat2.eat(bowl);
        }
        for (int i = 0; i < cats.length; i++) {
            System.out.println("Кот " + (i + 1) + (cats[i].isFull() ? " сытый." : " голодный."));
        }
        System.out.println("Остаток еды в миске: " + bowl.getFoodAmount());
        bowl.addFood(15);
        System.out.println("Добавили 15 единиц еды в миску.");
        for (Cat cat1 : cats) {
            cat1.eat(bowl);
            System.out.println("Количество созданных животных: " + Animal.animalCount);
            System.out.println("Количество созданных собак: " + Dog.dogCount);
            System.out.println("Количество созданных котов: " + Cat.catCount);
        }

    }
}