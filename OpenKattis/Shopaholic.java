import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Shopaholic {

    public BufferedReader br;

    public static void main(String[] args) throws IOException {
        Shopaholic a = new Shopaholic();
        a.maximumDiscount();
    }

    public class Item implements Comparable<Item>{
        int price;

        public Item(int price){
            this.price = price;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public int compareTo(Item item) {
            return Integer.compare(item.price, this.price);
        }
    }

    private void maximumDiscount() throws IOException {
        br  = new BufferedReader(new InputStreamReader(System.in));
        String[] split;

        int items = Integer.valueOf(br.readLine());
        Item[] itemArray = new Item[items];
        split = br.readLine().split(" ");

        for (int i = 0; i < items; i++) {
            itemArray[i] = new Item(Integer.valueOf(split[i]));
        }

        Arrays.sort(itemArray, Item::compareTo);


        long totDiscount = 0;
        int count = 1;
        if(itemArray.length < 3){
            System.out.println(totDiscount);
        }else {
            for (int i = 1; i <= items; i++) {
                if(i % 3 == 0){
                    totDiscount += itemArray[i - 1].price;
                }

            }
            System.out.println(totDiscount);
        }

    }
}
