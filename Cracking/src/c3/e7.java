package c3;

import java.util.LinkedList;

public class e7{
    LinkedList<Wrapper> dog;
    LinkedList<Wrapper> cat;
    long counter;
    
    
    public e7(){
        dog=new LinkedList<Wrapper>();
        cat=new LinkedList<Wrapper>();
        counter=0;   
    }
    
    void enqueue(Animal a){
        if(a.type=="dog") dog.add(new Wrapper(a,++counter));
        else cat.add(new Wrapper(a,++counter));
    }
    
    Animal dequeuDog(){
        if(dog.isEmpty())return null;
        else return dog.remove().animal;
    }
    
    Animal dequeuCat(){
        if(cat.isEmpty())return null;
        else return cat.remove().animal;
    }
    
    Animal dequeuAll(){
        if(dog.peek().order<cat.peek().order) return dequeuDog();
        else return  dequeuCat();
    }



}


class Wrapper{
    Animal animal;
    long order;
    
    Wrapper(Animal a,long n){
        animal=a;
        order=n;
    }
}

class Animal{
    String type;
}
