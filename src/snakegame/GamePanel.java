/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 *
 * @author SHILPI
 */



public class GamePanel extends JPanel implements ActionListener, KeyListener{
    
    private ImageIcon snakeTitle=new ImageIcon(getClass().getResource("snake2.png"));
    private ImageIcon leftview=new ImageIcon(getClass().getResource("leftmouth.png"));
    private ImageIcon rightview=new ImageIcon(getClass().getResource("rightmouth.png"));
    private ImageIcon downview=new ImageIcon(getClass().getResource("downmouth.png"));
    private ImageIcon upview=new ImageIcon(getClass().getResource("upmouth.png"));
    private ImageIcon enemy=new ImageIcon(getClass().getResource("d20.png"));
    private ImageIcon ranimani=new ImageIcon(getClass().getResource("hexagon.png"));
    private ImageIcon snakebody=new ImageIcon(getClass().getResource("poly.png"));
    private ImageIcon century=new ImageIcon(getClass().getResource("hexa.png"));
    private ImageIcon snakebody1=new ImageIcon(getClass().getResource("ami.png"));
    
    private int[] xlength=new int[800];
    private int[] ylength=new int[800];
    private int[] xaxis={20,40,60,80,100,120,140,160,180,200,220,240,260,280,300,320,340,360,380,400,420,440,460,480,600,620,640,660,680,700,720,740,760,780,800,820,840,860};
    private int[] yaxis={100,120,140,160,180,200,220,240,260,280,300,320,340,360,380,400,420,440,460,480,600,620,640};
//    private int[] x1axis={20,50,80,110,140,170,200,230,260,290,320,350,380,410,440,470,500,530,560,590,620,650,680,710,740,770,800,830};
//    private int[] y1axis={110,140,170,200,230,260,290,320,350,380,410,440,470,500,530,560,590,620};
    private int ilength=3;
    private int xenemy ,yenemy;
//    private int x1enemy ,y1enemy;
   private boolean gameOver=false;
    private int steps=0;
    private int score=0;
    private int food=0;
    private Random nagmani=new Random();
    private boolean left=false;
    private boolean right=true;
    private boolean up=false;
    private boolean down=false;
    
    
    private Timer timer ;
    private int delay=100;
    
    GamePanel(){
       addKeyListener(this);
       setFocusable(true);
       setFocusTraversalKeysEnabled(true);
       
       timer =new Timer(delay,this) ;
       timer.start();
       
       newnagmani();
    }
    @Override
    public void paint (Graphics g){
        super.paint(g);
        
        g.setColor(Color.CYAN);
//        g.setstroke()
        g.drawRoundRect(18, 10, 902, 74, 8, 8);
//        snakeTitle =new ImageIcon("snakes/snaketitle.jpg");
//        snakeTitle.paintIcon(this, g, 42, 21);
 snakeTitle.paintIcon(this, g, 34, 16);
g.setColor(Color.CYAN);
g.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 50));
g.drawString("SnakeGame",300,64);
//ImageIcon img = new ImageIcon("snakes/snaketitle.png");
//        g.paintIcon(img);
//        g.drawImage("snaketitle.jpg", 900, 73, Color.yellow, this);
        g.drawRect(18, 90, 902, 590);
        g.setColor(new Color(152,251,152));
        g.fillRect(19, 91, 902, 588);
        
        if(steps==0){
            xlength[0]=100;
            xlength[1]=80;
            xlength[2]=60;
            
            ylength[0]=100;
            ylength[1]=100;
            ylength[2]=100;
            
            steps++;
            
        }
        
        if(left){
            leftview.paintIcon(this, g, xlength[0], ylength[0]);
        }
        if(right){
            rightview.paintIcon(this, g, xlength[0], ylength[0]);
        }
        if(up){
            upview.paintIcon(this, g, xlength[0], ylength[0]);
        }
        if(down){
            downview.paintIcon(this, g, xlength[0], ylength[0]);
        }
        if(score%100==0 && score>0){
           for(int i=1;i<ilength;i++){
            snakebody1.paintIcon(this, g, xlength[i], ylength[i]);
        } 
        }
        else{
        for(int i=1;i<ilength;i++){
            snakebody.paintIcon(this, g, xlength[i], ylength[i]);
        }
        }
        if(score%100==0 && score>0){
            century.paintIcon(this, g, xenemy, yenemy);
            
        }
        else{
        if(food%5==0 && food>0){
        ranimani.paintIcon(this, g, xenemy, yenemy);
        }
        else{
            enemy.paintIcon(this, g, xenemy, yenemy);
        }
        }
        if(gameOver){
            g.setColor(Color.RED);
            g.setFont(new Font("Arial",Font.BOLD,50));
            g.drawString("GAMEOVER", 300, 350);
            
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial",Font.PLAIN,24));
            g.drawString("Press SPACE to Restart", 320, 450);
            
        }
 g.setColor(Color.WHITE);
