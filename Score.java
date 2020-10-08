import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
       private static final Color transparent = new Color (0,0,0,0);
       private GreenfootImage background;
       private int value;
       private int target;
       private String prefix;
       
       public Score()
       {
           this(new String());
       
       }
       
       public Score (String prefix)
       {
           background = getImage();
           value=0;
           target =0 ;
           this.prefix = prefix ;
           updateImage();
        }
        
        public void act() 
    {
        if (value < target) {
            value++;
            updateImage();
        }
        else if (value > target) {
            value--;
            updateImage();
        }
    }
    
    public void add(int score)
    {
        target += score;
    }
    
    public int getValue()
    {
        return target;
    }
    
    public void setValue(int newValue)
    {
        target = newValue;
        value = newValue;
        updateImage();
        
    }
    
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
        updateImage();
    }
    
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        image.clear();
        
        GreenfootImage text  = new GreenfootImage(prefix + value, 30, Color.BLUE, transparent);
        Color c = new Color(127,127,127,127);
        image.setColor(c);
        image.fill();
        
        
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 30, image.getHeight());
        }
        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
   
}
    
    
    
    
    