public class OffByN implements CharacterComparator {

    private int T;
    public OffByN(int N) {
        T = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return (x- y == T || x - y == -T);
    }
}
