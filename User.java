/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

/**
 *
 * @author LENOVO
 */
public class User {
   public  String id;public  String User_Name, passward,phase,Level,BosName,points;
    
    public User (String  id,String User_Name, String passward, String phase, String Level,
                 String BosName, String points){
        this.id=id;
        this.User_Name = User_Name;
        this.passward = passward;
        this.phase = phase;
        this.Level = Level;
        this.BosName = BosName;
        this.points = points;
    }

    
}
