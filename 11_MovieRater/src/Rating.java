public enum Rating {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);

    private final int value;

    Rating(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Rating fromInt(int number) {
        return switch (number) {
            case 1 -> ONE;
            case 2 -> TWO;
            case 3 -> THREE;
            case 4 -> FOUR;
            case 5 -> FIVE;
            default -> throw new IllegalArgumentException("Invalid rating: " + number);
        };
    }
}
