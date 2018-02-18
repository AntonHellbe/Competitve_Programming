import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CarouselRides {

    public BufferedReader br;
    int n, m;

    public class TicketOffer implements Comparable<TicketOffer>{
        int tickets, price;

        public TicketOffer(int tickets, int price){
            this.price = price;
            this.tickets = tickets;
        }

        @Override
        public int compareTo(TicketOffer ticketOffer) {
            double a = (double) this.tickets / this.price;
            double b = (double) ticketOffer.tickets / ticketOffer.price;
            if(Double.compare(b, a) == 0){
                return Integer.compare(ticketOffer.tickets, this.tickets);
            }else {
                return Double.compare(b, a);
            }


        }
    }

    public static void main(String[] args) throws IOException {
        CarouselRides r = new CarouselRides();
        r.solveCarlsTicketIssue();
    }

    private void solveCarlsTicketIssue() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines;


        while(true) {
            lines = br.readLine().split(" ");
            n = Integer.parseInt(lines[0]);
            m = Integer.parseInt(lines[1]);
            ArrayList<TicketOffer> t = new ArrayList<>();

            if(n == 0 && m == 0) return;

            int price, tickets;

            for (int i = 0; i < n; i++) {
                lines = br.readLine().split(" ");
                tickets = Integer.parseInt(lines[0]);
                price = Integer.parseInt(lines[1]);

                if (tickets <= m) {
                    t.add(new TicketOffer(tickets, price));
                }
            }

            t.sort(TicketOffer::compareTo);
            if(t.size() == 0)
                System.out.println("No suitable tickets offered");
            else
                System.out.println("Buy " + t.get(0).tickets + " tickets for $" + t.get(0).price);
        }

    }
}
