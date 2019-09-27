public class HashtableOpenAddressing<V> extends AbstractHashtable<V> {

    public HashtableOpenAddressing(int m, int q, int probing){
        super(m);
    }

    @Override
    public Item<V> delete(int key) {
        return null;
    }

    @Override
    public int insert(Item<V> item) {
        return 0;
    }

    @Override
    public Item<V> search(int key) {
        return null;
    }

    @Override
    public void print() {

    }
}