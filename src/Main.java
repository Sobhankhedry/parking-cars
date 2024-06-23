public class Main {
    public static void main(String[] args) {
        char[] Parks = {'p', 'p', 'c', 'c', 'p', 'c'};
        int l = MaxPark(Parks, 2);
        System.out.println(l);

    }

    private static int MaxPark(char[] parks, int k) {
        int ParkedCars = 0;
        for (int i = 0; i < parks.length; i++) {
            if (parks[i] == 'p'|| parks[i] == 'R') {
                continue;
            }
            int s = Math.min(0,i-k);
            for (int j = s; j < i+k; j++) {
                if (parks[j] == 'p') {
                    parks[j]= 'R';
                    ParkedCars++;
                    break;
                }

            }
        }
        return ParkedCars;
    }

}
