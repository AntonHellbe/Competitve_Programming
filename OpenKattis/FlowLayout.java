import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FlowLayout {

    public BufferedReader br;

    public class Rectangle implements Comparable<Rectangle>{
        int width, height;

        public Rectangle(int width, int height){
            this.width = width;
            this.height = height;
        }


        @Override
        public int compareTo(Rectangle o) {
            if(this.width == o.width){
                return Integer.compare(o.height, this.width);
            }

            return Integer.compare(o.width, this.width);
        }
    }

    public static void main(String[] args) throws IOException {
        FlowLayout f = new FlowLayout();
        f.calcHeightAndWidth();
    }

    private void calcHeightAndWidth() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;

        while(true) {
            int maxWidth = Integer.valueOf(br.readLine());
            if(maxWidth == 0) return;
            int totHeight = 0, totWidth = 0, maxHeight = 0, currentWidth = 0;

            while(true){
               split = br.readLine().split(" ");
               if(split[0].equals("-1") && split[1].equals("-1")) break;
               int width = Integer.valueOf(split[0]);

//                System.out.println(currentWidth);

               if(currentWidth + width > maxWidth) {
                   totHeight += maxHeight;
                   totWidth = Math.max(totWidth, currentWidth);
                   maxHeight = Math.max(0, Integer.valueOf(split[1]));
                   currentWidth = width;
               }else{
                   maxHeight = Math.max(maxHeight, Integer.valueOf(split[1]));
                   currentWidth += width;
               }

            }

            if(currentWidth > totWidth) {
                totWidth = currentWidth;
            }

            if(maxHeight != 0){
                totHeight += maxHeight;
            }

            System.out.println(totWidth + " x " + totHeight);
//            break;

        }
    }
}
