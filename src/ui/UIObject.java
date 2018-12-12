package ui;

import main.Handler;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 *
 * @Since 2018-10-30
 */
public abstract class UIObject {

    protected float x,y;
    protected int width, height;
    protected boolean hovering = false;
    protected Rectangle bounds;
    protected Handler handler;

    public UIObject(float x, float y, int width, int height){
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        bounds = new Rectangle((int)x,(int)y, width, height);
    }

    public abstract void tick();

    public abstract void render(Graphics2D g2d);

    public abstract void onClick();

    public void onMouseMove(MouseEvent e){
        if(bounds.contains(e.getX(), e.getY()))
            hovering = true;
        else
            hovering = false;
    }

    public void onMouseRelease(MouseEvent e){
        if(hovering){
            onClick();
        }
    }

    //getters and setters

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isHovering() {
        return hovering;
    }

    public void setHovering(boolean hovering) {
        this.hovering = hovering;
    }

    public void setHandler(Handler handler){
        this.handler = handler;
    }
}
