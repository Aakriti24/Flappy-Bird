import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlappyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyWorld extends World
{
   
    int pipeCounter=0;
    int PIPE_spacing=150;
    int Value=0;
    int FIRST_PIPE = 230;
    int flappyCounter=0;
    Score scoreObj = null;
    
    
    

    /**
     * Constructor for objects of class FlappyWorld.
     * 
     */
    public FlappyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1,false); 
        
        setPaintOrder(Pipe.class, FlappyBird.class, GameOver.class,Score.class);
        
        FlappyBird flappy = new FlappyBird();
        GameOver g = new GameOver();
        
        addObject(flappy,100, getHeight()/2);
        
        scoreObj = new Score();
        scoreObj.setValue(0);
        
        
        addObject(scoreObj, 100, 100);
        
        
    }
    
    
   
    public void act() {
        pipeCounter++;
        
        
        if (pipeCounter%100==0){
            createPipes();
           
        }
        
        if (pipeCounter >=FIRST_PIPE){
            if (flappyCounter%100 == 0){
                Value++;
                scoreObj.setValue(Value);
                
            }
            flappyCounter++;
    
        }
}
        private void createPipes()
        {
            Pipe pipe = new Pipe();
            tPipe tpipe= new tPipe();
            GreenfootImage image =pipe.getImage();
            int n =Greenfoot.getRandomNumber(getHeight()/2);
            if(n>=199)
            n=0;
            addObject(pipe,getWidth(),getHeight()/2 + (image.getHeight()/2) + n);
            
           //(pipe.getY()-getHeight()/2 + (image.getHeight())+n)
            addObject(tpipe,getWidth(),getHeight()/2 + (image.getHeight()/2) + n-PIPE_spacing-image.getHeight());
            
       }
    
}

