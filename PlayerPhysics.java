import greenfoot.*;
//air resistance?
//ur gonna have to make X and Y physics
public class PlayerPhysics extends Actor
{
    /**
     * Act - do whatever the PlayerPhysics wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Player john;
    public static double terminalXVelocity;
    public static double terminalYVelocity;
    public static double friction;
    public boolean freeMode;
    
    public PlayerPhysics() {
        freeMode = false; 
        friction = 0.03;
        terminalYVelocity = 8;
        terminalXVelocity = 5;
    }
    public void act()
    {
        john = (Player)getWorld().getObjects(Player.class).get(0);
        //for freemode implementation later
        if(!freeMode) {
            if(!Player.touchingPlatform) {
                normalPhysics(); 
            }
            else {
                contactPhysics(); 
            }
        }
    }
    
    public void normalPhysics() {
        //apply gravity if john is not grounded
        if(!john.checkGrounded()) {
            if (Player.YVelocity <= terminalYVelocity) {
                Player.YVelocity += 0.5*Player.gravity*Player.gravity; 
            }
            john.setLocation(john.getX() + (int)Player.XVelocity, john.getY()+ (int)Player.YVelocity);
        }
        //in-air logic 
        else if(Player.jumping) {
            Player.jumping = false; 
        }
        //sets velocity to 0 if touching sides and moving
        else if(john.checkXBounds() && Math.abs(Player.XVelocity) >= 1.5) {
            Player.XVelocity = 0;
        }
        //bounces you back onto page if too far off (on x axis)
        else if(john.checkXBounds()) {
            if(john.getX() < 15) {
                john.setLocation(15, john.getY());
            }
            if(john.getX() > getWorld().getWidth() - 15) {
                john.setLocation(getWorld().getWidth() - 15, john.getY());
            }
        }
        else{
            //Y velocity and position whenever touching ground
            Player.YVelocity = 0;
            john.setLocation(john.getX(), getWorld().getHeight() - 29);
            //making sure X velocity is not decreasing forever
            //logic is courtesy of Mr.Sarnowski
            if(Math.abs(Player.XVelocity) <= 0.4) {
            Player.XVelocity = 0; 
            }
            //friction 
            else if(Math.abs(Player.XVelocity) > 0){
            Player.XVelocity -= Player.XVelocity*friction;
            }
        }
        john.setLocation(john.getX() + (int)Player.XVelocity, john.getY() + (int)Player.YVelocity);
    }
    
    public void contactPhysics() {
        //apply gravity if john is not grounded
        if(!john.checkGrounded() || !Player.touchingPlatform) {
            if (Player.YVelocity <= terminalYVelocity) {
                Player.YVelocity += 0.5*Player.gravity*Player.gravity; 
            }
            john.setLocation(john.getX() + (int)Player.XVelocity, john.getY()+ (int)Player.YVelocity);
        }
        //in-air logic 
        else if(Player.jumping) {
            Player.jumping = false; 
        }
        //sets velocity to 0 if touching sides and moving
        else if(john.checkXBounds() && Math.abs(Player.XVelocity) >= 1.5) {
            Player.XVelocity = 0;
        }
        //bounces you back onto page if too far off (on x axis)
        else if(john.checkXBounds()) {
            if(john.getX() < 15) {
                john.setLocation(15, john.getY());
            }
            if(john.getX() > getWorld().getWidth() - 15) {
                john.setLocation(getWorld().getWidth() - 15, john.getY());
            }
        }
        else{
            //Y velocity and position whenever touching ground
            Player.YVelocity = 0;
            john.setLocation(john.getX(), getWorld().getHeight() - 29);
            //making sure X velocity is not decreasing forever
            //logic is courtesy of Mr.Sarnowski
            if(Math.abs(Player.XVelocity) <= 0.4) {
            Player.XVelocity = 0; 
            }
            //friction 
            else if(Math.abs(Player.XVelocity) > 0){
            Player.XVelocity -= Player.XVelocity*friction;
            }
        }
        //john.setLocation(john.getX() + (int)Player.XVelocity, john.getY() + (int)Player.YVelocity);
    }
}
