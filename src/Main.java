public class Main {
    public static void main(String[] args) {
        char[] Parks = {'c','p','p','c','c','p','c'};
        int l = MaxPark(Parks, 2);
        System.out.println(l);

    }

    private static int MaxPark(char[] parks, int k) {
        int ParkedCars = 0;
        for (int i =0; i< parks.length;i++){
            if(parks[i]== 'c'){
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (parks[j] =='p'){
                    ParkedCars++;
                }
            }
        }
        return ParkedCars;
    }
}