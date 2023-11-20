import processing.core.PApplet;
import processing.core.PImage; // Import the image library 

/**
   * A program that uses an image background and animates the collision of an object
   *  @author T. Chen
   */
 
public class Sketch extends PApplet {
	
  // Image variables
  PImage imgOcean;
  PImage imgFish;
  PImage imgDragon;
  PImage imgRDragon;

  // Location and speed variables
  int intDragonX = 150;
  int intDragonY = 100;

  int intCXSpeed = 2;
  int intCYSpeed = 2;

  int intDXSpeed = 3;
  int intDYSpeed = 2;

  float fltFishX = -100;
  float fltFishY = -100;
  float fltFishA = 0;

  // Cloud variable
  float fltCloudX = 160; 
  float fltCloudY = 55;

  float fltCloudX2 = 560;
  float fltCloudY2 = 75;

	
  
  public void settings() {

    size(800, 800);
  }

  
  public void setup() {

    // Loads Images
    imgOcean = loadImage("ocean.jpg");
    imgOcean.resize(800, 800);

    imgFish = loadImage("flyingfish.png");
    imgFish.resize(150, 150);

    imgDragon = loadImage("dragon.png");
    imgDragon.resize(120, 120);

    imgRDragon = loadImage("reversedragon.png");
    imgRDragon.resize(120, 120);

  }

  public void draw() {

	  // Draws background
    image(imgOcean, 0, 0);

    // Draws clouds and animates them
    stroke(230, 230, 230);
    fill(230, 230, 230);
    ellipse(fltCloudX + 20, fltCloudY, 140, 90);
    ellipse(fltCloudX + 70, fltCloudY + 20, 150, 80);
    ellipse(fltCloudX, fltCloudY + 10, 190, 90);

    stroke(230, 230, 230);
    fill(230, 230, 230);
    ellipse(fltCloudX2 + 20, fltCloudY2, 140, 90);
    ellipse(fltCloudX2 + 70, fltCloudY2 + 20, 150, 80);
    ellipse(fltCloudX2, fltCloudY2 + 10, 190, 90);

    fltCloudX = fltCloudX - intCXSpeed;
    fltCloudX2 = fltCloudX2 - intCXSpeed;

    // Cloud edge detection
    if (fltCloudX / 2 == 0 || fltCloudX == 700){
      intCXSpeed = intCXSpeed * -1;
    }

    if (fltCloudX2 / 2 == 0 || fltCloudX2 == 700){
      intCXSpeed = intCXSpeed * -1;
    }

    // Draws fish
    image(imgFish, fltFishX, fltFishY);

    // Fish non-linear movement
   fltFishX = -50 + (fltFishA) * 70; 
   fltFishY = 380 - cos(fltFishA) * 40;
 
    // Fish Speed
   fltFishA += 0.036;
 
    // Animation reset
   if (fltFishA > 12) {
     fltFishA = -1;
     }

    // Draws dragon and determines flipped or normal dragon image
    if (intDXSpeed > 0){
      image(imgRDragon, intDragonX, intDragonY);
    }

    if (intDXSpeed < 0){
      image(imgDragon, intDragonX, intDragonY);
    }

    // Movement of the dragon
    intDragonX = intDragonX - intDXSpeed;

    // Dragon edge detection
    if (intDragonX / 2 == 0 || intDragonX == 750){
      intDXSpeed = intDXSpeed * -1;
    }

    
	  
  }
  
  
}
