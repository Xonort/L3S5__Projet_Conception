import java.util.ArrayList;

public class main {

    //up 1
    //right 2
    //down 3
    //left 4

    //mur 0
    //sol 1
    //perso 2
    // goal 3
    //caisse 4
    //caisse sur goal 5
    //perso sur goal 6


    public static void move(int dir, ArrayList<ArrayList<Integer>> niveau, int pos_x ,int pos_y){
        int x=0;
        int y=0;
        if(dir==1){
            x=-1;
            y=0;
        }
        if (dir==2){
            x=0;
            y=1;
        }
        if(dir==3){
            x=1;
            y=0;
        }
        if(dir==4){
            x=0;
            y=-1;
        }

        if(x==0&&y==0){return;}
//détermine l'augmentation de l'abs/ordo

        if(niveau.get(pos_x+x).get(pos_y+y)==0){//mur
            System.out.println("ouch") ;
            System.out.println() ;


        }else if(niveau.get(pos_x+x).get(pos_y+y)==1){//déplacement simple
            int a=niveau.get(pos_x+x).get(pos_y+y);

            if(niveau.get(pos_x).get(pos_y)==2){niveau.get(pos_x).set(pos_y,1);}//depuis "sol"
            else if(niveau.get(pos_x).get(pos_y)==6){niveau.get(pos_x).set(pos_y,3);}//depuis "goal"


        }else if(niveau.get(pos_x+x).get(pos_y+y)==3){//marche sur un goal
            niveau.get(pos_x+x).set(pos_y+y,6);
            if(niveau.get(pos_x).get(pos_y)==2){niveau.get(pos_x).set(pos_y,1);}//depuis "sol"
            else if(niveau.get(pos_x).get(pos_y)==6){niveau.get(pos_x).set(pos_y,3);}//depuis "goal"

        }else if(niveau.get(pos_x+x).get(pos_y+y)==4){//pousse une boite vers:
            //déplacement impossible
            if(niveau.get(pos_x+x+x).get(pos_y+y+y)==4 || niveau.get(pos_x+x+x).get(pos_y+y+y)==5 || niveau.get(pos_x+x+x).get(pos_y+y+y)==0) {
                System.out.println("Niuuuuuuuuuu !");
                System.out.println();

            }else {
                if (niveau.get(pos_x + x + x).get(pos_y + y + y) == 1) {//vers sol
                    if (niveau.get(pos_x).get(pos_y) == 2) {
                        niveau.get(pos_x).set(pos_y,1);
                        niveau.get(pos_x + x).set(pos_y + y,2);
                        niveau.get(pos_x + x + x).set(pos_y + y + y,4);
                    }//depuis "sol"
                    else if (niveau.get(pos_x).get(pos_y) == 6) {
                        niveau.get(pos_x).set(pos_y,3);
                        niveau.get(pos_x + x).set(pos_y + y,2);
                        niveau.get(pos_x + x + x).set(pos_y + y + y,4);
                    }//depuis "goal"


                } else if (niveau.get(pos_x + x + x).get(pos_y + y + y) == 3) {//vers goal
                    if (niveau.get(pos_x).get(pos_y) == 2) {
                        niveau.get(pos_x).set(pos_y,1);
                        niveau.get(pos_x + x).set(pos_y + y,2);
                        niveau.get(pos_x + x + x).set(pos_y + y + y,5);
                    }//depuis "sol"
                    else if (niveau.get(pos_x).get(pos_y) == 6) {
                        niveau.get(pos_x).set(pos_y,3);
                        niveau.get(pos_x + x).set(pos_y + y,2);
                        niveau.get(pos_x + x + x).set(pos_y + y + y,5);
                    }//depuis "goal"
                }
            }
        }else if(niveau.get(pos_x+x).get(pos_y+y)==5){//pousse une boite vers:
                    //déplacement impossible
                    if(niveau.get(pos_x+x+x).get(pos_y+y+y)==4 || niveau.get(pos_x+x+x).get(pos_y+y+y)==5 || niveau.get(pos_x+x+x).get(pos_y+y+y)==0) {
                        System.out.println("Niuuuuuuuuuu !");
                        System.out.println();

                    }else{
                            if(niveau.get(pos_x+x+x).get(pos_y+y+y)==1){//vers sol
                                if(niveau.get(pos_x).get(pos_y)==2){
                                    niveau.get(pos_x).set(pos_y,1);
                                    niveau.get(pos_x+x).set(pos_y+y,6);
                                    niveau.get(pos_x+x+x).set(pos_y+y+y,4);
                                }//depuis "sol"
                                else if(niveau.get(pos_x).get(pos_y)==6){
                                    niveau.get(pos_x).set(pos_y,3);
                                    niveau.get(pos_x+x).set(pos_y+y,6);
                                    niveau.get(pos_x+x+x).set(pos_y+y+y,4);
                                }//depuis "goal"


                            }else if(niveau.get(pos_x+x+x).get(pos_y+y+y)==3){//vers goal
                                if(niveau.get(pos_x).get(pos_y)==2){
                                    niveau.get(pos_x).set(pos_y,1);
                                    niveau.get(pos_x+x).set(pos_y+y,6);
                                    niveau.get(pos_x+x+x).set(pos_y+y+y,5);
                                }//depuis "sol"
                                else if(niveau.get(pos_x).get(pos_y)==6){
                                    niveau.get(pos_x).set(pos_y,3);
                                    niveau.get(pos_x+x).set(pos_y+y,6);
                                    niveau.get(pos_x+x+x).set(pos_y+y+y,5);
                                }//depuis "goal"

                            }
                    }
        }
    }

