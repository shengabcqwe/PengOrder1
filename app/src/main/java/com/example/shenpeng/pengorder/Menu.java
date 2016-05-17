package com.example.shenpeng.pengorder;


public class Menu {
    private String name;
    private int imageId;
    private String price;
    private int number=0;
    private int score=0;

    @Override
        public String toString() {
                return "Product{" +
                 "name='" + name + '\'' +
                 ", num=" + number +
                  ", price=" + price +
                 '}';
             }
    public Menu(String name,int imageId,String price,int score){
        this.name=name;
        this.imageId=imageId;
        this.price=price;
        this.score=score;
    }
    public Menu(String name,int imageId,String price,int score,int number){
        this.name=name;
        this.imageId=imageId;
        this.price=price;
        this.score=score;
        this.number=number;
    }
    public Menu(String name,int imageId,int number){
        this.name=name;
        this.imageId=imageId;
        this.number=number;
    }
    public String getName(){
        return name;
    }
    public  int getImageId(){
        return imageId;
    }
    public String getPrice(){
        return price;
    }
    public int getnumber(){return number;}
    public int getScore(){return score;}
    public  void  setNumber(int number){this.number=number;}
    public  void  setScore(int score){this.score=score;}
}

/**public class Menu{
    private String name;
    private int imageId;
    private int num=0;
    private int price;
    public Menu(String name,int imageId,int price){
        this.name=name;
        this.imageId=imageId;
        this.price=price;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
    public int getPrice(){
        return price;
    }
    public void setNum(){
        this.num=num;
    }
    public int getNum(){
        return num;
    }
}**/