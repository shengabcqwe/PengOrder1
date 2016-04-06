package com.example.shenpeng.pengorder;


public class Menu {
    private String name;
    private int imageId;
    private int price;
    private int number=0;

    @Override
        public String toString() {
                return "Product{" +
                 "name='" + name + '\'' +
                 ", num=" + number +
                  ", price=" + price +
                 '}';
             }
    public Menu(String name,int imageId,int price){
        this.name=name;
        this.imageId=imageId;
        this.price=price;
    }
    public String getName(){
        return name;
    }
    public  int getImageId(){
        return imageId;
    }
    public int getPrice(){
        return price;
    }
    public int getnumber(){return number;}
    public  void  setNumber(int number){this.number=number;}
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