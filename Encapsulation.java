public class Encapsulation {
    private int weight;
    private static final int MIN_WEIGHT = 1;

    /**
     * @param args
     */
    public static void main(String[] args) {
        Encapsulation e = new Encapsulation();
        e.setWeight(-1);
        System.out.println(e.getWeight());
        System.out.println(e.toString());
    }

    /**
     * Sets the weight to the given value or the minimum weight if the value is less
     * than it.
     * 
     * @param weight
     */
    public void setWeight(int weight) {
        this.weight = Math.max(weight, MIN_WEIGHT);
    }

    /**
     * @return integer value of the weight
     */
    public int getWeight() {
        return weight;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Encapsulation [] weight=" + weight + "]";
    }

}