g.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 14));
g.drawString("Score :"+score,750,40);
g.drawString("Length of Snake :"+ilength,750,60);
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i=ilength-1;i>0;i--){
            xlength[i]=xlength[i-1];
            ylength[i]=ylength[i-1];
            
        }
        if(score>=100){
            
        if(left){
            xlength[0] -= 20;
        }
        if(right){
            xlength[0] += 20;
        }
        if(down){
            ylength[0] += 20;
        }
        if(up){
            ylength[0] -= 20;
        }
//        eatnagmani1();
//        eatItSelf();
//        repaint();
        }
        else{
          if(left){
            xlength[0] -= 20;
        }
        if(right){
            xlength[0] += 20;
        }
        if(down){
            ylength[0] += 20;
        }
        if(up){
            ylength[0] -= 20;
        }  
        }
        
        if(xlength[0]>900) {
            xlength[0]=20;
        }
        if(xlength[0]<20) {
            xlength[0]=900;
        }
        if(ylength[0]>640) {
            ylength[0]=90;
        }
        if(ylength[0]<90) {
            ylength[0]=640;
        }
        eatnagmani();
        eatItSelf();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
      if(e.getKeyCode()==KeyEvent.VK_X){
        int result = JOptionPane.showConfirmDialog(
                null,
                "Do you really want to close this game?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION
        );

        // Check the user's response
        if (result == JOptionPane.YES_OPTION) {
            gameOver=true;
        } else {
            gameOver=false;
        }
    
      }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_SPACE && gameOver==true){
            reStart();
        }
         if(e.getKeyCode()==KeyEvent.VK_LEFT && (!right)){
            left=true;
            right=false;
            up=false;
            down=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT && (!left)){
            left=false;
            right=true;
            up=false;
            down=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_UP && (!down)){
            left=false;
            right=false;
            up=true;
            down=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN && (!up)){
            left=false;
            right=false;
            up=false;
            down=true;
        } 
    }
//    private void rani(){
//        if(score%5==0){
//            score+=2;
//        }
//    }
//    private void powerUps(){
//        
//    }
    private void reStart(){
        gameOver=false;
        steps=0;
        score=0;
        ilength=3;
        left=false;
        right=true;
        up=false;
        down=false;
        timer.start();
        repaint();
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
       if(e.getKeyCode()==KeyEvent.VK_X){
        int result = JOptionPane.showConfirmDialog(
                null,
                "Do you really want to close this game?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION
        );

        // Check the user's response
        if (result == JOptionPane.YES_OPTION) {
//            timer.stop();
           
            left=false;
            right=false;
            up=false;
            down=false;
            gameOver=true;
            
        } else {
            gameOver=false;
        }
    
      }
    }
    
    private void newnagmani(){
      xenemy= xaxis[nagmani.nextInt(38)];
      yenemy= yaxis[nagmani.nextInt(20)];
      
      for(int i=ilength-1;i>=0;i--){
          if(xlength[i]==xenemy && ylength[i]==yenemy){
              newnagmani();
          }
      }
    }
//    private void newnagmani1(){
//      x1enemy= x1axis[nagmani.nextInt(27)];
//      y1enemy= y1axis[nagmani.nextInt(14)];
//      for(int i=ilength-1;i>=0;i--){
//          if(xlength[i]==x1enemy && ylength[i]==y1enemy){
//              newnagmani1();
//          }
//      }
//    }
    private void eatItSelf(){
        for(int i=ilength-1;i>0;i--){
          if(xlength[i]==xlength[0] && ylength[i]==ylength[0]){
              
              timer.stop();
              gameOver=true;
              JOptionPane.showMessageDialog(this,"GameOver");
          }
      }
    }
    private void eatnagmani(){
        if(xlength[0]==xenemy && ylength[0]==yenemy){
            newnagmani();
            ilength++;
            if(food%5==0 && food>0)
            {
                 food++;
                score+=8;
            }
            else{
                 food++;
                score+=4;
            }
        }
        
    }
//    private void eatnagmani1(){
//        if(xlength[0]==x1enemy && ylength[0]==y1enemy){
//            newnagmani1();
//            ilength++;
//            if(food%5==0 && food>0)
//            {
//                 food++;
//                score+=8;
//            }
//            else{
//                 food++;
//                score+=4;
//            }
//        }
//        
//    }
}
