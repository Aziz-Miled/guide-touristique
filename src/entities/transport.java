/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author houss
 */
public class transport {
    private int id;
    private String type;
   
  public transport(){
      
  }
  public transport(String type, int Numero){
      this.type=type;
      
  }
  public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type=type;
    }

    public transport(int id, String type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString() {
        return "transport{" + "id=" + id + ", type=" + type + '}';
    }
     
}