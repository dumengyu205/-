package untility;
public class Main{
       public static void main(String args[]){
              TV tv;
               TVFactory factory;
               factory = (TVFactory)XMLUtil.getBean();
               tv = factory.produceTV();
               tv.play();
        }
}