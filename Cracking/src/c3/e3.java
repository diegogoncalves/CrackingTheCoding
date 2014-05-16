package c3;

import java.util.Stack;

class e3<T>{
    
    Stack<Stack<T>> set;
    int n;
    
    public e3(int _n){
        n=_n;
        set=new Stack<Stack<T>>();
        set.push(new Stack<T>());
    }
    
    public void push(T el){
        Stack<T> aux=set.peek();
        if(aux.size()==n){
            Stack<T> aux2=new Stack<T>();
            aux2.push(el);
            set.push(aux2);
        }
        else{
            aux.push(el);
        }
    }
    
    public T pop(){
        Stack<T> aux=set.peek();
        if(aux.size()==0){
            if(set.size()!=1){
                set.pop();
                aux=set.peek();
                return aux.pop();
            }
            else return null;
        }
        else{
            return aux.pop();
        }
    }
    
    //considering 1 is the most recent
    public T popAt(int index){
        if(index>set.size()||index<1)return null;
        else{
            Stack<T> aux=set.get(index);
            if(aux.size()>0){
                return aux.pop();
            }
            else{
                if(set.size()>1){
                set.remove(index);
                aux=set.get(index);
                return aux.pop();
                }
                else return null;            
            }
        }
    }
}