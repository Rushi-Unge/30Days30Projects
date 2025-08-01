package model;

public class Rating {
    
    ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5);
    private final int stars;

    Rating(int stars){
        this.stars = stars;
    }

    public int getStars(){
        return stars;
    }

    public static Rating fromInt(int value){
        return switch(value){
            case 1 -> ONE;
            case 2 -> TWO;
            case 3 -> THREE;
            case 4 -> FOUR;
            case 5 -> FIVE;
            default -> throw new IllegalArgumentException("Invalid rating: "+value);

        };
    }
}
