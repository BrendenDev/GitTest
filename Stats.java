import greenfoot.*; 
 
//debugging class
public class Stats extends Actor
{

    private Player john;
    private GreenfootImage text; 
    public Stats() {
        GreenfootImage text = new GreenfootImage(300,300); 
        this.text = text; 
    }
    
    public void act()
    {
        //clear text so it doesn't keep previous stats rendered
        text.clear();
        john = (Player)getWorld().getObjects(Player.class).get(0);
        //draw image
        text.drawString("Y Velocity: " + String.valueOf(john.YVelocity) +"\n" + 
        "Jumping: " + String.valueOf(Player.jumping) + "\n" + 
        "X Velocity: " + String.valueOf(Player.XVelocity) + "\n" + 
        "Y Position: " + String.valueOf(john.getY()) + "\n" + 
        "Touching Platform: " +  String.valueOf(john.touchingPlatform), 3, 20);
        //render image in scene
        setImage(text);
    }
}
