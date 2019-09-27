public class SeparateChainingMain {
    public static void main(String[] args) {
        HashtableSeparateChaining separateChaining = new HashtableSeparateChaining(10);
        int[] numbers = {7,17, 36, 100, 106, 205};
        for (int number: numbers) {
            separateChaining.insert(new Item(number, String.valueOf(number)));
            separateChaining.print();
            System.out.println();
        }
        System.out.println("Finished insert");

        int keyToDelete = 17;
        System.out.println(separateChaining.search(keyToDelete));
        separateChaining.print();

        separateChaining.delete(keyToDelete);
        System.out.println("Deleted key " + keyToDelete);
        separateChaining.print();

        System.out.println(separateChaining.search(keyToDelete));
    }
}