    public static void display (ArrayList<ArrayList<Integer>> t/*, int size*/){
        for (int i=0; i<9 ; i++){
            for (int j=0 ; j<9 ; j++){
                System.out.print(t.get(i).get(j));
            }
            System.out.println();
        }
    }
    public static void main (String []args){
        ArrayList<ArrayList<Integer>> level = new ArrayList<ArrayList<Integer>>() ;//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
        ArrayList<Integer> l0= new ArrayList<>();
        ArrayList<Integer> l1= new ArrayList<>();
        ArrayList<Integer> l2= new ArrayList<>();
        ArrayList<Integer> l3= new ArrayList<>();
        ArrayList<Integer> l4= new ArrayList<>();
        ArrayList<Integer> l5= new ArrayList<>();
        ArrayList<Integer> l6= new ArrayList<>();
        ArrayList<Integer> l7= new ArrayList<>();
        ArrayList<Integer> l8= new ArrayList<>();
        ArrayList<Integer> l9= new ArrayList<>();
        level.add(l0);
        level.add(l1);
        level.add(l2);
        level.add(l3);
        level.add(l4);
        level.add(l5);
        level.add(l6);
        level.add(l7);
        level.add(l8);
        level.add(l9);
        for(int a=0;a<10;a++){
            for(int b=0;b<10;b++){
                level.get(a).add(b,0);
            }
        }
        for (int i=0; i<10 ; i++){
            for (int j=0 ; j<10 ; j++){
                if(i==0||j==0||i==9||j==9){
                    level.get(i).set(j,0);
                }
                else{
                    level.get(i).set(j,1);
                }
            }
        }

        /*
        display(level);
        System.out.println("move 1");
        level[4][4]=2;
        move(1,level,4,4);//1 up
        display(level);

        System.out.println("move 2");
        level[4][4]=2;
        move(2,level,4,4);
        display(level);

        System.out.println("move 3");
        level[4][4]=2;
        move(3,level,4,4);
        display(level);

        System.out.println("move 4");
        level[4][4]=2;
        move(4,level,4,4);
        display(level);

        System.out.println("move 4 -> 6 6");
        move(4,level,6,6);//4 down
        display(level);*/

        System.out.println("move 1");
        level.get(4).set(4,2);
        level.get(3).set(4,4);
        level.get(2).set(4,3);
        move(1,level,4,4);
        move(1,level,3,4);
        move(1,level,2,4);

        display(level);
    }
}

