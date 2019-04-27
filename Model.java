public class Model {

    private Viewer viewer;

    int [][] desktop;
    int indexX;
    int indexY;

    int checkX;
    int checkY;

    Model(Viewer viewer){
        this.viewer = viewer;

        desktop = new int[10][10];

        indexX = 1;
        indexY = 1;

        initArray(indexX,indexY);

    }

    public void move(String direction){
        if (direction.equals("Up")){
            moveUp();
        }else if(direction.equals("Right")){
            moveRight();
        }else if(direction.equals("Down")){
            moveDown();
        }else if(direction.equals("Left")){
            moveLeft();
        }
        //printArray();
        viewer.update();
    }

    private void moveUp(){


        if (indexX>0 && check((checkX=indexX-1),indexY)){
            desktop[indexX][indexY]=0;
            indexX--;
            desktop[indexX][indexY]=1;
        }
    }

    private void moveRight(){
        if (indexY<(desktop[indexX].length-1) && check(indexX,(checkY=indexY+1))){
            desktop[indexX][indexY]=0;
            indexY++;
            desktop[indexX][indexY]=1;
        }
    }

    private void moveDown(){
        if (indexX<(desktop[indexY].length-1) && check((checkX=indexX+1),indexY)){
            desktop[indexX][indexY]=0;
            indexX++;
            desktop[indexX][indexY]=1;
        }
    }

    private void moveLeft(){
        if (indexY>0 && check(indexX,(checkY=indexY-1))){
            desktop[indexX][indexY]=0;
            indexY--;
            desktop[indexX][indexY]=1;
        }
    }

    private boolean check(int x2, int y2){
        if (desktop[x2][y2]==2){
            return  false;
        }else{
            return true;
        }
    }

    private void initArray(int x,int y){
        desktop = new int[][]
            {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 2, 2, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 2, 2, 2, 0},
                {0, 0, 0, 0, 2, 0, 2, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 2, 0, 0, 0},
                {0, 0, 0, 0, 2, 2, 2, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
            };
    }

    private void printArray(){
        for(int i=0; i< desktop.length;i++){
            for(int j=0;j<desktop[i].length;j++){
                System.out.print(desktop[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();System.out.println();
    }
}
