import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlappyBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyBird extends Actor
{
    double dy= 0;
    double g = 1; 
    double BOOST_SPEED =-7;
    
    /**
     * Act - do whatever the FlappyBird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    
    {
        
        
        if(getOneIntersectingObject(Pipe.class)!= null){
            displayGameOver();
            
        }
        if(getOneIntersectingObject(tPipe.class)!= null)
        {
            displayGameOver();
        }
        setLocation(getX(),(int)(getY()+dy) );
        
        
        if(Greenfoot.isKeyDown("up")== true) {
            dy=BOOST_SPEED;
        }
        
        
            
        if(getY()>getWorld().getHeight()){
            GameOver gameOver = new GameOver();
            displayGameOver();
        }
            
        
        dy = dy+g;
        
      
    }
    private void displayGameOver(){
        GameOver gameOver= new GameOver();
        getWorld().addObject(gameOver, getWorld().getWidth()/2, getWorld().getHeight()/2);
        Greenfoot.stop();
        
        
        
            
        }
        
    private void rotateFlappyBird(){
        if (dy < 1)
            setRotation(-30);
        else if (dy < 8)
            setRotation(0);
        else if (dy < 12)
            setRotation(50);
        else if (dy < 30)
            setRotation(75);
    }
     
    
}

