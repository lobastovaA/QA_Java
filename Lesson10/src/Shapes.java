interface Shape {
    double getPerimeter();
    double getArea();
    String getBackgroundColor();
    String getBorderColor();
}

class Round implements Shape {
    private double radius;
    private String backgroundColor;
    private String borderColor;

    public Round(double radius, String backgroundColor, String borderColor) {
        this.radius = radius;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;
    private String backgroundColor;
    private String borderColor;

    public Rectangle(double width, double height, String backgroundColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

class Triangle implements Shape {
    private double side1;
    private double side2;
    private double side3;
    private String backgroundColor;
    private String borderColor;

    public Triangle(double side1, double side2, double side3, String backgroundColor, String borderColor) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public String getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

public class Shapes {
    public static void main(String[] args) {
        Round round = new Round(5, "Зелёный", "Чёрный");
        Rectangle rectangle = new Rectangle(4, 6, "Синий", "Зелёный");
        Triangle triangle = new Triangle(3, 4, 5, "Жёлтый", "Фиолетовый");

        System.out.println("Round: Perimeter=" + round.getPerimeter() + ", Area=" + round.getArea() +
                ", BackgroundColor=" + round.getBackgroundColor() + ", BorderColor=" + round.getBorderColor());
        System.out.println("Rectangle: Perimeter=" + rectangle.getPerimeter() + ", Area=" + rectangle.getArea() +
                ", BackgroundColor=" + rectangle.getBackgroundColor() + ", BorderColor=" + rectangle.getBorderColor());
        System.out.println("Triangle: Perimeter=" + triangle.getPerimeter() + ", Area=" + triangle.getArea() +
                ", BackgroundColor=" + triangle.getBackgroundColor() + ", BorderColor=" + triangle.getBorderColor());
    }
}
